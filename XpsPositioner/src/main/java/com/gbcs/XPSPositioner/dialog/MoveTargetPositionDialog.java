package com.gbcs.XPSPositioner.dialog;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.MoveTargetPositionData;
import com.gbcs.XPSPositioner.panel.TargetOintPanel;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * MoveTargetPositionDialog
 * @author Sébastien
 *
 */
public class MoveTargetPositionDialog extends Dialog<MoveTargetPositionData> {

	// Logger
	private static final Logger logger = Logger.getLogger(MoveTargetPositionDialog.class);
	
	private TargetOintPanel oIntPanel = new TargetOintPanel("Oint");
	
	/**
	 * MoveTargetPositionDialog ctor
	 * @param text
	 */
	public MoveTargetPositionDialog(String text) {

		setTitle(text);
		  	 	
   	 	// Grid
   	 	GridPane mainGrid = new GridPane();
   	 	mainGrid.setPadding(new Insets(5, 5, 5, 5));
   	 	
	   	GridPane.setHalignment(oIntPanel, HPos.CENTER);  
	   	
	   	mainGrid.add(oIntPanel, 0, 0);

	   	getDialogPane().setContent(mainGrid);

 	 	// Set Ok button
	   	final ButtonType butonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
	   	ButtonType butonTypeCancelClose = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
 	 	getDialogPane().getButtonTypes().add(butonTypeOk);
 	 	getDialogPane().getButtonTypes().add(butonTypeCancelClose);
 	 	
 	 	// Convert result to DAO
 	 	setResultConverter(new Callback<ButtonType, MoveTargetPositionData>() {
 	 		
 		    @Override
 		    public MoveTargetPositionData call(ButtonType b) {

 		        if (b == butonTypeOk) {
 		        	try {
 		        		return new MoveTargetPositionData(oIntPanel.getX(), oIntPanel.getY(), oIntPanel.getZ(), oIntPanel.getTypeOfAlignment());
 		        	} catch (NumberFormatException ex) {
 		        		logger.log(Level.ERROR, "Bad target x, y or z values. MoveTargetPositionDialog cancelled");
 		        	}
 		        } else {
 		        	logger.log(Level.TRACE, "MoveTargetPositionDialog cancelled");
 		        }

 		        return null;
 		    }
 	 	});
 	}
}
