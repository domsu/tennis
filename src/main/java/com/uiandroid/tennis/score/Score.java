package com.uiandroid.tennis.score;

public class Score {

    private boolean winner;
    private int wonSets;
    private int wonGames;
    private int wonPoints;

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getWonSets() {
        return wonSets;
    }

    public void setWonSets(int wonSets) {
        this.wonSets = wonSets;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }

    public int getWonPoints() {
        return wonPoints;
    }

    public void setWonPoints(int wonPoints) {
        this.wonPoints = wonPoints;
    }
}

