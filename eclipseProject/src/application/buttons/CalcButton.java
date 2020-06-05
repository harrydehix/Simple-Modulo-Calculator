package application.buttons;

import application.Main;
import backend.ModuloUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalcButton extends NumpadButton{
	
	public CalcButton(TextField base, TextField module, Label result) {
		super("=");
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				calc(base, module, result);
			}
		});
	}
	

	private void calc(TextField base, TextField module, Label result) {
		// TODO Auto-generated method stub
		//starts the operation
		Main util = new Main();
		//converts Strings from TextField
		int baseInt = 0, moduleInt = 0;
		
		try {
			baseInt = Integer.parseInt(base.getText());
			moduleInt = Integer.parseInt(module.getText());
			//module-operation
			ModuloUtils mod = new ModuloUtils();
			int res = mod.modulo(baseInt, moduleInt);
			//print result
			result.setText(Integer.toString(res));
		}catch(Exception e) {}

	}
}
