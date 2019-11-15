package com.ceruto.lbs.jt808;

/**
 * @Description 指令类型
 * CS/CLIENT_SIDE_*** 客户端发起响应、指令 <p>
 * SS/SERVER_SIDE_*** 服务器端发起、响应指令<p>
 * v1.0.0 <p>
 * 涵盖章节： 8.1 - 8.18，8.20 - 8.23 <p>
 * @Author Ceruto
 * @Date 2019-07-25 13:16
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public enum MessageType {

    /**
     * 客户端（终端）通用应答 （文档目录：8.1）
     */
    CLIENT_SIDE_RESPONSE(0x0001),
    /**
     * 平台通用应答 （文档目录：8.2）
     */
    SERVER_SIDE_RESPONSE(0x8001),
    /**
     *  客户端（终端）心跳 （文档目录：8.3）
     */
    CLIENT_SIDE_HEARTBEAT(0x0002),
    /**
     *  客户端（终端）查询服务器时间请求（文档目录：8.4）
     */
    CLIENT_SIDE_GET_SYNC_TIME(0x0004),
    /**
     * 平台：查询服务器时间应答（文档目录：8.5）
     */
    SERVER_SIDE_RES_SYNC_TIME(0x8004),
    /**
     * 平台：服务器补传分包请求（文档目录：8.6）
     */
    SERVER_SIDE_GET_PACKAGE(0x8003),
    /**
     * 客户端（终端）补传分包请求（文档目录：8.7）
     */
    CLIENT_SIDE_GET_LAG_PACKAGE(0x0005),
    /**
     * 客户端（终端）注册（文档目录：8.8）
     */
    CLIENT_SIDE_REGISTER(0X0100),
    /**
     * 平台：终端注册应答（文档目录：8.9）
     */
    CLIENT_SIDE_RES_REGISTER(0X8100),
    /**
     * 客户端（终端）注销（文档目录：8.10）
     */
    CLIENT_SIDE_UNREGISTER(0x0003),
    /**
     * 客户端（终端）鉴权（文档目录：8.11）
     */
    CLIENT_SIDE_AUTHENTICATION(0x0102),
    /**
     * 平台：设置客户端（终端）参数（文档目录：8.12）
     */
    SERVER_SIDE_SET_PARAM(0x8103),
    /**
     * 平台：查询客户端（终端）参数（文档目录：8.13）
     */
    SERVER_SIDE_GET_PARAM(0x8104),
    /**
     * 平台：查询指定客户端（终端）参数。（文档目录：8.14）
     */
    CLIENT_SIDE_SPECIFIC_GET_PARAM(0X8106),
    /**
     * 客户端（终端）：查询客户端（终端）参数应答（文档目录：8.15）
     */
    CLIENT_SIDE_RES_PARAM(0x0104),
    /**
     * 平台（服务端）：客户端（终端）控制（文档目录：8.16）
     */
    SERVER_SIDE_CONTROL_RESPONSE(0x8105),
    /**
     * 平台（服务端）：查询客户端（终端）属性。（文档目录：8.17）
     */
    SERVER_SIDE_GET_ATTRIBUTE(0X8107),
    /**
     * 客户端（终端）：查询终端属性响应（文档目录：8.18）
     */
    CLIENT_SIDE_RES_ATTRIBUTE(0X0107),
    /**
     * 平台（服务端）：下发终端升级包（文档目录：8.19）
     */
    SERVER_SIDE_UPDATE_SEND(0x8108),
    /**
     * 客户端（终端）：升级结果应答（文档目录：8.20）
     */
    CLIENT_SIDE_UPDATE_RESPONSE(0x0108), 
    /**
     * 客户端（终端）：位置信息汇报（文档目录：8.21）
     */
    CLIENT_SIDE_LOCATION(0x0200),
    /**
     * 平台（服务端）：位置信息查询（文档目录：8.22）
     */
    SERVER_SIDE_GET_LOCATION(0x8201),
    /**
     * 客户端（终端）：位置信息查询应答。（文档目录：8.23）
     */
    CLIENT_SIDE_RESPONSE_LOCATION(0x0201),
    /**
     * 平台（服务端）： 临时位置跟踪控制（文档目录：8.24）
     */
    SERVER_SIDE_REALTIME_LOCATION(0x8202),
    /**
     * 平台（服务端）：人工确认报警信息（文档目录：8.25）
     */
    SERVER_SIDE_MANUAL_WARNING(0x8203),
    /**
     * 平台（服务端）：链路检测（文档目录：8.26）
     */
    SERVER_SIDE_LINK_TEST(0x8204),
    /**
     * 平台（服务端）：文本下发（文档目录：8.27）
     */
    SERVER_SIDE_TEXT_SEND(0x8205),
    /**
     * 平台（服务端）：车辆控制应答（文档目录：8.31）
     */
    CLIENT_SIDE_VEHICLE_CONTROL_RESPONSE(0x0500), 
    /**
     * 平台（服务端）：行驶记录数据采集命令（文档目录：8.42）
     */
    SERVER_SIDE_DASHCAM_UPLOAD(0x8700),
    /**
     * 客户端（终端）：行驶记录数据上传（文档目录：8.43）
     */
    CLIENT_SIDE_DASHCAM_UPLOAD(0x0700),
    /**
     * 平台（服务端）：上报驾驶员身份信息请求（文档目录：8.46）
     */
    SERVER_SIDE_GET_DRIVERID(0x8702),
    /**
     * 客户端（终端）：驾驶员身份信息采集上报（文档目录：8.47）
     */
    CLIENT_SIDE_GET_DRIVERID_RES(0x0702),
    /**
     * 
     */
    CLIENT_SIDE_CAN_UPLOAD(0x0705),


    public int value;
    private MessageType(int value){
        this.value = value;
    }

}
