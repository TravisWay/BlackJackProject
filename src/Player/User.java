package Player;

import java.util.List;

import Deck.*;

public class User extends Player{
	
	
	public void setHand(Card card) {
		
		hand.add(card);
	}
	
	public List<Card> getHand() {
		// TODO Auto-generated method stub
		return super.getHand();
	}
	
	@Override
	public Card take(List<Card> deck) {
		// TODO Auto-generated method stub
		
		return Computer.deal(deck); 
		
		
	}

	@Override
	public void stay() {
		
	}

}
