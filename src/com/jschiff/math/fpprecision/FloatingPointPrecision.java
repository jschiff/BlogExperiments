package com.jschiff.math.fpprecision;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FloatingPointPrecision {
    public static void main(String[] args) {
        float start = Float.parseFloat(args[0]);
        float end = Float.parseFloat(args[1]);

        var fpp = new FloatingPointPrecision();
        var results = fpp.processRange(start, end);

        results.forEach(System.out::println);
    }

    public Stream<PrecisionPair1> processRange(float start, float end) {
        return Stream.generate(new PairSupplier(start, end))
                .takeWhile(Objects::nonNull);
    }

    private static class PairSupplier implements Supplier<PrecisionPair1> {
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
        public PrecisionPair1 get() {
            if (cursor > target) {
                return null;
            }

            var toReturn = Common.numberOfValues(cursor);
            cursor++;
            return toReturn;
        }
    }
}
