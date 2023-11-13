package com.EffortLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlanningPoker extends Scene{
	protected PlanningPoker(Stage stage, GridPane gp) {
		super(gp, 320, 480);
		Button screenshot = new Button();
		ComboBox<Double> challenge = new ComboBox<Double>();
		Label challengeLevel = new Label();
		BorderPane challengeBP = new BorderPane();
		TextField storyName = new TextField();
		ComboBox<String> projectName = new ComboBox<String>();
		ComboBox<String> phaseName = new ComboBox<String>();
		TextField tagField = new TextField();
		TextArea rationale = new TextArea();
		challenge.getItems().addAll(0.0,0.5,1.0,2.0,3.0,5.0,8.0,13.0,20.0,40.0,100.0,Double.MAX_VALUE);
		storyName.setPromptText("Story Name/Description");
		challenge.getSelectionModel().select(0);
		challengeLevel.setText("Expected challenge level:");
		challengeBP.setLeft(challengeLevel);
		challengeBP.setRight(challenge);
		screenshot.setMinSize(320, 20);
		screenshot.setText("Export as .png");
		screenshot.setOnAction(e->{
			screenshot();
		});
		rationale.setMaxSize(320, 480);
		rationale.setPromptText("Rationale");
		rationale.setWrapText(true);
		projectName.getItems().add("Project Name");
		projectName.setMinWidth(320);
		projectName.getSelectionModel().select(0);	
		phaseName.getItems().add("Phase Name");
		phaseName.setMinWidth(320);
		phaseName.getSelectionModel().select(0);
		tagField.setPromptText("Add Tags");
		tagField.setMinWidth(320);
		gp.add(screenshot, 1, 6);
		gp.add(rationale, 1, 5);
		gp.add(challengeBP, 1, 4);
		gp.add(tagField, 1, 3);
		gp.add(storyName, 1, 2);
		gp.add(phaseName, 1, 1);
		gp.add(projectName, 1, 0);
	}
	protected void screenshot() {
		try {
	         WritableImage image = super.snapshot(null);
	         File outputFile = Files.createTempFile("planningpoker-screenshot-",".png").toFile();
	         ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outputFile);
	         System.out.println("Wrote: " + outputFile);
	    } catch (IOException e) {
	         e.printStackTrace();
	    }
	 }
}
