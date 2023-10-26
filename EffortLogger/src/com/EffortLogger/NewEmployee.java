package com.EffortLogger;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewEmployee extends Scene{
	static GridPane gp = new GridPane();
	protected NewEmployee(Stage stage) {
		super(gp, 720, 480);
		
	}
}
