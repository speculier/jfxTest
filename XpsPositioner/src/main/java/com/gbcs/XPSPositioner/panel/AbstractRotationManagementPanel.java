package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.MoveUnit;

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
 * AbstractRotationManagementPanel
 * @author Sébastien
 *
 */
public abstract class AbstractRotationManagementPanel extends AbstractMoveManagementPanel {
	
	protected MoveUnit unit;
	
	/**
	 * AbstractRotationManagementPanel ctor
	 * @param view
	 * @param text
	 */
	public AbstractRotationManagementPanel(GabiView view) {
		
		super(view);
		
		unit = MoveUnit.µRad;
 	 	
 	 	// Labels
 	 	labelUnitCurrentValue.setText(unit.toString());
 	 	labelUnitRelativeValue.setText(unit.toString());
 	 	labelUnitAbsoluteValue.setText(unit.toString());
	}
	
	/**
	 * relativeMovePlus
	 */
	//protected abstract void relativeMoveMine();
	
	/**
	 * relativeMovePlus
	 */
//	protected abstract void relativeMovePlus();
	
	/**
	 * absoluteMove
	 */
//	protected abstract void absoluteMove();
}
