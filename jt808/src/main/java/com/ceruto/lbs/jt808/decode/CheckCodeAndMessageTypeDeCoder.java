package com.ceruto.lbs.jt808.decode;


import com.ceruto.lbs.jt808.exception.GB808Excepiton;
import com.ceruto.lbs.jt808.exception.GB808ExceptionType;
import com.ceruto.lbs.jt808.message.Message;

/**
 * @Description 
 *  解析一条指令，对协议的转义处理，已经校验码验证。
 * @Author Ceruto
 * @Date 2019-07-25 11:15
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public abstract class CheckCodeAndMessageTypeDeCoder implements DeCoder<Message<?>, byte[]> {

    public final boolean IS_CHECK_CODE;
    public final int MESSAGE_ID;

    /**
     * 以终端心跳的长度为最小长度。只有头信息，没有消息体。
     * 总计约 16（head) + 1(校验码) + 2（头尾协议标识）
     */
    final int MINIMUM = 19;

    /**
     * 是否需要校验验证码和指定的消息ID。
     * @param isCheckCode   是否校验验证码
     * @param messageId     设置该消息的消息Id。
     */
    public CheckCodeAndMessageTypeDeCoder(boolean isCheckCode, int messageId){
        IS_CHECK_CODE = isCheckCode;
        this.MESSAGE_ID = messageId;
    }

    /**
     * 转义过程。
     * 对验证码是否准确做了认证。
     * @param message
     * @throws GB808Excepiton
     */
    public void escape(byte[] message) throws GB808Excepiton {
        int length = message.length - 1;
        byte tmp = message[1];

        for(int i = 1;i < length;i++){
            if(message[i] == 0x7D
                    && i + 1 < length
                    && (message[i + 1] == 0x71 || message[i + 1] == 0x72)){
                message[i] = (byte)(message[i+1] | 0x7C);
                System.arraycopy(message,i + 2 , message, i + 1,length - i - 1 );
                length--;
            }
            tmp |= message[i];
        }

        if(IS_CHECK_CODE && tmp != message[length - 1]){
            throw new GB808Excepiton(GB808ExceptionType.CHECK_CODE_UNMATCHED);
        }
    }
}
