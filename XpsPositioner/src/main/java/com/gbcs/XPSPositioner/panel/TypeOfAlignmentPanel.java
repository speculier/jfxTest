package com.gbcs.XPSPositioner.panel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.TypeOfAlignment;

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
	private static final Logger logger = LogManager.getLogger(TypeOfAlignmentPanel.class);
	
	ToggleGroup group = new ToggleGroup();
	RadioButton radioTranslation = new RadioButton("TX / TY");
	RadioButton radioRotation = new RadioButton("RX / RY");
	
	/**
	 * TypeOfAlignmentPanel ctor
	 * @param text
	 */
	public TypeOfAlignmentPanel(String text) {
 	 	
		// Radio buttons
		radioTranslation.setToggleGroup(group);
		radioTranslation.setUserData(TypeOfAlignment.TX_TY);
		radioTranslation.setSelected(false);
		
		radioRotation.setToggleGroup(group);
		radioRotation.setUserData(TypeOfAlignment.RX_RY);
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
	
	/**
	 * getTypeOfAlignment
	 * @return TypeOfAlignment
	 */
	public TypeOfAlignment getTypeOfAlignment() {
		return (TypeOfAlignment) group.getSelectedToggle().getUserData();
	}
}
