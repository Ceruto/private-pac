package com.sinoiov.jt808.message.body;

import com.sinoiov.jt808.MessageType;
import com.sinoiov.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description TODO
 * @Author Ceruto yanghaipeng@sinoiov.com
 * @Date 2019/10/24 18:13:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
class VehicleControlResponseBody extends LocationBody {

    public VehicleControlResponseBody(){
        this.setMessageType(MessageType.CLIENT_SIDE_VEHICLE_CONTROL_RESPONSE);
        this.setMesaageId(MessageType.CLIENT_SIDE_VEHICLE_CONTROL_RESPONSE.value);
    }

    private int serialId;

    @Override
    public byte[] toBytes() {
        return null;
    }
    
}