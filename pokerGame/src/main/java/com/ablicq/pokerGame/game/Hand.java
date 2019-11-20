package com.ablicq.pokerGame.game;

import com.ablicq.pokerGame.cards.Card;
import com.ablicq.pokerGame.cards.Deck;
import com.ablicq.pokerGame.cards.PokerDeck;

import java.util.ArrayList;

public class Hand {

    /**
     * An enum to store the phase of the game (preflop, flop, turn or river)
     * This helps for dealing cards and readability
     */
    private enum Phase {
        PREFLOP, FLOP, TURN, RIVER
    }


    // ####################################################
    // #################### Attributes ####################
    // ####################################################

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
    private Deck deck = new PokerDeck();

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
     * The current phase of the current hand
     * @see Phase
     */
    private Phase phase = Phase.PREFLOP;


    // ########################################################
    // ####################  Constructors  ####################
    // ########################################################

    /**
     * the constructor of a hand object
     * @param players the participants to the hand
     */
    public Hand(ArrayList<Player> players) {
        this.players = players;
    }

    // ###############################################################
    // ####################  Getters and Setters  ####################
    // ###############################################################

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


    // ##################################################
    // ####################  methods ####################
    // ##################################################


    /**
     * resets the hand and make it ready for a new hand
     * @param players the players that participate to the next hand
     */
    void reset(ArrayList<Player> players){
        board.clear();
        deck.shuffle();
        pot = 0;
        this.players = players;
        this.phase = Phase.PREFLOP;
    }

    /**
     * set the phase of the game to the next one
     * if the current phase is river, do nothing
     */
    void nextPhase(){
        switch (phase){
            case PREFLOP:
                phase = Phase.FLOP;
                return;
            case FLOP:
                phase = Phase.TURN;
                return;
            case TURN:
                phase = Phase.RIVER;
                return;
            case RIVER:
                // do nothing
        }
    }

    /**
     * Deals the cards for the next phase:
     * preflop : each player receives two cards
     * flop : three cards are dealt on the board
     * turn and river : one more card for the board
     */
    void dealCards(){
        switch (phase){
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
     * Asks the players for their action
     * each player is asked for a bet
     * if the bet is strictly less than the current bet size, it is considered as a fold
     * if the bet is equal to the current bet size it is either a check (bet size = 0) or a call (bet size > 0)
     * if the bet is strictly greater than the current bet size, it is considered as a raise
     */
    void manageActions(){
        int lastBeter = 0; // a variable to remember who was the last player to bet
        int i = 0; // the index of the current active player
        int n = players.size(); // for readability
        int currentBetSize = 0; // the current bet size

        do{
            Player p = players.get(i); // get the next player (for readability)
            if (!p.isIn()){
                // if the player folded, we directly go for the next one
                i = (i+1)%n;
                continue;
            }

            int b = p.getBet(); // otherwise, we ask for a bet

            if(b < currentBetSize)
                // if it is less than the current bet size, it is considered as a fold
                p.setIn(false);
            else if(b > currentBetSize){
                // if greater, it is a raise
                currentBetSize = b;
                lastBeter = i;
            }
            // note : the equality is not considered because there is nothing to do in this case

            i = (i+1)%n; // iterate for the next player
        }while(i%n != lastBeter); // we iterate until no one is left to act

        // go fetch the bets of each players and add these to the pot
        for(Player p : players){
            pot += p.fetchBet();
        }
    }

    /**
     * evaluates hands and gives its chips to the winner
     */
    void results(){
//        Player winner = players.get(0);
//        ArrayList<Card> winnerCards = (ArrayList<Card>) board.clone();
//        winnerCards.addAll(winner.getCards());
//        for (Player p : players){
//            ArrayList<Card> playerCards = (ArrayList<Card>) board.clone();
//            playerCards.addAll(p.getCards());
//            if(HandEvaluator.evalSevenCards(playerCards) > HandEvaluator.evalSevenCards(winnerCards)){
//                winner = p;
//                winnerCards = playerCards;
//            }
//        }
//        winner.giveChips(pot);
    }
}
