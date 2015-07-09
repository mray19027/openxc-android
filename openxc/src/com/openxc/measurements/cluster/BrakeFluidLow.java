package com.openxc.measurements.cluster;

import com.openxc.measurements.BaseMeasurement;
import com.openxc.units.Boolean;

/**
 * The BrakeFluidLow measurement knows if the brake fluid is low or not
 */
public class BrakeFluidLow extends BaseMeasurement<Boolean> {
    public final static String ID = "BRK_FLUID_LO";

    public BrakeFluidLow(Boolean value) {
        super(value);
    }

    public BrakeFluidLow(java.lang.Boolean value) {
        this(new Boolean(value));
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
