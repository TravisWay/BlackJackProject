package Casino;

import java.lang.invoke.SwitchPoint;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import Deck.Card;
import Deck.Deck;
import Player.Computer;
import Player.User;

public class Play {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hit or GTFO \n\nThe BlackJack Game for the Ballsy\n");
		
		System.out.println("Ready to play? y or n");
		
		String answer = input.nextLine();
		
		switch (answer) {
		case "y":
			Game();
			break;

		default:
			System.exit(0);;
		}
	
	}
		
	public static void Game(){	
		
		Computer Dealer = new Computer();
		User user = new User();
		Table table = new Table();
		List<Card> deck = table.newdeck().getDeck();
		Dealer.shuffle(deck);
		Card Pfirst= Dealer.deal(deck);
		Card Ptwo = Dealer.deal(deck);
		Card Cfirst= Dealer.deal(deck);
		Card Ctwo = Dealer.deal(deck);
		System.out.println("\nYour cards are "+ Pfirst+ " and  "+ Ptwo +"\nWould you like a hit(h) or to stay(s)?");
		
		

	}

}
