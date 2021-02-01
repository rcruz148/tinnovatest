package com.zurcnanor.tinnovatest.algorithms;

public class FactorialCalculator {

    private FactorialStrategy strategy;

    public FactorialCalculator(FactorialStrategy strategy) {
        this.strategy = strategy;
    }

    public Integer calculate(Integer number) {
        return strategy.calculate(number);
    }

}

@FunctionalInterface
interface FactorialStrategy {

    Integer calculate(Integer number);

}

class FactorialRecursivelyStrategy implements FactorialStrategy {

    @Override
    public Integer calculate(Integer number) {
        if (number == 0)
            return 1;
        else
            return number * calculate(number - 1);
    }

}

class FactorialInteractiveStrategy implements FactorialStrategy {

    @Override
    public Integer calculate(Integer number) {
        int factorial = 1;
        for (int n = 2; n <= number; n++) {
            factorial *= n;
        }
        return factorial;
    }

}
