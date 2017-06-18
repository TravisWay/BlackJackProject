package Player;

import java.util.ArrayList;
import java.util.List;

import Deck.Card;

public abstract class Player {

	public List<Card> hand = new ArrayList<>(10);

	public List<Card> getHand() {
		return hand;
	}

	public abstract void setHand(Card card);

	public abstract void stay();
}
