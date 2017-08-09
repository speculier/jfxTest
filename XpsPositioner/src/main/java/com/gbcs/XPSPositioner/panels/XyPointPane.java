package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 * XyPointPane
 * @author Sébastien
 *
 */
public class XyPointPane extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(XyPointPane.class);
	
	/**
	 * XyPointPane ctor
	 * @param text
	 */
	public XyPointPane(String text) {
		
 	 	// Labels
 	 	Label labelX = new Label("X");
 	 	Label labelY = new Label("Y");
 	 	
 	 	// TextFields
 	 	TextField textFieldX = new TextField();
 	 	textFieldX.setEditable(true);
 	 	
 	 	TextField textFieldY = new TextField();
 	 	textFieldY.setEditable(true);
 	 	
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	 	
	 	GridPane.setHalignment(labelX, HPos.LEFT);
	 	GridPane.setHalignment(textFieldX, HPos.LEFT);
	 	GridPane.setHalignment(labelY, HPos.LEFT);
		GridPane.setHalignment(textFieldY, HPos.LEFT);
		
		grid.add(labelX, 0, 0);
	 	grid.add(textFieldX, 1, 0);
	 	grid.add(labelY, 2, 0);
		grid.add(textFieldY, 3, 0);
		
	 	setContent(grid);
	}
}
