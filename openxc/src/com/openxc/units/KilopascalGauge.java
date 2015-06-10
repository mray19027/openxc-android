package com.openxc.units;

/**
 * KilometersPerHour is an SI derived unit of velocity.
 */
public class KilopascalGauge extends Quantity<Number> {
    private final String TYPE_STRING = "kPaG";

    public KilopascalGauge(Number value) {
        super(value);
    }

    @Override
    public String getTypeString() {
        return TYPE_STRING;
    }
}
