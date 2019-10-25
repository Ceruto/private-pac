package com.sinoiov.jt808.message.body;

import com.sinoiov.jt808.MessageType;
import com.sinoiov.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author Ceruto
 * @Date 2019-08-03 17:30
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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

    @Override
    public byte[] toBytes() {
        return new byte[0];
    }
}
