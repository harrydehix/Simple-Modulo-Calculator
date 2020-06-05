package application.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ClearButton extends Button{
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
