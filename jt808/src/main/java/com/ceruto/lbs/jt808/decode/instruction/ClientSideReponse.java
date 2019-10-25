package com.ceruto.lbs.jt808.decode.instruction;

import com.ceruto.lbs.jt808.Exchange;
import com.ceruto.lbs.jt808.Index;
import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.decode.HeadDeCoder;
import com.ceruto.lbs.jt808.message.Head;
import com.ceruto.lbs.jt808.message.body.ResponseBody;

/**
 * 客户端（终端、车载机等）响应。
 */
public class ClientSideReponse extends HeadDeCoder<ResponseBody> {

    public ClientSideReponse() {
        super(true, MessageType.CLIENT_SIDE_RESPONSE.value);
    }

    @Override
    public ResponseBody body(byte[] message, Head head, int offset) {
        ResponseBody responseBody = ResponseBody.ofMessage();
        responseBody.setId(Exchange.toInteger(slice(message , offset , Index.WORD)))
                .setMessageId(Exchange.toInteger(slice(message , offset + Index.WORD , Index.WORD)))
                .setResult(message[offset + Index.WORD * 2]);
        return responseBody;
    }


}
