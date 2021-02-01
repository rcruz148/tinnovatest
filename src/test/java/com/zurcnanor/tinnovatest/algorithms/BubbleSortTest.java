package com.zurcnanor.tinnovatest.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    private BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void shouldSortArray() {
        assertArrayEquals(new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7 },
                bubbleSort.sort(new Integer[]{ 5, 3, 2, 4, 7, 1, 0, 6 }));

        assertArrayEquals(new Integer[]{ 1, 2, 3, 7, 9, 10, 12 },
                bubbleSort.sort(new Integer[]{ 10, 3, 9, 12, 7, 1, 2 }));
    }

}
