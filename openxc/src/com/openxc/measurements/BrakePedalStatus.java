package com.openxc.measurements;

import com.openxc.units.State;

import java.util.Locale;

/**
 * The BrakePedalStatus measurement knows if the brake pedal is pressed.
 */
public class BrakePedalStatus extends BaseMeasurement<State<BrakePedalStatus.BrakePedalState>> {
    public final static String ID = "Brk_Stat";

    public enum BrakePedalState {
        NOT_PSD,
        PSD,
        SNA
    }

    public BrakePedalStatus(State<BrakePedalState> value) {
        super(value);
    }

    public BrakePedalStatus(BrakePedalState value) {
        this(new State<BrakePedalState>(value));
    }

    public BrakePedalStatus(String value) {
        this(BrakePedalState.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
