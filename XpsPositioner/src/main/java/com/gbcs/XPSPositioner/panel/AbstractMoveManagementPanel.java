package com.gbcs.XPSPositioner.panel;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 * AbstractTranslationManagementPanel
 * @author Sébastien
 *
 */
public abstract class AbstractMoveManagementPanel extends TitledPane {
	
	protected GabiView gabiView;
	
	protected ComboBox<Double> comboRelativeValue = new ComboBox<Double>();
	protected ComboBox<Double> comboAbsoluteValue = new ComboBox<Double>();
	protected TextField textFieldCurrentValue = new TextField();
	protected Label labelUnitCurrentValue = new Label();
	protected Label labelUnitRelativeValue = new Label();
	protected Label labelUnitAbsoluteValue = new Label();
	 	
	/**
	 * AbstractTranslationManagementPanel ctor
	 * @param view
	 */
	public AbstractMoveManagementPanel(GabiView view) {
		
		gabiView = view;
 	 	
		// Buttons
		Button buttonRelativeMovePlus = new Button("+");
 	 	buttonRelativeMovePlus.setOnAction(e-> relativeMovePlus());

		Button buttonRelativeMoveMine = new Button("-");
	 	buttonRelativeMoveMine.setOnAction(e-> relativeMoveMine());

		Button buttonAbsolute = new Button("Go");
 	 	buttonAbsolute.setOnAction(e-> absoluteMove());
 	 	
 	 	// Labels
 	 	Label labelCurrentValue = new Label("Courant");
 	 	Label labelRelativeValue = new Label("Relatif");
 	 	Label labelAbsoluteValue = new Label("Absolu");
 	 	
 	 	// TextField
 	 	textFieldCurrentValue.setEditable(false);
 	 	
 	 	// ComboBox	 	
	 	comboRelativeValue.setEditable(true);
 	 	comboRelativeValue.setVisibleRowCount(5);
 	 	
 	 	comboAbsoluteValue.setEditable(true);
 	 	comboAbsoluteValue.setVisibleRowCount(5);
 	 	
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	
	 	// Distance for separating components in the grid
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
		GridPane.setHalignment(buttonAbsolute, HPos.CENTER);
	 	
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
	 	grid.add(buttonAbsolute, 3, 5);

	 	setContent(grid);
	}
	
	/**
	 * relativeMovePlus
	 */
	protected abstract void relativeMoveMine();
	
	/**
	 * relativeMovePlus
	 */
	protected abstract void relativeMovePlus();
	
	/**
	 * absoluteMove
	 */
	protected abstract void absoluteMove();
}
