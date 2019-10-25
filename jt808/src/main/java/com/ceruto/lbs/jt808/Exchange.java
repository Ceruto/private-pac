package com.sinoiov.jt808;

import java.nio.charset.Charset;
import java.util.Objects;

/**
 * @Description 数值转换帮助类。
 * @Author Ceruto
 * @Date 2019-08-03 16:49
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public abstract class Exchange {

    private static char[] hexCode = "0123456789ABCDEF".toCharArray();

    int a = 123_234;

    private Exchange(){}

    /**
     * 将byte[] 处理为 BCD/8421码。
     * @param bytes
     * @return
     */
    public static String bcd(byte[] bytes){
        int l = bytes.length;
        StringBuilder s = new StringBuilder(l * 2);
        for(int i = 0;i < l;i++){
            s.append(hexCode[(bytes[i] >> 4) & 0xF]);
            s.append(hexCode[(bytes[i] & 0xF)]);
        }
        return s.toString();
    }

    /**
     * 将字符串逐个转换为BCD，字符必须是数字形式。
     * 即 15010845689 -> 变为 0x00000000015010845689
     * @return
     */
    public static byte[] numberStrToBcd(int byteSrc, String src){
        Objects.requireNonNull(src);
        byte[] dest = null;
        if(src.matches("^[0,9]*$")){
            dest = new byte[byteSrc];
            char[] srcs = src.toCharArray();
            int srcLength = srcs.length;
            for (int i=0;i<byteSrc;i++){
                if(i >= srcLength - 1){
                    dest[i]=0x00;
                    continue;
                }
                dest[i] = (byte)srcs[i];
            }
        }
        return dest;
    }

    /**
     * bytep[] 处理为汉字（默认编码为GBK）。
     * @param bytes
     * @param charset
     * @return
     */
    public static String chinese(byte[] bytes, Charset charset){
        if(charset == null){
            charset = Charset.forName("GBK");
        }
        return new String(bytes,charset);
    }

    public static String toChineseByGBK(byte[] bytes){
        return chinese(bytes,Charset.forName("GBK"));
    }

    /**
     * 将字节转换为整数。字节长度不能超过4个字节。即协议中所示 DWORD
     * @param bytes
     * @return
     */
    public static int toInteger(byte[] bytes){
        int size = 0;
        if(bytes == null || (size = bytes.length) > 4){
            return -1;
        }

        int r = 0 ;
        for(int i = 0;i < size;i++){
            r |= (bytes[i] & 0xFF) << (8 * (size - i - 1));
        }
        return r;
    }

    /**
     * 将byte[] 数组转换为 char 字符串
     * @param bytes
     * @return
     */
    public static String toChars(byte[] bytes){
        int l = bytes.length;
        StringBuilder s = new StringBuilder(l * 2);
        for(int i = 0;i < l;i++){
            s.append((char)bytes[i]);
        }
        return s.toString();
    }

    /**
     * 将数字转为换byte、word（数组为2字节），dword（4字节） 0X7FFFFFFF 超过怎么办？ todo
     * @param byteSize
     * @return
     */
    public static byte[] toBytes(int byteSize, int src){
        if(byteSize < 1 || byteSize > 2) {
            return null;
        }

        byte[] dest = new byte[byteSize];
        for (int i=0; i < byteSize; i++){
            dest[i] = (byte) (src >> (i*8) & 0xFF);
        }

        return dest;
    }

    /**
     * 将数字转为换byte、word（数组为2字节），dword（4字节）
     * 每个byte 最高就到 7F，如果超过7F，比如8F 会变为 FFFFFF8F，
     * @param byteSize
     * @return
     */
    public static byte[] toBytes(int byteSize, long src) {
        if(byteSize < 1 || byteSize > 4) {
            return null;
            //throw new NumberChangeException();
        }
        byte[] dest = new byte[byteSize];
        for (int i=0; i < byteSize; i++){
            dest[i] = (byte) (src >> (i*8) & 0xFF);
        }
        return dest;
    }

    public static void main(String[] args) {
        int src =  0x2122788F;
        byte[] dest = toBytes(2,src);
        System.out.println(Integer.toHexString(dest[0]));
    }

}

