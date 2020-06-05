package application.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CalcButton extends NumpadButton{
	public CalcButton() {
		super("=");
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				calc();
			}
		});
	}
	
	private void calc() {
		// TODO Auto-generated method stub
		
	}
}
