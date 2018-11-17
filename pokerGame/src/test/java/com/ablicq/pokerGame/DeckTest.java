package com.ablicq.pokerGame;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeckTest{
    private Deck deck = new PokerDeck();

    @AfterEach
    public void shuffleDeck()
    {
        deck.shuffle();
    }

    @Test
    public void initTest()
    {
        assertEquals(new PokerCard(2, 1), deck.getNext());
        assertNotEquals(new PokerCard(2, 1), deck.getNext());
    }
}
