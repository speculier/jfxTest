package com.gbcs.XPSPositioner.dialog;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * PasswordStage
 * @author Sébastien
 *
 */
public class PasswordStage extends Stage {

	// Logger
	private static final Logger logger = Logger.getLogger(PasswordStage.class);
	
	/**
	 * PasswordStage ctor
	 * @param text
	 * @param parent
	 */
	public PasswordStage(String text, Window parent) {

		setTitle(text);
		initStyle(StageStyle.UTILITY);
		
		// Buttons
   	 	
   	 	Button buttonOk = new Button("OK");
   	 	buttonOk.setOnAction(e->{
   	 		close();
        });
   	 	
   	 	Button buttonCancel = new Button("Annuler");
   	 	buttonCancel.setCancelButton(true);
   	 	buttonCancel.setOnAction(e->{
   	 		close();
        });
   	 	
   	 	// Labels
   	 	Label labelPassword = new Label("Mot de passe:");
   	 	
   	 	// TextField
   	 	PasswordField fieldPassword = new PasswordField ();
   	 	fieldPassword.setEditable(true);
   	 
   	 	// Grid
   	 	GridPane mainGrid = new GridPane();
	    mainGrid.setPadding(new Insets(5, 5, 5, 5));
	   	 	
	    GridPane.setHalignment(labelPassword, HPos.CENTER);  
	   	GridPane.setHalignment(fieldPassword, HPos.CENTER);
	   	GridPane.setHalignment(buttonOk, HPos.CENTER);
	   	GridPane.setHalignment(buttonCancel, HPos.CENTER);
	   	
	   	mainGrid.add(labelPassword, 0, 0);
	   	mainGrid.add(fieldPassword, 0, 1);
	   	mainGrid.add(buttonOk, 0, 2);
	   	mainGrid.add(buttonCancel,0, 3);
	   	
        Scene scene = new Scene(mainGrid);
        
 	 	initOwner(parent);
 	 	initModality(Modality.APPLICATION_MODAL); 
 	 	sizeToScene();

 	 	setScene(scene);
 	}
}
