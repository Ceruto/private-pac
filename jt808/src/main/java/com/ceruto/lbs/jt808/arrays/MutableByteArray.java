package com.ceruto.lbs.jt808.arrays;

import java.util.Objects;

/**
 * 简单的可自增byte 数组，
 * 目前仅支持追加操作和 , 在头，尾插入字符
 * @Author Ceruto
 * @Date 2019-08-17 14:33
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class MutableByteArray {

    private byte[] array;

    //数组当前位置，初始为0，即可写位置为数组下标为0的地址上。
    private int positon = 0;

    private int capacity = 0;

    /**
     * 初始化MutableByteArray 大小。
     * @param capacity
     */
    private MutableByteArray(int capacity){
        if(capacity < 0 || capacity > Integer.MAX_VALUE){
            throw new IllegalArgumentException("initial capacity can not negative");
        }
        this.positon = 0;
        this.capacity = capacity;
        this.array = new byte[capacity];
    }

    public static MutableByteArray createMutableArray(int capacity){
        return new MutableByteArray(capacity);
    }

    /**
     * 追加一个字节。
     * @param content
     * @return
     */
    public void append(byte content){
       this.append(new byte[]{content});
    }

    /**
     * 追加一个数组
     * @param content
     * @return
     */
    public MutableByteArray append(byte[] content){
        this.insert(content);
        return this;
    }

    /**
     * 在position位置开始，追加字符串，如果长度超过capacity,则重新生成新的array。
     * @param src
     */
    private void insert(byte[] src){
        Objects.requireNonNull(src,"byte[] to need to add must not be null ");
        int srcSize = src.length;

        if(this.positon + srcSize <= capacity){
            System.arraycopy(src,0,this.array,this.positon,srcSize);
            this.positon = this.positon + srcSize;
        }else{
            int newArrayLength = this.positon + srcSize;
            byte[] newArray = new byte[newArrayLength];
            System.arraycopy(this.array,0,newArray,0,this.capacity);
            System.arraycopy(src, 0, newArray, this.positon, srcSize);
            this.array = newArray;
            this.positon = this.capacity = newArrayLength;
        }

    }

    public byte[] getArray(){
        return this.array;
    }
}
