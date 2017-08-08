package com.gbcs.XPSPositioner.stages;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.panels.AboutPane;
import com.gbcs.XPSPositioner.panels.XyPointPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * AboutStage
 * @author Sébastien
 *
 */
public class AboutStage extends Stage {

	// Logger
	private static final Logger logger = Logger.getLogger(AboutStage.class);
	
	/**
	 * AboutStage ctor
	 * @param text
	 * @param parent
	 */
	public AboutStage(String text, Window parent) {

		setTitle(text);
		initStyle(StageStyle.UTILITY);
		
		// Buttons
   	 	
   	 	Button buttonOk = new Button("OK");
   	 	buttonOk.setOnAction(e->{
   	 		close();
        });
   	 	
   	 	// About panel
   	 	AboutPane aboutPane = new AboutPane();
   	 	
   	 	// Grid
   	 	GridPane grid = new GridPane();
   	 	grid.setPadding(new Insets(5, 5, 5, 5));
   	 	
	   	grid.setHalignment(aboutPane, HPos.CENTER);  
	   	grid.setHalignment(buttonOk, HPos.CENTER);
	   	
	   	grid.add(aboutPane, 0, 0);
	   	grid.add(buttonOk, 0, 1);

        Scene scene = new Scene(grid);
        
 	 	initOwner(parent);
 	 	initModality(Modality.APPLICATION_MODAL); 
 	 	sizeToScene();

 	 	setScene(scene);
 	}
}
