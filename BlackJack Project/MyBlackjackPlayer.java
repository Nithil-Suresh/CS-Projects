// Nithil Suresh
package agents;

import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;


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

		
	}

	
}
