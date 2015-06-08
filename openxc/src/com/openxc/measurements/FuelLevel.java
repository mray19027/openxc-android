package com.openxc.measurements;

import com.openxc.units.Liter;
import com.openxc.util.Range;

/**
 * The FuelLevel is the current level of fuel in the gas tank.
 */
public class FuelLevel extends BaseMeasurement<Liter> {
    private final static Range<Liter> RANGE =
        new Range<Liter>(new Liter(0), new Liter(255));
    public final static String ID = "AvgFuelLvl";

    public FuelLevel(Number value) {
        super(new Liter(value), RANGE);
    }

    public FuelLevel(Liter value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
