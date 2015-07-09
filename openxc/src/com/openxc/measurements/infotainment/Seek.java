package com.openxc.measurements.infotainment;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.State;
import com.openxc.wrappers.SwitchState;

import java.util.Locale;

/**
 * The EngineSpeed measurement represents the speed of the engine.
 *
 * The valid range for this measurement is from 0 to 8000 RotationsPerMinute.
 */
public class Seek extends BaseMeasurement<State<SwitchState>> {
    public final static String ID = "SEEK";

    public Seek(State<SwitchState> value) {
        super(value);
    }

    public Seek(SwitchState value) {
        this(new State<SwitchState>(value));
    }

    public Seek(String value) {
        this(SwitchState.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}