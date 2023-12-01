package com.EffortLogger;
	

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	//private Label entry2;
	
	public void start(Stage primaryStage) {
		UserLogIn scene = new UserLogIn(primaryStage, new GridPane());
		primaryStage.setTitle("EffortLogger");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
