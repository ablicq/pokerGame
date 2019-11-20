package com.ablicq.pokerGame.cards;

public enum CardRank implements Comparable<CardRank> {
    DEUCE (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    TEN (10),
    JACK (11),
    QUEEN (12),
    KING (13),
    ACE (14);

    private int val;

    CardRank(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }
}
