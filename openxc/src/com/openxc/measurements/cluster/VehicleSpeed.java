package com.openxc.measurements.cluster;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.KilometersPerHour;
import com.openxc.util.Range;

/**
 * The VehicleSpeed is the current forward speed of the vehicle.
 */
public class VehicleSpeed extends BaseMeasurement<KilometersPerHour> {
    private final static Range<KilometersPerHour> RANGE =
        new Range<KilometersPerHour>(new KilometersPerHour(0.0),
                new KilometersPerHour(511.98));
    public final static String ID = "VEH_SPEED";

    public VehicleSpeed(KilometersPerHour value) {
        super(value, RANGE);
    }

    public VehicleSpeed(Number value) {
        this(new KilometersPerHour(value.doubleValue()));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
