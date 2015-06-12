package com.openxc.measurements.tires;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.State;
import com.openxc.wrappers.TireStatus;

import java.util.Locale;

/**
 * The TireRRSTatus is the current status of a tire's sensor.
 */
public class TireFLStatus
        extends BaseMeasurement<State<TireStatus>> {
    public final static String ID = "Tire_FL";

    public TireFLStatus(State<TireStatus> value) {
        super(value);
    }

    public TireFLStatus(TireStatus value) {
        this(new State<TireStatus>(value));
    }

    public TireFLStatus(String value) {
        this(TireStatus.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
