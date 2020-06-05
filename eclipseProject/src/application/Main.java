package application;
	
import application.buttons.CalcButton;
import application.buttons.ClearButton;
import application.buttons.NumberButton;
import backend.ModuloUtils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static int selectedField = 1;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,600);
			
			
			//TOP
			
			//objects
			HBox inputField = new HBox();
			TextField base = new TextField();
			Label operator = new Label("%");
			TextField module = new TextField();
			Label equals = new Label("=");
			Label result = new Label();
			
			//actionListener for base and module
			base.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					selectedField = 1;
				}
			});
			module.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					selectedField = 2;
				}
			});
			
			//add objects
			inputField.getChildren().addAll(base, operator, module, equals, result);
			
			root.setTop(inputField);
			
			
			GridPane numpad = new GridPane();
			numpad.add(new NumberButton(7, base, module, result), 0, 0);
			numpad.add(new NumberButton(8, base, module, result), 1, 0);
			numpad.add(new NumberButton(9, base, module, result), 2, 0);
			
			numpad.add(new NumberButton(4, base, module, result), 0, 1);
			numpad.add(new NumberButton(5, base, module, result), 1, 1);
			numpad.add(new NumberButton(6, base, module, result), 2, 1);
			
			numpad.add(new NumberButton(1, base, module, result), 0, 2);
			numpad.add(new NumberButton(2, base, module, result), 1, 2);
			numpad.add(new NumberButton(3, base, module, result), 2, 2);
			
			numpad.add(new NumberButton(0, base, module, result), 0, 3);
			numpad.add(new ClearButton(base, module, result), 1, 3);
			numpad.add(new CalcButton(base, module, result), 2, 3);
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
