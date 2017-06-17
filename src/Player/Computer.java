package Player;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import Deck.*;

public class Computer extends Player {
	//Computer/AI player is made with a hand for cards, shuffle, deal, and stay actions 
	public void setHand(Card card) {
		// TODO Auto-generated method stub
		hand.add(card);
	}

	public List<Card> getHand() {
		// TODO Auto-generated method stub
		return super.getHand();
	}

	public List<Card> shuffle(List<Card> toShuffle) {
		Collections.shuffle(toShuffle);
		return toShuffle;

	}

	public static Card deal(List<Card> deck) {
		return deck.remove(0);

	}

	@Override
	public void stay() {

	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Computer");
		return builder.toString();
	}

}
