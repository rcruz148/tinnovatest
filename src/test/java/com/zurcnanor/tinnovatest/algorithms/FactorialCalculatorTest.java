package com.zurcnanor.tinnovatest.algorithms;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class FactorialCalculatorTest {

    @Test
    public void shouldCalculateFactorialRecursively() {
        FactorialCalculator calculator = new FactorialCalculator(new FactorialRecursivelyStrategy());

        assertEquals(new Integer(1), calculator.calculate(1));
        assertEquals(new Integer(120), calculator.calculate(5));
        assertEquals(new Integer(479001600), calculator.calculate(12));
    }

    @Test
    public void shouldCalculateFactorialInteractive() {
        FactorialCalculator calculator = new FactorialCalculator(new FactorialInteractiveStrategy());

        assertEquals(new Integer(1), calculator.calculate(1));
        assertEquals(new Integer(120), calculator.calculate(5));
        assertEquals(new Integer(479001600), calculator.calculate(12));
    }

}
