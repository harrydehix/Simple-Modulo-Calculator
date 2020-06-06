package application;
	
import application.buttons.CalcButton;
import application.buttons.ClearButton;
import application.buttons.NumberButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
			NumberButton b7 = new NumberButton(7, base, module, result, false, numpad);
			NumberButton b8 = new NumberButton(8, base, module, result, false, numpad);
			NumberButton b9 = new NumberButton(9, base, module, result, false, numpad);
			
			NumberButton b4 = new NumberButton(4, base, module, result, false, numpad);
			NumberButton b5 = new NumberButton(5, base, module, result, false, numpad);
			NumberButton b6 = new NumberButton(6, base, module, result, false, numpad);
			
			NumberButton b1 = new NumberButton(1, base, module, result, false, numpad);
			NumberButton b2 = new NumberButton(2, base, module, result, true, numpad);
			NumberButton b3 = new NumberButton(3, base, module, result, false, numpad);
			
			NumberButton b0 = new NumberButton(0, base, module, result, true, numpad);
			
			
			numpad.add(b7, 0, 0);
			numpad.add(b8, 1, 0);
			numpad.add(b9, 2, 0);
			
			numpad.add(b4, 0, 1);
			numpad.add(b5, 1, 1);
			numpad.add(b6, 2, 1);
			
			numpad.add(b1, 0, 2);
			numpad.add(b2, 1, 2);
			numpad.add(b3, 2, 2);
			
			numpad.add(b0, 0, 3);
			numpad.add(new ClearButton(base, module, result), 1, 3);
			numpad.add(new CalcButton(base, module, result), 2, 3);
			
			root.setBottom(numpad);
			
			// Global key event listeners to enable input via backspace and number keys
			
			module.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					handleGlobalKeyEvent(event, base, module, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
					event.consume();
				}
			});
			base.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					handleGlobalKeyEvent(event, base, module, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
					event.consume();
				}
			});
			result.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					handleGlobalKeyEvent(event, base, module, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
					event.consume();
				}
			});
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					handleGlobalKeyEvent(event, base, module, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
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
	
	public static void handleGlobalKeyEvent(KeyEvent event, TextField base, TextField module, Button... buttons) {
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

			buttons[0].fireEvent(new ActionEvent());
			break;
		case DIGIT1:
		case NUMPAD1:	
			// What happens on pressing 1
			
			buttons[1].fireEvent(new ActionEvent());
			break;
		case DIGIT2:
		case NUMPAD2:
			// What happens on pressing 2
			
			buttons[2].fireEvent(new ActionEvent());
			break;
		case DIGIT3:
		case NUMPAD3:
			// What happens on pressing 3
			
			buttons[3].fireEvent(new ActionEvent());
			break;
		case DIGIT4:
		case NUMPAD4:
			// What happens on pressing 4
			
			buttons[4].fireEvent(new ActionEvent());
			break;
		case DIGIT5:
		case NUMPAD5:
			// What happens on pressing 5
			
			buttons[5].fireEvent(new ActionEvent());
			break;
		case DIGIT6:
		case NUMPAD6:
			// What happens on pressing 6
			
			buttons[6].fireEvent(new ActionEvent());
			break;
		case DIGIT7:
		case NUMPAD7:
			// What happens on pressing 7
			
			buttons[7].fireEvent(new ActionEvent());
			break;
		case DIGIT8:
		case NUMPAD8:
			// What happens on pressing 8
			
			buttons[8].fireEvent(new ActionEvent());
			break;
		case DIGIT9:
		case NUMPAD9:
			// What happens on pressing 9
			
			buttons[9].fireEvent(new ActionEvent());
			break;
		default:
			break;
		}
		event.consume();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
