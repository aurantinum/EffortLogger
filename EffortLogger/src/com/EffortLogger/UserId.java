package com.EffortLogger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserId extends Application {
	 public void start(Stage primaryStage) {
		 Button button = new Button("Hello World!");
		 GridPane gp = new GridPane();
		 Pane filler1 = new Pane();
		 Pane filler2 = new Pane();
		 Pane filler3 = new Pane();
		 Pane filler4 = new Pane();
		 Label userLabel, statusLabel, passLabel;
		 userLabel = new Label("User ID: ");
		 statusLabel = new Label("Please enter User ID and Password");
		 passLabel = new Label("Password: ");
		 BorderPane bp = new BorderPane(); 
		 TextField userTB = new TextField();
		 PasswordField passTB =new PasswordField();
		 userTB.setPromptText("User ID");
		 passTB.setPromptText("Password");
		 BorderPane passwordField = new BorderPane();
		 BorderPane userField = new BorderPane();
		 filler1.setMinSize(240, 120);
		 filler2.setMinSize(240, 120);
		 filler3.setMinSize(240, 120);
		 filler4.setMinSize(240, 120);
		 bp.setMinSize(240, 6);
		 gp.setMinWidth(240);
		 gp.add(filler1, 0, 0);
		 gp.add(filler2, 1, 0);
		 gp.add(filler3, 2, 0);
		 gp.add(filler4, 1, 2);
		 userField.setLeft(userLabel);
		 userField.setRight(userTB);
		 passwordField.setLeft(passLabel);
		 passwordField.setRight(passTB);
		 bp.setTop(statusLabel);
		 bp.setCenter(userField);
		 bp.setBottom(passwordField);
		 gp.add(bp, 1, 1);
		 Scene scene = new Scene(gp, 720,480);
		 primaryStage.setScene(scene);
		 primaryStage.show();
	 }
	 public static void main(String[] args) {
		 launch(args);
	 }
	 private class ButtonHandler implements EventHandler<ActionEvent>{
		 public void handle(ActionEvent e) {
			 //get userID from db
			 //
		 }
	 }
}
