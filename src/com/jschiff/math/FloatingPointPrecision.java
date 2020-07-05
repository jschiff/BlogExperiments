package com.jschiff.math;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class FloatingPointPrecision {
    public static void main(String[] args) {
        float start = Float.parseFloat(args[0]);
        float end = Float.parseFloat(args[1]);

        var fpp = new FloatingPointPrecision();
        var results = fpp.processRange(start, end);

        results.forEach(pair -> System.out.println(pair));
    }

    public Stream<PrecisionPair> processRange(float start, float end) {
        Stream<PrecisionPair> result = Stream.generate(new PairSupplier(start, end))
                .takeWhile(p -> p != null);
        return result;
    }

    public static PrecisionPair numberOfValues(float from) {
        float cursor = from;
        float target = from + 1;
        long iterations = 0;
        while (cursor < target) {
            cursor = Math.nextUp(cursor);
            iterations++;
        }

        return new PrecisionPair(from, target, iterations);
    }

    private class PairSupplier implements Supplier<PrecisionPair> {
        final float start;
        final float target;

        float cursor;

        public PairSupplier(float start, float target) {
            this.start = start;
            this.target = target;
            cursor = start;

            if (target < start) throw new IllegalArgumentException("Start must be less than target");
        }

        @Override
        public PrecisionPair get() {
            if (cursor > target) {
                return null;
            }

            var toReturn = FloatingPointPrecision.numberOfValues(cursor);
            cursor++;
            return toReturn;
        }
    }
}
