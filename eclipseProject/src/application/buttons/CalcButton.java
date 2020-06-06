package application.buttons;

import backend.ModuloUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class CalcButton extends NumpadButton{
	
	public CalcButton(TextField base, TextField module, TextField result) {
		super("=", false, null);
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				calc(base, module, result);
			}
		});
	}
	

	private void calc(TextField base, TextField module, TextField result) {
		//converts Strings from TextField
		int baseInt = 0, moduleInt = 0;
		
		try {
			baseInt = Integer.parseInt(base.getText());
			moduleInt = Integer.parseInt(module.getText());
			//module-operation
			int res = ModuloUtils.modulo(baseInt, moduleInt);
			//print result
			result.setText(Integer.toString(res));
			if(!result.getStyleClass().contains("result")) result.getStyleClass().add("result");
		}catch(Exception e) {}

	}
}
