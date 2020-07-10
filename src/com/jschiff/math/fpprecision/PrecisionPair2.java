package com.jschiff.math.fpprecision;

public class PrecisionPair2 {
    final float low;
    final float high;
    final long numberOfValuesBetween;

    public PrecisionPair2(float low, float high, long count) {
        this.low = low;
        this.high = high;
        this.numberOfValuesBetween = count;
    }

    public float GetDifference() {
        return high - low;
    }

    @Override
    public String toString() {
        return String.format("%d, %d, %d, %d", (long)low, (long)high, numberOfValuesBetween, (long)GetDifference());
    }
}
