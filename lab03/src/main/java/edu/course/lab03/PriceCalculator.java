package edu.course.lab03;

public class PriceCalculator {
    private final DiscountPolicy discountPolicy;

    public PriceCalculator(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double calculateFinalPrice(double price) {
        return discountPolicy.apply(price);
    }
}
