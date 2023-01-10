// Nithil Suresh
// Computing ID: anh6ee@virginia.edu
// Module 3 - Blackjack
package casino;

/**
 * A stack of more than one deck used in a casino game
 *
 */
public class DeckStack {
	
	//An array of decks of cards that comprise this multi-deck.
	private Deck[] decks;

	// you may need other instance variables here
	
	
	//Constructor: instantiates the number of decks specified and
	//adds them to the list of decks
	public DeckStack(int numDecks) {
		decks = new Deck[numDecks];
		for(int i = 0; i < decks.length; i++) {
			decks[i] = new Deck();
		}
	}
	
	
	//Deals the top card from the stack of decks and returns that Card.
	//You can implement this several ways, as long as it correctly
	//deals a card from one of the decks.  
	//Important: if you’ve dealt the last card in all the decks, you’ll want 
	//to reshuffle all the decks and start over again
	public Card dealTopCard() {
		for(int i = 0; i < decks.length; i++) {
			if(decks[i] != null)
				return decks[i].dealTopCard();
		}
		for(int i = 0; i < decks.length; i++) {
			decks[i].shuffle();
		}
		return decks[0].dealTopCard();
	}
	
	
	//Reshuffles all of the decks.
	protected void restoreDecks() {
		for(int i = 0; i < decks.length; i++) {
			decks[i].restockDeck();
		}
	}
	
	
	//returns the number of cards left to be dealt in the entire stack of cards.
	public int cardsLeft() {
		int count = 0;
		for(int i = 0; i < decks.length; i++) {
			count += decks[i].cardsLeft();
		}
		return count;
	}
	
	
}
