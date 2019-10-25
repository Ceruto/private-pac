package com.ceruto.lbs.jt808.decode.instruction;

import com.ceruto.lbs.jt808.Exchange;
import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.decode.HeadDeCoder;
import com.ceruto.lbs.jt808.message.Head;
import com.ceruto.lbs.jt808.message.body.AuthenticationBody;

/**
 * @Description 健全
 * @Author Ceruto
 * @Date 2019-08-03 17:30
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class Authentication extends HeadDeCoder<AuthenticationBody> {

    public Authentication(){
        super(true, MessageType.CLIENT_SIDE_AUTHENTICATION.value);
    }

    @Override
    public AuthenticationBody body(byte[] message, Head head, int offset) {
        AuthenticationBody authBody = new AuthenticationBody();
        int authSize = slice(message,offset,1)[0];
        authBody.setSize(authSize)
                .setContent(Exchange.toChars(slice(message,offset + 1,authSize)))
                .setImei(Exchange.toChars(slice(message,offset + 1 + authSize,15)))
                .setVersion(Exchange.toChars(slice(message,offset + 16 + authSize,20)));
        return authBody;
    }
}
