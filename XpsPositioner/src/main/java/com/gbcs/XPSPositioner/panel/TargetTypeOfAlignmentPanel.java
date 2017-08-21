package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.TargetTypeOfAlignment;

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
	
	ToggleGroup group = new ToggleGroup();
	RadioButton radioTranslation = new RadioButton("TX / TY (Conserver les angles)");
	RadioButton radioRotation = new RadioButton("RX / RY (Conserver OM2)");
	RadioButton radioDoNotMove = new RadioButton("Ne pas bouger");
	
	/**
	 * TargetTypeOfAlignmentPanel ctor
	 * @param text
	 */
	public TargetTypeOfAlignmentPanel(String text) {
 	 	
		// Radio buttons

		radioTranslation.setToggleGroup(group);
		radioTranslation.setUserData(TargetTypeOfAlignment.TX_TY_KEEP_ANGLES);
		radioTranslation.setSelected(false);
		
		radioRotation.setToggleGroup(group);
		radioRotation.setUserData(TargetTypeOfAlignment.RX_RY_KEEP_OM2);
		radioRotation.setSelected(true);
		
		radioDoNotMove.setToggleGroup(group);
		radioDoNotMove.setUserData(TargetTypeOfAlignment.DO_NOT_MOVE);
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
	
	/**
	 * getTypeOfAlignment
	 * @return TypeOfAlignment
	 */
	public TargetTypeOfAlignment getTypeOfAlignment() {
		return (TargetTypeOfAlignment) group.getSelectedToggle().getUserData();
	}
}
