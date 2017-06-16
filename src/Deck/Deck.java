package Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import Deck.Card;
import Deck.Rank;
import Deck.Suit;

public class Deck {
	
	
	private List<Card> deck = new ArrayList<>(52);
	
		
       

        public Deck() {
		super();
		
		
	}
		
        public List<Card> getDeck() {
			createDeck();
        	return deck;
		}

		public void setDeck(List<Card> deck) {
			this.deck = deck;
		}

		public void createDeck(){
        
        for(Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                deck.add(new Card(r, s));
            }
        }

//        for (Card card : deck) {
//            System.out.println(card);
//        }
       //Collections.shuffle(deck);
        //for (Card card : deck) {
          //  System.out.println(card);
        //}
    }
}
