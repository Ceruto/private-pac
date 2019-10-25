package com.sinoiov.jt808.exception;

/**
 * @Description GB808协议的自定义异常的基类。
 * @Author Ceruto
 * @Date 2019-07-17 19:19
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class GB808Excepiton extends Exception{
    
    private static final long serialVersionUID = 1L;

    String code = "";
    String description = "";

    public GB808Excepiton(GB808ExceptionType gb808ExceptionType){
        this(gb808ExceptionType.code,gb808ExceptionType.desc);
    }

    public GB808Excepiton(String code ,String description){
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return code + " : "+ this.description;
    }
}
