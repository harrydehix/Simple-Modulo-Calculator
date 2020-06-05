package application.buttons;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public class NumpadButton extends Button{
	public NumpadButton(String txt) {
		super(txt);
		style();
	}
	
	protected void style() {
		GridPane.setHgrow(this, Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);
		GridPane.setHalignment(this, HPos.CENTER);
		this.setMaxWidth(Double.MAX_VALUE);
		this.setMaxHeight(Double.MAX_VALUE);
		this.setFont(new Font(40));
	}
}
