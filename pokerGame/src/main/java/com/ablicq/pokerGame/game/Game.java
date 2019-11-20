package com.ablicq.pokerGame.game;

import java.util.ArrayList;

/**
 * This class contains the methods needed to run a game of poker
 * It implements the logic of a game of poker, and is responsible for calling methods to
 * control the Hand object, representing the current state of the game
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

    private Hand hand;

    // ########################################################
    // ####################  Constructors  ####################
    // ########################################################

    /**
     * The constructor of the poker game
     * @param players the players for the game
     */
    public Game(ArrayList<Player> players) {
        this.players = players;
        this.hand = new Hand(players);
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

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
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
            hand.reset(players);
            for(int i = 0; i < 4; i++) {
                hand.dealCards();
                hand.manageActions();
                hand.nextPhase();
            }
            hand.results();
        }
    }

    public void addNewPlayer(Player newPlayer){ players.add(newPlayer); }

    public void removePlayer(Player p){players.remove(p);}
}
