package com.openxc.measurements;

import com.openxc.units.State;

public class TransmissionGearPosition
        extends Measurement<State<TransmissionGearPosition.GearPosition>>
        implements VehicleMeasurement {
    public final static String ID = "TransmissionGearPosition";

    public enum GearPosition {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH,
        SIXTH,
        NEUTRAL,
        REVERSE
    }

    public TransmissionGearPosition(State<GearPosition> value) {
        super(value);
    }
}