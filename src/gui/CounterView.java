package gui;

import java.util.Observable;
import java.util.Observer;

import game.NumberGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the value of a Counter.
 * This has only one component (but you can add more components),
 * so write it in code instead of FXML.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.03.2018
 */
public class CounterView implements Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a game to show the number of input to guess */
	private NumberGame game;
	/** the label that shows the counter value. */
	private Label label;
	
	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * @param counter the Counter to show.
	 */
	public CounterView(NumberGame game) {
		this.game = game;
		initComponents();
	}
	
	/**
	 * Initialize the component.
	 */
	private void initComponents() {
		stage = new Stage();
		// components and containers for our window
		HBox root = new HBox();

		root.setPadding(new Insets(10));

		root.setAlignment(Pos.CENTER);
		// The label that will show the counter value.
		label = new Label("   ");
		// make the label big enough
		label.setPrefWidth(144);

		label.setFont(new Font("Arial", 80.0));

		label.setAlignment(Pos.CENTER);
		// Add the label to the HBox.  You can all more components, too.
		root.getChildren().add(label);
		// Create a Scene using HBox as the root element
		Scene scene = new Scene(root);
		// show the scene on the stage
		stage.setScene(scene);
		stage.setTitle("Count");
		stage.sizeToScene();
	}
	
	/** Show the window and update the counter value. */
	public void run() {
		stage.show();
		displayCount();
	}
	/**
	 * Display the count.
	 */
	public void displayCount() {
		label.setText(game.getCount()+"");
	}
	
	/**
	 * The update changing event for counter.
	 * @param O is obervable to notify the update of count.
	 * 		  arg is the object that want to update.
	 */
	@Override
	public void update(Observable o, Object arg) {
		displayCount();
	}	
}
