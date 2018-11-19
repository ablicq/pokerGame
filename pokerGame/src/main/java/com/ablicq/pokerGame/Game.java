package com.ablicq.pokerGame;

import com.ablicq.pokerGame.cards.Card;
import com.ablicq.pokerGame.cards.Deck;

import java.util.ArrayList;

public class Game {
    private enum State {PREFLOP, FLOP, TURN, RIVER}

    private ArrayList<Card> board = new ArrayList<>();
    private Deck deck;
    private int pot = 0;
    private ArrayList<Player> players;
    private State state;

    public Game(Deck deck, ArrayList<Player> players) {
        this.deck = deck;
        this.players = players;
        this.state = State.PREFLOP;
    }

    public ArrayList<Card> getBoard() {
        return board;
    }

    public int getPot() {
        return pot;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public static void main(String[] args){
        //TODO: implement the main function
    }

    private void oneHand(){
        reset();
        this.state = State.PREFLOP;
        dealNextStep();
        //manageActions();
        this.state = State.FLOP;
        dealNextStep();
        //manageActions();
        this.state = State.TURN;
        dealNextStep();
        //manageActions();
        this.state = State.RIVER;
        dealNextStep();
        //manageActions();
        //getHandResults();
    }

    private void reset(){
        deck.shuffle();
        pot = 0;
        board.clear();
    }

    private void dealNextStep(){
        switch (state){
            case PREFLOP:
                // if preflop, we deal their cards to the players
                for(Player p : players)
                    p.setFirstCard(deck.getNext());
                for(Player p : players)
                    p.setSecondCard(deck.getNext());
                return;

            case FLOP:
                // if flop, we deal three cards on the board
                for(int i = 0; i < 3; i++)
                    board.add(deck.getNext());
                return;

            case TURN:
            case RIVER:
                // if turn or river, we deal one more card to the board
                board.add(deck.getNext());
        }
    }

    private void manageActions(){

    }

    private void getHandResults(){

    }
}
