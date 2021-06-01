package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;


/**
 * @Description TODO
 * @Author Ceruto xibeijian@gmail.com
 * @Date 2019/10/24 18:07:38
 */
class ClientUpdateResponseBody extends Body {

    private int type;
    private int result;

    public ClientUpdateResponseBody(){
        super(MessageType.CLIENT_SIDE_UPDATE_RESPONSE);
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    @Override
    public byte[] toBytes() {
        return null;
    }
    
}