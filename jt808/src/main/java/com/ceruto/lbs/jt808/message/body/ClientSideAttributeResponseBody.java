package com.sinoiov.jt808.message.body;

import com.sinoiov.jt808.message.Body;

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
        // TODO Auto-generated method stub
        return null;
    }

}
