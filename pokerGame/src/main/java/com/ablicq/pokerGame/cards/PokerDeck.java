package com.ablicq.pokerGame.cards;

import java.util.ArrayList;
import java.util.Collections;

public class PokerDeck implements Deck {
    private ArrayList<Card> cards;
    private int counter;

    public PokerDeck() {
        this.cards = new ArrayList<>();
        for(CardRank r : CardRank.values()){
            for(CardSuit s : CardSuit.values()){
                this.cards.add(new PokerCard(r, s));
            }
        }
        this.shuffle();
    }

    public Card getNext() {
        return cards.get(counter++);
    }

    public void shuffle() {
        Collections.shuffle(cards);
        counter = 0;
    }
}