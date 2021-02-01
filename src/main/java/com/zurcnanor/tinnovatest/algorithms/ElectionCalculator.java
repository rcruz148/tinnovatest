package com.zurcnanor.tinnovatest.algorithms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ElectionCalculator {

    public ElectionResult calculateElectionResult(Election election) {
        return ElectionResult.builder()
                .validVotesPercent(getPercentValidVotes(election))
                .whiteVotesPercent(getPercentWhiteVotes(election))
                .nullVotesPercent(getPercentNullVotes(election))
                .build();
    }

    private double getPercentValidVotes(Election election) {
        return (election.getValidVotes() / election.getElectorTotal() * 100);
    }

    private double getPercentWhiteVotes(Election election) {
        return (election.getWhiteVotes() / election.getElectorTotal() * 100);
    }

    private double getPercentNullVotes(Election election) {
        return (election.getNullVotes() / election.getElectorTotal() * 100);
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Election {

        private double electorTotal;

        private double validVotes;

        private double whiteVotes;

        private double nullVotes;

    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class ElectionResult {

        private Double validVotesPercent;

        private Double whiteVotesPercent;

        private Double nullVotesPercent;

    }

}
