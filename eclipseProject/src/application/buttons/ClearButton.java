package application.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearButton extends NumpadButton{
	public ClearButton() {
		super("C");
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				clearInputAndResult();
			}
		});
	}
	
	private void clearInputAndResult() {
		// TODO Auto-generated method stub
		
	}
}
