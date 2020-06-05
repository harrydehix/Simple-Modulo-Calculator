package application;
	
import application.buttons.CalcButton;
import application.buttons.ClearButton;
import application.buttons.NumberButton;
import backend.ModuloUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
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
			Label result = new Label("result");
			
			//modulo
			ModuloUtils op = new ModuloUtils();
			
//			//default values -> solved through send-button
//			int ba = 3;
//			int mo = 3;
//			if (!base.getText().equals("")) {
//				ba = Integer.parseInt(base.getText());
//			}
//			if (!module.getText().equals("")) {
//				mo = Integer.parseInt(module.getText());
//			}
			
//			int res = ModuloUtils.modulo(ba, mo);
//			result.setText(String.valueOf(res));
			
			//add objects
			inputField.getChildren().addAll(base, operator, module, equals, result);
			
			root.setTop(inputField);
			
			
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
