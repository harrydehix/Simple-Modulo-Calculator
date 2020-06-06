package application.buttons;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NumberButton extends NumpadButton{

	public NumberButton(int number, TextField base, TextField module, TextField result, boolean styleGridPaneOnHover, GridPane numpad) {
		super(String.valueOf(number), styleGridPaneOnHover, numpad);
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				addNumberToInput(number, base, module, result);
			}
		});
	}

	private void addNumberToInput(int number, TextField base, TextField module, TextField result) {
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
