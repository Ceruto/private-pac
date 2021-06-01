package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

/**
 * @Description TODO
 * @Author Ceruto xibeijian@gmail.com
 * @Date 2019/10/24 18:26:21
 */
class DashcamBody extends Body {

    public DashcamBody(){
        super(MessageType.CLIENT_SIDE_DASHCAM_UPLOAD);
    }

    @Override
    public byte[] toBytes() {
        return null;
    }
    
}