package com.ablicq.pokerGame;

import com.ablicq.pokerGame.cards.Card;
import com.ablicq.pokerGame.cards.Deck;

import java.util.ArrayList;

/**
 * This class contains the methods needed to run a game of poker
 */
public class Game {

    /**
     * An enum to store the state of the game (preflop, flop, turn or river)
     * This helps for dealing cards and readability
     */
    private enum State {PREFLOP, FLOP, TURN, RIVER}


    /**
     * The board of the game ie the cards that has been dealt
     * and that are available for everyone
     * @see Card
     * @see com.ablicq.pokerGame.cards.PokerCard
     */
    private ArrayList<Card> board = new ArrayList<>();

    /**
     * The deck of cards with which the game is played
     * @see Deck
     * @see com.ablicq.pokerGame.cards.PokerDeck
     */
    private Deck deck;

    /**
     * The total amount of chips that were bet by the players during the current hand
     * Is won by the winner of the hand
     */
    private int pot = 0;

    /**
     * The players involved in the game
     * @see Player
     */
    private ArrayList<Player> players;

    /**
     * The current state of the current hand
     * @see State
     */
    private State state;

    /**
     * The constructor of the poker game
     * @param deck the deck of cards with which the game will be played
     * @param players the players for the game
     */
    public Game(Deck deck, ArrayList<Player> players) {
        this.deck = deck;
        this.players = players;
        this.state = State.PREFLOP;
    }

    /**
     * A method to get the information about the board cards
     * @return an ArrayList containing the cards on the board
     */
    public ArrayList<Card> getBoard() {
        return board;
    }

    /**
     * A method to get the amount of chips in the pot
     * @return an int indicating how many chips there is in the pot
     */
    public int getPot() {
        return pot;
    }

    /**
     * information about the players in this game
     * @return an ArrayList containing the players of the game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * the main function that runs the game loop
     * @param args currently, no argument is parsed for the main function
     */
    public static void main(String[] args){
        //TODO: implement the main function
    }

    /**
     * Emulates one hand of the game
     */
    private void oneHand(){
        reset(); // first, reset the game
        this.state = State.PREFLOP; // then, it is time for the preflop
        dealNextStep(); // deal the cards
        //manageActions(); // wait for actions
        this.state = State.FLOP; // then the flop
        dealNextStep(); // deal the cards
        //manageActions(); // wait for actions
        this.state = State.TURN; // then, the turn
        dealNextStep(); // deal the cards
        //manageActions(); // wait for actions
        this.state = State.RIVER; // then, the river
        dealNextStep(); // deal the cards
        //manageActions(); // wait for actions
             board.clear(); // clear the board   //getHandResults(); // finally, get the results and give the reward
    }

    /**
     * Resets the game for another hand
     */
    private void reset(){
        board.clear(); // clear the board
        deck.shuffle(); // shuffle the deck
        pot = 0; // empty the pot
    }

    /**
     * Deals the cards for the next step:
     * preflop : each player receives two cards
     * flop : three cards are dealt on the board
     * turn and river : one more card for the board
     */
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

    /**
     * Asks the players for their action (bet, check, fold, call, raise)
     */
    private void manageActions(){

    }

    /**
     * evaluates hands and gives its chips to the winner
     */
    private void getHandResults(){

    }
}
