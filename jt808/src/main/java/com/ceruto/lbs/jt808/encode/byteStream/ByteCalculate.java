package com.sinoiov.jt808.encode.byteStream;

import com.sinoiov.jt808.arrays.MutableByteArray;

/**
 * @Description 模拟集合的流处理方式，处理对一条协议(byte[]) 的“流式”处理。
 * @Author Ceruto
 * @Date 2019/9/23 17:18
 * @Version 1.0
 * @Copyright 北京中交兴路车联网科技有限公司/SINOIOV.COM
 * @email xibeijian@gmail.com
 **/
@FunctionalInterface
public interface ByteCalculate<T,R> {

    R calculate(T src);
	/**
     * 转义（0x7D->0x7D71，0x7E->0x7D72）
     * @return
     */
    static ByteCalculate<byte[], byte[]> escape(){
        return src -> {
            int size = src.length;
            MutableByteArray dest = MutableByteArray.createMutableArray(size);
            dest.append(src[0]);
            for (int i = 1;i< size - 1;i++){
                if(src[i] == 0x7D || src[i] == 0x7E){
                    dest.append((byte)(src[i] - 0x0C));
                }
            }
            dest.append(src[size -1]);
            return dest.getArray();
        };
    }

    /**
     * 逐字节异或。
     * @return
     */
    static ByteCalculate<byte[], Byte> xor(){
        return src -> {
            byte tmp = 0x7F;
            for (byte b : src){
                tmp ^= b;
            }

            return tmp;
        };
    }

    /**
     * RSA加密
     * @return
     */
    static ByteCalculate<byte[], byte[]> rsa(){
        return src -> {
            return src;
        };
    }
}
