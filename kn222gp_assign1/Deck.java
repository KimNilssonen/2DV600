package kn222gp_assign1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> deck = new ArrayList();
	
	public Deck() {
		for(Card.Suite suite: Card.Suite.values()) {
			int value = 1;
			for(Card.Rank rank: Card.Rank.values()) {
				deck.add(new Card(suite, rank, value));
				value++;
			}
		}
	}
	
	public void shuffle() {
		if(deckSize() == 52) {
			Collections.shuffle(deck);
		}
		else {
			System.out.println("Shuffle not possible. Deck does not contain 52 cards!");
		}
	}
	
	public Card handOutNextCard() {
		Card cardToHandOut = deck.get(0);
		deck.remove(0);
		return cardToHandOut;
	}
	
	public int deckSize() {
		return deck.size();
	}

}
