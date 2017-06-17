package Player;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import Deck.*;

public class Computer extends Player {
	
	
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
		// for (Card card : toShuffle) {
		// System.out.println(card);
		// }
		return toShuffle;

	}

	public static Card deal(List<Card> deck) {
		int rand = (int) (Math.random() * 52);

		return deck.remove(rand);

	}

	

	@Override
	public void stay() {
		
		
		
	}

	@Override
	public Card take(List<Card> deck) {
		// TODO Auto-generated method stub
		
		return deal(deck); 
		
		
	}


}
