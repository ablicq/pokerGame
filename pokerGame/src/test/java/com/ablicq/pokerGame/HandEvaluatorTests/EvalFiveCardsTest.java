package com.ablicq.pokerGame.HandEvaluatorTests;

import com.ablicq.pokerGame.game.HandEvaluator;
import com.ablicq.pokerGame.cards.Card;
import com.ablicq.pokerGame.cards.CardRank;
import com.ablicq.pokerGame.cards.CardSuit;
import com.ablicq.pokerGame.cards.PokerCard;
import com.ablicq.pokerGame.game.Score;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(0, score.getEval());
        assertEquals(14, score.getAbsoluteHeight());
        assertEquals(0, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(1, score.getEval());
        assertEquals(2, score.getAbsoluteHeight());
        assertEquals(0, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(2, score.getEval());
        assertEquals(14, score.getAbsoluteHeight());
        assertEquals(2, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(3, score.getEval());
        assertEquals(2, score.getAbsoluteHeight());
        assertEquals(0, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(4, score.getEval());
        assertEquals(6, score.getAbsoluteHeight());
        assertEquals(0, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(4, score.getEval());
        assertEquals(5, score.getAbsoluteHeight());
        assertEquals(0, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(5, score.getEval());
        assertEquals(8, score.getAbsoluteHeight());
        assertEquals(0, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(6, score.getEval());
        assertEquals(2, score.getAbsoluteHeight());
        assertEquals(5, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(7, score.getEval());
        assertEquals(2, score.getAbsoluteHeight());
        assertEquals(0, score.getAuxHeight());
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
        Score score = HandEvaluator.evalFiveCards(hand);
        assertEquals(8, score.getEval());
        assertEquals(6, score.getAbsoluteHeight());
        assertEquals(0, score.getAuxHeight());
    }
}