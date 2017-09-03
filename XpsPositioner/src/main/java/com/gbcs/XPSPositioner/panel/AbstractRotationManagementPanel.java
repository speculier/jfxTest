package com.gbcs.XPSPositioner.panel;

import com.gbcs.XPSPositioner.enumeration.MoveUnit;

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
