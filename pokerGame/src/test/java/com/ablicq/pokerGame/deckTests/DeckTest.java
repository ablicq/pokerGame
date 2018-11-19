package com.ablicq.pokerGame.deckTests;

import com.ablicq.pokerGame.cards.*;
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
        assertEquals(new PokerCard(CardRank.DEUCE, CardSuit.SPADES), deck.getNext());

    }

    @Test
    public void nextTest()
    {
        Card first = deck.getNext();
        assertNotEquals(first, deck.getNext());
    }
}
