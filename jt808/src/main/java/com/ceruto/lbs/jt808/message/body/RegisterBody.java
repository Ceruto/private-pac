package com.sinoiov.jt808.message.body;

import com.sinoiov.jt808.MessageType;
import com.sinoiov.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 注册内容消息体。
 * @Author Ceruto
 * @Date 2019-08-03 16:29
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RegisterBody extends Body {
    /**
     * 标示终端安装车辆所在的省域，0保留，由平台取默认值。省域ID采用GB/T 2260中规定的行政区划代码六位中前两位
     */
    int provinceCode;
    /**
     * 标示终端安装车辆所在的市域和县域，0保留，由平台取默认值。市县域ID采用GB/T 2260中规定的行政区划代码六位中后四位
     */
    int cityCode;
    /**
     * 由车载终端厂商所在地行政区划代码和制造商 ID 组成
     */
    String manufactoryId;
    /**
     * 此终端型号由制造商自行定义，位数不足的前补0x00
     */
    String clientType;
    /**
     * 由大写字母和数字组成，此终端ID由制造商自行定义
     */
    String clientId;
    /**
     * 车牌颜色按照JT/T 697.7-2014中的规定，未上牌车辆填0
     */
    int vehiclePlateColor;
    /**
     * 公安交通管理部门颁发的机动车号牌，如果车辆未上牌则填写车架号
     */
    String vehiclePlate;

    public RegisterBody(){
        super(MessageType.CLIENT_SIDE_REGISTER);
    }

    @Override
    public byte[] toBytes() {
        return new byte[0];
    }
}
