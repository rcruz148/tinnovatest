package com.zurcnanor.tinnovatest.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class ElectionCalculatorTest {

    private ElectionCalculator calculator = new ElectionCalculator();

    @Test
    public void shouldCalculateElectionResult() {
        ElectionCalculator.Election election = ElectionCalculator.Election
                .builder()
                .electorTotal(1000)
                .validVotes(800)
                .whiteVotes(150)
                .nullVotes(50)
                .build();

        ElectionCalculator.ElectionResult result = calculator.calculateElectionResult(election);

        assertNotNull(result);
        assertEquals(new Double(80), result.getValidVotesPercent());
        assertEquals(new Double(15), result.getWhiteVotesPercent());
        assertEquals(new Double(5), result.getNullVotesPercent());
    }

}
