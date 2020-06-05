package application;
	
import application.buttons.CalcButton;
import application.buttons.ClearButton;
import application.buttons.NumberButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,600);
			
			root.setTop(null);
			
			GridPane numpad = new GridPane();
			numpad.add(new NumberButton(7), 0, 0);
			numpad.add(new NumberButton(8), 1, 0);
			numpad.add(new NumberButton(9), 2, 0);
			
			numpad.add(new NumberButton(4), 0, 1);
			numpad.add(new NumberButton(5), 1, 1);
			numpad.add(new NumberButton(6), 2, 1);
			
			numpad.add(new NumberButton(1), 0, 2);
			numpad.add(new NumberButton(2), 1, 2);
			numpad.add(new NumberButton(3), 2, 2);
			
			numpad.add(new NumberButton(0), 0, 3);
			numpad.add(new ClearButton(), 1, 3);
			numpad.add(new CalcButton(), 2, 3);
			root.setBottom(numpad);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
