package com.sinoiov.jt808.message;

/**
 *
 */
public class Attribute{

    private int bodySize = 0;
    private String encryptType = "RSA";
    private boolean isEncrypt = false;
    //版本标识
    private int versionIdentify = 1;
    private boolean isPackage = false;

    public int getBodySize() {
        return bodySize;
    }

    public Attribute setBodySize(int bodySize) {
        this.bodySize = bodySize;
        return this;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public Attribute setEncryptType(String encryptType) {
        this.encryptType = encryptType;
        return this;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public Attribute setEncrypt(boolean encrypt) {
        isEncrypt = encrypt;
        return this;
    }

    public boolean isPackage() {
        return isPackage;
    }

    public Attribute setPackage(boolean aPackage) {
        isPackage = aPackage;
        return this;
    }

    public Attribute setVersionIdentify(int versionIdentify) {
        this.versionIdentify = versionIdentify;
        return this;
    }

    public int getVersionIdentify() {
        return versionIdentify;
    }

    /**
     * @param bodySize
     * @return
     */
    public static Attribute ofSimpleBodySize(int bodySize){
        Attribute attribute = new Attribute();
        attribute.setBodySize(bodySize)
                .setEncrypt(false)
                .setVersionIdentify(1)
                .setPackage(false);
        return attribute;
    }
}
