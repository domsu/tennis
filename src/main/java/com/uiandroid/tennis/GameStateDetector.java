package com.uiandroid.tennis;

import com.uiandroid.tennis.score.Score;

public class GameStateDetector {

    public boolean isTieBreak(Score scoreOne, Score scoreTwo) {
        return scoreOne.getWonGames() >= 6 && scoreTwo.getWonGames() >= 6;
    }

    public boolean isAdvantage(Score higherScore, Score lowerScore) {
        return !isTieBreak(higherScore, lowerScore)
                && higherScore.getWonPoints() >= 3
                && lowerScore.getWonPoints() >= 3
                && higherScore.getWonPoints() > lowerScore.getWonPoints();
    }

    public boolean isDeuce(Score scoreOne, Score scoreTwo) {
        return !isTieBreak(scoreOne, scoreTwo)
                && scoreOne.getWonPoints() >= 3
                && scoreTwo.getWonPoints() >= 3
                && scoreOne.getWonPoints() == scoreTwo.getWonPoints();
    }

    public boolean matchFinished(Score scoreOne, Score scoreTwo) {
        return scoreOne.isWinner() || scoreTwo.isWinner();
    }

}
