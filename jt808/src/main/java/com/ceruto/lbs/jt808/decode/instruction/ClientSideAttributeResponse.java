package com.sinoiov.jt808.decode.instruction;

import com.sinoiov.jt808.decode.HeadDeCoder;
import com.sinoiov.jt808.message.Head;
import com.sinoiov.jt808.message.body.ClientSideAttributeResponseBody;

/**
 * @Description TODO
 * @Author Ceruto yanghaipeng@sinoiov.com
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