package com.ceruto.lbs.jt808.param;
/**
 * @Description 终端参数设置各参数项定义及说明
 * @Author Ceruto xibeijian@gmail.com
 * @Date 2019/10/24 17:23:05
 */
public enum ClientSideParam { 

    HEATBEAT_INTERVAL_SECONDS(0x0001),
    TCP_RESPONSE_TIMEOUT_SECONDS(0x0002),
    TCP_REPEAT_COUNT(0x0003),
    UDP_RESPONSE_TIMEOUT_SECONDS(0x0004),
    UDP_REPEAT_COUNT(0x0005),
    SMS_RESPONSE_TIMEOUT_SECONDS(0x0006),
    SMS_RESPONSE_COUNT(0x0006),
    MAIN_SERVER_APN_OR_PPPNUM(0x0010),
    MAIN_SERVER_APN_USERNAME(0x0011),
    MAIN_SERVER_APN_PASSWORD(0x0012),
    MAIN_SERVER_APN_IP_PORTS(0x0013),
    BACK_SERVER_APN(0x0014),
    BACK_SERVER_APN_USERNAME(0x0015),
    BACK_SERVER_APN_PASSWORD(0x0016),
    BACK_SERVER_APN_IP_PORTS(0x0017),
    // Road Transport Certificate  RTC
    RTC_IC_SERVER_IP_DOMAIN(0x001A),
    RTC_IC_SERVER_TCP_PORT(0x001B),
    RTC_IC_SERVER_UDP_PORT(0x001C),
    RTC_IC_BACK_SERVER_IP_DOMAIN(0x001D)
    // todo 表13，继续。
    ;

    private int value;

    private ClientSideParam(int value){
        this.value = value;
    }
}