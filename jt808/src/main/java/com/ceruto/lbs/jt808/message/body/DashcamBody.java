package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description TODO
 * @Author Ceruto xibeijian@gmail.com
 * @Date 2019/10/24 18:26:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
class DashcamBody extends Body {

    public DashcamBody(){
        super(MessageType.CLIENT_SIDE_DASHCAM_UPLOAD);
    }

    

    @Override
    public byte[] toBytes() {
        return null;
    }
    
}