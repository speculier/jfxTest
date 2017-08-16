package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.DoubleRangeStringConverter;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 * XyPointPane
 * @author S�bastien
 *
 */
public class XyPointPane extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(XyPointPane.class);
	
	private TextField textFieldX = new TextField();
	private TextField textFieldY = new TextField();
	
	/**
	 * XyPointPane ctor
	 * @param text
	 */
	public XyPointPane(String text) {
		
 	 	// Labels
 	 	Label labelX = new Label("X");
 	 	Label labelY = new Label("Y");
 	 	
 	 	// TextFields
 	 	textFieldX.setEditable(true);
 	 	textFieldY.setEditable(true);
 	 	//textFieldX.setTextFormatter(new TextFormatter<>(new DoubleRangeStringConverter(0.0D, 100.0D)));
 
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
	
	/**
	 * getX
	 * @return double
	 */
	public double getX() {
		return Double.parseDouble(textFieldX.getText());
	}
	
	/**
	 * getY
	 * @return double
	 */
	public double getY() {
		return Double.parseDouble(textFieldY.getText());
	}
}
