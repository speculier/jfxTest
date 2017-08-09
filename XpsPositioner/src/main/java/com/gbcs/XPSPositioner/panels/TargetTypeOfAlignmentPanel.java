package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * TargetTypeOfAlignmentPanel
 * @author Sébastien
 *
 */
public class TargetTypeOfAlignmentPanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(TargetTypeOfAlignmentPanel.class);
	
	/**
	 * TargetTypeOfAlignmentPanel ctor
	 * @param text
	 */
	public TargetTypeOfAlignmentPanel(String text) {
 	 	
		// Radio buttons
		final ToggleGroup group = new ToggleGroup();
		RadioButton radioTranslation = new RadioButton("TX / TY (Conserver les angles)");
		radioTranslation.setToggleGroup(group);
		radioTranslation.setSelected(false);
		
		RadioButton radioRotation = new RadioButton("RX / RY (Conserver OM2)");
		radioRotation.setToggleGroup(group);
		radioRotation.setSelected(true);
		
		RadioButton radioDoNotMove = new RadioButton("RX / RY (Conserver OM2)");
		radioDoNotMove.setToggleGroup(group);
		radioDoNotMove.setSelected(false);
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(5);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	GridPane.setHalignment(radioTranslation, HPos.LEFT);
	 	GridPane.setHalignment(radioRotation, HPos.LEFT);
	 	GridPane.setHalignment(radioDoNotMove, HPos.LEFT);
	
	 	grid.add(radioTranslation, 0, 0);
	 	grid.add(radioRotation, 0, 1);
	 	grid.add(radioDoNotMove, 0, 2);

	 	setContent(grid);
	}
}
