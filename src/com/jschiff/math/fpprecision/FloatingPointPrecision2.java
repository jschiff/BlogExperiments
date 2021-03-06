package com.jschiff.math.fpprecision;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FloatingPointPrecision2 {
    public static void main(String[] args) {
        float start = Float.parseFloat(args[0]);
        float end = Float.parseFloat(args[1]);

        var fpp = new FloatingPointPrecision2();
        var results = fpp.processRange(start, end);

        System.out.println("Low, High, Values In Between");
        results.forEach(System.out::println);
    }

    public Stream<PrecisionPair> processRange(float start, float end) {
        return Stream.generate(new PairSupplier(start, end))
                .takeWhile(Objects::nonNull);
    }

    private static class PairSupplier implements Supplier<PrecisionPair> {
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
        public PrecisionPair get() {
            if (cursor > end) {
                return null;
            }

            var toReturn = Common.numberOfValues(cursor);
            cursor = Math.max(cursor + 1, cursor * 2);
            return toReturn;
        }
    }
}
