package com.sinoiov.jt808.decode.instruction;

import com.sinoiov.jt808.MessageType;
import com.sinoiov.jt808.decode.HeadDeCoder;
import com.sinoiov.jt808.message.BlankBody;
import com.sinoiov.jt808.message.Head;

import java.time.LocalDate;

/**
 * @Description 注销
 * @Author Ceruto
 * @Date 2019-08-03 17:29
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class Unregister extends HeadDeCoder<BlankBody> {

    public Unregister(){
        super(true, MessageType.CLIENT_SIDE_UNREGISTER.value);
    }
    @Override
    public BlankBody body(byte[] message, Head head, int offset) {
        headLogger.info("{0} / client-side / Unregister, Time : {1} ", Integer.toHexString(head.getMessageId()), LocalDate.now());
        return null;
    }
}
