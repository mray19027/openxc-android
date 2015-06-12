package com.openxc.measurements.transmission;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.State;
import com.openxc.wrappers.GearPosition;

import java.util.Locale;

/**
 * The TransmissionGearPosition is the actual current gear of the transmission.
 *
 * This measurement is the current actual gear, not the selected or desired gear
 * by the driver or computer.
 */
public class TransmissionGearPosition
        extends BaseMeasurement<State<GearPosition>> {
    public final static String ID = "PRNDL_DISP";

    public TransmissionGearPosition(State<GearPosition> value) {
        super(value);
    }

    public TransmissionGearPosition(GearPosition value) {
        this(new State<GearPosition>(value));
    }

    public TransmissionGearPosition(String value) {
        this(GearPosition.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
