package gui;
	
import java.net.URL;

import game.KwanwanGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;

/**
 * Create a JavaFX user interface with 1 input view
 * and 2 observers that show the counter value, so that all
 * the views refer to the same Counter object.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.03.16
 */
public class Main extends Application {
	/**
	 * Start primary stage.
	 */
	@Override
	public void start(Stage primaryStage) {
		// Create the Counter object (the "model" part of our app)
		KwanwanGame game = new KwanwanGame(100);
		
		try {
			URL url = getClass().getResource("GuessingGameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GuessingGameUI.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			GuessingGameController controller = loader.getController();
			
			// Dependency Injection:
			// Set the Counter object we want the view to update.
			controller.setCounter(game);

			// Build and show the scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Guessing Game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		// Add an observer that displays the Counter value on console.
		// Dependency Injection: 
		// We set a reference to the counter using the constructor.

		
		// Create another window that references the SAME counter. 
		CounterView view = new CounterView(game);
		game.addObserver(view);
		view.run();
	}
	/**
	 * Running the counter program
	 * @param args is argument that want to run.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
