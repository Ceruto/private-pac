package com.ceruto.lbs.jt808.message.body;

import java.util.List;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;
import com.ceruto.lbs.jt808.param.ClientSideParam;


/**
 * @Description 
 * @Author Ceruto yanghaipeng@sinoiov.com
 * @Date 2019/10/24 17:37:31
 */
class ClientSideParamsResponse extends Body {

    public ClientSideParamsResponse(){
        this(MessageType.CLIENT_SIDE_RES_PARAM);
    }

    public ClientSideParamsResponse(MessageType messageType) {
        super(messageType);
    }

    // 参数总数
    private int paramSize = 0;

    private List<Param> params;

    public void setParamSize(int paramSize) {
        this.paramSize = paramSize;
    }

    public int getParamSize() {
        return paramSize;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public List<Param> getParams() {
        return params;
    }

    @Override
    public byte[] toBytes() {
        return null;
    }

    class Param<T> {
        private ClientSideParam param;
        private int length = 0;
        private T value ;
    }
}