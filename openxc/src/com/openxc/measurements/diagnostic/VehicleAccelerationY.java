package com.openxc.measurements.diagnostic;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.MetersPerSecondSquared;
import com.openxc.util.Range;

/**
 * The VehicleAccelerationX is the vehicles forward acceleration in units of meters per second squared
 */
public class VehicleAccelerationY extends BaseMeasurement<MetersPerSecondSquared> {
    private final static Range<MetersPerSecondSquared> RANGE =
        new Range<MetersPerSecondSquared>(new MetersPerSecondSquared(-10.24),
                new MetersPerSecondSquared(10.24));
    public final static String ID = "VehAccel_Y";

    public VehicleAccelerationY(MetersPerSecondSquared value) {
        super(value, RANGE);
    }

    public VehicleAccelerationY(Number value) {
        this(new MetersPerSecondSquared(value.doubleValue()));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
