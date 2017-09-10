package com.gbcs.XPSPositioner.dialog;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.data.AbsoluteEssaiMoveData;
import com.gbcs.XPSPositioner.data.AbsoluteMecaMoveData;
import com.gbcs.XPSPositioner.data.RelativeEssaiMoveData;
import com.gbcs.XPSPositioner.data.RelativeMecaMoveData;
import com.gbcs.XPSPositioner.enumeration.MoveType;
import com.gbcs.XPSPositioner.panel.AxesPanel;

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
 * MoveDialog
 * @author Sébastien
 *
 */
public class MoveDialog extends Dialog<Object> {

	// Logger
	private static final Logger logger = LogManager.getLogger(MoveDialog.class);
	
	private TextField textFieldMoveValue = new TextField();
	
	private AxesPanel axesPanel = new AxesPanel("Axe");

	/**
	 * MoveDialog ctor
	 * @param text
	 * @param type
	 */
	public MoveDialog(String text, MoveType type) {

		setTitle(text);
   	 	
   	 	// Labels
		Label labelMove;
		if (type == MoveType.ABSOLUTE_ESSAI || type == MoveType.ABSOLUTE_MECA) {
   	 		labelMove = new Label("Ciblet:");
		} else {
			labelMove = new Label("Déplacement:");
		}
		
   	 	Label labelUnit = new Label("mm");
   	 	
   	 	// TextField
   	 	textFieldMoveValue.setEditable(true);
   	 	
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
 	 	setResultConverter(new Callback<ButtonType, Object>() {
 	 		
 		    @Override
 		    public Object call(ButtonType b) {

 		        if (b == butonTypeOk) {
 		        	try {
 		        		switch (type) {
 		        			case ABSOLUTE_ESSAI:
 		        				return new AbsoluteEssaiMoveData(Double.parseDouble(textFieldMoveValue.getText()), axesPanel.getMoveTypeOnAxe());
 		        			case ABSOLUTE_MECA:
 		        				return new AbsoluteMecaMoveData(Double.parseDouble(textFieldMoveValue.getText()), axesPanel.getMoveTypeOnAxe());
 		        			case RELATIVE_ESSAI:
 		        				return new RelativeEssaiMoveData(Double.parseDouble(textFieldMoveValue.getText()), axesPanel.getMoveTypeOnAxe());
 		        			case RELATIVE_MECA:
 		        				return new RelativeMecaMoveData(Double.parseDouble(textFieldMoveValue.getText()), axesPanel.getMoveTypeOnAxe());
 		        			default:
 		        				break;
 		        		} 
 		        	} catch (NumberFormatException ex) {
	 		        	logger.log(Level.ERROR, "Bad move value. MoveDialog cancelled");
	 		        }
 		        } else {
 		        	logger.log(Level.TRACE, "MoveDialog cancelled");
 		        }

 		        return null;
 		    }
 	 	});
 	}
}
