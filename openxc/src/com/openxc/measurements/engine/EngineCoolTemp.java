package com.openxc.measurements.engine;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.Celsius;
import com.openxc.util.Range;

/**
 * The EngineCoolTemp measurement represents the temperature of the engine coolant.
 *
 * The valid range for this measurement is from -40 to 215 degrees celsius.
 */
public class EngineCoolTemp extends BaseMeasurement<Celsius> {
    private final static Range<Celsius> RANGE =
        new Range<Celsius>(new Celsius(-40),
                new Celsius(215));
    public final static String ID = "EngCoolTemp";

    public EngineCoolTemp(Number value) {
        super(new Celsius(value), RANGE);
    }
    public EngineCoolTemp(Celsius value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
