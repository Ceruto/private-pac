package com.sinoiov.jt808.decode.instruction;

import java.time.LocalDate;

import com.sinoiov.jt808.MessageType;
import com.sinoiov.jt808.decode.HeadDeCoder;
import com.sinoiov.jt808.message.BlankBody;
import com.sinoiov.jt808.message.Head;

/**
 * @Description 查询服务器时间请求
 * @Author Ceruto yanghaipeng@sinoiov.com
 * @Date 2019/10/24 16:48:11
 */
class SyncServerTime extends HeadDeCoder<BlankBody> {

    public SyncServerTime() {
        super(true, MessageType.CLIENT_SIDE_GET_SYNC_TIME.value);
    }

    @Override
    public BlankBody body(byte[] message, Head head, int from) {
        headLogger.info("{0} / client-side / sync server time, Time : {1} ", Integer.toHexString(head.getMessageId()), LocalDate.now());
        return null;
    }
    
}