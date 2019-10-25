package com.ceruto.lbs.jt808.decode.instruction;

import com.ceruto.lbs.jt808.decode.HeadDeCoder;
import com.ceruto.lbs.jt808.message.Head;
import com.ceruto.lbs.jt808.message.body.ClientSideAttributeResponseBody;

/**
 * @Description TODO
 * @Author Ceruto xibeijian@gmail.com
 * @Date 2019/10/24 17:56:00
 */
class ClientSideAttributeResponse extends HeadDeCoder<ClientSideAttributeResponseBody> {

    public ClientSideAttributeResponse(boolean isCheckCode, int messageId) {
        super(isCheckCode, messageId);
    }

    @Override
    public ClientSideAttributeResponseBody body(byte[] message, Head head, int from) {
        return null;
    }
    
}