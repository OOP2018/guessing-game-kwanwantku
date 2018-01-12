import java.util.Random;

/**
 * 
 * @author Kwanwan Tantichartkul
 *
 */
public class KwanwanGame extends NumberGame {
	/**upper bound for secret game*/
	private int upperBound;
	/**the secret number for the game*/
	private int secret;
	/**count guesses*/
	private int count;

	
	public KwanwanGame(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperBound) + 1 ;
		this.setMessage(String.format("I'm thinking of a number between 1 and %d.",upperBound)); 
	}
	
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
	
	public int getUpperBound() {
		return this.upperBound;
	}
	
	public String toString() {
		return "Guess a secret number.";
	}
	
	public int getCount() {
		return this.count;
	}

}
