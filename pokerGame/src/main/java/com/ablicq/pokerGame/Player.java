package com.ablicq.pokerGame;

import com.ablicq.pokerGame.cards.Card;

public class Player {
    private Card firstCard;
    private Card secondCard;
    private int chipStack;
    private int betStash;
    private int position;

    public Player(int chipStack) {
        this.chipStack = chipStack;
        this.betStash = 0;
        this.firstCard = null;
        this.secondCard = null;
        this.position = -1;
    }
}
