package com.EffortLogger;
/*
 * Created by Maguire Brady
 * For use in CSE360
 */
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminConsole extends Scene{
	public AdminConsole(Stage stage, GridPane gp){
		//three buttons : goto effortlogger, add new person, change permissions
		super(gp, 720, 480);
		//initialize components
		Button effortButton = new Button();
		Button newEmpButton = new Button();
		Button promoButton = new Button();
		Button viewEffortButton = new Button();
		Button logOutButton = new Button();
		Pane filler1 = new Pane();
		Pane filler2 = new Pane();
		Pane filler3 = new Pane();
		Pane filler4 = new Pane();
		BorderPane logHolder = new BorderPane();
		//starting state of components
		effortButton.setText("Go to EffortLogger");
		newEmpButton.setText("Create a new Employee ID");
		promoButton.setText("Change Employee Permissions");
		viewEffortButton.setText("View Employee effort data");
		logOutButton.setText("Log out");
		effortButton.setMinWidth(240);
		newEmpButton.setMinWidth(240);
		promoButton.setMinWidth(240);
		viewEffortButton.setMinWidth(240);
		logOutButton.setMaxWidth(120);
		logOutButton.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		logHolder.setRight(logOutButton);
		logHolder.setMaxSize(240, 120);
		filler1.setMinSize(240, 120);
		filler2.setMinSize(240, 120);
		filler3.setMinSize(240, 120);
		filler4.setMinSize(240, 120);
		//add components to scene
		gp.setMinWidth(240);
		gp.add(filler1, 0, 0);
		gp.add(filler2, 0, 1);
		gp.add(filler3, 0, 2);
		gp.add(filler4, 2, 0);
		gp.add(effortButton, 1, 0);
		gp.add(newEmpButton, 1, 1);
		gp.add(promoButton, 1, 2);
		gp.add(viewEffortButton, 1, 3);
		gp.add(logHolder, 2, 3);
//		effortButton.setOnAction(e ->{
//			primaryStage.setScene(new EffortConsole());
//		});
		//button functionality
		newEmpButton.setOnAction(e->{
			stage.setScene(new NewEmployee(stage, new GridPane()));
		});
		promoButton.setOnAction(e->{
			stage.setScene(new Promotion(stage, new GridPane()));
		});
		viewEffortButton.setOnAction(e->{
			stage.setScene(new AdminViewer(stage, new VBox(10)));
		});
		logOutButton.setOnAction(e->{
			stage.close();
		});
	}
}
