package Casino;

import Deck.*;
import Player.*;

public class Table {
	//Creates a new table with a Deck
	private Deck deck = new Deck();
	
	public Table() {
		super();
		
	}

	public Deck newdeck(){	
		deck.createDeck();
		return deck;
		
	}

}
	

