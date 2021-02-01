package com.zurcnanor.tinnovatest.algorithms;

import java.util.Arrays;

public class BubbleSort {

    public Integer[] sort(Integer[] numbers) {
        System.out.print("\nSorting the following array: ");
        printArray(numbers);

        for (int k = 1; k < numbers.length - 1; k++) {
            System.out.print("\n" + k + "o round:");
            for (int i = 0; i < (numbers.length - k); i++) {
                Integer first = numbers[i];
                Integer second = numbers[i + 1];

                if (first > second){
                    numbers[i] = second;
                    numbers[i + 1] = first;
                }
            }
            printArray(numbers);
        }
        return numbers;
    }

    private void printArray(Integer[] numbers) {
        Arrays.stream(numbers)
                .forEach(n -> System.out.print(" " + n));
    }

}
