package com.jschiff.math.fpprecision;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FloatingPointPrecision3 {
    public static void main(String[] args) {
        float start = Float.parseFloat(args[0]);
        float end = Float.parseFloat(args[1]);

        var fpp = new FloatingPointPrecision3();
        var results = fpp.processRange(start, end);

        System.out.println("Low, High, Values In Between, Distance Between Values");
        results.forEach(pair -> System.out.println(pair.toString()));
    }

    public Stream<PrecisionPair2> processRange(float start, float end) {
        return Stream.generate(new PairSupplier(start, end))
                .takeWhile(Objects::nonNull);
    }

    private static class PairSupplier implements Supplier<PrecisionPair2> {
        final float start;
        final float end;

        float cursor;

        public PairSupplier(float start, float end) {
            this.start = start;
            this.end = end;
            cursor = start;

            if (end < start) throw new IllegalArgumentException("Start must be less than target");
        }

        @Override
        public PrecisionPair2 get() {
            if (cursor > end) {
                return null;
            }

            var toReturn = Common.numberOfValuesWithFix(cursor);
            cursor = Math.max(cursor + 1, cursor * 2);
            return toReturn;
        }
    }
}
