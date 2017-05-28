package com.uiandroid.tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testReturnsCorrectPlayerName() throws Exception {
        Player p = new Player("Dominik");
        assertEquals(p.getName(), "Dominik");
    }

}