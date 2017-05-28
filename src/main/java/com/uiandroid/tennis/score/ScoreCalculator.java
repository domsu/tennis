package com.uiandroid.tennis.score;

import com.uiandroid.tennis.GameStateDetector;
import com.uiandroid.tennis.score.particle.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScoreCalculator {

    private final List<ScoreParticleModifier> scoreModifiers;
    private final GameStateDetector gameStateDetector;

    public ScoreCalculator(GameStateDetector gameStateDetector) {
        this.gameStateDetector = gameStateDetector;
        this.scoreModifiers = Collections.unmodifiableList(
                Arrays.asList(
                        new PointsScoreParticleModifier(),
                        new GameScoreParticleModifier(),
                        new TieBreakGameScoreParticleModifier(),
                        new SetScoreParticleModifier(),
                        new TieBreakSetScoreParticleModifier(),
                        new MatchScoreParticleModifier()
                )
        );
    }

    public void playerScored(Score playerScore, Score opponentScore) {
        scoreModifiers.forEach(modifier -> {

                    if (modifier.isApplicable(playerScore, opponentScore, gameStateDetector)) {
                        ScoreParticle particleToIncrease = modifier.getParticleToIncrease();
                        increaseScoreParticle(particleToIncrease, playerScore);

                        ScoreParticle particleToClear = modifier.getParticleToClear();
                        if (particleToClear != null) {
                            clearScoreParticle(particleToClear, playerScore);
                            clearScoreParticle(particleToClear, opponentScore);
                        }
                    }
                }
        );
    }

    private void increaseScoreParticle(ScoreParticle scoreParticle, Score score) {
        switch (scoreParticle) {
            case POINTS:
                score.setWonPoints(score.getWonPoints() + 1);
                break;
            case WON_GAMES:
                score.setWonGames(score.getWonGames() + 1);
                break;
            case WON_SETS:
                score.setWonSets(score.getWonSets() + 1);
                break;
            case WON_MATCH:
                score.setWinner(true);
                break;
        }
    }

    private void clearScoreParticle(ScoreParticle scoreParticle, Score score) {
        switch (scoreParticle) {
            case POINTS:
                score.setWonPoints(0);
                break;
            case WON_GAMES:
                score.setWonGames(0);
                break;
        }
    }


}
