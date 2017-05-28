package com.uiandroid.tennis.score.particle;

import com.uiandroid.tennis.GameStateDetector;
import com.uiandroid.tennis.score.Score;
import com.uiandroid.tennis.score.ScoreParticle;

public class TieBreakGameScoreParticleModifier implements ScoreParticleModifier {

    @Override
    public boolean isApplicable(Score playerScore, Score opponentScore, GameStateDetector gameStateDetector) {
        return gameStateDetector.isTieBreak(playerScore, opponentScore)
                && playerScore.getWonPoints() >= 7
                && playerScore.getWonPoints() - opponentScore.getWonPoints() >= 2;
    }

    @Override
    public ScoreParticle getParticleToIncrease() {
        return ScoreParticle.WON_GAMES;
    }

    @Override
    public ScoreParticle getParticleToClear() {
        return ScoreParticle.POINTS;
    }


}
