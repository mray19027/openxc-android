package com.openxc.measurements.user_control;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.State;
import com.openxc.wrappers.PaddleShifterPosition;

import java.util.Locale;

/**
 * The PaddleShifterStatus measurement knows if the paddle shifters are pressed.
 */
public class PaddleShifterStatus extends BaseMeasurement<State<PaddleShifterPosition>> {
    public final static String ID = "Pad_Shft";

    public PaddleShifterStatus(State<PaddleShifterPosition> value) {
        super(value);
    }

    public PaddleShifterStatus(PaddleShifterPosition value) {
        this(new State<PaddleShifterPosition>(value));
    }

    public PaddleShifterStatus(String value) {
        this(PaddleShifterPosition.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
