// Nithil Suresh
// Computing ID: anh6ee@virginia.edu
// Module 3 - Blackjack
package agents;

import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;

/*
 * Define a blackjack player by inheriting from the superclass BlackjackPlayer
 *   and implementing the 3 abstract methods.
 */
public class MyBlackjackPlayer extends BlackjackPlayer{

	@Override
	public int getBet() {
		if(getChips() < 200)
			return 1;
		if(getChips() < 500)
			return 2;
		if(getChips() < 750)
			return 4;
		if(getChips() < 900)
			return 5;
		return 10;
	}

	@Override
	public Move getMove() {
		/* Hits until we get a score of 16 or better */
		if(handScore() <= 16 && handScore() >= 13) {
			if(dealer.getVisibleCard().getRank() <= 6)
				return Move.STAY; 
			if(dealer.getVisibleCard().getRank() > 6)
				return Move.HIT; 
		}
		if(handScore() == 10 || handScore() == 11)
			return Move.DOUBLE; 
		if(this.handScore() > 16) 
			return Move.STAY;
		else
			return Move.HIT;
	}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process. The dealer's hand will be
		 * found in the array of Cards that you pass when the method returns.
		 */
		
	}

	
}
