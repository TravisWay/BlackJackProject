package Deck;

import Deck.Card;
import Deck.Rank;
import Deck.Suit;

public class Card {
	 public Rank rank;
	    public Suit suit;
	    public int value;
	    public Card(Rank r, Suit s) {
	        rank = r;
	        suit = s;
	        setValue();
	    }

	    @Override
	    public String toString() {
	        return (rank+"").toLowerCase();
	    }
	    public void setValue(){
	    	value = rank.getValue();
	    	
	    }
	    public int getValue(){
	    	return value;
	    	
	    	
	    }
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result
	                + ((rank == null) ? 0 : rank.hashCode());
	        result = prime * result
	                + ((suit == null) ? 0 : suit.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Card other = (Card) obj;
	        if (rank != other.rank)
	            return false;
	        if (suit != other.suit)
	            return false;
	        return true;
	    }
	}

