package com.sinoiov.jt808.decode;

import com.sinoiov.jt808.exception.GB808Excepiton;

import java.util.Objects;

@FunctionalInterface
public interface DeCoder<R,T> {

    char[] hexCode = "0123456789ABCDEF".toCharArray();

    /**
     * 解析一条指令。
     * @param message
     * @return
     */
    R decode(T message, int idx) throws GB808Excepiton;

    /**
     * 将一条指令(byte[])转义，并转换为16进制字符串。
     * @param message
     * @return
     */
    static String toHexString(byte[] message){
        Objects.requireNonNull(message);
        StringBuilder s = new StringBuilder(message.length * 2);
        int l = message.length;
        for(int i = 0;i < l;i++){
            if(message[i] != 0x7D){
                s.append(hexCode[(message[i] >> 4) & 0xF]);
                s.append(hexCode[(message[i] & 0xF)]);
            }else{
                if(i + 1 < l){
                    if(message[i+1] == 0x71){
                        s.append("7D");
                        i++;
                    } else if(message[i+1] == 0x72){
                        s.append("7E");
                        i++;
                    }
                    //实际上这个else对于809协议而言永远不会出现。7D后必须跟71或72
                    // else{
                    //     s.append("7D");
                    // }
                }
            }
        }
        return s.toString();
    }

    /**
     * 转换为 16进制数组 的一个实现。
     * @return
     */
    static DeCoder<String, byte[]> toHexString() {
        return (bytes,nouse) -> {
            return toHexString(bytes);
        };
    }
}
