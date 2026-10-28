package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountPolicyTest {

    @Test
    void testNoDiscount() {
        DiscountPolicy policy = new NoDiscount();
        assertEquals(100.0, policy.apply(100.0), 0.001);
        assertEquals(50.0, policy.apply(50.0), 0.001);
    }

    @Test
    void testNoDiscountNegativePrice() {
        DiscountPolicy policy = new NoDiscount();
        assertThrows(IllegalArgumentException.class, () -> policy.apply(-10.0));
    }

    @Test
    void testPercentDiscount() {
        DiscountPolicy policy = new PercentDiscount(20.0);
        assertEquals(80.0, policy.apply(100.0), 0.001);
        assertEquals(40.0, policy.apply(50.0), 0.001);
    }

    @Test
    void testPercentDiscountZero() {
        DiscountPolicy policy = new PercentDiscount(0.0);
        assertEquals(100.0, policy.apply(100.0), 0.001);
    }

    @Test
    void testPercentDiscountHundred() {
        DiscountPolicy policy = new PercentDiscount(100.0);
        assertEquals(0.0, policy.apply(100.0), 0.001);
    }

    @Test
    void testPercentDiscountInvalidPercent() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-5.0));
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(150.0));
    }

    @Test
    void testPercentDiscountNegativePrice() {
        DiscountPolicy policy = new PercentDiscount(10.0);
        assertThrows(IllegalArgumentException.class, () -> policy.apply(-50.0));
    }

    @Test
    void testPriceCalculatorWithNoDiscount() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calculator.calculateFinalPrice(100.0), 0.001);
    }

    @Test
    void testPriceCalculatorWithPercentDiscount() {
        PriceCalculator calculator = new PriceCalculator(new PercentDiscount(25.0));
        assertEquals(75.0, calculator.calculateFinalPrice(100.0), 0.001);
    }

    @Test
    void testPolicyReplacement() {
        PriceCalculator calculator1 = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calculator1.calculateFinalPrice(100.0), 0.001);

        PriceCalculator calculator2 = new PriceCalculator(new PercentDiscount(20.0));
        assertEquals(80.0, calculator2.calculateFinalPrice(100.0), 0.001);
    }
}
