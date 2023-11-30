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
	//extending Scene to make combination with other code for EffortLogger simple
	//declare tagField for use in both constructor and screenshot method
	TextField tagField;
	protected PlanningPoker(Stage stage, GridPane gp) {
		super(gp, 320, 480);
		//set Vgap to make the pane look better aesthetically and to minimize 'misclicks'
		gp.setVgap(15);
		//Initialize components to add to the Scene in the order that they are shown
		//ComboBox to allow user to choose from active projects
		ComboBox<String> projectName = new ComboBox<String>();
		//ComboBox to allow user to choose from project's phases
		ComboBox<String> phaseName = new ComboBox<String>();
		//TextField to allow users to create a name for the story
		TextField storyName = new TextField();
		//TextField for user created tags
		tagField = new TextField();
		//BorderPane to easily set-up the spacing for challenge and challengeLevel
		BorderPane challengeBP = new BorderPane();
		//Label to identify what challenge is used for
		Label challengeLevel = new Label();
		//ComboBox to allow user to choose a challenge level for the user story
		ComboBox<Double> challenge = new ComboBox<Double>();
		//TextArea to describe a brief rationale for the user's choice about the chosen challenge level
		TextArea rationale = new TextArea();
		//Button to take a screenshot of the active scene
		Button screenshot = new Button();
		//Button to return to EffortLogger
		Button returnToEL = new Button();
		//set up projectName component
		projectName.getItems().add("Project Name");
		projectName.setMinWidth(320);
		projectName.getSelectionModel().select(0);	
		//set up phaseName component
		phaseName.getItems().add("Phase Name");
		phaseName.setMinWidth(320);
		phaseName.getSelectionModel().select(0);
		//set up storyName component
		storyName.setPromptText("Story Name/Description");
		//set up tagName component
		tagField.setPromptText("Add Tags (Separate with ; , or :)");
		tagField.setMinWidth(320);
		//set up challengeBP component using challengeLevel label and challenge combobox
		challengeBP.setLeft(challengeLevel);
		challengeBP.setRight(challenge);
		//set up challengeLevel component
		challengeLevel.setText("Expected challenge level:");
		//set up challenge component
		challenge.getItems().addAll(0.0,0.5,1.0,2.0,3.0,5.0,8.0,13.0,20.0,40.0,100.0,Double.MAX_VALUE);
		challenge.getSelectionModel().select(0);
		//set up rationale component
		rationale.setMinSize(320, 100);
		rationale.setPromptText("Rationale");
		rationale.setWrapText(true);
		//set up screenshot component
		screenshot.setMinSize(320, 20);
		screenshot.setText("Export as .png");
		screenshot.setOnAction(e->{
			//When the button is pressed, take a screenshot
			screenshot();
		});
		//set up returnToEL component
		returnToEL.setMinSize(320, 20);
		returnToEL.setText("Return to EffortLogger Console");
		returnToEL.setOnAction(e->{
			//When the button is pressed, return to the EffortLogger console
			//stage.setScene(new EffortLoggerConsole(stage, new GridPane());
		});
		//add all set up components to gp, which will make them visible to the user
		gp.add(projectName, 1, 0);
		gp.add(phaseName, 1, 1);
		gp.add(storyName, 1, 2);
		gp.add(tagField, 1, 3);
		gp.add(challengeBP, 1, 4);
		gp.add(rationale, 1, 5);
		gp.add(screenshot, 1, 6);
		gp.add(returnToEL, 1, 7);
		//make the stage nonresizable
		stage.setResizable(false);
	}
	protected void screenshot() {
		/**
		 * Takes a picture of the current Scene
		 * Used in: Constructor
		 */
		try {
			//take a screenshot of the current Scene
	         WritableImage image = super.snapshot(null);
	         String tags = fileNameFormat(tagField.getText());
	         //create the output file with tags added to easily find similar Planning Poker rounds
	         File outputFile = Files.createTempFile("planningpoker-screenshot-"+tags+"-",".png").toFile();
	         //write that screenshot to outputFile and save
	         ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outputFile);
	         //Used for debugging
	         System.out.println("Wrote: " + outputFile);
	    } catch (IOException e) {
	    	//On error, see what went wrong
	         e.printStackTrace();
	    }
	 }
	protected String fileNameFormat(String toFix) {
		/**
		 * Formats toFix into a string that can be added to the end of a file name.
		 * Used in: screenshot()
		 */
		String outp = toFix;
		//remove whitespace
		outp = outp.replaceAll("\n", "");
		outp = outp.replaceAll("\t", "");
		outp = outp.replaceAll(" ", "");
		//replace separators with '_'
		outp = outp.replaceAll(";", "_");
		outp = outp.replaceAll(",", "_");
		outp = outp.replaceAll(":", "_");
		//return corrected output
		return outp;
	}
}
