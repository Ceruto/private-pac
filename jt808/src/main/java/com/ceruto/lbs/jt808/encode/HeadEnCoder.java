package com.ceruto.lbs.jt808.encode;

import com.ceruto.lbs.jt808.message.Attribute;
import com.ceruto.lbs.jt808.message.Head;
import com.ceruto.lbs.jt808.message.Message;

/**
 * @Description 创建协议的信息头，并指定消息序列号和消息ID，以及相关的基础参数。
 * <p> 基础参数包括：</p>
 *  versionIdentify   版本标识 <p>
 *  isPackage         是否分包，当前不支持分包构建协议<p>
 *  isEncrypt         是否需要加密 <p>
 *  version           协议版本 <p>
 * @Author Ceruto
 * @Date 2019-07-24 11:31
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public abstract class HeadEnCoder implements EnCoder<Message<?>> {

    private Head head;
    private IDGenerater idGenerater;

    /**
     * 初始化 HeadCreate 子类，并构建协议的Head，Head中默认的body 长度是 0.
     * @param versionIdentify   版本标识
     * @param isPackage         是否分包
     * @param isEncrypt         是否需要加密
     * @param version           协议版本
     */
    public HeadEnCoder(int versionIdentify, boolean isPackage, boolean isEncrypt, int version,
                       IDGenerater idGenerater){
        this.idGenerater = idGenerater !=null ? idGenerater : IDGenerater.simpleIDGenerater();

        Attribute attribute = Attribute.ofSimpleBodySize(0);
        attribute.setVersionIdentify(versionIdentify)
                .setPackage(isPackage)
                .setEncrypt(isEncrypt);

        head = Head.ofAttribute(attribute);
        head.setSerialId(idGenerater())
                .setVersion(version);

    }

    protected int idGenerater(){
        return this.idGenerater.idCreate();
    }

    public Head getHead() {
        return head;
    }

}
