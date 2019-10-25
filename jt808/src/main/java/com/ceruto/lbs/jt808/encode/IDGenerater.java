package com.sinoiov.jt808.encode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description idCreate 生成器
 * @Author Ceruto
 * @Date 2019-07-22 16:36
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public interface IDGenerater {

    IDGenerater idGenerater = simpleIDGenerater();

    int idCreate();

    static IDGenerater simpleIDGenerater(){

        AtomicInteger integer = new AtomicInteger(0);
        return () -> {
            if(integer.get() == Integer.MAX_VALUE){
                integer.set(0);
            }
            return integer.incrementAndGet();
        };
    }

}
