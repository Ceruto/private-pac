package com.sinoiov.jt808.encode;

/**
 * @Description 消息构成
 * @Author Ceruto
 * @Date 2019-07-22 16:24
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
@FunctionalInterface
public interface EnCoder<R> {
    R create();
}
