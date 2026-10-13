package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NormalizationStrategyTest {

    @Test
    void testMinMaxNormalizationBasic() {
        NormalizationStrategy strategy = new MinMaxNormalization();
        double[] input = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{0.0, 0.25, 0.5, 0.75, 1.0}, result, 0.001);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, input, 0.001);
    }

    @Test
    void testMinMaxNormalizationNegativeValues() {
        NormalizationStrategy strategy = new MinMaxNormalization();
        double[] input = {-10.0, 0.0, 10.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result, 0.001);
    }

    @Test
    void testMinMaxNormalizationAllSame() {
        NormalizationStrategy strategy = new MinMaxNormalization();
        double[] input = {5.0, 5.0, 5.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, result, 0.001);
    }

    @Test
    void testMinMaxNormalizationSingleElement() {
        NormalizationStrategy strategy = new MinMaxNormalization();
        double[] input = {42.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{0.0}, result, 0.001);
    }

    @Test
    void testMinMaxNormalizationEmptyArray() {
        NormalizationStrategy strategy = new MinMaxNormalization();
        assertThrows(IllegalArgumentException.class, () -> strategy.normalize(new double[]{}));
    }

    @Test
    void testMinMaxNormalizationNullArray() {
        NormalizationStrategy strategy = new MinMaxNormalization();
        assertThrows(IllegalArgumentException.class, () -> strategy.normalize(null));
    }

    @Test
    void testMeanCenteringNormalizationBasic() {
        NormalizationStrategy strategy = new MeanCenteringNormalization();
        double[] input = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{-2.0, -1.0, 0.0, 1.0, 2.0}, result, 0.001);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, input, 0.001);
    }

    @Test
    void testMeanCenteringNormalizationNegativeValues() {
        NormalizationStrategy strategy = new MeanCenteringNormalization();
        double[] input = {-10.0, 0.0, 10.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{-10.0, 0.0, 10.0}, result, 0.001);
    }

    @Test
    void testMeanCenteringNormalizationAllSame() {
        NormalizationStrategy strategy = new MeanCenteringNormalization();
        double[] input = {5.0, 5.0, 5.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, result, 0.001);
    }

    @Test
    void testMeanCenteringNormalizationSingleElement() {
        NormalizationStrategy strategy = new MeanCenteringNormalization();
        double[] input = {42.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{0.0}, result, 0.001);
    }

    @Test
    void testMeanCenteringNormalizationEmptyArray() {
        NormalizationStrategy strategy = new MeanCenteringNormalization();
        assertThrows(IllegalArgumentException.class, () -> strategy.normalize(new double[]{}));
    }

    @Test
    void testMeanCenteringNormalizationNullArray() {
        NormalizationStrategy strategy = new MeanCenteringNormalization();
        assertThrows(IllegalArgumentException.class, () -> strategy.normalize(null));
    }

    @Test
    void testFeatureProcessorWithMinMax() {
        FeatureProcessor processor = new FeatureProcessor(new MinMaxNormalization());
        double[] input = {0.0, 50.0, 100.0};
        double[] result = processor.process(input);

        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result, 0.001);
    }

    @Test
    void testFeatureProcessorWithMeanCentering() {
        FeatureProcessor processor = new FeatureProcessor(new MeanCenteringNormalization());
        double[] input = {10.0, 20.0, 30.0};
        double[] result = processor.process(input);

        assertArrayEquals(new double[]{-10.0, 0.0, 10.0}, result, 0.001);
    }

    @Test
    void testStrategyReplacement() {
        double[] input = {1.0, 2.0, 3.0};

        FeatureProcessor processor1 = new FeatureProcessor(new MinMaxNormalization());
        double[] result1 = processor1.process(input);
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result1, 0.001);

        FeatureProcessor processor2 = new FeatureProcessor(new MeanCenteringNormalization());
        double[] result2 = processor2.process(input);
        assertArrayEquals(new double[]{-1.0, 0.0, 1.0}, result2, 0.001);
    }

    @Test
    void testZScoreNormalizationBasic() {
        NormalizationStrategy strategy = new ZScoreNormalization();
        double[] input = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{-1.414, -0.707, 0.0, 0.707, 1.414}, result, 0.01);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, input, 0.001);
    }

    @Test
    void testZScoreNormalizationSymmetric() {
        NormalizationStrategy strategy = new ZScoreNormalization();
        double[] input = {-10.0, 0.0, 10.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{-1.225, 0.0, 1.225}, result, 0.01);
    }

    @Test
    void testZScoreNormalizationAllSame() {
        NormalizationStrategy strategy = new ZScoreNormalization();
        double[] input = {5.0, 5.0, 5.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, result, 0.001);
    }

    @Test
    void testZScoreNormalizationSingleElement() {
        NormalizationStrategy strategy = new ZScoreNormalization();
        double[] input = {42.0};
        double[] result = strategy.normalize(input);

        assertArrayEquals(new double[]{0.0}, result, 0.001);
    }

    @Test
    void testZScoreNormalizationEmptyArray() {
        NormalizationStrategy strategy = new ZScoreNormalization();
        assertThrows(IllegalArgumentException.class, () -> strategy.normalize(new double[]{}));
    }

    @Test
    void testZScoreNormalizationNullArray() {
        NormalizationStrategy strategy = new ZScoreNormalization();
        assertThrows(IllegalArgumentException.class, () -> strategy.normalize(null));
    }

    @Test
    void testFeatureProcessorWithZScore() {
        FeatureProcessor processor = new FeatureProcessor(new ZScoreNormalization());
        double[] input = {10.0, 20.0, 30.0};
        double[] result = processor.process(input);

        assertArrayEquals(new double[]{-1.225, 0.0, 1.225}, result, 0.01);
    }

    @Test
    void testThreeStrategiesReplacement() {
        double[] input = {0.0, 50.0, 100.0};

        FeatureProcessor processor1 = new FeatureProcessor(new MinMaxNormalization());
        double[] result1 = processor1.process(input);
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result1, 0.001);

        FeatureProcessor processor2 = new FeatureProcessor(new MeanCenteringNormalization());
        double[] result2 = processor2.process(input);
        assertArrayEquals(new double[]{-50.0, 0.0, 50.0}, result2, 0.001);

        FeatureProcessor processor3 = new FeatureProcessor(new ZScoreNormalization());
        double[] result3 = processor3.process(input);
        assertArrayEquals(new double[]{-1.225, 0.0, 1.225}, result3, 0.01);
    }
}
