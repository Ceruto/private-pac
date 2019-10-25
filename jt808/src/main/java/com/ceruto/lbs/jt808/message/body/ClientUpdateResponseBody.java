package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description TODO
 * @Author Ceruto xibeijian@gmail.com
 * @Date 2019/10/24 18:07:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
class ClientUpdateResponseBody extends Body {

    private int type;
    private int result;

    public ClientUpdateResponseBody(){
        super(MessageType.CLIENT_SIDE_UPDATE_RESPONSE);
    }

    @Override
    public byte[] toBytes() {
        return null;
    }
    
}