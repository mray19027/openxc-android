package com.openxc.measurements;

import com.openxc.units.Volt;
import com.openxc.util.Range;

/**
 * The BatteryVoltage measurement represents the voltage of the battery.
 *
 * The valid range for this measurement is from 0 to 25 volts.
 */
public class BatteryVoltage extends BaseMeasurement<Volt> {
    private final static Range<Volt> RANGE =
        new Range<Volt>(new Volt(0),
                new Volt(25));
    public final static String ID = "BATT_VOLT";

    public BatteryVoltage(Number value) {
        super(new Volt(value), RANGE);
    }
    public BatteryVoltage(Volt value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
