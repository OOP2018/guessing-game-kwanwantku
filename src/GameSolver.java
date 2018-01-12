import java.util.Random;
import java.util.Scanner;

public class GameSolver { 

	public int play(NumberGame game) {
		
		int max = game.getUpperBound();
		int min = 1;
		int guess = 0;

		while(true) {
			guess = (min+max)/2;
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
			if (min<max) {
				System.out.println("impossible !!");
				return 0;
			}
		}
		
	}

}
