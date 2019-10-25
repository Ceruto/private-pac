package com.ceruto.lbs.jt808;

/**
 * @Description 指令类型
 * CLIENT_SIDE_*** 客户端发起响应、指令 <p>
 * SERVER_SIDE_*** 服务器端发起、响应指令<p>
 * v1.0.0 <p>
 * 涵盖章节： 8.1 - 8.18，8.20 - 8.23 <p>
 * @Author Ceruto
 * @Date 2019-07-25 13:16
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public enum MessageType {

    /**
     * 客户端（终端）通用应答
     */
    CLIENT_SIDE_RESPONSE(0x0001),
    /**
     *  客户端（终端）心跳
     */
    CLIENT_SIDE_HEARTBEAT(0x0002),
    /**
     *  客户端（终端）请求平台时间
     */
    CLIENT_SIDE_GET_SYNC_TIME(0x0004),

    /**
     * 平台响应终端请求平台时间
     */
    SERVER_SIDE_RES_SYNC_TIME(0x8004),
    /**
     * 客户端（终端）补传分包请求
     */
    CLIENT_SIDE_GET_LAG_PACKAGE(0x0005),
    /**
     * 服务器补传分包请求
     */
    SERVER_SIDE_GET_PACKAGE(0x8003),
    /**
     * 平台通用应答
     */
    SERVER_SIDE_RESPONSE(0x8001),
    /**
     * 客户端（终端）注册
     */
    CLIENT_SIDE_REGISTER(0X0100),
    /**
     * 服务端响应注册
     */
    CLIENT_SIDE_RES_REGISTER(0X8100),
    /**
     * 客户端（终端）鉴权
     */
    CLIENT_SIDE_AUTHENTICATION(0x0102),
    /**
     * 客户端（终端）注销
     */
    CLIENT_SIDE_UNREGISTER(0x0003),
    /**
     * 服务端：设置客户端（终端）参数
     */
    SERVER_SIDE_SET_PARAM(0x8103),
    /**
     * 服务端：查询客户端（终端）参数
     */
    SERVER_SIDE_GET_PARAM(0x8104),
    /**
     * 终端管理类协议：设置客户端（终端）参数 响应
     */
    CLIENT_SIDE_RES_PARAM(0x0104),
    /**
     * 服务端：控制客户端（终端）
     */
    SERVER_SIDE_CONTROL_RESPONSE(0x8105),
    /**
     * 客户端（终端）：设置指定客户端（终端）参数。
     */
    CLIENT_SIDE_SPECIFIC_GET_PARAM(0X8106),
    /**
     * 服务端：查询客户端（终端）属性。
     */
    SERVER_SIDE_GET_ATTRIBUTE(0X8107),
    /**
     * 客户端（终端）：查询终端属性。响应
     */
    CLIENT_SIDE_RES_ATTRIBUTE(0X0107),
    /**
     * 客户端（终端）：位置信息汇报
     */
    CLIENT_SIDE_LOCATION(0x0200),
    /**
     * 服务端：位置信息查询
     */
    SERVER_SIDE_GET_LOCATION(0x8201),
    /**
     * 客户端（终端）：位置信息查询 响应。
     */
    CLIENT_SIDE_RESPONSE_LOCATION(0x0201),

    /**
     * 客户端（终端）：升级结果应答
     */
    CLIENT_SIDE_UPDATE_RESPONSE(0x0108), 

    CLIENT_SIDE_VEHICLE_CONTROL_RESPONSE(0x0500), 
    
    CLIENT_SIDE_DASHCAM_UPLOAD(0x0700);

    public int value;
    private MessageType(int value){
        this.value = value;
    }

}
