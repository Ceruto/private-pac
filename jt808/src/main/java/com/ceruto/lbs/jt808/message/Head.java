package com.ceruto.lbs.jt808.message;

import com.ceruto.lbs.jt808.Exchange;
import com.ceruto.lbs.jt808.arrays.MutableByteArray;

public class Head implements ToBytes {

    private Attribute atrribute;
    private int messageId;
    private int version;
    private String sim;
    private int serialId;
    //消息包封装项
    private int packageSize = 1;
    private int packageNo = 1;

    public Head(Attribute attribute) {
        setAtrribute(attribute);
    }

    public Attribute getAtrribute() {
        return atrribute;
    }

    public Head setAtrribute(Attribute atrribute) {
        this.atrribute = atrribute;
        return this;
    }

    public int getMessageId() {
        return messageId;
    }

    public Head setMessageId(int messageId) {
        this.messageId = messageId;
        return this;
    }

    public int getVersion() {
        return version;
    }

    public Head setVersion(int version) {
        this.version = version;
        return this;
    }

    public String getSim() {
        return sim;
    }

    public Head setSim(String sim) {
        this.sim = sim;
        return this;
    }

    public int getSerialId() {
        return serialId;
    }

    public Head setSerialId(int serialId) {
        this.serialId = serialId;
        return this;
    }

    public int getPackageSize() {
        return packageSize;
    }

    public Head setPackageSize(int packageSize) {
        this.packageSize = packageSize;
        return this;
    }

    public int getPackageNo() {
        return packageNo;
    }

    public Head setPackageNo(int packageNo) {
        this.packageNo = packageNo;
        return this;
    }

    public static Head ofAttribute(Attribute attribute){
        return new Head(attribute);
    }

    @Override
    public byte[] toBytes(){
        int attribute = 0x00;
        //消息体长度     0~9
        attribute = attribute & this.getAtrribute().getBodySize();
        //数据加密方式   10~12 ，目前仅支持RSA，即文档规定10-12位置的值为：100
        attribute = isEncrypt() ? attribute | 0x400 : attribute;
        //分包        13  目前自定义包，不支持分包，所以不做处理。
        //attribute = attribute;
        //版本标识     14   2011年后的版本为1，2011年前的版本为0。自定义协议 默认为1？ todo
        attribute =  attribute | getAtrribute().getVersionIdentify() << 14 ;
        //保留        15   不做处理,无风暴项
        MutableByteArray byteArray = MutableByteArray.createMutableArray(16);
        byteArray.append(Exchange.toBytes(2,getMessageId()))
                .append(Exchange.toBytes(2,attribute))
                .append(Exchange.toBytes(1,getVersion()))
                .append(Exchange.numberStrToBcd(10,getSim()))
                .append(Exchange.toBytes(2,getMessageId()));

        return byteArray.getArray();
    }

    public boolean isPackage(){
        return this.atrribute.isPackage();
    }

    public boolean isEncrypt(){
        return this.atrribute.isEncrypt();
    }
}
