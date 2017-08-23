package com.gbcs.XPSPositioner.data;

import javafx.util.StringConverter;

/**
 * 
 * @author Sébastien
 *
 */
public class DoubleRangeStringConverter extends StringConverter<Double> {

    private final double min;
    private final double max;

    /**
     * DoubleRangeStringConverter ctor
     * @param min
     * @param max
     */
    public DoubleRangeStringConverter(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString(Double object) {
        return String.format("%f", object);
    }

    @Override
    public Double fromString(String string) {
        double dble = Double.parseDouble(string);
        if (dble > max || dble < min) {
            throw new IllegalArgumentException();
        }

        return dble;
    }
}