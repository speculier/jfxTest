package com.gbcs.XPSPositioner.dialog;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.data.PasswordData;
import com.gbcs.XPSPositioner.parameters.GabiParameters;
import com.gbcs.XPSPositioner.util.PasswordEncrypter;

import javafx.application.Platform;
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
 * ChangePasswordDialog
 * @author Sébastien
 *
 */
public class ChangePasswordDialog extends Dialog<PasswordData> {

	// 	Logger
	private static final Logger logger = LogManager.getLogger(ChangePasswordDialog.class.getName());
	
	private PasswordField fieldPassword = new PasswordField ();
	private PasswordField fieldNewPassword = new PasswordField ();
	private PasswordField fieldNewPassword2 = new PasswordField ();
	
	/**
	 * PasswordDialog ctor
	 * @param text
	 */
	public ChangePasswordDialog(String text) {

		setTitle(text);
   	 	
   	 	// Labels
   	 	Label labelPassword = new Label("Ancien mot de passe:");
   	 	Label labelNewPassword = new Label("Nouveau mot de passe:");
   	 	Label labelNewPassword2 = new Label("Confirmation du nouveau mot de passe:");
   	 	
   	 	// TextFields
   	 	fieldPassword.setEditable(true);
   		fieldNewPassword.setEditable(true);
   		fieldNewPassword2.setEditable(true);
   	 	Platform.runLater(() -> fieldPassword.requestFocus());
   	 
   	 	// Grid
   	 	GridPane mainGrid = new GridPane();
	    mainGrid.setPadding(new Insets(5, 5, 5, 5));
	   	 	
	    GridPane.setHalignment(labelPassword, HPos.CENTER);  
	    GridPane.setHalignment(labelNewPassword, HPos.CENTER); 
	    GridPane.setHalignment(labelNewPassword2, HPos.CENTER); 
	   	GridPane.setHalignment(fieldPassword, HPos.CENTER);
	   	GridPane.setHalignment(fieldNewPassword, HPos.CENTER);
	   	GridPane.setHalignment(fieldNewPassword2, HPos.CENTER);

	   	mainGrid.add(labelPassword, 0, 0);
	   	mainGrid.add(fieldPassword, 1, 0);
	   	mainGrid.add(labelNewPassword, 0, 1);
	   	mainGrid.add(fieldNewPassword, 1, 1);
	   	mainGrid.add(labelNewPassword2, 0, 2);
	   	mainGrid.add(fieldNewPassword2, 1, 2);
	   	
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

 				String md5InputPassword = PasswordEncrypter.getInstance().getMd5EncryptedPassword(fieldPassword.getText());
 		    	if (md5InputPassword.equals(GabiParameters.getInstance().getGabiDataParameters().getPwd())) {
	 		        if (b == butonTypeOk) {
	 		        	return new PasswordData(PasswordEncrypter.getInstance().getMd5EncryptedPassword(fieldNewPassword.getText()));
	 		        } else {
	 		        	logger.log(Level.TRACE, "ChangePasswordDialog operation cancelled");
	 		        }
 		    	} else {
 		    		logger.log(Level.TRACE, "ChangePasswordDialog Bad password entered");
 		    	}

 		        return null;
 		    }
 	 	});
 	}
}
