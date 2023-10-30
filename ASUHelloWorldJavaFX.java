package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ASUHelloWorldJavaFX extends Application {
	 public static void main(String[] args) {
	        launch(args);
	    }

	 public class User {
		    private String name;
		    private String password;
		    private String data;

		    public User(String name, String password, String data) {
		        this.name = name;
		        this.password = password;
		        this.data = data;
		    }

		 // Getter and setter methods for name, password and 'data'
		    //these will be implemented more later to actually collect the data
		    public String getName() {
		        return name;
		    }

		    public void setName(String name) {
		        this.name = name;
		    }

		    
		    public String getPassword() {
		        return password;
		    }

		    public void setPassword(String password) {
		        this.password = password;
		    }

		    
		    public String getData() {
		        return data;
		    }

		    public void setData(String data) {
		        this.data = data;
		    }
		}
	 
	  @Override
	    public void start(Stage primaryStage) {
	        TableView<User> table = new TableView<>();
	        
	        // Create columns for the table - thank you maguire for helping me find a table
	        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
	        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
	        nameColumn.setMinWidth(100);
	        
	        TableColumn<User, String> passwordColumn = new TableColumn<>("Password");
	        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
	        passwordColumn.setMinWidth(100);

	        TableColumn<User, String> dataColumn = new TableColumn<>("Data");
	        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
	        dataColumn.setMinWidth(200);

	        table.getColumns().addAll(nameColumn, passwordColumn, dataColumn);
	        
	        // Sample data to enter into the table
	        table.getItems().addAll(
	                new User("tom brady", "password123", "Sample Data"),
	                new User("kanye west", "password123", "Sample Data")
	        );


	        Region emptySpace = new Region(); //empty space for spacing

	        //creating tabs 
	        TabPane tabPane = new TabPane();
	        Tab userDataTab = new Tab("User Data", table);
	        userDataTab.setClosable(false);
	        tabPane.getTabs().add(userDataTab);

	        //creating other tabs to flip through to view more data
	        tabPane.getTabs().addAll(createTab("Console"), createTab("Player Moves"), createTab("Player History"), createTab("Account Info"), createTab("Cookies"));
	        
	        //more spacing
	        VBox momma = new VBox(10, tabPane);
	        momma.setPadding(new Insets(10));
	        
	        momma.setPadding(new Insets(10)); 
	        
	        Scene scene = new Scene(momma, 800, 600); // Window size set to 800x600.
	        
	        primaryStage.setTitle("User Data Table");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	  private Tab createTab(String title) {
	        Tab tab = new Tab(title);
	        TableView<Object> emptyTable = new TableView<>();  // Empty table for now
	        tab.setContent(emptyTable);
	        tab.setClosable(false);  // ensure the tabs cant be closed
	        return tab;
	    }
	  
}
