package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * TableAxesPanel
 * @author Sébastien
 *
 */
public class TableAxesPanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(TableAxesPanel.class);
	
	/**
	 * TableAxesPanel ctor
	 * @param text
	 */
	public TableAxesPanel(String text) {
 	 	
		// Radio buttons
		final ToggleGroup group = new ToggleGroup();
		
		RadioButton radioXM1 = new RadioButton("M1 X");
		radioXM1.setToggleGroup(group);
		radioXM1.setSelected(true);
		
		RadioButton radioYM1 = new RadioButton("M1 Y");
		radioYM1.setToggleGroup(group);
		radioYM1.setSelected(false);
		
		RadioButton radioXM2 = new RadioButton("M2 X");
		radioXM2.setToggleGroup(group);
		radioXM2.setSelected(false);
		
		RadioButton radioYM2 = new RadioButton("M2 Y");
		radioYM2.setToggleGroup(group);
		radioYM2.setSelected(false);
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	grid.setHalignment(radioXM1, HPos.LEFT);
		grid.setHalignment(radioYM1, HPos.LEFT);
		grid.setHalignment(radioXM2, HPos.LEFT);
		grid.setHalignment(radioYM2, HPos.LEFT);
		
	 	grid.add(radioXM1, 0, 0);
	 	grid.add(radioYM1, 0, 1);
	 	grid.add(radioXM2, 0, 2);
	 	grid.add(radioYM2, 0, 3);
	 	
	 	setContent(grid);
	}
}
