package com.sinoiov.jt808.message;

import com.sinoiov.jt808.MessageType;

/**
 * 空body体。
 */
public class BlankBody extends Body {

    public BlankBody(MessageType messageType) {
        super(messageType);
    }

    @Override
    public byte[] toBytes() {
        return null;
    }
}
