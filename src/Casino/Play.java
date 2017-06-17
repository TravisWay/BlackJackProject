package Casino;

import java.security.GuardedObject;
import java.util.List;
import java.util.Scanner;

import Deck.Card;
import Deck.Deck;
import Player.Computer;
import Player.Player;
import Player.User;

public class Play {
	int option;
	int status = 0;
	int status1 = 0;
	Computer Dealer = new Computer();
	User user = new User();
	Table table = new Table();
	List<Card> deck = table.newdeck().getDeck();
	Deck deck2 = new Deck();
	boolean status3 = true;


	public void PlayGame() {
		Scanner input = new Scanner(System.in);
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

	public void Game() {
		Scanner input = new Scanner(System.in);
		while(status3){
		Dealer.shuffle(deck);
		user.setHand(Dealer.deal(deck));
		user.setHand(Dealer.deal(deck));
		Dealer.setHand(Dealer.deal(deck));
		Dealer.setHand(Dealer.deal(deck));
		wincheck(Dealer.hand, Dealer);
		wincheck(user.hand, user);
		System.out.println("\nYour cards are " + user.getHand() + "\nWould you like a hit(1) or to stay(2)?");
		HitStayPlayer(user);
		if(status3==false){
			break;
		}
		wincheck(user.hand, user);
		HitStayDealer(Dealer);
		status3=false;
		}
		
		
		FinalWinCheck(user.hand, Dealer.hand);

	}

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

	public void HitStayDealer(Player player) {
		while (status1 == 0) {
			System.out.println("\nDealer's cards are " + player.getHand());
			if(status1 ==0){
			if (wincheck(player.hand, player) <= 17) {
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
		int total = 0;

		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.get(i);
			total = total + card.getValue();
		}
		if (player == user) {
			System.out.println(player.toString() + "r total is " + total);
		}

		if (total > 21) {
			System.out.println(player.toString() + " busted with the cards "+ player.getHand());
			
			status = 1;
			status1=1;
			status3 = false;
		}

		return total;
	}

	public int FinalWinCheck(List<Card> user, List<Card> dealer) {
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

		}
		else if (p1total > 21) {
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

}
