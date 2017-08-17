package com.gbcs.XPSPositioner.dialog;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.RelativeTablePositionData;
import com.gbcs.XPSPositioner.panel.TableAxesPanel;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * MoveTableDialog
 * @author Sébastien
 *
 */
public class MoveTableDialog extends Dialog<RelativeTablePositionData>  {

	// Logger
	private static final Logger logger = Logger.getLogger(MoveTableDialog.class);
		
	/**
	 * MoveTableDialog ctor
	 * @param text
	 */
	public MoveTableDialog(String text) {

		setTitle(text);
		  	 	
   	 	// Labels
   	 	Label labelMove = new Label("Déplacement:");
   	 	Label labelUnit = new Label("mm");
   	 	
   	 	// TextField
   	 	TextField textFieldMoveValue = new TextField();
   	 	textFieldMoveValue.setEditable(true);
 	 	
   	 	// Table axes panels
   	 	TableAxesPanel tableAxesPanel = new TableAxesPanel("Table");
   	 	
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
   	 	
   	 	GridPane.setHalignment(tableAxesPanel, HPos.CENTER);  
	   	GridPane.setHalignment(moveValueGrid, HPos.CENTER);
	   	
	   	grid.add(tableAxesPanel, 0, 0);
	   	grid.add(moveValueGrid, 0, 1);
	   	
	   	getDialogPane().setContent(grid);

 	 	// Set Ok button
	   	final ButtonType butonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
	   	ButtonType butonTypeCancelClose = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
 	 	getDialogPane().getButtonTypes().add(butonTypeOk);
 	 	getDialogPane().getButtonTypes().add(butonTypeCancelClose);
 	 	
 	 	// Convert result to DAO
 	 	setResultConverter(new Callback<ButtonType, RelativeTablePositionData>() {
 	 		
 		    @Override
 		    public RelativeTablePositionData call(ButtonType b) {

 		        if (b == butonTypeOk) {
 		        	try {
 		        		return new RelativeTablePositionData(Double.parseDouble(textFieldMoveValue.getText()), tableAxesPanel.getAxe());
 		        	} catch (NumberFormatException ex) {
	 		        	logger.log(Level.ERROR, "Bad move value. MoveTableDialog cancelled");
	 		        }
 		        } else {
 		        	logger.log(Level.TRACE, "MoveTableDialog cancelled");
 		        }

 		        return null;
 		    }
 	 	});
 	}
}
