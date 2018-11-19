package com.ablicq.pokerGame.cards;

/**
 * This interface defines the basic interactions of a Card
 *
 */
public interface Card
{
	/**
	 * This method gives the rank of the card (eg 3 if the card is three of spades)
	 * @return the rank as an integer
	 */
	CardRank getRank();

	/**
	 * This method gives the suit of the card (eg spades if the card is three of spades)
	 * @return the suit as an integer
	 */
	CardSuit getSuit();
}
