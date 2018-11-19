package com.ablicq.pokerGame.cards;

public class PokerCard implements Card{
    private CardRank rank;
    private CardSuit suit;

    public PokerCard(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
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