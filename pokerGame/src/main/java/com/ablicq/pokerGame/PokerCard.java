package com.ablicq.pokerGame;

public class PokerCard implements Card{
    private int rank;
    private int suit;

    public PokerCard(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }
}
