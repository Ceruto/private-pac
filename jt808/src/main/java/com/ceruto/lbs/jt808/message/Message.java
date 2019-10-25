package com.sinoiov.jt808.message;

import com.sinoiov.jt808.encode.byteStream.ByteStream;

/**
 * @Description 消息。
  * @Author Ceruto
 * @Date 2019-07-24 17:26
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class Message<T extends Body> {

    public byte headCode = 0x7E;
    public byte tailCode = 0x7E;
    private Head head;
    private T body;
    private byte verifyCode;

    public Message(){}

    public Message(Head head){
        this.setHead(head);
    }

    public Message<T> setHead(Head head) {
        this.head = head;
        return this;
    }

    public Head getHead() {
        return head;
    }

    public byte getVerifyCode() {
        return verifyCode;
    }

    public Message<T> setBody(T body) {
        this.body = body;
        return this;
    }

    public boolean isPackage(){
        return this.head.isPackage();
    }

    public boolean isEncrypt(){
        return this.head.isEncrypt();
    }

    public T getBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuffer p = new StringBuffer();
        p.append("MessageID:").append(head.getMessageId())
                .append(",SIM NO:").append(head.getSim());
        return p.toString();
    }

    public ByteStream<byte[]> byteStream(){
        return ByteStream.getDefaultByteStream(this);
    }
}
