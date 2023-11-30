package com.EffortLogger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserLogIn extends Scene {
	private int count = 5;
	private String user;
	private int value;
	//private Label entry2;
	
	@SuppressWarnings("unused")
	public UserLogIn(Stage primaryStage, GridPane grid) {
		super(grid, 350, 180);
		grid.setHgap(10);
        grid.setVgap(10);
        

        // Create labels, text fields, and a button
        Label countLabel = new Label("Remaining Attempts: 5");
        Label title = new Label("EffortLogger Login:");
        Label passwordTitle = new Label("Change Password");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label newPasswordLabel = new Label("New Password:");
        Label checkPassword = new Label("Confirm Password");
        Label admin = new Label("Admin View");
        Label employee = new Label("Employee View");
        
        TextField passwordField = new PasswordField();
		TextField passwordCheckField = new TextField();
        TextField usernameField = new TextField();
        
        Button passwordReset = new Button("Forgot Password?");
        Button loginButton = new Button("Login");
        Button contact = new Button("Contact Admin");
        Button changePassword = new Button("Change Password:");

        grid.add(title, 0, 0);
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(loginButton, 0, 4);
        grid.add(countLabel, 0, 3); //will display whether or not user is allowed access
        grid.add(passwordReset, 1, 4); //will allow reset password in later implementation
        
        // Add an action when the login button is clicked
        
        	
        	
        loginButton.setOnAction(e -> {
           	
        	String username = usernameField.getText(); //gets a username and password with valid inputs
            String password = passwordField.getText();
               
            if(isLoginSuccessful(username, password)) {
            	System.out.println("Success"); //will be taken out and replaced with entry label
                grid.getChildren();
                grid.getChildren().remove(title);
            	grid.getChildren().remove(usernameLabel);
            	grid.getChildren().remove(usernameField);
            	grid.getChildren().remove(passwordLabel);
            	grid.getChildren().remove(passwordField);
            	grid.getChildren().remove(loginButton);
            	grid.getChildren().remove(countLabel);
            	grid.getChildren().remove(passwordReset);
                if(isUserAdmin(username)) {
                	grid.add(admin, 0, 0);
                }
                else{
                	grid.add(employee, 0, 0);
                }
                //Add an if statement for whether user is admin or employee
                //if admin add admin panel
                //else show EffortLogger
            }
            else if(count > 1) {
                count--;
                updateLabel(countLabel);
                
            }
            else {
            	grid.getChildren().remove(loginButton);
            	grid.getChildren().remove(passwordReset);
            	grid.add(contact, 0, 4);
            	count--;
            	updateLabel(countLabel);
            }
            
                //Add authentication rules here
                
                
        });
        
        
        passwordReset.setOnAction(e ->{
        	grid.getChildren().remove(title);
        	grid.getChildren().remove(usernameLabel);
        	grid.getChildren().remove(usernameField);
        	grid.getChildren().remove(passwordLabel);
        	grid.getChildren().remove(passwordField);
        	grid.getChildren().remove(loginButton);
        	grid.getChildren().remove(countLabel);
        	grid.getChildren().remove(passwordReset);
        	grid.add(passwordTitle, 0, 0);
        	grid.add(usernameLabel, 0, 1);
            grid.add(usernameField, 1, 1);
            grid.add(newPasswordLabel, 0, 2);
            grid.add(passwordField, 1, 2);
        	System.out.println("Change Password: "); //Allow user to change password based on conditions
        	
        });

        

	}
	private void updateLabel(Label label) {
        label.setText("Remaining Attempts: " + count);
        if(count == 0) {
        	label.setText("Contact Admin for Account Reset");
        	
        }
    }
	
	
	public String getStringValue() {
        return user;
    }

    public int getIntValue() {
        return value;
    }
	private boolean isLoginSuccessful(String username, String password) {
		//username and password will have checks against saved username and password database in later implementation
        if(username.equals("Admin") && password.equals("password123.")) {
        	return true;
        }
        if(username.equals("Employee") && password.equals("password123.")) {
        	return true;
        }
                
        return false;
        
    }
	private boolean isUserAdmin(String username) {
		if(username.equals("Admin")){
			return true;
		}
		return false;
		
	}
}
