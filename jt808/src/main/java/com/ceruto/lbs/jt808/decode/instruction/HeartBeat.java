package com.ceruto.lbs.jt808.decode.instruction;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.decode.HeadDeCoder;
import com.ceruto.lbs.jt808.message.BlankBody;
import com.ceruto.lbs.jt808.message.Head;

import java.time.LocalDate;

/**
 * @Description 心跳BODY内容为空。
 * @Author Ceruto
 * @Date 2019-07-22 16:10
 * @Version 1.0
 * @email xibeijian@gmail.com
 **/
public class HeartBeat extends HeadDeCoder<BlankBody> {

    public HeartBeat(){
        super(true, MessageType.CLIENT_SIDE_HEARTBEAT.value);
    }

    @Override
    public BlankBody body(byte[] message, Head head, int offset) {
        headLogger.info("{0} / client-side / heartbeat, Time : {1} ", Integer.toHexString(head.getMessageId()), LocalDate.now());
        return null;
    }

}
