package com.openxc.measurements;

import com.openxc.units.Coordinate;
import com.openxc.util.Range;

/**
 * The EngineSpeed measurement represents the speed of the engine.
 *
 * The valid range for this measurement is from 0 to 8000 RotationsPerMinute.
 */
public class ScreenPressX extends BaseMeasurement<Coordinate> {
    private final static Range<Coordinate> RANGE =
        new Range<Coordinate>(new Coordinate(0),
                new Coordinate(65534));
    public final static String ID = "CM_TCH_X_COORD";

    public ScreenPressX(Number value) {
        super(new Coordinate(value), RANGE);
    }
    public ScreenPressX(Coordinate value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
