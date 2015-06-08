package com.openxc.units;

/**
 * Coordinate is a measure of the pixels on a screen.
 *
 * This is commonly used with regard to screen location(i.e. x/y coord).
 */
public class Coordinate extends Quantity<Number> {
    private final String TYPE_STRING = "Coordinate";

    public Coordinate(Number value) {
        super(value);
    }

    @Override
    public String getTypeString() {
        return TYPE_STRING;
    }
}
