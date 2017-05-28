package com.uiandroid.tennis.score.particle;

import com.uiandroid.tennis.GameStateDetector;
import com.uiandroid.tennis.score.Score;
import com.uiandroid.tennis.score.ScoreParticle;

public class MatchScoreParticleModifier implements ScoreParticleModifier {

    @Override
    public boolean isApplicable(Score playerScore, Score opponentScore, GameStateDetector gameStateDetector) {
        return playerScore.getWonSets() == 1;
    }

    @Override
    public ScoreParticle getParticleToIncrease() {
        return ScoreParticle.WON_MATCH;
    }

    @Override
    public ScoreParticle getParticleToClear() {
        return null;
    }

}
