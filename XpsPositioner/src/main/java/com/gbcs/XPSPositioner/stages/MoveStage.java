package com.gbcs.XPSPositioner.stages;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.panels.AxesPanel;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * MoveStage
 * @author Sébastien
 *
 */
public class MoveStage extends Stage {

	// Logger
	private static final Logger logger = Logger.getLogger(MoveStage.class);
	
	/**
	 * MoveStage ctor
	 * @param text
	 * @param parent
	 */
	public MoveStage(String text, Window parent) {

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
   	 	Label labelMove = new Label("Déplacement:");
   	 	Label labelUnit = new Label("mm");
   	 	
   	 	// TextField
   	 	TextField textFieldMoveValue = new TextField();
   	 	textFieldMoveValue.setEditable(true);
 	 	
   	 	// Axes panels
   	 	AxesPanel axesPanel = new AxesPanel("Axe");
   	 	
   	 	// Grid
   	 	GridPane moveValueGrid = new GridPane();
	   	moveValueGrid.setPadding(new Insets(5, 5, 5, 5));
		   	 	
	   	GridPane.setHalignment(labelMove, HPos.LEFT);  
	   	GridPane.setHalignment(textFieldMoveValue, HPos.LEFT);
	   	GridPane.setHalignment(labelUnit, HPos.LEFT);

	   	moveValueGrid.add(labelMove, 0, 0);
	   	moveValueGrid.add(textFieldMoveValue, 1, 0);
	   	moveValueGrid.add(labelUnit, 2, 0);
   	 	
   	 	// Grid
   	 	GridPane grid = new GridPane();
   	 	grid.setPadding(new Insets(5, 5, 5, 5));
   	 	
   	 	GridPane.setHalignment(axesPanel, HPos.CENTER);  
	   	GridPane.setHalignment(moveValueGrid, HPos.CENTER);
	   	GridPane.setHalignment(buttonOk, HPos.CENTER);
	   	GridPane.setHalignment(buttonCancel, HPos.CENTER);
	   	
	   	grid.add(axesPanel, 0, 0);
	   	grid.add(moveValueGrid, 0, 1);
	   	grid.add(buttonOk, 0, 2);
	   	grid.add(buttonCancel,0, 3);
	   	
        Scene scene = new Scene(grid);
        
 	 	initOwner(parent);
 	 	initModality(Modality.APPLICATION_MODAL); 
 	 	sizeToScene();

 	 	setScene(scene);
 	}
}
