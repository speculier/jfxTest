package com.gbcs.XPSPositioner.dialog;

import com.gbcs.XPSPositioner.panel.AboutPane;

import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

/**
 * AboutDialog
 * @author Sébastien
 *
 */
public class AboutDialog extends Dialog<Object> {
	
	/**
	 * AboutDialog ctor
	 * @param text
	 */
	public AboutDialog(String text) {

		setTitle(text);

 	 	// Set grid
 	 	getDialogPane().setContent(new AboutPane());
 	 	
 	 	// Set Ok button
 	 	getDialogPane().getButtonTypes().add(new ButtonType("OK", ButtonData.OK_DONE));
 	}
}
