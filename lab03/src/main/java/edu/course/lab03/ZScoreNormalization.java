package edu.course.lab03;

public class ZScoreNormalization implements NormalizationStrategy {
    @Override
    public double[] normalize(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Values array cannot be null or empty");
        }

        double[] result = new double[values.length];

        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        double mean = sum / values.length;

        double squaredDiffSum = 0.0;
        for (double value : values) {
            double diff = value - mean;
            squaredDiffSum += diff * diff;
        }
        double stdDev = Math.sqrt(squaredDiffSum / values.length);

        if (stdDev == 0.0) {
            for (int i = 0; i < values.length; i++) {
                result[i] = 0.0;
            }
        } else {
            for (int i = 0; i < values.length; i++) {
                result[i] = (values[i] - mean) / stdDev;
            }
        }

        return result;
    }
}
