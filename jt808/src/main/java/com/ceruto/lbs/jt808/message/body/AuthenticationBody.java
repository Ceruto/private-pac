package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

/**
 * @Author Ceruto
 * @Date 2019-08-03 17:30
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class AuthenticationBody extends Body {
    /**
     * 不定，有服务端或者客户端（终端）指定
     */
    int size;
    /**
     * 鉴权码内容
     */
    String content;
    /**
     * 终端IMEI
     */
    String imei;
    /**
     * 厂家自定义版本号，位数不足时，后补“0X00”.
     */
    String version;

    public AuthenticationBody(){
        super(MessageType.CLIENT_SIDE_AUTHENTICATION);
    }

    public AuthenticationBody setSize(int size) {
        this.size = size;
        return this;
    }

    public int getSize() {
        return size;
    }

    public AuthenticationBody setContent(String content) {
        this.content = content;
        return this;
    }

    public String getContent() {
        return content;
    }

    public AuthenticationBody setImei(String imei) {
        this.imei = imei;
        return this;
    }

    public String getImei() {
        return imei;
    }

    public AuthenticationBody setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public byte[] toBytes() {
        return new byte[0];
    }
}
