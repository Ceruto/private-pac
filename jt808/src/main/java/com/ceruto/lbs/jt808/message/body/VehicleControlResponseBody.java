package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;

/**
 * @Description TODO
 * @Author Ceruto xibeijian@gmail.com
 * @Date 2019/10/24 18:13:14
 */
class VehicleControlResponseBody extends LocationBody {

    public VehicleControlResponseBody(){
        this.setMessageType(MessageType.CLIENT_SIDE_VEHICLE_CONTROL_RESPONSE);
        this.setMesaageId(MessageType.CLIENT_SIDE_VEHICLE_CONTROL_RESPONSE.value);
    }

    private int serialId;

    public VehicleControlResponseBody setSerialId(int serialId) {
        this.serialId = serialId;
        return this;
    }

    public int getSerialId() {
        return serialId;
    }

    @Override
    public byte[] toBytes() {
        return null;
    }
    
}