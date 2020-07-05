package com.jschiff.math.fpprecision;

public class PrecisionPair {
    final float low;
    final float high;
    final long numberOfValuesBetween;

    public PrecisionPair(float low, float high, long count) {
        this.low = low;
        this.high = high;
        this.numberOfValuesBetween = count;
    }

    public float GetDifference() {
        return high - low;
    }

    @Override
    public String toString() {
        return String.format("%.1f, %.1f, %d", low, high, numberOfValuesBetween);
    }

    public String toStringWithDifference() {
        return String.format("%.1f, %.1f, %.1f, %d,", low, high, GetDifference(), numberOfValuesBetween);
    }
}
