package com.ablicq.pokerGame.deckTests;

import com.ablicq.pokerGame.Card;
import com.ablicq.pokerGame.Deck;
import com.ablicq.pokerGame.PokerCard;
import com.ablicq.pokerGame.PokerDeck;
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
        Assertions.assertEquals(new PokerCard(2, 1), deck.getNext());

    }

    @Test
    public void nextTest()
    {
        Card first = deck.getNext();
        assertNotEquals(first, deck.getNext());
    }
}
