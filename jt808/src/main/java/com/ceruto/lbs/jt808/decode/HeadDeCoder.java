package com.sinoiov.jt808.decode;

import com.sinoiov.jt808.arrays.ByteSlice;
import com.sinoiov.jt808.Exchange;
import com.sinoiov.jt808.exception.GB808Excepiton;
import com.sinoiov.jt808.message.Attribute;
import com.sinoiov.jt808.message.Body;
import com.sinoiov.jt808.message.Head;
import com.sinoiov.jt808.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @param <T>
 */
public abstract class HeadDeCoder<T extends Body> extends CheckCodeAndMessageTypeDeCoder {

    protected final Logger headLogger = LoggerFactory.getLogger("vp808-client-side");

    protected ByteSlice<byte[],byte[]> byteSlice = null ;

    public HeadDeCoder(boolean isCheckCode, int messageId) {
        this(isCheckCode, messageId, null);
    }

    public HeadDeCoder(boolean isCheckCode, int messageId, ByteSlice<byte[],byte[]> slice) {
        super(isCheckCode, messageId);
        this.byteSlice = slice != null ? slice : ByteSlice.copyOfRange();

    }
    /**
     * 0000 0011 1111 1111  0x03FF 消息体长度
     * 0001 1100 0000 0000  0x1C00 数据加密方式
     * 0010 0000 0000 0000  0x2000 分包
     * 0100 0000 0000 0000  0x4000 版本标识
     * 1000 0000 0000 0000  0x 保留
     * 0000 0000 0000 0000
     * @param message
     * @return
     */
    private Attribute attribute(byte[] message){
        byte[] attribute = slice(message,2,2);
        int attrInt = (attribute[0] & 0xFF) << 8 | (attribute[1] & 0xFF) ;
        Attribute a = new Attribute();
        a.setBodySize(attrInt & 0x03FF);
        //数据加密方式
        int encryptType = (attrInt & 0x1C00) >> 10;
        a.setEncrypt(encryptType == 1);
        int isPackage =  (attrInt & 0x2000) >> 13;
        if(isPackage == 1){
            a.setEncrypt(Boolean.TRUE);
            a.setPackage(Boolean.TRUE);
        }

        int versionIdentify = (attrInt & 0x4000 ) >> 14;
        a.setVersionIdentify(versionIdentify);

        return a;
    }

    public Head head(byte[] message, int idx) {
        Attribute attribute = attribute(message);
        Head head = Head.ofAttribute(attribute);
        boolean isPackage = attribute.isPackage();

        byte[] messageId = slice(message,0,2);
        head.setMessageId(Exchange.toInteger(messageId));

        //协议版本号
        byte[] protocolVersion = slice(message,4,1);
        head.setVersion(protocolVersion[0] & 0xFF);
        //终端手机号
        byte[] sim = slice(message,5,10);
        head.setSim(Exchange.bcd(sim));
        //流水号
        byte[] serialNo = slice(message,15,2);
        head.setSerialId(Exchange.toInteger(serialNo));

        if(isPackage){
            //总包数
            byte[] pSize = slice(message,17,2);
            head.setPackageSize(Exchange.toInteger(pSize));
            //当前包数
            byte[] pNow = slice(message, 19,2);
            head.setPackageNo(Exchange.toInteger(pNow));
        }

        return head;
    }

    @Override
    public Message<T> decode(byte[] content, int idx) throws GB808Excepiton {
        //转义字符处理
        escape(content);
        //获得头标志
        Head head = head(content,idx);
        Message<T> message = new Message<T>(head);
        if(MESSAGE_ID == head.getMessageId()){
            int offset = head.isPackage() ? 21 : 17;
            message.setBody(body(content,head,offset));
        }

        return message;
    }

    /**
     * 对 Body的解析
     * @param message
     * @param head
     * @param from  message 的初始下标，从这个下标位置开始为BODY数据。
     * @return
     */
    public abstract T body(byte[] message, Head head, int from);

    protected byte[] slice(byte[] src, int from, int size){
        return this.byteSlice.slice(src, from, size);
    }
}
