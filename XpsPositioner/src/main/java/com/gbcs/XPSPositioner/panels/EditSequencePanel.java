package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.stages.MovePositionStage;
import com.gbcs.XPSPositioner.stages.MoveStage;
import com.gbcs.XPSPositioner.stages.MoveTableStage;
import com.gbcs.XPSPositioner.stages.MoveTargetPositionStage;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
	
	/**
	 * EditSequencePanel ctor
	 * @param lv
	 * @param text
	 */
	public EditSequencePanel(ListView<String> lv, String text) {
 	 	
		listviewSequences = lv;
		
		// Buttons	
 	 	Button buttonInitializeAxes = new Button("Initiaiser les axes");
 	 	buttonInitializeAxes.setOnAction(e -> initializeAxes());

 	 	
 	 	Button buttonTablesRelative = new Button("Tables relatif");
 	 	buttonTablesRelative.setOnAction(e->{
 	 		MoveTableStage relativeMoveDialog = new MoveTableStage("Déplacement relatif d'une table", ((Node)e.getSource()).getScene().getWindow());
 	 		relativeMoveDialog.showAndWait();
        });
 	 	
 	 	Button buttonTablesAbsolute = new Button("Tables absolu");
 	 	buttonTablesAbsolute.setOnAction(e->{
 	 		MovePositionStage absoluteMoveDialog = new MovePositionStage("Aller à une position", ((Node)e.getSource()).getScene().getWindow());
 	 		absoluteMoveDialog.showAndWait();
        });
 	 	
 	 	Button buttonMecaRelative = new Button("Meca relatif");
 	 	buttonMecaRelative.setOnAction(e->{
 			MoveStage relativeMoveDialog = new MoveStage("Déplacement relatif suivant un axe", ((Node)e.getSource()).getScene().getWindow());
 	 		relativeMoveDialog.showAndWait();
        });
 	 	
 	 	Button buttonMecaAbsolute = new Button("Meca absolu");
 	 	buttonMecaAbsolute.setOnAction(e->{
 	 		MoveStage relativeMoveDialog = new MoveStage("Déplacement absolu suivant un axe", ((Node)e.getSource()).getScene().getWindow());
 	 		relativeMoveDialog.showAndWait();
        });
 	 	
 	 	Button buttonEssaiRelative = new Button("Essai relatif");
 	 	buttonEssaiRelative.setOnAction(e->{
 	 		MoveStage relativeMoveDialog = new MoveStage("Déplacement relatif suivant \"essai\"", ((Node)e.getSource()).getScene().getWindow());
 	 		relativeMoveDialog.showAndWait();
        });
 	 	
 	 	Button buttonEssaiAbsolute = new Button("Essai absolu");
 	 	buttonEssaiAbsolute.setOnAction(e->{
 	 		MoveStage relativeMoveDialog = new MoveStage("Déplacement absolu  \"essai\"", ((Node)e.getSource()).getScene().getWindow());
 	 		relativeMoveDialog.showAndWait();
        });
 	 	
 	 	Button buttonPositionOint = new Button("Position Oint");
 	 	buttonPositionOint.setOnAction(e->{
 	 		MoveTargetPositionStage moveTargetPositionDalog = new MoveTargetPositionStage("Changer cible", ((Node)e.getSource()).getScene().getWindow());
 	 		moveTargetPositionDalog.showAndWait();
        });
 	 	
 	 	Button buttonRepeat = new Button("Répeter N fois");
 	 	buttonRepeat.setOnAction(e->{

        });
 	 	
 	 	Button buttonEndLoop = new Button("Fin de boucle");
 	 	buttonEndLoop.setOnAction(e->{

        });
 	 	
 	 	Button buttonDelay = new Button("Délai");
 	 	buttonDelay.setOnAction(e->{

        });
 	 	
 	 	Button buttonWaiting = new Button("Attente opérateur");
 	 	buttonWaiting.setOnAction(e->{

        });
 	 	
 	 	// Sequence actions panel
 	 	SequenceActionPanel actionPanel = new SequenceActionPanel("Action");
		
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	 	
	 	grid.setHalignment(actionPanel, HPos.LEFT);
		grid.setHalignment(buttonInitializeAxes, HPos.LEFT);
		grid.setHalignment(buttonTablesRelative, HPos.LEFT);
		grid.setHalignment(buttonTablesAbsolute, HPos.LEFT);
		grid.setHalignment(buttonMecaRelative, HPos.LEFT);
		grid.setHalignment(buttonMecaAbsolute, HPos.LEFT);
		grid.setHalignment(buttonEssaiRelative, HPos.LEFT);
		grid.setHalignment(buttonEssaiAbsolute, HPos.LEFT);
		grid.setHalignment(buttonPositionOint, HPos.LEFT);
		grid.setHalignment(buttonRepeat, HPos.LEFT);
		grid.setHalignment(buttonEndLoop, HPos.LEFT);
		grid.setHalignment(buttonDelay, HPos.LEFT);
		grid.setHalignment(buttonWaiting, HPos.LEFT);
		
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
	 * initializeAxes
	 */
	private void initializeAxes() {
		listviewSequences.getItems().add("I ; Initialisation des axes");
	}
}
