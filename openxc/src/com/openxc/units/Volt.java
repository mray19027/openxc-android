package com.openxc.units;

/**
 * KilometersPerHour is an SI derived unit of velocity.
 */
public class Volt extends Quantity<Number> {
    private final String TYPE_STRING = "V";

    public Volt(Number value) {
        super(value);
    }

    @Override
    public String getTypeString() {
        return TYPE_STRING;
    }
}
