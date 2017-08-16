package com.gbcs.XPSPositioner.dialog;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.RelativeMecaMoveData;
import com.gbcs.XPSPositioner.data.RelativeTablePositionData;
import com.gbcs.XPSPositioner.panel.AxesPanel;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * MoveDialog
 * @author Sébastien
 *
 */
public class MoveDialog extends Dialog<RelativeMecaMoveData> {

	// Logger
	private static final Logger logger = Logger.getLogger(MoveDialog.class);
	
	/**
	 * MoveDialog ctor
	 * @param text
	 */
	public MoveDialog(String text) {

		setTitle(text);
   	 	
   	 	// Labels
   	 	Label labelMove = new Label("Déplacement:");
   	 	Label labelUnit = new Label("mm");
   	 	
   	 	// TextField
   	 	TextField textFieldMoveValue = new TextField();
   	 	textFieldMoveValue.setEditable(true);
 	 	
   	 	// Axes panels
   	 	AxesPanel axesPanel = new AxesPanel("Axe");
   	 	
   	 	// Grid
   	 	GridPane moveValueGrid = new GridPane();
	   	moveValueGrid.setPadding(new Insets(5, 5, 5, 5));
		   	 	
	   	GridPane.setHalignment(labelMove, HPos.LEFT);  
	   	GridPane.setHalignment(textFieldMoveValue, HPos.LEFT);
	   	GridPane.setHalignment(labelUnit, HPos.LEFT);

	   	moveValueGrid.add(labelMove, 0, 0);
	   	moveValueGrid.add(textFieldMoveValue, 1, 0);
	   	moveValueGrid.add(labelUnit, 2, 0);
   	 	
   	 	// Grid
   	 	GridPane grid = new GridPane();
   	 	grid.setPadding(new Insets(5, 5, 5, 5));
   	 	
   	 	GridPane.setHalignment(axesPanel, HPos.CENTER);  
	   	GridPane.setHalignment(moveValueGrid, HPos.CENTER);
	   	
	   	grid.add(axesPanel, 0, 0);
	   	grid.add(moveValueGrid, 0, 1);

	   	getDialogPane().setContent(grid);

 	 	// Set Ok button
	   	final ButtonType butonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
	   	ButtonType butonTypeCancelClose = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
 	 	getDialogPane().getButtonTypes().add(butonTypeOk);
 	 	getDialogPane().getButtonTypes().add(butonTypeCancelClose);
 	 	
 	 	// Convert result to DAO
 	 	setResultConverter(new Callback<ButtonType, RelativeMecaMoveData>() {
 	 		
 		    @Override
 		    public RelativeMecaMoveData call(ButtonType b) {

 		        if (b == butonTypeOk) {
 		            return new RelativeMecaMoveData(Double.parseDouble(textFieldMoveValue.getText()), axesPanel.getMoveType());
 		        }

 		        return null;
 		    }
 	 	});
 	}
}
