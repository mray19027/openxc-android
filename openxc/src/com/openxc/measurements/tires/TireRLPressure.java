package com.openxc.measurements.tires;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.PSI;
import com.openxc.util.Range;

/**
 * The TirePressure measurement represents the pressure of a tire.
 *
 * The valid range for this measurement is from 0 to 255 psi.
 */
public class TireRLPressure extends BaseMeasurement<PSI> {
    private final static Range<PSI> RANGE =
        new Range<PSI>(new PSI(0),
                new PSI(25));
    public final static String ID = "TirePrssRL";

    public TireRLPressure(Number value) {
        super(new PSI(value), RANGE);
    }
    public TireRLPressure(PSI value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
