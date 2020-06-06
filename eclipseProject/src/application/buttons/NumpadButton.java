package application.buttons;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class NumpadButton extends Button{
	public NumpadButton(String txt, boolean styleGridPaneOnHover, GridPane numpad) {
		super(txt);
		style(styleGridPaneOnHover, numpad);
	}
	
	protected void style(boolean styleGridPaneOnHover, GridPane numpad) {
		GridPane.setHgrow(this, Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);
		GridPane.setHalignment(this, HPos.CENTER);
		if(styleGridPaneOnHover) {
			this.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					numpad.getStyleClass().add("hovered");
				}
			});
			this.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					numpad.getStyleClass().remove("hovered");
				}
			});
		}
	}
}
