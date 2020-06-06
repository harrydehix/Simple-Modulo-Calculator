package application.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class ClearButton extends NumpadButton{

	public ClearButton(TextField base, TextField module, TextField result) {
		super("C", false, null);
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				clearInputAndResult(base, module, result);
			}
		});
	}
	
	private void clearInputAndResult(TextField base, TextField module, TextField result) {
		//clear all fields and labels
		base.deleteText(0, base.getText().length());
		module.deleteText(0, module.getText().length());
		result.setText("");
		result.getStyleClass().remove("result");
	}
}
