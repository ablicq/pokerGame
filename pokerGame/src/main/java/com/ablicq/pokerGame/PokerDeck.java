package com.ablicq.pokerGame;

import java.util.ArrayList;
import java.util.Collections;

public class PokerDeck implements Deck {
    private ArrayList<Card> cards;
    private int counter;

    public PokerDeck() {
        this.cards = new ArrayList<Card>();
        for(int r = 2; r <= 14; r++){
            for( int s = 1; s <= 4;  s++){
                this.cards.add(new PokerCard(r, s));
            }
        }
        this.counter = 0;
    }

    public Card getNext() {
        return cards.get(++counter);
    }

    public void shuffle() {
        Collections.shuffle(cards);
        counter = 0;
    }
}
