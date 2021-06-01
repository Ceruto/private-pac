package com.ceruto.lbs.jt808.message;

import com.ceruto.lbs.jt808.MessageType;

public abstract class Body implements ToBytes {

    private MessageType messageType;

    private byte[] body;

    private byte verifyCode;

    public Body(MessageType messageType){
        this.messageType = messageType;
    }

    public Body setMessageType(MessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public Body setBody(byte[] body) {
        this.body = body;
        return this;
    }

    public byte[] getBody() {
        return body;
    }

    public Body setVerifyCode(byte verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }
    
    public byte getVerifyCode() {
        return verifyCode;
    }
}


