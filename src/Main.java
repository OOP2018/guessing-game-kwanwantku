/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 12.1.2018
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new KwanwanGame(upperBound);
		GameConsole ui = new GameConsole( );
		GameSolver solver = new GameSolver();
		//ui.play(game);
		int solution = solver.play(game);
		System.out.println("play() returned "+solution);
		System.out.println("Total : "+game.getCount() + " guesses.");
		
		
	}
}
