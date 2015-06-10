package com.openxc.measurements;

import com.openxc.units.Celsius;
import com.openxc.util.Range;

/**
 * The EngineOilTemp measurement represents the temperature of the engine oil.
 *
 * The valid range for this measurement is from -40 to 215 degrees celsius.
 */
public class IntakeAirTemp extends BaseMeasurement<Celsius> {
    private final static Range<Celsius> RANGE =
        new Range<Celsius>(new Celsius(-40),
                new Celsius(215));
    public final static String ID = "IntkAirTemp";

    public IntakeAirTemp(Number value) {
        super(new Celsius(value), RANGE);
    }
    public IntakeAirTemp(Celsius value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
