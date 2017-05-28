package com.uiandroid.tennis.score;

import com.uiandroid.tennis.GameStateDetector;

public class ScorePrinter {

    private GameStateDetector gameStateDetector;

    public ScorePrinter(GameStateDetector gameStateDetector) {
        this.gameStateDetector = gameStateDetector;
    }

    public String printScore(Score playerOneScore, Score playerTwoScore) {
        String gamePointsTextScore = getPointsTextScore(playerOneScore, playerTwoScore);
        return String.format(
                "%d-%d, %d-%d, %s",
                playerOneScore.getWonSets(),
                playerTwoScore.getWonSets(),
                playerOneScore.getWonGames(),
                playerTwoScore.getWonGames(),
                gamePointsTextScore
        );
    }

    private String getPointsTextScore(Score playerOneScore, Score playerTwoScore) {
        if (gameStateDetector.isAdvantage(playerOneScore, playerTwoScore)) {
            return "Advantage player 1";
        } else if (gameStateDetector.isAdvantage(playerTwoScore, playerOneScore)) {
            return "Advantage player 2";
        } else if (gameStateDetector.isDeuce(playerOneScore, playerTwoScore)) {
            return "DEUCE";
        } else if (gameStateDetector.isTieBreak(playerOneScore, playerTwoScore)) {
            return String.format("%d-%d", playerOneScore.getWonPoints(), playerTwoScore.getWonPoints());
        } else {
            return String.format("%d-%d", convertGamePoints(playerOneScore.getWonPoints()), convertGamePoints(playerTwoScore.getWonPoints()));
        }
    }

    private int convertGamePoints(int gamePoints) {
        if (gamePoints == 0) {
            return 0;
        } else if (gamePoints == 1) {
            return 15;
        } else if (gamePoints == 2) {
            return 30;
        } else {
            return 40;
        }
    }
}
