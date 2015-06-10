package com.openxc.measurements;

import com.openxc.units.State;

import java.util.Locale;

/**
 * The PaddleShifterStatus measurement knows if the paddle shifters are pressed.
 */
public class PaddleShifterStatus extends BaseMeasurement<State<PaddleShifterStatus.PaddleShifterState>> {
    public final static String ID = "Pad_Shft";

    public enum PaddleShifterState {
        PS_OFF,
        PS_RIGHT,
        PS_LEFT,
        PS_BOTH,
        SNA
    }

    public PaddleShifterStatus(State<PaddleShifterState> value) {
        super(value);
    }

    public PaddleShifterStatus(PaddleShifterState value) {
        this(new State<PaddleShifterState>(value));
    }

    public PaddleShifterStatus(String value) {
        this(PaddleShifterState.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
