package com.gbcs.XPSPositioner.dialog;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.AbsoluteTablePositionData;
import com.gbcs.XPSPositioner.panel.XyPointPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * MovePositionDialog
 * @author Sebastien
 *
 */
public class MovePositionDialog extends Dialog<AbsoluteTablePositionData> {

	// Logger
	private static final Logger logger = Logger.getLogger(MovePositionDialog.class);
	
	// Position panels
	private XyPointPane pointPaneM1;
	private XyPointPane pointPaneM2;
	 	
	/**
	 * MovePositionDialog ctor
	 * @param text
	 * @param parent
	 */
	public MovePositionDialog(String text) {

		setTitle(text);
		
		// Buttons
		
   	 	Button buttonCurrentPosition = new Button("Position courante");
   	 	buttonCurrentPosition.setOnAction(e->{

        });
   	 	  	 	
   	 	// Position panels
   	 	pointPaneM1 = new XyPointPane ("M1");
   	 	pointPaneM2 = new XyPointPane ("M2");
   	 	
   	 	// Grid
   	 	GridPane grid = new GridPane();
   	 	grid.setPadding(new Insets(5, 5, 5, 5));

	   	GridPane.setHalignment(pointPaneM1, HPos.CENTER);  
	   	GridPane.setHalignment(pointPaneM2, HPos.CENTER);
	   	GridPane.setHalignment(buttonCurrentPosition, HPos.CENTER);
	   	
	   	grid.add(pointPaneM1, 0, 0);
	   	grid.add(pointPaneM2, 0, 1);
	   	grid.add(buttonCurrentPosition, 0, 2);

	   	getDialogPane().setContent(grid);

 	 	// Set Ok button
	   	final ButtonType butonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
	   	ButtonType butonTypeCancelClose = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
 	 	getDialogPane().getButtonTypes().add(butonTypeOk);
 	 	getDialogPane().getButtonTypes().add(butonTypeCancelClose);
 	 	
 	 	// Convert result to DAO
 	 	setResultConverter(new Callback<ButtonType, AbsoluteTablePositionData>() {
 	 		
 	 		    @Override
 	 		    public AbsoluteTablePositionData call(ButtonType b) {

 	 		        if (b == butonTypeOk) {
 	 		            return new AbsoluteTablePositionData(pointPaneM1.getX(), pointPaneM2.getX(), pointPaneM1.getY(), pointPaneM2.getY());
 	 		        }

 	 		        return null;
 	 		    }
 	 	});
 	}
}
