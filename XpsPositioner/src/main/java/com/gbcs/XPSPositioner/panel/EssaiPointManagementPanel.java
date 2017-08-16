package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 * EssaiPointManagementPanel
 * @author Sébastien
 *
 */
public class EssaiPointManagementPanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(EssaiPointManagementPanel.class);
	
	/**
	 * EssaiPointManagementPanel ctor
	 * @param text
	 */
	public EssaiPointManagementPanel(String text) {
		
		// Buttons
 	 	Button buttonPlace = new Button("Place");
 	 	buttonPlace.setOnAction(e->{

        });
 	 	
 	 	Button buttonVise = new Button("Vise");
 	 	buttonVise.setOnAction(e->{

        });
 	 	
 	 	// Labels
 	 	Label labelX = new Label("X");
 	 	Label labelY = new Label("Y");
 	 	Label labelZ = new Label("Z");
 	 	Label labelUnitX = new Label("mm");
 	 	Label labelUnitY = new Label("mm");
 	 	Label labelUnitZ = new Label("mm");
 	 	
 	 	// Combobox
 	 	ObservableList<String> moveValues = 
 	 		    FXCollections.observableArrayList(
 	 		        "1",
 	 		        "10",
 	 		        "100"
 	 		    );
 	 	
 	 	ComboBox<String> comboX = new ComboBox<String>(moveValues);
 	 	comboX.setEditable(false);
 	 	comboX.getSelectionModel().selectFirst();
 	 	comboX.setVisibleRowCount(5);
 	 	
 	 	ComboBox<String> comboY = new ComboBox<String>(moveValues);
 	 	comboY.setEditable(false);
 	 	comboY.getSelectionModel().selectFirst();
 	 	comboY.setVisibleRowCount(5);
 	 	
 	 	ComboBox<String> comboZ = new ComboBox<String>(moveValues);
 	 	comboZ.setEditable(false);
 	 	comboZ.getSelectionModel().selectFirst();
 	 	comboZ.setVisibleRowCount(5);
 	 	
 	 	// Groupbox alignment
 	 	TypeOfAlignmentPanel alignmentPanel = new TypeOfAlignmentPanel("Type d'alignement");
 	 	
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid1 = new GridPane();	
	 	grid1.setVgap(5);
	 	grid1.setHgap(10);
	 	grid1.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	GridPane.setHalignment(labelX, HPos.CENTER);
	 	GridPane.setHalignment(labelY, HPos.CENTER);
	 	GridPane.setHalignment(labelZ, HPos.CENTER);
	 	GridPane.setHalignment(labelUnitX, HPos.CENTER);
	 	GridPane.setHalignment(labelUnitY, HPos.CENTER);
	 	GridPane.setHalignment(labelUnitZ, HPos.CENTER);
	 	GridPane.setHalignment(comboX, HPos.CENTER);
	 	GridPane.setHalignment(comboY, HPos.CENTER);
	 	GridPane.setHalignment(comboZ, HPos.CENTER);
	 	
		grid1.add(labelX, 0, 0);
		grid1.add(labelY, 0, 1);
		grid1.add(labelZ, 0, 2);
		grid1.add(comboX, 1, 0);
		grid1.add(comboY, 1, 1);
		grid1.add(comboZ, 1, 2);
		grid1.add(labelUnitX, 2, 0);
		grid1.add(labelUnitY, 2, 1);
		grid1.add(labelUnitZ, 2, 2);
	 	
		GridPane grid2 = new GridPane();
	 	
	 	// Distance foe separating components in the grid
		grid2.setVgap(5);
		grid2.setHgap(10);
	 	grid2.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	GridPane.setHalignment(alignmentPanel, HPos.RIGHT);
		
	 	grid2.add(alignmentPanel, 0, 0);
		
	 	GridPane mainGrid = new GridPane();
	 	mainGrid.setVgap(20);
	 	mainGrid.setHgap(20);
		mainGrid.setPadding(new Insets(5, 5, 5, 5));
		
		GridPane.setHalignment(grid1, HPos.CENTER);
		GridPane.setHalignment(grid2, HPos.CENTER);
		GridPane.setHalignment(buttonPlace, HPos.CENTER);
		GridPane.setHalignment(buttonVise, HPos.CENTER);
		
		mainGrid.add(grid1, 0, 0);
		mainGrid.add(grid2, 1, 0);
		mainGrid.add(buttonPlace, 0, 1);
		mainGrid.add(buttonVise, 1, 1);
		
	 	setContent(mainGrid);
	}
}
