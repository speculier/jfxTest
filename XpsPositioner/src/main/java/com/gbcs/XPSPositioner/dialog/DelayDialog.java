package com.gbcs.XPSPositioner.dialog;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.data.DelayData;

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
 * DelayDialog
 * @author Sébastien
 *
 */
public class DelayDialog extends Dialog<DelayData> {

	// Logger
	private static final Logger logger = LogManager.getLogger(DelayDialog.class);
		 	
	/**
	 * DelayDialog ctor
	 * @param text
	 */
	public DelayDialog(String text) {

		setTitle(text);
   	 		
   	 	// Labels
   	 	Label labelDelay = new Label("Délai (ms):");
   	 	
   	 	// TextField
		TextField fieldDelay = new TextField("100");
   	 	fieldDelay.setEditable(true);

   	 	// Grid
   	 	GridPane mainGrid = new GridPane();
	    mainGrid.setPadding(new Insets(5, 5, 5, 5));
	   	 	
	    GridPane.setHalignment(labelDelay, HPos.CENTER);  
	   	GridPane.setHalignment(fieldDelay, HPos.CENTER);

	   	mainGrid.add(labelDelay, 0, 0);
	   	mainGrid.add(fieldDelay, 0, 1);

	   	getDialogPane().setContent(mainGrid);

 	 	// Set Ok button
	   	final ButtonType butonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
	   	ButtonType butonTypeCancelClose = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
 	 	getDialogPane().getButtonTypes().add(butonTypeOk);
 	 	getDialogPane().getButtonTypes().add(butonTypeCancelClose);
 	 	
 	 	// Convert result to DAO
 	 	setResultConverter(new Callback<ButtonType, DelayData>() {

 		    @Override
 		    public DelayData call(ButtonType b) {

 		        if (b == butonTypeOk) {
 		        	try {
 		        		return new DelayData(Double.parseDouble(fieldDelay.getText()));
 		        	} catch (NumberFormatException ex) {
	 		        	logger.log(Level.ERROR, "Bad delay value. DelayDialog cancelled");
	 		        }
 		        } else {
 		        	logger.log(Level.TRACE, "DelayDialog cancelled");
 		        }

 		        return null;
 		    }
 	 	});
 	}
}
