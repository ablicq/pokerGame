package com.ablicq.pokerGame;

import com.ablicq.pokerGame.cards.Card;
import com.ablicq.pokerGame.cards.CardRank;

import java.util.*;

public class HandEvaluator {
    public static int evalFiveCards(ArrayList<Card> cards) {

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

        int rank = 0;

        if (sVal.contains(4)){
            rank = 7; // four of a kind
        }
        else if (sVal.contains(3) && sVal.contains(2)){
            rank = 6; // full house
        }
        else if (sVal.contains(3) && sVal.contains(1)){
            rank = 3; // three of a kind
        }
        else if (sVal.contains(2) && sVal.contains(1) && sVal.size() == 3){
            rank = 2; // two pairs
        }
        else if (sVal.size() == 4){
            rank = 1; // one pair
        }

        System.out.println(rank);

        // check if the hand is a flush
        boolean isFlush = true;
        for(Card c : cards){
            if(c.getSuit() != cards.get(0).getSuit()){
                isFlush = false;
            }
        }

        // check if the hand is a straight
        ArrayList<CardRank> sKey = new ArrayList<>(hist.keySet());
        Collections.sort(sKey);
        // this complicated condition takes into account the 5-high straights
        boolean isStraight = (sKey.size() == 5 && sKey.get(sKey.size()-1).getVal() - sKey.get(0).getVal() == 4) ||
                (sKey.get(sKey.size()-1).getVal() == 14 && sKey.get(sKey.size()-2).getVal() == 5);

        System.out.println(isStraight);

        if (isFlush && isStraight){
            rank = 8; // straight flush
        }
        else if (isFlush){
            rank = 5; // flush
        }
        else if (isStraight){
            rank = 4; // straight
        }

        System.out.println(rank);

        return rank;
    }
}
