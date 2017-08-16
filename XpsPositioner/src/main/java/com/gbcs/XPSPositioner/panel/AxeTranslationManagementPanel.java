package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 * AxeTranslationManagementPanel
 * @author Sébastien
 *
 */
public class AxeTranslationManagementPanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(AxeTranslationManagementPanel.class);
	
	/**
	 * AxeTranslationManagementPanel ctor
	 * @param text
	 */
	public AxeTranslationManagementPanel(String text) {
		
		// Buttons
 	 	Button buttonRelativeMovePlus = new Button("+");
 	 	buttonRelativeMovePlus.setOnAction(e->{

        });
 	 	
 	 	Button buttonRelativeMoveMine = new Button("-");
 	 	buttonRelativeMoveMine.setOnAction(e->{

        });
 	 	
 	 	Button buttonAbsoluteMovePlus = new Button("+");
 	 	buttonAbsoluteMovePlus.setOnAction(e->{

        });
 	 	
 	 	Button buttonAbsoluteMoveMine = new Button("-");
 	 	buttonAbsoluteMoveMine.setOnAction(e->{

        });
 	 	
 	 	Button buttonGo = new Button("Go");
 	 	buttonGo.setOnAction(e->{

        });
 	 	
 	 	// Labels
 	 	Label labelCurrentValue = new Label("Courant");
 	 	Label labelRelativeValue = new Label("Relatif");
 	 	Label labelAbsoluteValue = new Label("Absolu");
 	 	Label labelUnitCurrentValue = new Label("mm");
 	 	Label labelUnitRelativeValue = new Label("mm");
 	 	Label labelUnitAbsoluteValue = new Label("mm");
 	 	
 	 	// TextField
 	 	TextField textFieldCurrentValue = new TextField();
 	 	textFieldCurrentValue.setEditable(false);
 	 	
 	 	// ComboBox
 	 	ObservableList<Integer> moveValues = 
 	 		    FXCollections.observableArrayList(
 	 		        1,
 	 		        10,
 	 		        100
 	 		    		);
 	 	
 	 	ComboBox<Integer> comboRelativeValue = new ComboBox<Integer>(moveValues);
 	 	comboRelativeValue.setEditable(false);
 	 	comboRelativeValue.getSelectionModel().selectFirst();
 	 	comboRelativeValue.setVisibleRowCount(5);
 	 	
 	 	ComboBox<Integer> comboAbsoluteValue = new ComboBox<Integer>(moveValues);
 	 	comboAbsoluteValue.setEditable(false);
 	 	comboAbsoluteValue.getSelectionModel().selectFirst();
 	 	comboAbsoluteValue.setVisibleRowCount(5);
 	 	
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	// Distance foe separating components in the grid
	 	grid.setVgap(5);
	 	grid.setHgap(10);
	 	
	 	// Center all childs
	 	GridPane.setHalignment(labelCurrentValue, HPos.CENTER);
	 	GridPane.setHalignment(labelRelativeValue, HPos.CENTER);
		GridPane.setHalignment(labelAbsoluteValue, HPos.CENTER);
		GridPane.setHalignment(labelUnitRelativeValue, HPos.CENTER);
		GridPane.setHalignment(labelUnitAbsoluteValue, HPos.CENTER);
		GridPane.setHalignment(labelUnitCurrentValue, HPos.CENTER);
		GridPane.setHalignment(textFieldCurrentValue, HPos.CENTER);
		GridPane.setHalignment(comboRelativeValue, HPos.CENTER);
		GridPane.setHalignment(comboAbsoluteValue, HPos.CENTER);
		GridPane.setHalignment(buttonRelativeMoveMine, HPos.CENTER);
		GridPane.setHalignment(buttonRelativeMovePlus, HPos.CENTER);
		GridPane.setHalignment(buttonGo, HPos.CENTER);
	 	
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	grid.add(labelCurrentValue, 1, 0);
	 	grid.add(textFieldCurrentValue, 1, 1);
	 	grid.add(labelUnitCurrentValue, 2, 1);
	 	grid.add(labelRelativeValue, 1, 2);
	 	grid.add(buttonRelativeMoveMine, 0, 3);
	 	grid.add(comboRelativeValue, 1, 3);
	 	grid.add(labelUnitRelativeValue, 2, 3);
	 	grid.add(buttonRelativeMovePlus, 3, 3);
	 	grid.add(labelAbsoluteValue, 1, 4);
	 	grid.add(comboAbsoluteValue, 1, 5);
	 	grid.add(labelUnitAbsoluteValue, 2, 5);
	 	grid.add(buttonGo, 3, 5);

	 	setContent(grid);
	}
}
