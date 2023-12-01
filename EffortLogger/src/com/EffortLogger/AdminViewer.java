package com.EffortLogger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;

public class AdminViewer extends Application {
    public static void main(String[] args) {
    	launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	// Sample effort data
        Employee[] sampleEffortData = {
        	new Employee("John", "342", "pass", "Developer", "1", "35", "none"),
        	new Employee("Alice", "343", "word", "Engineer", "1", "37", "Solution led to a possible infinite loop"),
        	new Employee("Bob", "344", "sword", "Developer", "2", "34", "compatability issues"),
        	new Employee("Emily", "345", "world", "Developer", "3", "40", "compatablity issues"),
        	new Employee("James", "346", "code", "Developer", "4", "32", "none"),
        	new Employee("Sarah", "347", "key", "Engineer", "2", "30", "Problems with testing"),
        	new Employee("Jack", "348", "secret", "Engineer", "3", "35", "none"),
        };
        
        // Create an EffortData object
        AdminManager effortData = new AdminManager(sampleEffortData);
        
        // Create a JavaFX window
        primaryStage.setTitle("Historical Data Viewer for Administrators");
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