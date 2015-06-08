package com.openxc.measurements;

import com.openxc.units.State;

import java.util.Locale;

/**
 * The IgnitionStatus is the current status of the vehicle's ignition.
 */
public class IgnitionStatus
        extends BaseMeasurement<State<IgnitionStatus.IgnitionPosition>> {
    public final static String ID = "CmdIgnStat";

    public enum IgnitionPosition {
        IGN_LK,
        IGN_OFF,
        IGN_ACC,
        IGN_OFF_ACC,
        IGN_RUN,
        IGN_START,
        SNA
    }

    public IgnitionStatus(State<IgnitionPosition> value) {
        super(value);
    }

    public IgnitionStatus(IgnitionPosition value) {
        this(new State<IgnitionPosition>(value));
    }

    public IgnitionStatus(String value) {
        this(IgnitionPosition.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
