package com.openxc.units;

/**
 * MetersPerSecondSquared is an SI derived unit of acceleration.
 */
public class MetersPerSecondSquared extends Quantity<Number> {
    private final String TYPE_STRING = "m / s^2";

    public MetersPerSecondSquared(Number value) {
        super(value);
    }

    @Override
    public String getTypeString() {
        return TYPE_STRING;
    }
}
