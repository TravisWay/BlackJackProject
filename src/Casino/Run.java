package Casino;

public class Run {

	public static void main(String[] args) {
		// Makes new game and runs game continously until user inputs that they would not like to play
		boolean gameover = false;
		System.err.println("Hit or GTFO \n\nThe BlackJack Game for the Ballsy\n");
		while(!gameover){
		Play game = new Play();
		game.PlayGame();
		}
	}

}
