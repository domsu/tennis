package com.uiandroid.tennis.score.particle;

import com.sun.istack.internal.Nullable;
import com.uiandroid.tennis.GameStateDetector;
import com.uiandroid.tennis.score.Score;
import com.uiandroid.tennis.score.ScoreParticle;

public interface ScoreParticleModifier {

    boolean isApplicable(Score playerScore, Score opponentScore, GameStateDetector gameStateDetector);

    ScoreParticle getParticleToIncrease();

    @Nullable
    ScoreParticle getParticleToClear();
}
