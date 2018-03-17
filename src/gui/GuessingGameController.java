package gui;

import game.NumberGame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * 
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
	/** the attribute of game*/
	private NumberGame game;
	
	public void handlercontroller() {
		game.guess(Integer.parseInt(textfield.getText()));
		hint.setText(game.getMessage());
	}
	/**
	 * Set the controller for program to run.
	 * @param game is the game that you want to play.
	 */
	public void setCounter(NumberGame game) {
		this.game = game;
		
	}


}
