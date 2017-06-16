package Player;

import java.util.List;

import Deck.*;

public class User extends Player{

	@Override
	public Card take(List<Card> deck) {
		// TODO Auto-generated method stub
		
		return Computer.deal(deck); 
		
		
	}

	@Override
	public void stay() {
		
	}

}
