package Casino;

import java.lang.invoke.SwitchPoint;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageTypeSpecifier;
import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.text.Highlighter.Highlight;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

import Deck.Card;
import Deck.Deck;
import Player.Computer;
import Player.Player;
import Player.User;

public class Play {
	static int status = 0;
	static Computer Dealer = new Computer();
	static User user = new User();
	static Table table = new Table();
	static List<Card> deck = table.newdeck().getDeck();

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
		Scanner input = new Scanner(System.in);
		
		Dealer.shuffle(deck);
		user.setHand(Dealer.deal(deck));
		user.setHand(Dealer.deal(deck));
		Dealer.setHand(Dealer.deal(deck));
		Dealer.setHand(Dealer.deal(deck));
		wincheck(Dealer.hand, Dealer);
		wincheck(user.hand, user);
		System.out.println("\nYour cards are "+ user.getHand()+"\nWould you like a hit(1) or to stay(2)?");
		HitStay(user,user.hand);
		HitStay(Dealer, Dealer.hand);
		FinalWinCheck(user.hand, Dealer.hand);
		
	}
	public static void HitStay(Player player,List<Card> hand){
		Scanner input = new Scanner(System.in);
		
		while(status ==0){
		int option = input.nextInt();
		switch (option) {
		case 1:
			user.setHand(Dealer.deal(hand));
			wincheck(user.hand, user);
			if(status == 0){System.out.println("\nYour cards are "+ user.getHand()+"\nWould you like a hit(1) or to stay(2)?");}
			
			break;
		case 2:
			wincheck(user.hand, user);
			wincheck(Dealer.hand, Dealer);
			break;
		default:
			System.exit(0);;
		}
		
		}

	}
	public static int wincheck(List<Card> hand, Player player){
		int total=0;
		
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.get(i);
			total =total + card.getValue();
		}
		System.out.println(player +"'s total is "+ total);
		if(total>21){
			System.out.println(player + " has busted");
			status = 1;
		}
		
		
		
		
		return status;
	}
	public static int FinalWinCheck(List<Card> hand,List<Card> hand2){
		int p1total=0;
		int p2total=0;
		
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.get(i);
			p1total =p1total + card.getValue();
		}
		
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.get(i);
			p1total =p1total + card.getValue();
		}
		if(p2total > p1total){
			System.out.println("You have won");	
		}
		else if(p2total < p1total){
			System.out.println("The computer has won");	
		}
		else{
			System.out.println("The game is a draw");
		}
		status =1;
		return status;
	}
	
	

}
