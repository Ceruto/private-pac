package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

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

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setManufactoryId(String manufactoryId) {
        this.manufactoryId = manufactoryId;
    }

    public String getManufactoryId() {
        return manufactoryId;
    }

    public void setClientModel(String clientModel) {
        this.clientModel = clientModel;
    }

    public String getClientModel() {
        return clientModel;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public int getClientType() {
        return clientType;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

}
