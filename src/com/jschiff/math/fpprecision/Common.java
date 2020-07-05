package com.jschiff.math.fpprecision;

public class Common {
    public static PrecisionPair1 numberOfValues(float from) {
        float cursor = from;
        float target = from + 1;
        long iterations = 0;
        while (cursor < target) {
            cursor = Math.nextUp(cursor);
            iterations++;
        }

        return new PrecisionPair1(from, target, iterations);
    }

    public static PrecisionPair2 numberOfValuesWithFix(float from) {
        float cursor = from;
        float target = from + 1;

        // This happens if the resolution of the floating point is too fuzzy to represent from + 1
        if (target == from) {
            target = Math.nextUp(from);
        }

        long iterations = 0;
        while (cursor < target) {
            cursor = Math.nextUp(cursor);
            iterations++;
        }

        return new PrecisionPair2(from, target, iterations);
    }
}
