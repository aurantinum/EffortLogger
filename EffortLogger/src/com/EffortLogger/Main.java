package application;
	

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	//private Label entry2;
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        

        // Create labels, text fields, and a button
        Label title = new Label("EffortLogger Login:");
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Label entry = new Label("Entry:");
        
        Button passwordReset = new Button("Forgot Password?");
        Button loginButton = new Button("Login");

        grid.add(title, 0, 0);
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(loginButton, 0, 3);
        //grid.add(entry, 1, 4); //will display whether or not user is allowed access
        grid.add(passwordReset, 1, 3); //will allow reset password in later implementation

        // Add an action when the login button is clicked
        loginButton.setOnAction(e -> {
            String username = usernameField.getText(); //gets a username and password with valid inputs
            String password = passwordField.getText();
           
            if(isLoginSuccessful(username, password)) {
            	System.out.println("Success"); //will be taken out and replaced with entry label
      
            }
            else {
            	System.out.println("Attempts remaining: 5");//will allow a total of 5 attempts before locking account
            }
        	
            //Add authentication rules here
            
            
        });
        passwordReset.setOnAction(e ->{
        	System.out.println("Change Password: "); //Allow user to change password based on conditions
        });

        
        Scene scene = new Scene(grid, 300, 180); //size of grid
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	private boolean isLoginSuccessful(String username, String password) {
		//username and password will have checks against saved username and password database in later implementation
        if(username.equals("Username") && password.equals("password123.")) {
        	return true;
        }
                
        return false;
        
    }
	private boolean isUserValid() { //will check if username is valid
		return true;
	}
	private boolean isPasswordValid() { //will check if password is valid
		return true;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
