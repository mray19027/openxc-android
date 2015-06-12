package com.openxc.measurements.cluster;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.Celsius;
import com.openxc.util.Range;

/**
 * The AmbientTemp measurement represents the temperature of the outside ambient temperature.
 *
 * The valid range for this measurement is from -40 to 615 degrees celsius.
 */
public class AmbientTemp extends BaseMeasurement<Celsius> {
    private final static Range<Celsius> RANGE =
        new Range<Celsius>(new Celsius(-40),
                new Celsius(615));
    public final static String ID = "AMB_TEMP_AVG";

    public AmbientTemp(Number value) {
        super(new Celsius(value), RANGE);
    }
    public AmbientTemp(Celsius value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
