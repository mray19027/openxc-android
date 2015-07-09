package com.openxc.measurements.cluster;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.Celsius;
import com.openxc.util.Range;

/**
 * The OutsideAirTemp measurement represents the temperature of the outside ambient temperature.
 *
 * The valid range for this measurement is from -40 to 87 degrees celsius.
 */
public class OutsideAirTemp extends BaseMeasurement<Celsius> {
    private final static Range<Celsius> RANGE =
        new Range<Celsius>(new Celsius(-40),
                new Celsius(87));
    public final static String ID = "AirTemp_Outsd";

    public OutsideAirTemp(Number value) {
        super(new Celsius(value), RANGE);
    }
    public OutsideAirTemp(Celsius value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
