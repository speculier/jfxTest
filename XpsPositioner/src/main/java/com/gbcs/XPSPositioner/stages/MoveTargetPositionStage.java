package com.gbcs.XPSPositioner.stages;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.panels.TargetOintPanel;
import com.gbcs.XPSPositioner.panels.TargetTypeOfAlignmentPanel;
import com.gbcs.XPSPositioner.panels.XyPointPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * MoveTargetPositionStage
 * @author Sébastien
 *
 */
public class MoveTargetPositionStage extends Stage {

	// Logger
	private static final Logger logger = Logger.getLogger(MoveTargetPositionStage.class);
	
	/**
	 * MoveTargetPositionStage ctor
	 * @param text
	 * @param parent
	 */
	public MoveTargetPositionStage(String text, Window parent) {

		setTitle(text);
		initStyle(StageStyle.UTILITY);
		
		// Target point panel
		TargetOintPanel oIntPanel = new TargetOintPanel("Oint");
		
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
   	 	
   	 	// Grid
   	 	GridPane mainGrid = new GridPane();
   	 	mainGrid.setPadding(new Insets(5, 5, 5, 5));
   	 	
   	 	mainGrid.setHalignment(oIntPanel, HPos.CENTER);  
   	 	mainGrid.setHalignment(buttonOk, HPos.CENTER);
   	 	mainGrid.setHalignment(buttonCancel, HPos.CENTER);
	   	
	   	mainGrid.add(oIntPanel, 0, 0);
	   	mainGrid.add(buttonOk, 0, 1);
	   	mainGrid.add(buttonCancel, 0, 2);
		   	
        Scene scene = new Scene(mainGrid);
        
 	 	initOwner(parent);
 	 	initModality(Modality.APPLICATION_MODAL); 
 	 	sizeToScene();

 	 	setScene(scene);
 	}
}
