package application;
	
import application.buttons.CalcButton;
import application.buttons.ClearButton;
import application.buttons.NumberButton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
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
			root.setId("root");
			
			Scene scene = new Scene(root,400,600);
			
			// Top area
			
			HBox inputField = new HBox();
			inputField.setId("input-field");
			
			TextField base = new TextField();
			base.setEditable(false);
			base.getStyleClass().add("selected");
			HBox.setMargin(base, new Insets(5));
			
			Label operator = new Label("%");
			operator.setId("operator");
			HBox.setMargin(operator, new Insets(5));
			
			TextField module = new TextField();
			module.setEditable(false);
			HBox.setMargin(module, new Insets(5));
			
			Label equals = new Label("=");
			equals.setId("equals");
			HBox.setMargin(equals, new Insets(5));
			
			TextField result = new TextField();
			result.setEditable(false);
			result.setId("result");
			HBox.setMargin(result, new Insets(5));
			
			// MouseListeners to change focus to module or base
			base.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					selectedField = 1;
					if(!base.getStyleClass().contains("selected")) base.getStyleClass().add("selected");
					module.getStyleClass().remove("selected");
					event.consume();
				}
			});
			module.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					selectedField = 2;
					base.getStyleClass().remove("selected");
					if(!module.getStyleClass().contains("selected")) module.getStyleClass().add("selected");
					event.consume();
				}
			});

			inputField.getChildren().addAll(base, operator, module, equals, result);
			root.setTop(inputField);
			
			// Bottom area
			
			GridPane numpad = new GridPane();
			numpad.setId("numpad");
			
			numpad.add(new NumberButton(7, base, module, result, false, numpad), 0, 0);
			numpad.add(new NumberButton(8, base, module, result, false, numpad), 1, 0);
			numpad.add(new NumberButton(9, base, module, result, false, numpad), 2, 0);
			
			numpad.add(new NumberButton(4, base, module, result, false, numpad), 0, 1);
			numpad.add(new NumberButton(5, base, module, result, false, numpad), 1, 1);
			numpad.add(new NumberButton(6, base, module, result, false, numpad), 2, 1);
			
			numpad.add(new NumberButton(1, base, module, result, false, numpad), 0, 2);
			numpad.add(new NumberButton(2, base, module, result, true, numpad), 1, 2);
			numpad.add(new NumberButton(3, base, module, result, false, numpad), 2, 2);
			
			numpad.add(new NumberButton(0, base, module, result, true, numpad), 0, 3);
			numpad.add(new ClearButton(base, module, result), 1, 3);
			numpad.add(new CalcButton(base, module, result), 2, 3);
			
			root.setBottom(numpad);
			
			// Global key event listeners to enable input via backspace and number keys
			
			module.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					handleGlobalKeyEvent(event, base, module);
					event.consume();
				}
			});
			base.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					handleGlobalKeyEvent(event, base, module);
					event.consume();
				}
			});
			result.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					handleGlobalKeyEvent(event, base, module);
					event.consume();
				}
			});
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					handleGlobalKeyEvent(event, base, module);
					event.consume();
				}
			});
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Simple Modulo Calculator");
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method gets executed when some key is pressed.
	 * @param event
	 * @param base
	 * @param module
	 */
	public static void handleGlobalKeyEvent(KeyEvent event, TextField base, TextField module) {
		switch(event.getCode()) {
		case BACK_SPACE:
			// What happens on pressing backspace
			
			String text;
			switch(selectedField) {
			case 1:
				text = base.getText();
				if(text.length() > 0)
					base.setText(text.substring(0, text.length()-1));
				break;
			case 2:
				text = module.getText();
				if(text.length() > 0)
					module.setText(text.substring(0, text.length()-1));
				break;
			}
			break;
		case DIGIT0:
		case NUMPAD0:
			// What happens on pressing 0
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "0"); break;
			case 2: module.setText(module.getText() + "0"); break;
			}
			break;
		case DIGIT1:
		case NUMPAD1:	
			// What happens on pressing 1
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "1"); break;
			case 2: module.setText(module.getText() + "1"); break;
			}
			break;
		case DIGIT2:
		case NUMPAD2:
			// What happens on pressing 2
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "2"); break;
			case 2: module.setText(module.getText() + "2"); break;
			}
			break;
		case DIGIT3:
		case NUMPAD3:
			// What happens on pressing 3
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "3"); break;
			case 2: module.setText(module.getText() + "3"); break;
			}
			break;
		case DIGIT4:
		case NUMPAD4:
			// What happens on pressing 4
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "4"); break;
			case 2: module.setText(module.getText() + "4"); break;
			}
			break;
		case DIGIT5:
		case NUMPAD5:
			// What happens on pressing 5
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "5"); break;
			case 2: module.setText(module.getText() + "5"); break;
			}
			break;
		case DIGIT6:
		case NUMPAD6:
			// What happens on pressing 6
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "6"); break;
			case 2: module.setText(module.getText() + "6"); break;
			}
			break;
		case DIGIT7:
		case NUMPAD7:
			// What happens on pressing 7
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "7"); break;
			case 2: module.setText(module.getText() + "7"); break;
			}
			break;
		case DIGIT8:
		case NUMPAD8:
			// What happens on pressing 8
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "8"); break;
			case 2: module.setText(module.getText() + "8"); break;
			}
			break;
		case DIGIT9:
		case NUMPAD9:
			// What happens on pressing 9
			
			switch(selectedField) {
			case 1: base.setText(base.getText() + "9"); break;
			case 2: module.setText(module.getText() + "9"); break;
			}
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
