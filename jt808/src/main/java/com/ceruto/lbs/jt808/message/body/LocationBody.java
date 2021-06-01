package com.ceruto.lbs.jt808.message.body;

import com.ceruto.lbs.jt808.MessageType;
import com.ceruto.lbs.jt808.message.Body;

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
    public LocationBody setAlarmBytes(byte[] alarmBytes, boolean isDescription){
        this.alarmBytes = alarmBytes;
        if(isDescription){
            this.setAlarm(new Alarm());
        }
        return this;
    }

    public LocationBody setAlarmBytes(byte[] alarmBytes){
        this.alarmBytes = alarmBytes;
        return this;
    }

    public byte[] getAlarmBytes() {
        return alarmBytes;
    }

    public LocationBody setMesaageId(int mesaageId) {
        this.mesaageId = mesaageId;
        return this;
    }

    public int getMesaageId() {
        return mesaageId;
    }

    public LocationBody setAlarm(Alarm alarm) {
        this.alarm = alarm;
        return this;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public LocationBody setStatusBytes(byte[] statusBytes) {
        this.statusBytes = statusBytes;
        return this;
    }

    public byte[] getStatusBytes() {
        return statusBytes;
    }

    public LocationBody setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
    
    public double getLatitude() {
        return latitude;
    }

    public LocationBody setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public LocationBody setElevation(int elevation) {
        this.elevation = elevation;
        return this;
    }

    public int getElevation() {
        return elevation;
    }
    
    public LocationBody setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public LocationBody setDirection(int direction) {
        this.direction = direction;
        return this;
    }

    public int getDirection() {
        return direction;
    }

    public LocationBody setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public LocationBody setVelocity(float velocity) {
        this.velocity = velocity;
        return this;
    }

    public float getVelocity() {
        return velocity;
    }

    @Override
    public byte[] toBytes() {
        return new byte[0];
    }
}
