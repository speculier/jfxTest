package com.gbcs.XPSPositioner.stages;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.panels.FileSequencePanel;
import com.gbcs.XPSPositioner.panels.TableAxesPanel;
import com.gbcs.XPSPositioner.panels.XyPointPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * MoveTableStage
 * @author Sébastien
 *
 */
public class MoveTableStage extends Stage {

	// Logger
	private static final Logger logger = Logger.getLogger(MoveTableStage.class);
	
	/**
	 * MoveTableStage ctor
	 * @param text
	 * @param parent
	 */
	public MoveTableStage(String text, Window parent) {

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
 	 	
   	 	// Table axes panels
   	 	TableAxesPanel tableAxesPanel = new TableAxesPanel("Table");
   	 	
   	 	// Grid
   	 	GridPane moveValueGrid = new GridPane();
	   	moveValueGrid.setPadding(new Insets(5, 5, 5, 5));
		   	 	
	   	moveValueGrid.setHalignment(labelMove, HPos.LEFT);  
	   	moveValueGrid.setHalignment(textFieldMoveValue, HPos.LEFT);
	   	moveValueGrid.setHalignment(labelUnit, HPos.LEFT);

	   	moveValueGrid.add(labelMove, 0, 0);
	   	moveValueGrid.add(textFieldMoveValue, 1, 0);
	   	moveValueGrid.add(labelUnit, 2, 0);
   	 	
   	 	// Grid
   	 	GridPane grid = new GridPane();
   	 	grid.setPadding(new Insets(5, 5, 5, 5));
   	 	
	   	grid.setHalignment(tableAxesPanel, HPos.CENTER);  
	   	grid.setHalignment(moveValueGrid, HPos.CENTER);
	   	grid.setHalignment(buttonOk, HPos.CENTER);
	   	grid.setHalignment(buttonCancel, HPos.CENTER);
	   	
	   	grid.add(tableAxesPanel, 0, 0);
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
