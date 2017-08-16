package com.gbcs.XPSPositioner.panel;

import java.util.Optional;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.AbsoluteTablePositionData;
import com.gbcs.XPSPositioner.data.MoveTargetPositionData;
import com.gbcs.XPSPositioner.data.RelativeMecaMoveData;
import com.gbcs.XPSPositioner.data.RelativeTablePositionData;
import com.gbcs.XPSPositioner.dialog.MoveDialog;
import com.gbcs.XPSPositioner.dialog.MovePositionDialog;
import com.gbcs.XPSPositioner.dialog.MoveTableDialog;
import com.gbcs.XPSPositioner.dialog.MoveTargetPositionDialog;
import com.gbcs.XPSPositioner.enumeration.SequenceAction;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 * EditSequencePanel
 * @author Sébastien
 *
 */
public class EditSequencePanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(EditSequencePanel.class);
	
	private ListView<String> listviewSequences;
	private SequenceActionPanel actionPanel;
	
	/**
	 * EditSequencePanel ctor
	 * @param lv
	 * @param text
	 */
	public EditSequencePanel(ListView<String> lv, String text) {
 	 	
		listviewSequences = lv;
		
		// Buttons	
 	 	Button buttonInitializeAxes = new Button("Initiaiser les axes");
 	 	buttonInitializeAxes.setOnAction(e -> insertInitializeAxes(e));

 	 	Button buttonTablesRelative = new Button("Tables relatif");
 	 	buttonTablesRelative.setOnAction(e-> insertMoveTableRelative(e));
 
 	 	Button buttonTablesAbsolute = new Button("Tables absolu");
 	 	buttonTablesAbsolute.setOnAction(e-> insertMoveTableAbsolute(e));
 	 	
 	 	Button buttonMecaRelative = new Button("Meca relatif");
 	 	buttonMecaRelative.setOnAction(e-> insertMoveMecaRelative(e));
 	 	
 	 	Button buttonMecaAbsolute = new Button("Meca absolu");
 	 	buttonMecaAbsolute.setOnAction(e-> insertMoveMecaAbsolute(e));
 	 	
 	 	Button buttonEssaiRelative = new Button("Essai relatif");
 	 	buttonEssaiRelative.setOnAction(e-> insertMoveEssaiRelative(e));
 	 	 	 	
 	 	Button buttonEssaiAbsolute = new Button("Essai absolu");
 	 	buttonEssaiAbsolute.setOnAction(e-> insertMoveEssaiAbsolute(e));
 	 	
 	 	Button buttonPositionOint = new Button("Position Oint");
 	 	buttonPositionOint.setOnAction(e-> insertMovePositionOint(e));
 	 	
 	 	Button buttonRepeat = new Button("Répeter N fois");
 	 	buttonRepeat.setOnAction(e-> insertRepeat(e));
 	 	
 	 	Button buttonEndLoop = new Button("Fin de boucle");
 	 	buttonEndLoop.setOnAction(e-> insertEndLoop(e));
 	 	
 	 	Button buttonDelay = new Button("Délai");
 	 	buttonDelay.setOnAction(e-> insertDelay(e));
 	 	
 	 	Button buttonWaiting = new Button("Attente opérateur");
 	 	buttonWaiting.setOnAction(e-> insertWaiting(e));
 	 	
 	 	// Sequence actions panel
 	 	actionPanel = new SequenceActionPanel("Action");
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	 	
	 	GridPane.setHalignment(actionPanel, HPos.LEFT);
	 	GridPane.setHalignment(buttonInitializeAxes, HPos.LEFT);
		GridPane.setHalignment(buttonTablesRelative, HPos.LEFT);
		GridPane.setHalignment(buttonTablesAbsolute, HPos.LEFT);
		GridPane.setHalignment(buttonMecaRelative, HPos.LEFT);
		GridPane.setHalignment(buttonMecaAbsolute, HPos.LEFT);
		GridPane.setHalignment(buttonEssaiRelative, HPos.LEFT);
		GridPane.setHalignment(buttonEssaiAbsolute, HPos.LEFT);
		GridPane.setHalignment(buttonPositionOint, HPos.LEFT);
		GridPane.setHalignment(buttonRepeat, HPos.LEFT);
		GridPane.setHalignment(buttonEndLoop, HPos.LEFT);
		GridPane.setHalignment(buttonDelay, HPos.LEFT);
		GridPane.setHalignment(buttonWaiting, HPos.LEFT);
		
		grid.add(actionPanel, 0, 0);
	 	grid.add(buttonInitializeAxes, 0, 1);
	 	grid.add(buttonTablesRelative, 0, 2);
	 	grid.add(buttonTablesAbsolute, 0, 3);
	 	grid.add(buttonMecaRelative, 0, 4);
	 	grid.add(buttonMecaAbsolute, 0, 5);
	 	grid.add(buttonEssaiRelative, 0, 6);
	 	grid.add(buttonEssaiAbsolute, 0, 7);
	 	grid.add(buttonPositionOint, 0, 8);
	 	grid.add(buttonRepeat, 0, 9);
	 	grid.add(buttonEndLoop, 0, 10);
	 	grid.add(buttonDelay, 0, 11);
	 	grid.add(buttonWaiting, 0, 12);
	 	
	 	setContent(grid);
	}
	
	/**
	 * insertInList
	 * @param e
	 * @param action
	 * @param text
	 */
	private void insertInList(ActionEvent e, SequenceAction action, String text) {

		if (listviewSequences.getItems().size() == 0 && action != SequenceAction.DELETE) {
			listviewSequences.getItems().add(text);
		} else {
			for(Integer currentIndice : listviewSequences.getSelectionModel().getSelectedIndices()){
				switch(action) {
				case INSERT_BEFORE:
		            listviewSequences.getItems().add(currentIndice, text);
					break;
				case REPLACE:
		            listviewSequences.getItems().set(currentIndice, text);
					break;
				case INSERT_AFTER:
		            listviewSequences.getItems().add(currentIndice + 1, text);
		            break;
				case DELETE:
					default:
						break;
				}
			}
		}
	}
	
	/**
	 * insertInitializeAxes
	 * I
	 */
	private void insertInitializeAxes(ActionEvent e) {
		insertInList(e, actionPanel.getSelectedAction(), "I ; Initialisation des axes");
		 System.out.println("I");
	}

	/**
	 * insertMoveTableAbsolute
	 * P
	 */
	private void insertMoveTableAbsolute(ActionEvent e) {
 		MovePositionDialog absoluteMoveDialog = new MovePositionDialog("Aller à une position");
 		
 		Optional<AbsoluteTablePositionData> result = absoluteMoveDialog.showAndWait();
 		if (result.isPresent()) {
 		   System.out.println(result.get().toString());
 		}
	}
	
	/**
	 * insertMoveTableRelative
	 * R
	 */
	private void insertMoveTableRelative(ActionEvent e) {
 		MoveTableDialog relativeMoveDialog = new MoveTableDialog("Déplacement relatif d'une table");
 		
 		Optional<RelativeTablePositionData> result = relativeMoveDialog.showAndWait();
 		if (result.isPresent()) {
 		   System.out.println(result.get().toString());
 		}
	}
	
	/**
	 * insertMoveMecaAbsolute
	 */
	private void insertMoveMecaAbsolute(ActionEvent e) {
 		MoveDialog relativeMoveDialog = new MoveDialog("Déplacement absolu suivant un axe");

		Optional<RelativeMecaMoveData> result = relativeMoveDialog.showAndWait();
 		if (result.isPresent()) {
 		   System.out.println(result.get().toString());
 		}
	}
	
	/**
	 * insertMoveMecaRelative
	 */
	private void insertMoveMecaRelative(ActionEvent e) {
		MoveDialog relativeMoveDialog = new MoveDialog("Déplacement relatif suivant un axe");
 		
		Optional<RelativeMecaMoveData> result = relativeMoveDialog.showAndWait();
 		if (result.isPresent()) {
 		   System.out.println(result.get().toString());
 		}
	}
	
	/**
	 * insertMoveEssaiAbsolute
	 */
	private void insertMoveEssaiAbsolute(ActionEvent e) {
 		MoveDialog relativeMoveDialog = new MoveDialog("Déplacement absolu  \"essai\"");
 		
		Optional<RelativeMecaMoveData> result = relativeMoveDialog.showAndWait();
 		if (result.isPresent()) {
 		   System.out.println(result.get().toString());
 		}
	}
	
	/**
	 * insertMoveEssaiRelative
	 */
	private void insertMoveEssaiRelative(ActionEvent e) {
 		MoveDialog relativeMoveDialog = new MoveDialog("Déplacement relatif suivant \"essai\"");

		Optional<RelativeMecaMoveData> result = relativeMoveDialog.showAndWait();
 		if (result.isPresent()) {
 		   System.out.println(result.get().toString());
 		}
	}
	
	/**
	 * insertMovePositionOint
	 */
	private void insertMovePositionOint(ActionEvent e) {
 		MoveTargetPositionDialog moveTargetPositionDialog = new MoveTargetPositionDialog("Changer cible");

		Optional<MoveTargetPositionData> result = moveTargetPositionDialog.showAndWait();
 		if (result.isPresent()) {
 		   System.out.println(result.get().toString());
 		}
	}
	
	/**
	 * insertRepeat
	 */
	private void insertRepeat(ActionEvent e) {
		
	}
	
	/**
	 * insertEndLoop
	 */
	private void insertEndLoop(ActionEvent e) {
		
	}
	
	/**
	 * insertDelay
	 */
	private void insertDelay(ActionEvent e) {
		
	}
	
	/**
	 * insertWaiting
	 */
	private void insertWaiting(ActionEvent e) {
		
	}
}
