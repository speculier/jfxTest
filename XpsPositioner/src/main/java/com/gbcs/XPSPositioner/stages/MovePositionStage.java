package com.gbcs.XPSPositioner.stages;

import org.apache.log4j.Logger;

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
 * PositionStage
 * @author Sébastien
 *
 */
public class MovePositionStage extends Stage {

	// Logger
	private static final Logger logger = Logger.getLogger(MovePositionStage.class);
	
	/**
	 * PositionStage ctor
	 * @param text
	 * @param parent
	 */
	public MovePositionStage(String text, Window parent) {

		setTitle(text);
		initStyle(StageStyle.UTILITY);
		
		// Buttons
		
   	 	Button buttonCurrentPosition = new Button("Position courante");
   	 	buttonCurrentPosition.setOnAction(e->{

        });
   	 	
   	 	Button buttonOk = new Button("OK");
   	 	buttonOk.setOnAction(e->{
   	 		close();
        });
   	 	
   	 	Button buttonCancel = new Button("Annuler");
   	 	buttonCancel.setCancelButton(true);
   	 	buttonCancel.setOnAction(e->{
   	 		close();
        });
   	 	
   	 	// Position panels
   	 	XyPointPane pointPaneM1 = new XyPointPane ("M1");
   	 	XyPointPane pointPaneM2 = new XyPointPane ("M2");
   	 	
   	 	// Grid
   	 	GridPane grid = new GridPane();
   	 	grid.setPadding(new Insets(5, 5, 5, 5));
   	 	
	   	grid.setHalignment(pointPaneM1, HPos.CENTER);  
	   	grid.setHalignment(pointPaneM2, HPos.CENTER);
	   	grid.setHalignment(buttonCurrentPosition, HPos.CENTER);
	   	grid.setHalignment(buttonOk, HPos.CENTER);
	   	grid.setHalignment(buttonCancel, HPos.CENTER);
	   	
	   	grid.add(pointPaneM1, 0, 0);
	   	grid.add(pointPaneM2, 0, 1);
	   	grid.add(buttonCurrentPosition, 0, 2);
	   	grid.add(buttonOk, 0, 3);
	   	grid.add(buttonCancel,0, 4);
	   	
        Scene scene = new Scene(grid);
        
 	 	initOwner(parent);
 	 	initModality(Modality.APPLICATION_MODAL); 
 	 	sizeToScene();

 	 	setScene(scene);
 	}
}
