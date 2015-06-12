package com.openxc.measurements.engine;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.Celsius;
import com.openxc.util.Range;

/**
 * The EngineOilTemp measurement represents the temperature of the engine oil.
 *
 * The valid range for this measurement is from -40 to 215 degrees celsius.
 */
public class EngineOilTemp extends BaseMeasurement<Celsius> {
    private final static Range<Celsius> RANGE =
        new Range<Celsius>(new Celsius(-40),
                new Celsius(215));
    public final static String ID = "EngOilTemp";

    public EngineOilTemp(Number value) {
        super(new Celsius(value), RANGE);
    }
    public EngineOilTemp(Celsius value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
