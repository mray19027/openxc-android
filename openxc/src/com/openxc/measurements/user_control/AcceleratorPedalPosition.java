package com.openxc.measurements.user_control;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.Percentage;
import com.openxc.util.Range;

/**
 * The AcceleratorPedalPosition is the percentage the pedal is depressed.
 *
 * When the pedal is fully depressed, the position is 100%. When it is not
 * pressed at all, the position is 0%.
 */
public class AcceleratorPedalPosition extends BaseMeasurement<Percentage> {
    private final static Range<Percentage> RANGE =
        new Range<Percentage>(new Percentage(0), new Percentage(100));
    public final static String ID = "AccelPdlPosn";

    public AcceleratorPedalPosition(Number value) {
        super(new Percentage(value), RANGE);
    }

    public AcceleratorPedalPosition(Percentage value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
