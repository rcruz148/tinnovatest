package com.zurcnanor.tinnovatest.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultipleByThreeOrFiveSumTest {

    private MultipleByThreeOrFiveSum multipleByThreeOrFiveSum = new MultipleByThreeOrFiveSum();

    @Test
    public void shouldSumMultipleByThreeOrFive() {
        assertEquals(new Integer(23), multipleByThreeOrFiveSum.sumMultipleByThreeOrFive(10));
        assertEquals(new Integer(45), multipleByThreeOrFiveSum.sumMultipleByThreeOrFive(15));
        assertEquals(new Integer(98), multipleByThreeOrFiveSum.sumMultipleByThreeOrFive(21));
        assertEquals(new Integer(195), multipleByThreeOrFiveSum.sumMultipleByThreeOrFive(30));
    }

}
