package com.uiandroid.tennis.score.particle;

import com.uiandroid.tennis.GameStateDetector;
import com.uiandroid.tennis.score.Score;
import com.uiandroid.tennis.score.ScoreParticle;

public class SetScoreParticleModifier implements ScoreParticleModifier {

    @Override
    public boolean isApplicable(Score playerScore, Score opponentScore, GameStateDetector gameStateDetector) {
        return !gameStateDetector.isTieBreak(playerScore, opponentScore)
                && playerScore.getWonGames() >= 6
                && playerScore.getWonGames() - opponentScore.getWonGames() >= 2;
    }

    @Override
    public ScoreParticle getParticleToIncrease() {
        return ScoreParticle.WON_SETS;
    }

    @Override
    public ScoreParticle getParticleToClear() {
        return ScoreParticle.WON_GAMES;
    }
}
