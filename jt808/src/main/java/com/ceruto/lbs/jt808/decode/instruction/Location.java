package com.ceruto.lbs.jt808.decode.instruction;

import com.ceruto.lbs.jt808.Exchange;
import com.ceruto.lbs.jt808.Index;
import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.decode.HeadDeCoder;
import com.ceruto.lbs.jt808.message.Head;
import com.ceruto.lbs.jt808.message.body.LocationBody;

import java.time.LocalDate;

public class Location extends HeadDeCoder<LocationBody> {

    public Location(){
        super(true, MessageType.CLIENT_SIDE_LOCATION.value);
    }
    /**
     * 20xx年到 99xx年。
     */
    int yearPrefix = LocalDate.now().getYear() / 100;

    @Override
    public LocationBody body(byte[] message, Head head, int offset) {
        slice(message,offset,head.getAtrribute().getBodySize());
        LocationBody locationBody = new LocationBody();
        locationBody.setAlarmBytes(slice(message,offset, Index.DWORD))
                    .setStatusBytes(slice(message,offset + 4,Index.DWORD))
                    .setLatitude(Exchange.toInteger(slice(message,offset + 8,Index.DWORD)))
                    .setLongitude(Exchange.toInteger(slice(message,offset + 12,Index.DWORD)))
                    .setElevation(Exchange.toInteger(slice(message,offset + 16,Index.WORD)))
                    .setVelocity(Exchange.toInteger(slice(message,offset + 18,Index.WORD)))
                    .setDirection(Exchange.toInteger(slice(message,offset + 20,Index.WORD)))
                    .setDateTime(yearPrefix + Exchange.bcd(slice(message,offset + 22,6)));

        //附加属性字段
        return locationBody;
    }

}
