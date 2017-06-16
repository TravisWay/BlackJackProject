package Player;

import java.util.List;

import Deck.Card;

public abstract class Player {

	public abstract Card take(List<Card> deck);
	
	public abstract void stay();
}
