package com.ablicq.pokerGame.game;

import com.ablicq.pokerGame.cards.Card;

import java.util.ArrayList;

public class RankedHand {
    private ArrayList<Card> cards;
    private Score score;

    public RankedHand(ArrayList<Card> cards, Score score) {
        this.cards = cards;
        this.score = score;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Score getScore() {
        return score;
    }
}
