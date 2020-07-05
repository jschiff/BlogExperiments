package com.jschiff.math;

public class PrecisionPair {
    final float low;
    final float high;
    final long numberOfValuesBetween;

    public PrecisionPair(float low, float high, long count) {
        this.low = low;
        this.high = high;
        this.numberOfValuesBetween = count;
    }

    @Override
    public String toString() {
        return String.format("%f, %d", low, numberOfValuesBetween);
    }
}
