package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * AxesPanel
 * @author Sébastien
 *
 */
public class AxesPanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(AxesPanel.class);
	
	/**
	 * AxesPanel ctor
	 * @param text
	 */
	public AxesPanel(String text) {
 	 	
		// Radio buttons
		final ToggleGroup group = new ToggleGroup();
		
		RadioButton radioTransateOnX = new RadioButton("TX");
		radioTransateOnX.setToggleGroup(group);
		radioTransateOnX.setSelected(true);
		
		RadioButton radioTransateOnY = new RadioButton("TY");
		radioTransateOnY.setToggleGroup(group);
		radioTransateOnY.setSelected(false);
		
		RadioButton radioRotateOnX = new RadioButton("RX");
		radioRotateOnX.setToggleGroup(group);
		radioRotateOnX.setSelected(false);
		
		RadioButton radioRotateOnY = new RadioButton("RY");
		radioRotateOnY.setToggleGroup(group);
		radioRotateOnY.setSelected(false);
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	GridPane.setHalignment(radioTransateOnX, HPos.LEFT);
	 	GridPane.setHalignment(radioTransateOnY, HPos.LEFT);
		GridPane.setHalignment(radioRotateOnX, HPos.LEFT);
		GridPane.setHalignment(radioRotateOnY, HPos.LEFT);
		
	 	grid.add(radioTransateOnX, 0, 0);
	 	grid.add(radioTransateOnY, 0, 1);
	 	grid.add(radioRotateOnX, 0, 2);
	 	grid.add(radioRotateOnY, 0, 3);
	 	
	 	setContent(grid);
	}
}
