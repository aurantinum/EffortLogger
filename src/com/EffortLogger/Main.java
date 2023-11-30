package com.EffortLogger;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	public void start(Stage primaryStage) {
		primaryStage.setScene(new PlanningPoker(primaryStage, new GridPane()));
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
