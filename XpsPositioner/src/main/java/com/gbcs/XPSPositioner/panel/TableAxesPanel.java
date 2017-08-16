package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.MoveAxe;
import com.gbcs.XPSPositioner.enumeration.SequenceAction;

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
	
	private ToggleGroup group = new ToggleGroup();
	private RadioButton radioXM1 = new RadioButton("M1 X");
	private RadioButton radioYM1 = new RadioButton("M1 Y");
	private RadioButton radioXM2 = new RadioButton("M2 X");
	private RadioButton radioYM2 = new RadioButton("M2 Y");
	
	/**
	 * TableAxesPanel ctor
	 * @param text
	 */
	public TableAxesPanel(String text) {
 	 	
		// Radio buttons	
		radioXM1.setToggleGroup(group);
		radioXM1.setUserData(MoveAxe.X_M1);
		radioXM1.setSelected(true);
		
		radioYM1.setToggleGroup(group);
		radioYM1.setUserData(MoveAxe.Y_M1);
		radioYM1.setSelected(false);
		
		radioXM2.setToggleGroup(group);
		radioXM2.setUserData(MoveAxe.X_M2);
		radioXM2.setSelected(false);
		
		radioYM2.setToggleGroup(group);
		radioYM2.setUserData(MoveAxe.Y_M2);
		radioYM2.setSelected(false);
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	GridPane.setHalignment(radioXM1, HPos.LEFT);
	 	GridPane.setHalignment(radioYM1, HPos.LEFT);
	 	GridPane.setHalignment(radioXM2, HPos.LEFT);
	 	GridPane.setHalignment(radioYM2, HPos.LEFT);
		
	 	grid.add(radioXM1, 0, 0);
	 	grid.add(radioYM1, 0, 1);
	 	grid.add(radioXM2, 0, 2);
	 	grid.add(radioYM2, 0, 3);
	 	
	 	setContent(grid);
	}
	
	/**
	 * getAxe
	 * @return MoveAxe
	 */
	public MoveAxe getAxe() {
		return (MoveAxe) group.getSelectedToggle().getUserData();
	}
}
