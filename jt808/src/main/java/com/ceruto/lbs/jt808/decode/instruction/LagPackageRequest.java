package com.ceruto.lbs.jt808.decode.instruction;

import com.ceruto.lbs.jt808.Exchange;
import com.ceruto.lbs.jt808.Index;
import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.decode.HeadDeCoder;
import com.ceruto.lbs.jt808.message.Head;
import com.ceruto.lbs.jt808.message.body.LagPackageReqeustBody;

/**
 * @Description 终端补传分包请求
 * @Author Ceruto yanghaipeng@sinoiov.com
 * @Date 2019/10/24 16:54:13
 */
class LagPackageRequest extends HeadDeCoder<LagPackageReqeustBody> {

    public LagPackageRequest() {
        super(true, MessageType.CLIENT_SIDE_GET_LAG_PACKAGE.value);
    }

    @Override
    public LagPackageReqeustBody body(byte[] message, Head head, int from) {
        LagPackageReqeustBody lagPackageReqeustBody = new LagPackageReqeustBody();
        lagPackageReqeustBody.setSerialId(Exchange.toInteger(slice(message,from,Index.WORD)));
        from += Index.WORD;
        int packageSize = Exchange.toInteger(slice(message,from , Index.WORD));
        lagPackageReqeustBody.setPackageSize(packageSize);
        int[] ids = new int[packageSize];
        from += Index.WORD;
        byte[] idsOfbcd = slice(message, from, packageSize);
        for (int i=0;i< packageSize;i++) {
            // todo 将byte[] 转换为 int
        }
        return lagPackageReqeustBody;
    }
    
}