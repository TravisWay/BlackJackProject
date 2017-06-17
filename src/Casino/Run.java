package Casino;

public class Run {

	public static void main(String[] args) {
		boolean gameover = false;
		System.err.println("Hit or GTFO \n\nThe BlackJack Game for the Ballsy\n");
		while(!gameover){
		Play game = new Play();
		game.PlayGame();
		}
	}

}
