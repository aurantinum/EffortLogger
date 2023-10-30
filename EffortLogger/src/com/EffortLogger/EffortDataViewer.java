package com.EffortLogger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;

public class EffortDataViewer extends Application {
    public static void main(String[] args) {
    	launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	// Sample effort data
        String[] sampleEffortData = {
            "Name: John\nID: 342\nRank: Developer\nData: 10 hours",
            "Name: Alice\nID: 35\nRank: Engineer\nData: 8 hours",
            "Name: Bob\nID: 3903\nRank: Developer\nData: 12 hours"
        };
        
        // Create an EffortData object
        EffortData effortData = new EffortData(sampleEffortData);
        
        // Create a JavaFX window
        primaryStage.setTitle("Effort Data Viewer");
        VBox root = new VBox(10);
        
        // Create a ChoiceBox
        ChoiceBox<String> dataChoice = new ChoiceBox<>();
        dataChoice.getItems().addAll("All", "Developers", "Engineers");
        dataChoice.setValue("All");
        
        // Create a TextArea to display the selected data
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setPrefSize(400, 300);
        
        textArea.setText(effortData.PrintAll());
        
        dataChoice.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		if (dataChoice.getValue().equals("Developers")) {
                	textArea.setText(effortData.PrintDevelopers());
                }
                else if (dataChoice.getValue().equals("Engineers")) {
                	textArea.setText(effortData.PrintEngineers());
                } 
                else {
                	textArea.setText(effortData.PrintAll());
                }
        	}
        });
        
        root.getChildren().addAll(dataChoice, textArea);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}