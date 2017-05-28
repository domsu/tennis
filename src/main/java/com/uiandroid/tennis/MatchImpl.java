package com.uiandroid.tennis;

import com.uiandroid.tennis.score.ScoreCalculator;
import com.uiandroid.tennis.score.ScorePrinter;

public class MatchImpl implements Match {

    private final Player playerOne;
    private final Player playerTwo;
    private final ScorePrinter scorePrinter;
    private final ScoreCalculator scoreCalculator;

    MatchImpl(Player playerOne, Player playerTwo, ScorePrinter scorePrinter, ScoreCalculator scoreCalculator) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scorePrinter = scorePrinter;
        this.scoreCalculator = scoreCalculator;
    }

    public static Match create(Player playerOne, Player playerTwo) {
        GameStateDetector gameStateDetector = new GameStateDetector();
        ScorePrinter scorePrinter = new ScorePrinter(gameStateDetector);
        ScoreCalculator scoreCalculator = new ScoreCalculator(gameStateDetector);
        return new MatchImpl(playerOne, playerTwo, scorePrinter, scoreCalculator);
    }

    @Override
    public void pointWonBy(Player player) {
        scoreCalculator.playerScored(player.getScore(), getOpponent(player).getScore());
    }

    @Override
    public String score() {
        return scorePrinter.printScore(playerOne.getScore(), playerTwo.getScore());
    }

    @Override
    public Player getPlayerOne() {
        return playerOne;
    }

    @Override
    public Player getPlayerTwo() {
        return playerTwo;
    }

    private Player getOpponent(Player player) {
        if (player == playerOne) return playerTwo;
        return playerOne;
    }
}
