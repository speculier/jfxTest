package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

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
	
	private ToggleGroup group = new ToggleGroup();
	RadioButton radioTransateOnX = new RadioButton("TX");
	RadioButton radioTransateOnY = new RadioButton("TY");
	RadioButton radioRotateOnX = new RadioButton("RX");
	RadioButton radioRotateOnY = new RadioButton("RY");
	
	/**
	 * AxesPanel ctor
	 * @param text
	 */
	public AxesPanel(String text) {
 	 	
		// Radio buttons		
		radioTransateOnX.setToggleGroup(group);
		radioTransateOnX.setUserData(MoveTypeOnAxe.TX);
		radioTransateOnX.setSelected(true);
		
		radioTransateOnY.setToggleGroup(group);
		radioTransateOnY.setUserData(MoveTypeOnAxe.TY);
		radioTransateOnY.setSelected(false);
		
		radioRotateOnX.setToggleGroup(group);
		radioRotateOnX.setUserData(MoveTypeOnAxe.RX);
		radioRotateOnX.setSelected(false);
		
		radioRotateOnY.setToggleGroup(group);
		radioRotateOnY.setUserData(MoveTypeOnAxe.RY);
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
	
	/**
	 * getMoveTypeOnAxe
	 * @return MoveType
	 */
	public MoveTypeOnAxe getMoveTypeOnAxe() {
		return (MoveTypeOnAxe) group.getSelectedToggle().getUserData();
	}
}
