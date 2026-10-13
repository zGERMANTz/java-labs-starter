package edu.course.lab03;

public class MinMaxNormalization implements NormalizationStrategy {
    @Override
    public double[] normalize(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Values array cannot be null or empty");
        }

        double[] result = new double[values.length];

        double min = values[0];
        double max = values[0];
        for (double value : values) {
            if (value < min) min = value;
            if (value > max) max = value;
        }

        if (min == max) {
            for (int i = 0; i < values.length; i++) {
                result[i] = 0.0;
            }
        } else {
            for (int i = 0; i < values.length; i++) {
                result[i] = (values[i] - min) / (max - min);
            }
        }

        return result;
    }
}
