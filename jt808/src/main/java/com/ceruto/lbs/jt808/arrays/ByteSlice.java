package com.ceruto.lbs.jt808.arrays;

import java.util.Arrays;

/**
 * @Description 获得指定数组中，连续N个字符。
 * @Author Ceruto
 * @Date 2019-09-11 12:53
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public interface ByteSlice<T,R> {

    /**
     * 获得指定数组 r ，指定位置 from 开始长度 size 的数组子集。
     * @param src
     * @param from
     * @param size
     * @return
     */
    T slice(R src, int from, int size);

    /**
     * 默认使用  Arrays.copyOfRange(bytes,from,to) 获取数组子集。
     * @return
     */
    static ByteSlice<byte[],byte[]> copyOfRange(){
        return (src,from,size) -> {
            if(from < 0 || size < 1) return null;
            return Arrays.copyOfRange(src,from,from + size);
        };
    }

    /**
     * System.arraycopy 实现 获取数组子集。
     * @return
     */
    static ByteSlice<byte[], byte[]> arrayCopy(){
        return (src,from,size) -> {
            if(from < 0 || size < 1) return null;
            byte[] dest = new byte[size];
            System.arraycopy(src,from,dest,0,size);
            return dest;
        };
    }

}
