package application;
	
import application.buttons.CalcButton;
import application.buttons.ClearButton;
import application.buttons.NumberButton;
import backend.ModuloUtils;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
			inputField.setPrefHeight(60);
			
			TextField base = new TextField();
			base.setPrefHeight(55);
			base.setPrefWidth(100);
			base.setFont(new Font(20));
			base.setEditable(false);
			HBox.setMargin(base, new Insets(5));
			
			Label operator = new Label("%");
			operator.setPrefHeight(60);
			operator.setPrefWidth(20);
			operator.setFont(new Font(20));
			HBox.setMargin(operator, new Insets(5));
			
			TextField module = new TextField();
			module.setPrefHeight(55);
			module.setPrefWidth(100);
			module.setFont(new Font(20));
			module.setEditable(false);
			HBox.setMargin(module, new Insets(5));
			
			Label equals = new Label("=");
			equals.setPrefHeight(55);
			equals.setPrefWidth(20);
			equals.setFont(new Font(20));
			HBox.setMargin(equals, new Insets(5));
			
			Label result = new Label("result");
			result.setPrefHeight(55);
			result.setFont(new Font(20));
			HBox.setMargin(result, new Insets(5));
			
			//modulo
			ModuloUtils op = new ModuloUtils();
			
			//add objects
			inputField.getChildren().addAll(base, operator, module, equals, result);
			
			root.setTop(inputField);
			
			GridPane numpad = new GridPane();
			numpad.setPrefWidth(400);
			numpad.setPrefHeight(550);
			numpad.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
			
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
			primaryStage.setTitle("Simple Modulo Calculator");
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
