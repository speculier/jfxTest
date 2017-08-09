package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * TypeOfAlignmentPanel
 * @author Sébastien
 *
 */
public class TypeOfAlignmentPanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(TypeOfAlignmentPanel.class);
	
	/**
	 * TypeOfAlignmentPanel ctor
	 * @param text
	 */
	public TypeOfAlignmentPanel(String text) {
 	 	
		// Radio buttons
		final ToggleGroup group = new ToggleGroup();
		RadioButton radioTranslation = new RadioButton("TX / TY");
		radioTranslation.setToggleGroup(group);
		radioTranslation.setSelected(false);
		
		RadioButton radioRotation = new RadioButton("RX / RY");
		radioRotation.setToggleGroup(group);
		radioRotation.setSelected(true);
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(5);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	GridPane.setHalignment(radioTranslation, HPos.CENTER);
	 	GridPane.setHalignment(radioRotation, HPos.CENTER);
	 	
	 	grid.add(radioTranslation, 0, 0);
	 	grid.add(radioRotation, 0, 1);

	 	setContent(grid);
	}
}
