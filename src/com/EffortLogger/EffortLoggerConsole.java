package com.EffortLogger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EffortLoggerConsole extends Scene {
    public EffortLoggerConsole(Stage primaryStage, VBox root) {
    	super(root, 300, 200);
        // Create a ComboBox for dropdown
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Option 1", "Option 2", "Option 3");

        // Create two TextFields for user input
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        // Add labels for clarity
        Label label1 = new Label("Dropdown Selection:");
        Label label2 = new Label("Text Field 1:");
        Label label3 = new Label("Text Field 2:");
        
        //Add Button for going to planning poker
        Button planningPokerButton = new Button();
        planningPokerButton.setText("Go to Planning Poker");
        planningPokerButton.setOnAction(e->{
        	primaryStage.setScene(new PlanningPoker(primaryStage, new GridPane()));
        });
        planningPokerButton.setMinWidth(200);
        // Add components to the VBox
        root.getChildren().addAll(label1, comboBox, label2, textField1, label3, textField2, planningPokerButton);
    }
}
