package com.ablicq.pokerGame.HandEvaluatorTests;

import com.ablicq.pokerGame.game.HandEvaluator;
import com.ablicq.pokerGame.cards.Card;
import com.ablicq.pokerGame.cards.CardRank;
import com.ablicq.pokerGame.cards.CardSuit;
import com.ablicq.pokerGame.cards.PokerCard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvalFiveCardsTest {

    private ArrayList<Card> generateNothing(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.FOUR, CardSuit.DIAMONDS));
        hand.add(new PokerCard(CardRank.ACE, CardSuit.CLUBS));
        hand.add(new PokerCard(CardRank.NINE, CardSuit.HEARTS));
        hand.add(new PokerCard(CardRank.TEN, CardSuit.DIAMONDS));
        return hand;
    }

    @Test
    public void nothingTest(){
        ArrayList<Card> hand = generateNothing();
        assertEquals(0, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generatePair(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.DIAMONDS));
        hand.add(new PokerCard(CardRank.ACE, CardSuit.CLUBS));
        hand.add(new PokerCard(CardRank.NINE, CardSuit.HEARTS));
        hand.add(new PokerCard(CardRank.TEN, CardSuit.DIAMONDS));
        return hand;
    }

    @Test
    public void pairTest(){
        ArrayList<Card> hand = generatePair();
        assertEquals(1, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generateTwoPairs(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.DIAMONDS));
        hand.add(new PokerCard(CardRank.ACE, CardSuit.CLUBS));
        hand.add(new PokerCard(CardRank.ACE, CardSuit.HEARTS));
        hand.add(new PokerCard(CardRank.TEN, CardSuit.DIAMONDS));
        return hand;
    }

    @Test
    public void twoPairsTest(){
        ArrayList<Card> hand = generateTwoPairs();
        assertEquals(2, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generateThreeOfAKind(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.DIAMONDS));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.CLUBS));
        hand.add(new PokerCard(CardRank.NINE, CardSuit.HEARTS));
        hand.add(new PokerCard(CardRank.TEN, CardSuit.DIAMONDS));
        return hand;
    }

    @Test
    public void ThreeOfAKindTest(){
        ArrayList<Card> hand = generateThreeOfAKind();
        assertEquals(3, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generateStraight1(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.FOUR, CardSuit.DIAMONDS));
        hand.add(new PokerCard(CardRank.THREE, CardSuit.CLUBS));
        hand.add(new PokerCard(CardRank.FIVE, CardSuit.HEARTS));
        hand.add(new PokerCard(CardRank.SIX, CardSuit.DIAMONDS));
        return hand;
    }

    @Test
    public void straight1Test(){
        ArrayList<Card> hand = generateStraight1();
        assertEquals(4, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generateStraight2(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.FOUR, CardSuit.DIAMONDS));
        hand.add(new PokerCard(CardRank.THREE, CardSuit.CLUBS));
        hand.add(new PokerCard(CardRank.FIVE, CardSuit.HEARTS));
        hand.add(new PokerCard(CardRank.ACE, CardSuit.DIAMONDS));
        return hand;
    }

    @Test
    public void straight2Test(){
        ArrayList<Card> hand = generateStraight2();
        assertEquals(4, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generateFlush(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.FOUR, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.EIGHT, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.FIVE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.SIX, CardSuit.SPADES));
        return hand;
    }

    @Test
    public void flushTest(){
        ArrayList<Card> hand = generateFlush();
        assertEquals(5, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generateFullHouse(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.CLUBS));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.DIAMONDS));
        hand.add(new PokerCard(CardRank.FIVE, CardSuit.HEARTS));
        hand.add(new PokerCard(CardRank.FIVE, CardSuit.SPADES));
        return hand;
    }

    @Test
    public void fullHouseTest(){
        ArrayList<Card> hand = generateFullHouse();
        assertEquals(6, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generateFourOfAKind(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.CLUBS));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.DIAMONDS));
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.HEARTS));
        hand.add(new PokerCard(CardRank.SIX, CardSuit.SPADES));
        return hand;
    }

    @Test
    public void fourOfAKindTest(){
        ArrayList<Card> hand = generateFourOfAKind();
        assertEquals(7, HandEvaluator.evalFiveCards(hand));
    }

    private ArrayList<Card> generateStraightFlush(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new PokerCard(CardRank.DEUCE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.FOUR, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.THREE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.FIVE, CardSuit.SPADES));
        hand.add(new PokerCard(CardRank.SIX, CardSuit.SPADES));
        return hand;
    }

    @Test
    public void straightFlushTest(){
        ArrayList<Card> hand = generateStraightFlush();
        assertEquals(8, HandEvaluator.evalFiveCards(hand));
    }
}