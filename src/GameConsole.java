import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		
		// describe the game
		System.out.println( game.toString());
		System.out.println( game.getMessage());
		String yourguess = "your guess?";
		System.out.print(yourguess+" ");
		
		//user put number to guess
		Scanner console = new Scanner(System.in);
		int answer = console.nextInt();
		
		while(!game.guess(answer)) {
			game.getMessage();
			System.out.println("Sorry !! " +answer+" " + game.getMessage());
			System.out.print(yourguess + " ");
			answer = console.nextInt();
		}
		System.out.println(game.getMessage()+answer+".");
		System.out.println("Total : "+game.getCount() + " guesses.");
		return answer;
	}
	
}
