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

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof PokerCard)) return false;
        PokerCard card = (PokerCard) obj;
        return (rank == card.getRank() && suit == card.getSuit());
    }
}