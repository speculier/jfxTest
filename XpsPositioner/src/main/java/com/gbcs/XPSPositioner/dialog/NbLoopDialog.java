package com.gbcs.XPSPositioner.dialog;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.data.NbLoopData;

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
 * NbLoopDialog
 * @author Sébastien
 *
 */
public class NbLoopDialog extends Dialog<NbLoopData> {

	// Logger
	private static final Logger logger = LogManager.getLogger(NbLoopDialog.class);
	
	private TextField fieldNbLoops = new TextField("2");
	 	
	/**
	 * NbLoopDialog ctor
	 * @param text
	 */
	public NbLoopDialog(String text) {

		setTitle(text);
   	 	
   	 	// Labels
   	 	Label labelNbLoops = new Label("Nombre de boucles:");
   	 	
   	 	// TextField
   	 	fieldNbLoops.setEditable(true);

   	 	// Grid
   	 	GridPane mainGrid = new GridPane();
	    mainGrid.setPadding(new Insets(5, 5, 5, 5));
	   	 	
	    GridPane.setHalignment(labelNbLoops, HPos.CENTER);  
	   	GridPane.setHalignment(fieldNbLoops, HPos.CENTER);

	   	mainGrid.add(labelNbLoops, 0, 0);
	   	mainGrid.add(fieldNbLoops, 0, 1);

	   	getDialogPane().setContent(mainGrid);

 	 	// Set Ok button
	   	final ButtonType butonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
	   	ButtonType butonTypeCancelClose = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
 	 	getDialogPane().getButtonTypes().add(butonTypeOk);
 	 	getDialogPane().getButtonTypes().add(butonTypeCancelClose);
 	 	
 	 	// Convert result to DAO
 	 	setResultConverter(new Callback<ButtonType, NbLoopData>() {

 		    @Override
 		    public NbLoopData call(ButtonType b) {

 		        if (b == butonTypeOk) {
 		        	try {
 		        		return new NbLoopData(Integer.parseInt(fieldNbLoops.getText()));
 		        	} catch (NumberFormatException ex) {
	 		        	logger.log(Level.ERROR, "Bad number of loop(s). NbLoopDialog cancelled");
	 		        }
 		        } else {
 		        	logger.log(Level.TRACE, "NbLoopDialog cancelled");
 		        }

 		        return null;
 		    }
 	 	});
 	}
}
