package com.gbcs.XPSPositioner.dialog;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.PasswordData;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * PasswordDialog
 * @author Sébastien
 *
 */
public class PasswordDialog extends Dialog<PasswordData> {

	// Logger
	private static final Logger logger = Logger.getLogger(PasswordDialog.class);
	
	private PasswordField fieldPassword = new PasswordField ();
	 	
	/**
	 * PasswordDialog ctor
	 * @param text
	 */
	public PasswordDialog(String text) {

		setTitle(text);
   	 	
   	 	// Labels
   	 	Label labelPassword = new Label("Mot de passe:");
   	 	
   	 	// TextField
   	 	fieldPassword.setEditable(true);
   	 
   	 	// Grid
   	 	GridPane mainGrid = new GridPane();
	    mainGrid.setPadding(new Insets(5, 5, 5, 5));
	   	 	
	    GridPane.setHalignment(labelPassword, HPos.CENTER);  
	   	GridPane.setHalignment(fieldPassword, HPos.CENTER);

	   	
	   	mainGrid.add(labelPassword, 0, 0);
	   	mainGrid.add(fieldPassword, 0, 1);

	   	getDialogPane().setContent(mainGrid);

 	 	// Set Ok button
	   	final ButtonType butonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
	   	ButtonType butonTypeCancelClose = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
 	 	getDialogPane().getButtonTypes().add(butonTypeOk);
 	 	getDialogPane().getButtonTypes().add(butonTypeCancelClose);
 	 	
 	 	// Convert result to DAO
 	 	setResultConverter(new Callback<ButtonType, PasswordData>() {
 	 		
 		    @Override
 		    public PasswordData call(ButtonType b) {

 		        if (b == butonTypeOk) {
 		        	return new PasswordData(fieldPassword.getText());
 		        } else {
 		        	logger.log(Level.TRACE, "PasswordDialog cancelled");
 		        }

 		        return null;
 		    }
 	 	});
 	}
}
