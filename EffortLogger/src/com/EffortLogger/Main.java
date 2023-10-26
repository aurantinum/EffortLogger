package com.EffortLogger;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	public void start(Stage primaryStage) {
		primaryStage.setScene(new AdminConsole(primaryStage));
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
