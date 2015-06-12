package com.openxc.measurements.cluster;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.State;
import com.openxc.wrappers.TurnSignalPosition;

import java.util.Locale;

public class TurnSignalStatus extends
        BaseMeasurement<State<TurnSignalPosition>> {
    public final static String ID = "TurnIndLvr_Stat";

    public TurnSignalStatus(State<TurnSignalPosition> value) {
        super(value);
    }

    public TurnSignalStatus(TurnSignalPosition value) {
        this(new State<TurnSignalPosition>(value));
    }

    public TurnSignalStatus(String value) {
        this(TurnSignalPosition.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
