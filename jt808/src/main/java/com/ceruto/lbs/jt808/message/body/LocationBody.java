package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LocationBody extends Body {

    private int mesaageId;
    private Alarm alarm;
    private byte[] alarmBytes;
    private byte[] statusBytes;
    private double longitude;
    private double latitude;
    //海拔
    private int elevation;
    private float velocity;
    private int direction;
    
    private long timeStamp;
    private String dateTime;

    public LocationBody(){
        super(MessageType.CLIENT_SIDE_LOCATION);
        this.mesaageId = this.getMessageType().value;
    }

    /**
     * 是否将报警位转为可描述语言
     * @param alarmBytes
     * @param isDescription
     */
    public void setAlarmBytes(byte[] alarmBytes, boolean isDescription){
        this.alarmBytes = alarmBytes;
        if(isDescription){
            this.setAlarm(new Alarm());
        }
    }

    @Override
    public byte[] toBytes() {
        return new byte[0];
    }
}
