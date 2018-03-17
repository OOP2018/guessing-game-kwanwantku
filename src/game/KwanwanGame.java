package game;
import java.util.Random;

/**
 * The guessing game to guess correct secret number.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 12/1/2018
 */
public class KwanwanGame extends NumberGame {
	/**upper bound for secret game*/
	private int upperBound;
	/**the secret number for the game*/
	private int secret;
	/**count guesses*/
	private int count;

	/** Initialize a new default game with generate secret number.
	 * @param upperBound is the maximum of number to guess
	 */
	public KwanwanGame(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperBound) + 1 ;
		this.setMessage(String.format("I'm thinking of a number between 1 and %d.",upperBound)); 
	}
	
    /**
     * Evaluate the solution from guess and count number of guesses.
     * @param number that guess from user.
     * @return true if answer correct.
     * 		   false if answer not correct.
     */
	public boolean guess(int number) {
		if(number == secret) {
			this.setMessage("Right ! The secret number is ");
			this.count++;
			return true;
		}
		
		else if(number > secret) {
			this.setMessage("too large");
			this.count++;
			return false;
		}
		
		else {
			this.setMessage("too small");
			this.count++;
			return false;
		}
		
	}
	
	/**
	 * Get the upperbound for solution
	 * @return The upperbound for solution.
	 */
	public int getUpperBound() {
		return this.upperBound;
	}
	
	/**
	 *The title of the game.
	 * @return The string of title of game.
	 */
	public String toString() {
		return "Guess a secret number.";
	}
	
	/**
	 * Get the count of guess.
	 * @return The count of guess.
	 */
	public int getCount() {
		return this.count;
	}

}
