package com.openxc.units;

/**
 * KilometersPerHour is an SI derived unit of velocity.
 */
public class Celsius extends Quantity<Number> {
    private final String TYPE_STRING = "C";

    public Celsius(Number value) {
        super(value);
    }

    @Override
    public String getTypeString() {
        return TYPE_STRING;
    }
}
