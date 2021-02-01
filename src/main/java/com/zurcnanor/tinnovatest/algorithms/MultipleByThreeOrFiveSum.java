package com.zurcnanor.tinnovatest.algorithms;

public class MultipleByThreeOrFiveSum {

    public Integer sumMultipleByThreeOrFive(Integer number) {
        int sum = 0;
        for (int n = 3; n < number; n++) {
            if (n % 3 == 0 | n % 5 == 0)
                sum += n;
        }

        return sum;
    }

}
