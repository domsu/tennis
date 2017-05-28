package com.uiandroid.tennis;

import com.uiandroid.tennis.score.Score;

public class Player {

    private final String name;
    private Score score;

    public Player(String name) {
        this(name, new Score());
    }

    public Player(String name, Score score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }
}
