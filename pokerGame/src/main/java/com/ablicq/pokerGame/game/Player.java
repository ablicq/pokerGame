package com.ablicq.pokerGame.game;

import com.ablicq.pokerGame.cards.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Card firstCard;
    private Card secondCard;
    private int chipStack;
    private int betStash;
    private boolean isIn = true;

    public Player(int chipStack) {
        this.chipStack = chipStack;
        this.betStash = 0;
        this.firstCard = null;
        this.secondCard = null;
    }

    public ArrayList<Card> getCards(){
        ArrayList<Card> ret = new ArrayList<>();
        ret.add(firstCard);
        ret.add(secondCard);
        return ret;
    }

    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public void setSecondCard(Card secondCard) {
        this.secondCard = secondCard;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    public boolean isIn(){
        return isIn;
    }

    public int getChipStack() {
        return chipStack;
    }

    public int getBetStash() {
        return betStash;
    }

    public void giveChips(int nbChips){
        chipStack += nbChips;
    }

    public int getBet() {
        Scanner sc = new Scanner(System.in);
        int b = 0;
        do {
            if (b > chipStack){
                System.out.println("Invalid bet!\nPlease enter a bet size smaller than your current Chipstack : " + chipStack + " chips.");
            }
            System.out.println("Please, enter a bet");
            b = sc.nextInt();
        } while (b > chipStack);
        chipStack -= b;
        betStash += b;
        return b;
    }

    public int fetchBet(){
        int b = betStash;
        betStash = 0;
        return b;
    }
}
