package com.gbcs.XPSPositioner.panel;

import com.gbcs.XPSPositioner.enumeration.MoveUnit;

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
public abstract class AbstractTranslationManagementPanel extends AbstractMoveManagementPanel {
	
	protected MoveUnit unit;
	
	/**
	 * AbstractTranslationManagementPanel ctor
	 * @param view
	 */
	public AbstractTranslationManagementPanel(GabiView view) {
		super(view);
		
		unit = MoveUnit.mm;
 	 	
 	 	// Labels
 	 	labelUnitCurrentValue.setText(unit.toString());
 	 	labelUnitRelativeValue.setText(unit.toString());
 	 	labelUnitAbsoluteValue.setText(unit.toString());
 	 }
}
