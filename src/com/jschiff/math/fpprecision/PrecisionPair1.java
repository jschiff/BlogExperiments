package com.jschiff.math.fpprecision;

public class PrecisionPair1 {
    final float low;
    final float high;
    final long numberOfValuesBetween;

    public PrecisionPair1(float low, float high, long count) {
        this.low = low;
        this.high = high;
        this.numberOfValuesBetween = count;
    }

    @Override
    public String toString() {
        return String.format("%.1f, %.1f, %d", low, high, numberOfValuesBetween);
    }
}
