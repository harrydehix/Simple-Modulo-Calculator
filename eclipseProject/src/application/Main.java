package application;
	
import backend.ModuloUtils;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


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
			
			
			root.setBottom(null);
			
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
