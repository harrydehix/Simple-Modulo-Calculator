package application.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class NumberButton extends Button{
	public NumberButton(int number) {
		super(String.valueOf(number));
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				addNumberToInput(number);
			}
		});
	}
	
	private void addNumberToInput(int number) {
		// TODO Auto-generated method stub
		
	}
}
