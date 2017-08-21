package com.gbcs.XPSPositioner.dialog;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.SpeedData;
import com.gbcs.XPSPositioner.panel.XyPointPanel;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * SpeedDialog
 * @author Sebastien
 *
 */
public class SpeedDialog extends Dialog<SpeedData> {

	// Logger
	private static final Logger logger = Logger.getLogger(SpeedDialog.class);
	
	private XyPointPanel pointPaneM1 = new XyPointPanel ("M1");
	private XyPointPanel pointPaneM2 = new XyPointPanel ("M2");
   	 	
	/**
	 * SpeedDialog ctor
	 * @param text
	 */
	public SpeedDialog(String text) {

		setTitle(text);
		
		// Button
   	 	Button buttonCurrentSpeeds = new Button("Vitesses courantes");
   	 	buttonCurrentSpeeds.setOnAction(e->{
   	 		logger.log(Level.TRACE, "Vitesses courantes");
        });
   	 	
   	 	// Grid
   	 	GridPane mainGrid = new GridPane();
   	 	mainGrid.setPadding(new Insets(5, 5, 5, 5));
   	 	
   	 	GridPane.setHalignment(pointPaneM1, HPos.CENTER);  
	   	GridPane.setHalignment(pointPaneM2, HPos.CENTER);
	   	GridPane.setHalignment(buttonCurrentSpeeds, HPos.CENTER);
	   	
	   	mainGrid.add(pointPaneM1, 0, 0);
	   	mainGrid.add(pointPaneM2, 0, 1);
	   	mainGrid.add(buttonCurrentSpeeds, 0, 2);
	   	
	   	getDialogPane().setContent(mainGrid);

 	 	// Set Ok button
	   	final ButtonType butonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
	   	ButtonType butonTypeCancelClose = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
 	 	getDialogPane().getButtonTypes().add(butonTypeOk);
 	 	getDialogPane().getButtonTypes().add(butonTypeCancelClose);
 	 	
 	 	// Convert result to DAO
 	 	setResultConverter(new Callback<ButtonType, SpeedData>() {
 	 		
 		    @Override
 		    public SpeedData call(ButtonType b) {

 		        if (b == butonTypeOk) {
 		        	try {
 		        		return new SpeedData(pointPaneM1.getX(), pointPaneM1.getY(), pointPaneM2.getX(), pointPaneM2.getY());
 		        	} catch (NumberFormatException ex) {
 		        		logger.log(Level.ERROR, "Bad target M1 or M2 x,y values. SpeedDialog cancelled");
 		        	}
 		        } else {
 		        	logger.log(Level.TRACE, "SpeedDialog cancelled");
 		        }

 		        return null;
 		    }
 	 	});
 	}
}
