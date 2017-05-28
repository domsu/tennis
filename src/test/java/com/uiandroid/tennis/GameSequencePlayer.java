package com.uiandroid.tennis;

class GameSequencePlayer {

    private final static char PLAYER_ONE_SCORE_CODE = 'A';
    private final static char PLAYER_TWO_SCORE_CODE = 'B';

    private final static char PLAYER_ONE_GAME_CODE = '1';
    private final static char PLAYER_TWO_GAME_CODE = '2';

    void play(String scenario, Match match) {
        for (char code : scenario.toCharArray()) {
            switch (code) {
                case PLAYER_ONE_SCORE_CODE:
                    match.pointWonBy(match.getPlayerOne());
                    break;
                case PLAYER_TWO_SCORE_CODE:
                    match.pointWonBy(match.getPlayerTwo());
                    break;
                case PLAYER_ONE_GAME_CODE:
                    match.pointWonBy(match.getPlayerOne());
                    match.pointWonBy(match.getPlayerOne());
                    match.pointWonBy(match.getPlayerOne());
                    match.pointWonBy(match.getPlayerOne());
                    break;
                case PLAYER_TWO_GAME_CODE:
                    match.pointWonBy(match.getPlayerTwo());
                    match.pointWonBy(match.getPlayerTwo());
                    match.pointWonBy(match.getPlayerTwo());
                    match.pointWonBy(match.getPlayerTwo());
                    break;
            }
        }
    }
}
