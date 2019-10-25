package com.ceruto.lbs.jt808.message;

import com.ceruto.lbs.jt808.MessageType;

import lombok.Data;

@Data
public abstract class Body implements ToBytes {

    private MessageType messageType;

    private byte[] body;

    private byte verifyCode;

    public Body(MessageType messageType){
        this.messageType = messageType;
    }
}


