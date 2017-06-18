package Casino;

import java.util.List;
import java.util.Scanner;

import Deck.Card;
import Deck.Deck;
import Deck.Rank;
import Player.Computer;
import Player.Player;
import Player.User;

public class Play {
	int option;
	int status = 0;
	int status1 = 0;
	Table table = new Table();
	List<Card> deck = table.newdeck().getDeck();
	Deck deck2 = new Deck();
	Computer Dealer = new Computer();
	User user = new User();
	boolean status3 = true;

	public void PlayGame() {
		// Asks user if they would like to play and runs Game
		Scanner input = new Scanner(System.in);
		boolean gameover = false;
		System.err.println("Hit or GTFO \n\nThe BlackJack Game for the Ballsy\n");
		while(!gameover){
		status3 =true;
		user.hand.clear();
		Dealer.hand.clear();
		status1=0;
		status=0;
		
		System.out.println("\nReady to play? y or n");

		String answer = input.nextLine();

		switch (answer) {
		case "y":
			Game();
			break;

		default:
			System.exit(0);
			;

		}
		}
	}

	public void Game() {
		Scanner input = new Scanner(System.in);
		// Proceeds with Blackjack(Deals to Player and Dealer, Player continues
		// to hit or stay, then Dealer does, with winchecks in between and after
		while (status3) {
			Dealer.shuffle(deck);
			user.setHand(Dealer.deal(deck));
			user.setHand(Dealer.deal(deck));
			Dealer.setHand(Dealer.deal(deck));
			Dealer.setHand(Dealer.deal(deck));
			wincheck(Dealer.hand, Dealer);
			wincheck(user.hand, user);
			System.out.println("\nYour cards are " + user.getHand() + "\nWould you like a hit(1) or to stay(2)?");
			HitStayPlayer(user);
			if (status3 == false) {
				break;
			}
			wincheck(user.hand, user);
			HitStayDealer(Dealer);
			status3 = false;
		}

		FinalWinCheck(user.hand, Dealer.hand);

	}

	// This is asks the player to hit or stay depending on their total already
	public void HitStayPlayer(Player player) {
		Scanner input = new Scanner(System.in);
		while (status == 0) {
			int option = input.nextInt();
			switch (option) {
			case 1:
				player.setHand(Dealer.deal(deck));
				wincheck(player.hand, player);
				if (status == 0) {
					System.out.println(
							"\nYour cards are " + player.getHand() + "\nWould you like a hit(1) or to stay(2)?");
				}

				break;
			case 2:
				status = 1;
				break;
			default:
				status = 1;
				break;

			}

		}
	}

	// This runs for the dealer and hits(if 15 or under) or stay depending on
	// their total already
	public void HitStayDealer(Player player) {
		while (status1 == 0) {
			System.out.println("\nDealer's cards are " + player.getHand());
			if (status1 == 0) {
				if (wincheck(player.hand, player) <= 15) {
					option = 1;
				} else {
					option = 2;

				}
			}
			switch (option) {
			case 1:
				player.setHand(Dealer.deal(deck));
				wincheck(player.hand, player);

				if (status1 == 0) {
					System.out.println("\nDealer's cards are " + player.getHand());
				}

				break;
			case 2:
				status1 = 1;
				break;
			default:
				status1 = 1;
				break;

			}

		}

	}

	public int wincheck(List<Card> hand, Player player) {
		/// Checks to see if a player has busted and prints total
		int newtotal =0;
		int total = 0;
		Card card;
		for (int i = 0; i < hand.size(); i++) {
			card = hand.get(i);
			total = total + card.getValue();
		}
		if (player == user) {
			System.out.println(player.toString() + "r total is " + total);
		}

		if (total > 21) {
			boolean acecheck = Ace(hand);
			if (acecheck) {
				System.out.println(player.toString() + "r ace value has changed to 1");
				for (int i = 0; i < hand.size(); i++) {
					card = hand.get(i);
					newtotal = newtotal + card.getValue();
				}
				System.out.println("Your new total is " + newtotal);	
			}

			else {
				System.out.println(player.toString() + " busted with the cards " + player.getHand());

				status = 1;
				status1 = 1;
				status3 = false;
			}
		}
		return total;
	}

	public int FinalWinCheck(List<Card> user, List<Card> dealer) {
		// This the final check for a winner after both have elected to stay and
		// not busted
		int p1total = 0;
		int pctotal = 0;

		for (int i = 0; i < user.size(); i++) {
			Card card = user.get(i);
			p1total = p1total + card.getValue();
		}

		for (int i = 0; i < dealer.size(); i++) {
			Card card = dealer.get(i);
			pctotal = pctotal + card.getValue();
		}
		if (pctotal > 21) {
			System.out.println("You have won");

		} else if (p1total > 21) {
			System.out.println("The computer has won");

		}

		else if (pctotal < p1total) {
			System.out.println("You have " + p1total);
			System.out.println("The Computer has " + pctotal);
			System.out.println("You have won");
		} else if (pctotal > p1total) {
			System.out.println("You have " + p1total);
			System.out.println("The Computer has " + pctotal);
			System.out.println("The computer has won");
		} else {
			System.out.println("You have " + p1total);
			System.out.println("The Computer has " + pctotal);
			System.out.println("The game is a push");
		}
		status = 1;
		return status;
	}

	boolean Ace(List<Card> hand) {
		int total=0;
		Card card;
		boolean acecheck = false;
		boolean acecheck1 = false;
		
		for (int i = 0; i < hand.size(); i++) {
			card = hand.get(i);
			if (card.rank == Rank.ACE) {
				card.value = 1;
				acecheck1=true;
			}
		}
		for (int j = 0; j < hand.size(); j++) {
				card = hand.get(j);
				total = total + card.getValue();
			}	
		if(acecheck1 && total<21)	{
			acecheck=true;
			
		}
		else{
			acecheck=false;
		}
		
		return acecheck;

	}

}
