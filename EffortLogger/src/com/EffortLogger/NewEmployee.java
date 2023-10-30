package com.EffortLogger;
/*
 * Created by Maguire Brady
 * For use in CSE360
 */
import java.util.HashSet;
import java.util.Set;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NewEmployee extends Scene{
	protected NewEmployee(Stage stage, GridPane gp) {
		super(gp, 720, 480);
		//initializing components
		TextField newEmpName = new TextField();
		PasswordField newEmpSSN = new PasswordField();
		PasswordField newEmpDesiredPassword = new PasswordField();
		ComboBox<String> rankCombo = new ComboBox<String>();
		Button submissionButton = new Button();
		Button backButton = new Button();
		Pane holder = new Pane();
		Label statusLabel = new Label();
		Label rankLabel = new Label();
		BorderPane statusNamePane = new BorderPane();
		BorderPane rankPane = new BorderPane();
		//setting starting state for components
		statusNamePane.setTop(statusLabel);
		statusNamePane.setBottom(newEmpName);
		statusLabel.setText("Please enter the employee's information:");
		rankLabel.setText("Employee rank: ");
		rankPane.setLeft(rankLabel);
		rankPane.setRight(rankCombo);
		holder.setMinSize(240,120);
		newEmpName.setPromptText("Employee Name");
		newEmpSSN.setPromptText("Employee SSN");
		newEmpDesiredPassword.setPromptText("Employee desired password");
		submissionButton.setText("Submit"); submissionButton.setOnAction(e -> {
			String ssn = newEmpSSN.getText();
			String name = newEmpName.getText();
			//if(employee exists) error: employee already exists
			//else
			String password = newEmpDesiredPassword.getText();
			String rank = rankCombo.getSelectionModel().getSelectedItem();
			String p = ("(?=(.*[a-z]){3,})(?=(.*[A-Z]){2,})(?=(.*[0-9]){2,})(?=(.*[!@#$%^&*()\\-__+.]){1,}).{8,}$");
//			(?=(.*[a-z]){3,})               lowercase letters. {3,} indicates that you want 3 of this group
//			(?=(.*[A-Z]){2,})               uppercase letters. {2,} indicates that you want 2 of this group
//			(?=(.*[0-9]){2,})               numbers. {2,} indicates that you want 2 of this group
//			(?=(.*[!@#$%^&*()\-__+.]){1,})  all the special characters in the [] fields. The ones used by regex are escaped by using the \ or the character itself. {1,} is redundant, but good practice, in case you change that to more than 1 in the future. Also keeps all the groups consistent
//			{8,}                            indicates that you want 8 or more
			if(ssn.length() == 9) {
				if(password.matches(p)) {
					//userID generation
					String userID = randomIdentifier();
					Employee newEmp = new Employee(name, userID, password, Integer.parseInt(rank), ssn);
					//add newEmp to db
					System.out.println(newEmp.toString());
					statusLabel.setText("Employee created\nEmployee USERID: " + userID);
					newEmpName.clear();
					newEmpSSN.clear();
					newEmpDesiredPassword.clear();
				}else {
					statusLabel.setText("Password is not valid, please try again with a stronger password\nPassword needs: at least 3 lowercase letters\n2 uppercase letters\n2 numbers\n1 special character (!@#$%^&*()\\-__+.)");
				}
			}else {
				statusLabel.setText("Social Security Number is not valid!");
			}
		});
		backButton.setText("Go back"); backButton.setOnAction(e -> {
			stage.setScene(new AdminConsole(stage, new GridPane()));
		});
		rankCombo.getItems().addAll("0", "1", "2");
		rankCombo.getSelectionModel().select(0);
		//adding components to scene
		gp.add(holder, 0, 0);
		gp.add(statusNamePane, 1, 0);
		gp.add(newEmpSSN, 1, 1);
		gp.add(newEmpDesiredPassword, 1, 2);
		gp.add(rankPane, 1, 3);
		gp.add(submissionButton, 1, 4);
		gp.add(backButton, 2, 3);
		
	}
	
	// class variable
	final private String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

	final private java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
	final private Set<String> identifiers = new HashSet<String>();

	private String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
}
