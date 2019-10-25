package com.sinoiov.jt808.message.body;

import com.sinoiov.jt808.MessageType;
import com.sinoiov.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description TODO
 * @Author Ceruto yanghaipeng@sinoiov.com
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