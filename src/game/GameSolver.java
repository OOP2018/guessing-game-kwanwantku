package game;
import java.util.Random;
import java.util.Scanner;

/**
 * The gamesolver for guess the number.
 * It automatically to guess number.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 12/1/2018
 */
public class GameSolver { 

	/**
	 * The play methods play game by automatically guess the number.
	 * @param Create object for game.
	 * @return the answer of guess.
	 */
	public int play(NumberGame game) {
		
		int max = game.getUpperBound();
		int min = 1;
		int guess = 0;

		while(true) {
			guess = min + (max-min)/2;
			if (game.guess(guess)) {
				return guess;
			}
			String message = game.getMessage().toLowerCase();
			if (message.contains("too small")) {
				
				min = guess + 1;
			}
			else {
				max = guess - 1;
			}
//			if (min<max) {
//				System.out.println("impossible !!");
//				return 0;
//			}
//			System.out.println(guess);
//			System.out.println(message);
		}
		
	}

}
