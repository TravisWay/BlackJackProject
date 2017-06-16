package Casino;

import Deck.*;
import Player.*;


public class Table {

	private Deck deck = new Deck();
	
	public Table() {
		super();
		
	}

	public Deck newdeck(){	
		deck.createDeck();
		return deck;
		
	}

	
	
	
	
	}
	



//		for (Card card : deck) {
//        System.out.println(card);
//      }
//      Collections.shuffle(deck);
//      for (Card card : deck) {
//          System.out.println(card);
//      }
//	}
	

