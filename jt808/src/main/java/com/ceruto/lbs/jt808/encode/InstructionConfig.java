package com.sinoiov.jt808.encode;

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

    public static InstructionConfig normalConfig() {
        return new InstructionConfig(1,false,false,1,IDGenerater.simpleIDGenerater());
    }
}
