package com.openxc.units;

/**
 * KilometersPerHour is an SI derived unit of velocity.
 */
public class PSI extends Quantity<Number> {
    private final String TYPE_STRING = "psi";

    public PSI(Number value) {
        super(value);
    }

    @Override
    public String getTypeString() {
        return TYPE_STRING;
    }
}
