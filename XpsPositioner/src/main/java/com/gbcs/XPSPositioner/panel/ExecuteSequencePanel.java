package com.gbcs.XPSPositioner.panel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 * ExecuteSequencePanel
 * @author Sébastien
 *
 */
public class ExecuteSequencePanel extends TitledPane {

	// Logger
	private static final Logger logger = LogManager.getLogger(ExecuteSequencePanel.class);
	
	/**
	 * ExecuteSequencePanel ctor
	 * @param text
	 */
	public ExecuteSequencePanel(String text) {
 	 	
		// Buttons
		
 	 	Button buttonExecuteLine = new Button("Exécuter ligne");
 	 	buttonExecuteLine.setOnAction(e->{

        });
 	 	
 	 	Button buttonExecuteSequence = new Button("Exécuter séquence");
 	 	buttonExecuteSequence.setOnAction(e->{

        });
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	 	
	 	GridPane.setHalignment(buttonExecuteLine, HPos.LEFT);
	 	GridPane.setHalignment(buttonExecuteSequence, HPos.LEFT);
		
		grid.add(buttonExecuteLine, 0, 0);
	 	grid.add(buttonExecuteSequence, 0, 1);
	 	
	 	setContent(grid);
	}
}
