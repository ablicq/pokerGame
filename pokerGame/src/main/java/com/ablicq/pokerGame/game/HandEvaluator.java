package com.ablicq.pokerGame.game;

import com.ablicq.pokerGame.cards.Card;
import com.ablicq.pokerGame.cards.CardRank;

import java.util.*;

public class HandEvaluator {
    /**
     * Evaluates the value of a set of 5 cards
     * @param cards the set of cards to evaluate
     * @return the value of the hand as an int (from 0-high_card to 8-straight_flush)
     */
    public static Score evalFiveCards(ArrayList<Card> cards) {

        // compute a histogram for the values
        HashMap<CardRank, Integer> hist = new HashMap<>();
        for (Card c : cards) {
            if (hist.containsKey(c.getRank())) {
                hist.replace(c.getRank(), hist.get(c.getRank()) + 1);
            } else {
                hist.put(c.getRank(), 1);
            }
        }

        // get the values from the histogram
        Collection sVal = hist.values();

        // get the keys from the histogram
        ArrayList<CardRank> sKey = new ArrayList<>(hist.keySet());

        int maxHeight = sKey.stream().max(CardRank::compareTo).get().getVal();
        Score rank = new Score(0, maxHeight); // height

        if (sVal.contains(4)){
            CardRank height = getRankFromVal(4, hist);

            rank = new Score(7, height.getVal()); // four of a kind
        }
        else if (sVal.contains(3) && sVal.contains(2)){
            CardRank height = getRankFromVal(3, hist);
            CardRank auxHeight = getRankFromVal(2, hist);
            rank = new Score(6, height.getVal(), auxHeight.getVal()); // full house
        }
        else if (sVal.contains(3) && sVal.contains(1)){
            CardRank height = getRankFromVal(3, hist);

            rank = new Score(3, height.getVal()); // three of a kind
        }
        else if (sVal.contains(2) && sVal.contains(1) && sVal.size() == 3){
            CardRank height = null;
            CardRank auxHeight = null;
            for(Map.Entry<CardRank, Integer> e : hist.entrySet()){
                if(e.getValue() == 2) {
                    if(height == null) {
                        height = e.getKey();
                    } else {
                        auxHeight = e.getKey();
                        break;
                    }
                }
            }

            assert auxHeight != null;
            if(height.compareTo(auxHeight) < 0){
                CardRank tmp = height;
                height = auxHeight;
                auxHeight = tmp;
            }

            rank = new Score(2, height.getVal(), auxHeight.getVal()); // two pairs
        }
        else if (sVal.size() == 4){
            CardRank height = getRankFromVal(2, hist);
            rank = new Score(1, height.getVal()); // one pair
        }

        // check if the hand is a flush
        boolean isFlush = true;
        for(Card c : cards){
            if(c.getSuit() != cards.get(0).getSuit()){
                isFlush = false;
            }
        }

        // check if the hand is a straight
        Collections.sort(sKey);
        // this complicated condition takes into account the 5-high straights
        boolean isStraight = (sKey.size() == 5 && sKey.get(sKey.size()-1).getVal() - sKey.get(0).getVal() == 4) ||
                (sKey.get(sKey.size()-1).getVal() == 14 && sKey.get(sKey.size()-2).getVal() == 5);

        if (isFlush && isStraight){
            rank = new Score(8, maxHeight); // straight flush
        }
        else if (isFlush){
            rank = new Score(5, maxHeight); // flush
        }
        else if (isStraight){
            // if 5 high straight, ace is not the height, 5 is
            if (sKey.get(sKey.size()-1).getVal() == 14 && sKey.get(sKey.size()-2).getVal() == 5)
                maxHeight = 5;
            rank = new Score(4, maxHeight); // straight
        }

        return rank;
    }

    /**
     * evaluates the value of a set of 7 cards
     * @param cards the set of cards to be evaluated
     * @return The RankedHand object corresponding to the score of this hand
     * @see RankedHand
     * @see Score
     */
    public static RankedHand evalSevenCards(ArrayList<Card> cards){
        // Among all the five cards subsets of cards, find the one with the highest score
        Score rank = null;
        RankedHand bestHand = null;

        // Iterate over the cards to be removed
        for(int i=0; i<6; i++){
            for(int j=i+1; j<7; j++){
                if(i==j) continue;

                // remove the cards
                ArrayList<Card> fiveCardsSample = new ArrayList<>(cards);
                fiveCardsSample.remove(i);
                fiveCardsSample.remove(j);

                // evaluate the five cards hand
                Score sampleRank = evalFiveCards(fiveCardsSample);

                // update best hand if needed
                if (sampleRank.compareTo(rank) > 0){
                    rank = sampleRank;
                    bestHand = new RankedHand(fiveCardsSample, rank);
                }
            }
        }

        // return the best hand
        return bestHand;
    }

    /**
     * Helper function for evalFiveCards
     * Finds the rank corresponding to a value in the rank histogram
     * @param val The value to find
     * @param hist The Map in which to find the value
     * @return The rank (key) corresponding to the value
     */
    private static CardRank getRankFromVal(int val, HashMap<CardRank, Integer> hist){
        CardRank rank = null;
        for(Map.Entry<CardRank, Integer> e : hist.entrySet()){
            if(e.getValue() == val) {
                rank = e.getKey();
                break;
            }
        }
        return rank;
    }
}
