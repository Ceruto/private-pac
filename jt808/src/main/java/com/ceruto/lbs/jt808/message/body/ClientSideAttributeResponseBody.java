package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClientSideAttributeResponseBody extends Body {

    private int clientType;
    private String manufactoryId;
    private String clientModel;
    private String clientId;
    private String iccid;

    @Override
    public byte[] toBytes() {
        return null;
    }

    public ClientSideAttributeResponseBody(){
        super(MessageType.CLIENT_SIDE_RES_ATTRIBUTE);
    }

}
