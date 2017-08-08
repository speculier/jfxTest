package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * TargetOintPanel
 * @author Sébastien
 *
 */
public class TargetOintPanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(TargetOintPanel.class);
	
	/**
	 * TargetOintPanel ctor
	 * @param text
	 */
	public TargetOintPanel(String text) {
		
	 	// Labels
 	 	Label labelX = new Label("X");
 	 	Label labelY = new Label("Y");
 	 	Label labelZ = new Label("Z");
 	 	Label labelUnitX = new Label("mm");
 	 	Label labelUnitY = new Label("mm");
 	 	Label labelUnitZ = new Label("mm");
 	 	
 	 	// TextFields
   	 	TextField textFieldMoveXValue = new TextField();
   	 	textFieldMoveXValue.setEditable(true);
 	 	
   	 	TextField textFieldMoveYValue = new TextField();
   	 	textFieldMoveYValue.setEditable(true);
   	 	
   	 	TextField textFieldMoveZValue = new TextField();
   	 	textFieldMoveZValue.setEditable(true);
   	 	
	 	GridPane upperGrid = new GridPane();	
	 	upperGrid.setVgap(5);
	 	upperGrid.setHgap(10);
	 	upperGrid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	upperGrid.setHalignment(labelX, HPos.CENTER);
	 	upperGrid.setHalignment(labelY, HPos.CENTER);
	 	upperGrid.setHalignment(labelZ, HPos.CENTER);
	 	upperGrid.setHalignment(textFieldMoveXValue, HPos.CENTER);
	 	upperGrid.setHalignment(textFieldMoveYValue, HPos.CENTER);
	 	upperGrid.setHalignment(textFieldMoveZValue, HPos.CENTER);
	 	upperGrid.setHalignment(labelUnitX, HPos.CENTER);
	 	upperGrid.setHalignment(labelUnitY, HPos.CENTER);
	 	upperGrid.setHalignment(labelUnitZ, HPos.CENTER);

	 	upperGrid.add(labelX, 0, 0);
		upperGrid.add(labelY, 0, 1);
		upperGrid.add(labelZ, 0, 2);
		upperGrid.add(textFieldMoveXValue, 1, 0);
		upperGrid.add(textFieldMoveYValue, 1, 1);
		upperGrid.add(textFieldMoveZValue, 1, 2);
		upperGrid.add(labelUnitX, 2, 0);
		upperGrid.add(labelUnitY, 2, 1);
		upperGrid.add(labelUnitZ, 2, 2);
		
		// Type of alignment
		TargetTypeOfAlignmentPanel typeOfAlignmentPanel = new TargetTypeOfAlignmentPanel("Alignement");
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane mainGgrid = new GridPane();
	 	mainGgrid.setVgap(10);
	 	mainGgrid.setHgap(10);
	 	mainGgrid.setPadding(new Insets(5, 5, 5, 5));
	 	 	
	 	mainGgrid.setHalignment(upperGrid, HPos.LEFT);
	 	mainGgrid.setHalignment(typeOfAlignmentPanel, HPos.LEFT);

	 	mainGgrid.add(upperGrid, 0, 0);
	 	mainGgrid.add(typeOfAlignmentPanel, 0, 1);
		
	 	setContent(mainGgrid);
	}
}
