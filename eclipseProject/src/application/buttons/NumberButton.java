package application.buttons;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NumberButton extends NumpadButton{

	public NumberButton(int number, TextField base, TextField module, Label result) {
		super(String.valueOf(number));
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				addNumberToInput(number, base, module, result);
			}
		});
	}

	private void addNumberToInput(int number, TextField base, TextField module, Label result) {
		// TODO Auto-generated method stub
		//set number, depending on which TextField is selected
		switch (Main.selectedField) {
			case 1:
				base.appendText(Integer.toString(number));
				break;
			case 2:
				module.appendText(Integer.toString(number));
				break;
		}
	}
}
