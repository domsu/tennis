package com.uiandroid.tennis;

public interface Match {

    void pointWonBy(Player player);

    String score();

    Player getPlayerOne();

    Player getPlayerTwo();
}
