package com.uiandroid.tennis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MatchTest {

    private String gameSequence;
    private String expectedScore;

    public MatchTest(String gameSequence, String expectedScore) {
        this.gameSequence = gameSequence;
        this.gameSequence = gameSequence;
        this.expectedScore = expectedScore;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getAllScores() {
        String tieBreakSequence = "111112222212";

        return Arrays.asList(new Object[][]{
                /*
                    Testing game points
                    A - point won by player 1
                    B - point won by player 2
                 */
                {"", "0-0, 0-0, 0-0"},

                {"A", "0-0, 0-0, 15-0"},
                {"AA", "0-0, 0-0, 30-0"},
                {"AAA", "0-0, 0-0, 40-0"},

                {"AB", "0-0, 0-0, 15-15"},

                {"AAB", "0-0, 0-0, 30-15"},
                {"AABB", "0-0, 0-0, 30-30"},

                {"AAAB", "0-0, 0-0, 40-15"},
                {"AAABB", "0-0, 0-0, 40-30"},

                {"AAABBB", "0-0, 0-0, DEUCE"},
                {"AAABBB" + "AB", "0-0, 0-0, DEUCE"},

                {"AAABBB" + "A", "0-0, 0-0, Advantage player 1"},
                {"AAABBB" + "AB" + "A", "0-0, 0-0, Advantage player 1"},
                {"AAABBB" + "AB" + "B", "0-0, 0-0, Advantage player 2"},

                /*
                    Testing games
                 */
                {"AAAA", "0-0, 1-0, 0-0"},
                {"AAAB" + "A", "0-0, 1-0, 0-0"},
                {"AAABB" + "A", "0-0, 1-0, 0-0"},
                {"AAABBB" + "AA", "0-0, 1-0, 0-0"},

                /*
                    Testing sets
                    1 - game won by player 1
                    2 - game won by player 2
                 */
                {"111111", "1-0, 0-0, 0-0"},
                {"111112" + "1", "1-0, 0-0, 0-0"},
                {"1111122" + "1", "1-0, 0-0, 0-0"},
                {"11111222" + "1", "1-0, 0-0, 0-0"},
                {"111112222" + "1", "1-0, 0-0, 0-0"},

                {"1111122222" + "11", "1-0, 0-0, 0-0"},

                /*
                    Testing-tie break
                 */
                {tieBreakSequence, "0-0, 6-6, 0-0"},
                {tieBreakSequence + "A", "0-0, 6-6, 1-0"},
                {tieBreakSequence + "AA", "0-0, 6-6, 2-0"},
                {tieBreakSequence + "AAA", "0-0, 6-6, 3-0"},
                {tieBreakSequence + "AAAA", "0-0, 6-6, 4-0"},
                {tieBreakSequence + "AAAAA", "0-0, 6-6, 5-0"},
                {tieBreakSequence + "AAAAAA", "0-0, 6-6, 6-0"},

                {tieBreakSequence + "AB", "0-0, 6-6, 1-1"},

                {tieBreakSequence + "AAB", "0-0, 6-6, 2-1"},
                {tieBreakSequence + "AABB", "0-0, 6-6, 2-2"},

                {tieBreakSequence + "AAAB", "0-0, 6-6, 3-1"},
                {tieBreakSequence + "AAABB", "0-0, 6-6, 3-2"},
                {tieBreakSequence + "AAABBB", "0-0, 6-6, 3-3"},

                {tieBreakSequence + "AAAAB", "0-0, 6-6, 4-1"},
                {tieBreakSequence + "AAAABB", "0-0, 6-6, 4-2"},
                {tieBreakSequence + "AAAABBB", "0-0, 6-6, 4-3"},
                {tieBreakSequence + "AAAABBBB", "0-0, 6-6, 4-4"},

                {tieBreakSequence + "AAAAAB", "0-0, 6-6, 5-1"},
                {tieBreakSequence + "AAAAABB", "0-0, 6-6, 5-2"},
                {tieBreakSequence + "AAAAABBB", "0-0, 6-6, 5-3"},
                {tieBreakSequence + "AAAAABBBB", "0-0, 6-6, 5-4"},
                {tieBreakSequence + "AAAAABBBBB", "0-0, 6-6, 5-5"},

                {tieBreakSequence + "AAAAAAB", "0-0, 6-6, 6-1"},
                {tieBreakSequence + "AAAAAABB", "0-0, 6-6, 6-2"},
                {tieBreakSequence + "AAAAAABBB", "0-0, 6-6, 6-3"},
                {tieBreakSequence + "AAAAAABBBB", "0-0, 6-6, 6-4"},
                {tieBreakSequence + "AAAAAABBBBB", "0-0, 6-6, 6-5"},
                {tieBreakSequence + "AAAAAABBBBBB", "0-0, 6-6, 6-6"},

                {tieBreakSequence + "AAAAAABBBBBB" + "A", "0-0, 6-6, 7-6"},
                {tieBreakSequence + "AAAAAABBBBBB" + "AA", "1-0, 0-0, 0-0"},

                {tieBreakSequence + "AAAAAAA", "1-0, 0-0, 0-0"},
                {tieBreakSequence + "AAAAAAB" + "A", "1-0, 0-0, 0-0"},
                {tieBreakSequence + "AAAAAABB" + "A", "1-0, 0-0, 0-0"},
                {tieBreakSequence + "AAAAAABBB" + "A", "1-0, 0-0, 0-0"},
                {tieBreakSequence + "AAAAAABBBB" + "A", "1-0, 0-0, 0-0"},
                {tieBreakSequence + "AAAAAABBBBB" + "A", "1-0, 0-0, 0-0"},
        });
    }

    @Test
    public void testCorrectScoreForGivenGameSequence() {
        Player playerOne = new Player("Dominik");
        Player playerTwo = new Player("Maria");

        Match match = MatchImpl.create(playerOne, playerTwo);

        GameSequencePlayer gamePlayer = new GameSequencePlayer();
        gamePlayer.play(gameSequence, match);

        Assert.assertEquals("Wrong score for sequence: " + gameSequence, expectedScore, match.score());
    }

}