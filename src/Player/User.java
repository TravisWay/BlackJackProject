package Player;

import java.util.List;

import Deck.*;

public class User extends Player {
	//User player is made with a hand for cards and stay actions
	public void setHand(Card card) {
		hand.add(card);
	}

	public List<Card> getHand() {
		// TODO Auto-generated method stub
		return super.getHand();
	}

	@Override
	public void stay() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User");
		return builder.toString();
	}

}
