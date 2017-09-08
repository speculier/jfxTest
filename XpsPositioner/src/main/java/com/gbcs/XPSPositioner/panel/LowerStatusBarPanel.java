package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * StatusBarPanel
 * @author Sébastien
 *
 */
public class LowerStatusBarPanel extends Pane {

	// Logger
	private static final Logger logger = Logger.getLogger(LowerStatusBarPanel.class);
	
	private Label x1Position  = new Label();
	private Label x2Position = new Label();
	private Label y1Position = new Label();
	private Label y2Position = new Label();
	private Label status = new Label();
	private Label errorMessage = new Label();
	private Label mode = new Label();
	
	private GabiView mainGabiView;
	
	/**
	 * LowerStatusBarPanel ctor
	 */
	public LowerStatusBarPanel(GabiView v) {
 	 	
		mainGabiView = v;
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(5);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	GridPane.setHalignment(x1Position, HPos.LEFT);
	 	GridPane.setHalignment(x2Position, HPos.LEFT);
	 	GridPane.setHalignment(y1Position, HPos.LEFT);
	 	GridPane.setHalignment(y2Position, HPos.LEFT);
	 	GridPane.setHalignment(status, HPos.LEFT);
	 	GridPane.setHalignment(errorMessage, HPos.LEFT);
	 	GridPane.setHalignment(mode, HPos.LEFT);
		
	 	grid.add(x1Position, 0, 0);
	 	grid.add(x2Position, 1, 0);
	 	grid.add(y1Position, 2, 0);
	 	grid.add(y2Position, 3, 0);
	 	grid.add(status, 4, 0);
	 	grid.add(errorMessage, 5, 0);
	 	grid.add(mode, 6, 0);
	 	
	 	getChildren().add(grid);
	 	
	 	// Update
	 	updateDisplay();
	}
	
	/**
	 * updateDisplay
	 */
	public void updateDisplay() {
		
		//System.out.println(mainGabiView.getMainGraphicalForm().getM1AxisGroup().getTx());
		//System.out.println(mainGabiView.getMainGraphicalForm().getM1AxisGroup().getTranslateX());
		
		System.out.println(mainGabiView.getMainGraphicalForm().getM1ReferencePoint().translateXProperty());
		System.out.println(mainGabiView.getMainGraphicalForm().getM1ReferencePoint().translateYProperty());
		//System.out.println(mainGabiView.getMainGraphicalForm().getM1ReferencePoint().getLayout());
		
		x1Position.setText("X1 = " + mainGabiView.getMainGraphicalForm().getM1ReferencePoint().getX());		
		x2Position.setText("X2 = " + mainGabiView.getMainGraphicalForm().getM2ReferencePoint().getX());
		y1Position.setText("Y1 = " + mainGabiView.getMainGraphicalForm().getM1ReferencePoint().getTy());
		y2Position.setText("Y2 = " + mainGabiView.getMainGraphicalForm().getM2ReferencePoint().getTranslateY());
	}
}
