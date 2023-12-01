package com.EffortLogger;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class EffortData extends Scene {
	    @SuppressWarnings({ "unchecked", "unused" })
		public EffortData(Stage primaryStage, VBox mainLayout) {
	    	super(mainLayout, 800, 600);
	    	// Create the main layout and scene for the primary stage
	        TableView<Employee> table = new TableView<>();
	        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
	        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
	        nameColumn.setMinWidth(100);
	        
	        TableColumn<Employee, String> passwordColumn = new TableColumn<>("Password");
	        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
	        passwordColumn.setMinWidth(100);

	        TableColumn<Employee, String> dataColumn = new TableColumn<>("Data");
	        dataColumn.setCellValueFactory(new PropertyValueFactory<>("defects"));
	        dataColumn.setMinWidth(200);

	        table.getColumns().addAll(nameColumn, passwordColumn, dataColumn);
	        
	        // Sample data to enter into the table
	        table.getItems().addAll(
	                new Employee("tom brady",null, "password123", null,null,null," Data",null),
	                new Employee("kanye west",null, "password123", null,null,null," Data",null)
	        );


	        Region emptySpace = new Region(); //empty space for spacing

	        //creating tabs 
	        TabPane tabPane = new TabPane();
	        Tab userDataTab = new Tab("User Data", table);
	        userDataTab.setClosable(false);
	        tabPane.getTabs().add(userDataTab);

	        //creating other tabs to flip through to view more data
	        tabPane.getTabs().addAll(createTab("Console"), createTab("Player Moves"), createTab("Player History"), createTab("Account Info"), createTab("Cookies"));
	        mainLayout.getChildren().add(tabPane);
	        mainLayout.setPadding(new Insets(10));
	  }
	                
		  private Tab createTab(String title) {
			    Tab tab = new Tab(title);
			    TextArea consoleTextArea = new TextArea();
			    consoleTextArea.setEditable(false); // Makes the text area non-editable
			    consoleTextArea.setStyle("-fx-control-inner-background: black; -fx-text-fill: limegreen; -fx-font-family: 'Consolas';"); // Console-like styling

			    // console output
			    consoleTextArea.setText("Console Output\n---");

			    tab.setContent(consoleTextArea);
			    tab.setClosable(false);  // Ensure the tabs can't be closed
			    return tab;
			}

	  
}