package com.ceruto.lbs.jt808.encode.byteStream;

import java.util.Objects;

import com.ceruto.lbs.jt808.arrays.MutableByteArray;
import com.ceruto.lbs.jt808.exception.GB808Excepiton;
import com.ceruto.lbs.jt808.exception.GB808ExceptionType;
import com.ceruto.lbs.jt808.message.Body;
import com.ceruto.lbs.jt808.message.Message;

/**
 * <p>针对一条协议原始内容（byte[]）的加密，增加校验码，转义处理。</p>
 * <p>并根据order的值规定以上三者处理的顺序。</p>
 * <pre>
 *  order = 1：对body进行加密
 *  order = 2：校验码 
 *  order = 3：转义
 * </pre>
 * @Author Ceruto
 * @Date 2019/9/23 17:13
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public interface ByteStream<R> {

    ByteStream<R> escape();

    ByteStream<R> checkCode();

    ByteStream<R> encrypt();

    R finished();

    public static ByteStream<byte[]> getDefaultByteStream(Message<?> message){
        return new DefaultByteStream<>(message);
    }

    /**
     * ByteStream 的 默认实现。
     */
    class DefaultByteStream<T extends Body> implements ByteStream<byte[]>{

        Message<T> message;
        byte[] content;
        /**
         * 过滤顺序。
         *  order = 1：对body进行加密
         *  order = 2：校验码
         *  order = 3：转义
         */
        private int order = 0;

        public DefaultByteStream(Message<T> message){
            Objects.requireNonNull(message);
            this.message = message;
            integrate();
        }

        @Override
        public ByteStream<byte[]> escape() {
            order(2,3);
            this.content = ByteCalculate.escape().calculate(this.content);
            this.order = 0;
            return this;
        }

        @Override
        public ByteStream<byte[]> checkCode() {
            order(1,2);
            byte checkCode = ByteCalculate.xor().calculate(this.content);
            this.content[this.content.length - 1] = checkCode;
            return this;
        }

        @Override
        public ByteStream<byte[]> encrypt() {
            order(0,1);
            this.content = ByteCalculate.rsa().calculate(this.content);
            return this;
        }

        @Override
        public byte[] finished() {
            order(3,0);
            //是否需要其他认证逻辑。
            return this.content;
        }

        /**
         * 定义ByteStream的执行方法顺序。
         * @param before
         * @param after
         */
        private void order(int before, int after){
            if(this.order != before){
                new GB808Excepiton(GB808ExceptionType.DECODE_ORDER_ERROR);
            }
            order = after;
        }

        /**
         * 整合 head 和 body ，获得某一条指令的字节数组。
         */
        private void integrate(){
            byte[] head = message.getHead().toBytes();
            byte[] body = message.getBody().toBytes();
            // 3 代表头，尾和校验码
            int size = head.length + body.length + 3;
            MutableByteArray dest = MutableByteArray.createMutableArray(size);
            dest.append(this.message.headCode);
            dest.append(head)                   //协议头
                .append(body)
                .append((byte)0x00);            //验证码
            dest.append(this.message.tailCode); //协议尾
            this.content = dest.getArray();
        }

    }
}
