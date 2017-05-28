package com.uiandroid.tennis.score.particle;

import com.uiandroid.tennis.GameStateDetector;
import com.uiandroid.tennis.score.Score;
import com.uiandroid.tennis.score.ScoreParticle;

public class PointsScoreParticleModifier implements ScoreParticleModifier {

    @Override
    public boolean isApplicable(Score playerScore, Score opponentScore, GameStateDetector gameStateDetector) {
        return !gameStateDetector.matchFinished(playerScore, opponentScore);
    }

    @Override
    public ScoreParticle getParticleToIncrease() {
        return ScoreParticle.POINTS;
    }

    @Override
    public ScoreParticle getParticleToClear() {
        return null;
    }
}
