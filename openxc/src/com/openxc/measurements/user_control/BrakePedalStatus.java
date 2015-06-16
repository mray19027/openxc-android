package com.openxc.measurements.user_control;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.State;
import com.openxc.wrappers.BrakePedalPosition;

import java.util.Locale;

/**
 * The BrakePedalStatus measurement knows if the brake pedal is pressed.
 */
public class BrakePedalStatus extends BaseMeasurement<State<BrakePedalPosition>> {
    public final static String ID = "Brk_Stat";

    public BrakePedalStatus(State<BrakePedalPosition> value) {
        super(value);
    }

    public BrakePedalStatus(BrakePedalPosition value) {
        this(new State<BrakePedalPosition>(value));
    }

    public BrakePedalStatus(String value) {
        this(BrakePedalPosition.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
