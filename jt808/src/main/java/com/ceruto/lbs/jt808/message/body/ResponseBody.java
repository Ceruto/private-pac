package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 客户端（终端）通用应答与服务端通用应答，内容一致。
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResponseBody extends Body {
    //响应的流水号
    private int id;
    //响应的消息ID；
    private int messageId;
    /**
     * 客户端（终端）应答结果 0：成功/确认；1：失败；2：消息有误；3：不支持
     * 服务端应答结果：0：成功/确认；1：失败；2：消息有误；3：不支持；4：报警处理确认
     */
    private int result;

    public static ResponseBody ofMessage() {
        return new ResponseBody();
    }

    public String toString(){
        return null;
    }

    public ResponseBody(int mesaageId){
        super(MessageType.CLIENT_SIDE_RESPONSE);
    }

    public ResponseBody(int id, int messageId, int result){
        super(MessageType.CLIENT_SIDE_RESPONSE);
        setId(id);
        setMessageId(messageId);
        setResult(result);
    }

    public ResponseBody(){
        this(0,0,0);
    }

    @Override
    public byte[] toBytes() {
        return null;
    }
}
