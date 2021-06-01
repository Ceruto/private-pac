package com.ceruto.lbs.jt808.encode;

import lombok.Data;

/**
 * @Description 构建一条协议，或者一类协议的基础参数集合。
 * @Author Ceruto
 * @Date 2019-08-13 14:10
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
@Data
public class InstructionConfig {

    private int versionIdentify = 1;
    private boolean isPackage = false ;
    private boolean isEncrypt = false;
    private int version = 1;

    private IDGenerater idGenerater;

    public InstructionConfig(int versionIdentify, boolean isPackage, boolean isEncrypt, int version, IDGenerater idGenerater) {
        this.versionIdentify = versionIdentify;
        this.isPackage = isPackage;
        this.isEncrypt = isEncrypt;
        this.version = version;
        this.idGenerater = idGenerater;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public void setVersionIdentify(int versionIdentify) {
        this.versionIdentify = versionIdentify;
    }

    public int getVersionIdentify() {
        return versionIdentify;
    }

    public boolean isPackage() {
        return isPackage;
    }

    public void setPackage(boolean isPackage) {
        this.isPackage = isPackage;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public void setEncrypt(boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public void setIdGenerater(IDGenerater idGenerater) {
        this.idGenerater = idGenerater;
    }

    public IDGenerater getIdGenerater() {
        return idGenerater;
    }

    public static InstructionConfig normalConfig() {
        return new InstructionConfig(1,false,false,1,IDGenerater.simpleIDGenerater());
    }
}
