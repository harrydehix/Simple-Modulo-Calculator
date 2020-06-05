package application.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClearButton extends Button{
	public ClearButton(TextField base, TextField module, Label result) {
		super("C");
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				clearInputAndResult(base, module, result);
			}
		});
	}
	
	private void clearInputAndResult(TextField base, TextField module, Label result) {
		// TODO Auto-generated method stub
		//clear all fields and labels
		base.deleteText(0, base.getText().length());
		module.deleteText(0, module.getText().length());
		result.setText("");
	}
}
