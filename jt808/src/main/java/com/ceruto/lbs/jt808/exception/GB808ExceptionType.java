package com.ceruto.lbs.jt808.exception;
/**
 * @Description TODO
 * @Author Ceruto xibeijian@gmail.com
 * @Date 2019/10/24 14:37:24
 */
public enum GB808ExceptionType { 
 
    CHECK_CODE_UNMATCHED("0001","check code is unmatched."),
    NUMBER_CHANGE_ERROR("0002",""),
    DECODE_ORDER_ERROR("0003",""),
    ;

    public final String code;
    public final String desc;

    private GB808ExceptionType(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

}