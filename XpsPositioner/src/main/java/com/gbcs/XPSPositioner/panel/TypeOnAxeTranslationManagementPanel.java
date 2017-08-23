package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.MoveAxe;
import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

/**
 * TypeOnAxeTranslationManagementPanel
 * @author Sébastien
 *
 */
public class TypeOnAxeTranslationManagementPanel extends AbstractTranslationManagementPanel {

	// Logger
	static final Logger logger = Logger.getLogger(TypeOnAxeTranslationManagementPanel.class);

	private MoveTypeOnAxe typeOnAxe;
	
	/**
	 * TypeOnAxeTranslationManagementPanel
	 * @param view
	 * @param a
	 */
	public TypeOnAxeTranslationManagementPanel(GabiView view, MoveTypeOnAxe a) {
		super(view);
		typeOnAxe = a;
 	 	
		setText(a.name());
	}

	/**
	 * relativeMovePlus
	 */
	@Override
	protected void relativeMovePlus() {
		
	}
	
	/**
	 * relativeMoveMine
	 */
	@Override
	protected void relativeMoveMine() {

	}
	
	/**
	 * absoluteMove
	 */
	@Override
	protected void absoluteMove() {

	}
}
