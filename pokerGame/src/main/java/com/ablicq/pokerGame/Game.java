package com.ablicq.pokerGame;

import com.ablicq.pokerGame.cards.Card;
import com.ablicq.pokerGame.cards.Deck;

import java.util.ArrayList;

/**
 * This class contains the methods needed to run a game of poker
 */
public class Game {

    // ####################################################
    // #################### Attributes ####################
    // ####################################################


    /**
     * The players involved in the game
     * @see Player
     */
    private ArrayList<Player> players;

    // ########################################################
    // ####################  Constructors  ####################
    // ########################################################

    /**
     * The constructor of the poker game
     * @param deck the deck of cards with which the game will be played
     * @param players the players for the game
     */
    public Game(Deck deck, ArrayList<Player> players) {
        this.players = players;
    }

    // ###############################################################
    // ####################  Getters and Setters  ####################
    // ###############################################################

    /**
     * information about the players in this game
     * @return an ArrayList containing the players of the game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }


    // ###################################################
    // ####################  Methods  ####################
    // ###################################################

    /**
     * main method to run a game
     * repeatedly creates new hands and plays them
     */
    public void runGame(){
        while(true){
            Hand hand = new Hand(players);
            hand.play();
        }
    }

    public void addNewPlayer(Player newPlayer){ players.add(newPlayer); }

    public void removePlayer(Player p){players.remove(p);}
}
