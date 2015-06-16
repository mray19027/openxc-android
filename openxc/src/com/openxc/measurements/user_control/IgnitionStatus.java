package com.openxc.measurements.user_control;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.State;
import com.openxc.wrappers.IgnitionPosition;

import java.util.Locale;

/**
 * The IgnitionStatus is the current status of the vehicle's ignition.
 */
public class IgnitionStatus
        extends BaseMeasurement<State<IgnitionPosition>> {
    public final static String ID = "CmdIgnStat";

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
