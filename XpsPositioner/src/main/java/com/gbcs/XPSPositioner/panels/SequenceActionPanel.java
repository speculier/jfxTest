package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * SequenceActionPanel
 * @author Sébastien
 *
 */
public class SequenceActionPanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(SequenceActionPanel.class);
	
	/**
	 * SequenceActionPanel ctor
	 * @param text
	 */
	public SequenceActionPanel(String text) {
 	 	
		// Radio buttons
		final ToggleGroup group = new ToggleGroup();
		
		RadioButton radioInsertBefore = new RadioButton("Insérer avant");
		radioInsertBefore.setToggleGroup(group);
		radioInsertBefore.setSelected(false);
		
		RadioButton radioInsertAfter = new RadioButton("Insérer après");
		radioInsertAfter.setToggleGroup(group);
		radioInsertAfter.setSelected(true);
		
		RadioButton radioReplace = new RadioButton("Remplacer");
		radioReplace.setToggleGroup(group);
		radioReplace.setSelected(false);
		
		RadioButton radioDelete = new RadioButton("Supprimer");
		radioDelete.setToggleGroup(group);
		radioDelete.setSelected(false);
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	GridPane.setHalignment(radioInsertBefore, HPos.LEFT);
	 	GridPane.setHalignment(radioInsertAfter, HPos.LEFT);
		GridPane.setHalignment(radioReplace, HPos.LEFT);
		GridPane.setHalignment(radioDelete, HPos.LEFT);
		
	 	grid.add(radioInsertBefore, 0, 0);
	 	grid.add(radioInsertAfter, 0, 1);
	 	grid.add(radioReplace, 0, 2);
	 	grid.add(radioDelete, 0, 3);
	 	
	 	setContent(grid);
	}
}
