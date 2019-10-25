package com.sinoiov.jt808.decode.instruction;

import com.sinoiov.jt808.Exchange;
import com.sinoiov.jt808.MessageType;
import com.sinoiov.jt808.decode.HeadDeCoder;
import com.sinoiov.jt808.message.Head;
import com.sinoiov.jt808.message.body.RegisterBody;

/**
 * @Description todo
 * @Author Ceruto
 * @Date 2019-08-03 16:28
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class Register extends HeadDeCoder<RegisterBody> {

    public Register(){
        super(true, MessageType.CLIENT_SIDE_REGISTER.value);
    }

    @Override
    public RegisterBody body(byte[] message, Head head, int offset) {
        RegisterBody registerBody = new RegisterBody();
        registerBody.setProvinceCode(Exchange.toInteger(slice(message,offset,2)) * 10000)
                .setCityCode(Exchange.toInteger(slice(message,offset + 2,2)))
                .setManufactoryId(Exchange.toChars(slice(message,offset + 4,11)))
                .setClientType(Exchange.toChars(slice(message,offset + 15,30)))
                .setClientId(Exchange.toChars(slice(message,offset + 45,30)))
                .setVehiclePlateColor(slice(message,offset + 75, 1)[0]);
        int length = head.getAtrribute().getBodySize();
                //车牌号不定长度，需要根据总长度相减 -_-!!
        registerBody.setVehiclePlate(
                Exchange.toChineseByGBK(
                        slice(message,offset + 76, length - 76)));

        return registerBody;
    }
}
