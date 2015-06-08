package com.openxc.measurements;

import com.openxc.units.State;

import java.util.Locale;

public class TurnSignalStatus extends
        BaseMeasurement<State<TurnSignalStatus.TurnSignalPosition>> {
    public final static String ID = "TurnIndLvr_Stat";

    public enum TurnSignalPosition {
        OFF,
        LEFT,
        RIGHT
    }

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
