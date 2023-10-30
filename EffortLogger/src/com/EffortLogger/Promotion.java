package com.EffortLogger;
/*
 * Created by Maguire Brady
 * For use in CSE360
 */
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Promotion extends Scene {
	protected Promotion(Stage stage, GridPane gp) {
		super(gp, 720, 480);
		//initialize components
		TextField employeeToPromote = new TextField();
		Button submit = new Button();
		Pane holder = new Pane();holder.setMinSize(720/3, 120);
		Button backButton = new Button();
		ComboBox<Integer> rankCombo = new ComboBox<Integer>();
		Label statusLabel = new Label();
		//setting base state of components
		statusLabel.setText("Please enter the Employee's ID and new rank: ");
		rankCombo.getItems().addAll(0,1,2);
		employeeToPromote.setPromptText("Employee User ID");
		submit.setText("Submit");submit.setOnAction(e->{
			//get the employee with userid
			Employee change = Employee.GetEmployee(employeeToPromote.getText());
			if(change != null) {
				//change employee's rank
				change.setRank(rankCombo.getSelectionModel().getSelectedItem());
				employeeToPromote.clear();
				statusLabel.setText("Permissions updated");
			}else {
				//error handling
				statusLabel.setText("Could not find employee, please try again");
			}
		});
		rankCombo.getSelectionModel().select(0);
		//leave
		backButton.setText("Go back"); backButton.setOnAction(e -> {
			stage.setScene(new AdminConsole(stage, new GridPane()));
		});
		//add everything to scene
		gp.add(holder, 0, 0);
		gp.add(employeeToPromote, 1, 0);
		gp.add(rankCombo, 1, 1);
		gp.add(submit, 1, 2);
		gp.add(backButton, 2, 3);
	}
}
