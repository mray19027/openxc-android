package com.openxc.measurements.cluster;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.KilopascalGauge;
import com.openxc.util.Range;

/**
 * The OilPressure measurement represents the pressure of the oil in the engine/trans.
 *
 * The valid range for this measurement is from 0 to 1023 kPaG.
 */
public class OilPressure extends BaseMeasurement<KilopascalGauge> {
    private final static Range<KilopascalGauge> RANGE =
        new Range<KilopascalGauge>(new KilopascalGauge(0),
                new KilopascalGauge(1023));
    public final static String ID = "Oil_PRESS";

    public OilPressure(Number value) {
        super(new KilopascalGauge(value), RANGE);
    }
    public OilPressure(KilopascalGauge value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
