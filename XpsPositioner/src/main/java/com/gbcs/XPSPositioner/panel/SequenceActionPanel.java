package com.gbcs.XPSPositioner.panel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.SequenceAction;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * SequenceActionPanel
 * @author Sébastien
 *
 */
public class SequenceActionPanel extends TitledPane {

	// Logger
	private static final Logger logger = LogManager.getLogger(SequenceActionPanel.class);
	
	private ToggleGroup group = new ToggleGroup();
	
	/**
	 * SequenceActionPanel ctor
	 * @param text
	 */
	public SequenceActionPanel(String text) {
 	 	
		// Radio buttons		
		RadioButton radioInsertBefore = new RadioButton("Insérer avant");
		radioInsertBefore.setToggleGroup(group);
		radioInsertBefore.setUserData(SequenceAction.INSERT_BEFORE);
		radioInsertBefore.setSelected(false);
		
		RadioButton radioInsertAfter = new RadioButton("Insérer après");
		radioInsertAfter.setToggleGroup(group);
		radioInsertAfter.setUserData(SequenceAction.INSERT_AFTER);
		radioInsertAfter.setSelected(true);
		
		RadioButton radioReplace = new RadioButton("Remplacer");
		radioReplace.setToggleGroup(group);
		radioReplace.setUserData(SequenceAction.REPLACE);
		radioReplace.setSelected(false);
		
		RadioButton radioDelete = new RadioButton("Supprimer");
		radioDelete.setToggleGroup(group);
		radioDelete.setUserData(SequenceAction.DELETE);
		radioDelete.setSelected(false);
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

		         if (group.getSelectedToggle() != null) {

		        	   RadioButton currentRadioSelected = (RadioButton) new_toggle.getToggleGroup().getSelectedToggle(); 
		               System.out.println("Selected Radio Button - "+ currentRadioSelected.getUserData().toString());
		         }
		     } 
		});
		
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
	
	/**
	 * getSelectedAction
	 * @return SequenceAction
	 */
	SequenceAction getSelectedAction() {

		if (group.getSelectedToggle() == null) {
		   return null;
		}

		RadioButton currentRadioSelected = (RadioButton) group.getSelectedToggle(); 
		if (currentRadioSelected == null) {
			return null;
		}
  	   
       return (SequenceAction) currentRadioSelected.getUserData();
	}
}
