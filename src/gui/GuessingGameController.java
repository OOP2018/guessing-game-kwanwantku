package gui;

import game.KwanwanGame;
import game.NumberGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The guessing game controller and play game.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.03.16
 */
public class GuessingGameController {
	/**To add input to guess the number*/
	@FXML
	private TextField textfield;
	/**Set the hint*/
	@FXML
	private Label hint;
	/**Set the input number*/
	@FXML
	private Label input;
	/**Count the input number*/
	@FXML
	private Label count;
	/** the attribute of game*/
	private NumberGame game;
	
	/**
	 * The controller for playing the guessing game.
	 */
	public void handlerController() {
		String inputnumber = textfield.getText();
		game.guess(Integer.parseInt(inputnumber));
		input.setText(textfield.getText());
		count.setText(game.getCount()+"");
		if(game.getMessage().contains("Right")) {
			hint.setText(game.getMessage()+" "+inputnumber);
			hint.setStyle("-fx-text-inner-color: black;");
		}
		else {
			hint.setText(game.getMessage());
			hint.setStyle("-fx-text-inner-color: red;");
		}
		
	}
	
	/**
	 * Clear game for every time you want to restart new game.
	 * @param event is event that pressed buttton
	 */
	public void handlerClear(ActionEvent event) {
		textfield.setText("");
		input.setText("");
		hint.setText("");
		count.setText("");
		hint.setStyle("-fx-text-inner-color: black;");
	}
	
	/**
	 * Set the controller for program to run.
	 * @param game is the game that you want to play.
	 */
	public void setCounter(NumberGame game) {
		this.game = game;
		
	}


}
