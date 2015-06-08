package com.openxc.measurements;

import com.openxc.units.Boolean;
import com.openxc.units.State;

import java.util.Locale;

public class WindshieldWiperStatus
        extends EventedMeasurement<State<WindshieldWiperStatus.WiperId>> {
    public final static String ID = "WprSw6Posn";

    /**
     * The DoorId is the specific door of the vehicle.
     */
    public enum WiperId {
        OFF,
        INTERVAL1,
        INTERVAL2,
        INTERVAL3,
        INTERVAL4,
        INTERVAL5,
        INTERVAL6,
        WPR_LOW,
        WPR_HI,
        SNA
    }

    public WindshieldWiperStatus(State<WiperId> value, Boolean event) {
        super(value, event);
    }

    public WindshieldWiperStatus(WiperId value, Boolean event) {
        this(new State<WiperId>(value), event);
    }

    public WindshieldWiperStatus(WiperId value, java.lang.Boolean event) {
        this(value, new Boolean(event));
    }

    public WindshieldWiperStatus(String value, java.lang.Boolean event) {
        this(WiperId.valueOf(value.toUpperCase(Locale.US)), new Boolean(event));
    }

    @Override
    public Boolean getEvent() {
        return (Boolean) super.getEvent();
    }

    @Override
    public java.lang.Boolean getSerializedEvent() {
        return new java.lang.Boolean(getEvent().booleanValue());
    }

    @Override
    public String getSerializedValue() {
        return getValue().enumValue().toString();
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
