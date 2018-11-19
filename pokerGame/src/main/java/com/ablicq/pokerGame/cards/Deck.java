package com.ablicq.pokerGame.cards;

/**
 * This interface defines the basic interactions with a Deck of cards
 *
 */
public interface Deck
{
	/**
	 * This method draws the next card in the deck
	 * @return the Card object that were drawn
	 */
	Card getNext();

	/**
	 * This method shuffles the deck (and puts back in it all the cards that were drawn)
	 */
	void shuffle();
}
