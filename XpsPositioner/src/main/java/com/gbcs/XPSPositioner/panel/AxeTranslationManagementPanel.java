package com.gbcs.XPSPositioner.panel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.MoveAxe;
import com.gbcs.XPSPositioner.enumeration.MoveSign;

import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;

/**
 * AxeTranslationManagementPanel
 * @author Sébastien
 *
 */
public class AxeTranslationManagementPanel extends AbstractTranslationManagementPanel {

	// Logger
	static final Logger logger = LogManager.getLogger(AxeTranslationManagementPanel.class);

	private MoveAxe axe;

	/**
	 * AxeTranslationManagementPanel
	 * @param view
	 * @param a
	 */
	public AxeTranslationManagementPanel(GabiView view, MoveAxe a) {
		super(view);
		axe = a;
		
		setText(axe.name());
		updateCurrentValue();
	}

	/**
	 * relativeMovePlus
	 */
	@Override
	protected void relativeMoveMine() {
		relativeMove(MoveSign.MOVE_MINE);
		
		gabiView.getStatusBar().updateDisplay();
	}
	
	/**
	 * relativeMovePlus
	 */
	@Override
	protected void relativeMovePlus() {		        		
		relativeMove(MoveSign.MOVE_PLUS);
		
		gabiView.getStatusBar().updateDisplay();
	}
	
	/**
	 * relativeMove
	 * @param sign
	 */
	protected void relativeMove(MoveSign sign) {
		
		try {
			double relativeValue = Double.parseDouble(comboRelativeValue.getEditor().getText());
			gabiView.getMainGraphicalForm().doRelativeTableTranslation(axe, sign,relativeValue);		
						
			updateCurrentValue();
			
			if (comboRelativeValue.getItems().contains(relativeValue) == false) {
				comboRelativeValue.getItems().add(relativeValue);
			}
			
			logger.log(Level.INFO, "Relative translation " + axe + ": " + relativeValue);
		} catch (NumberFormatException ex) {
	        logger.error("Bad relative translation value. Translation operation cancelled");
	    } catch (NullPointerException ex) {
	    	logger.error("Bad relative translation value. Translation operation cancelled");
	    }
	}

	/**
	 * absoluteMove
	 */
	@Override
	protected void absoluteMove() {
				
		try {
			double value = Double.parseDouble(comboAbsoluteValue.getEditor().getText());
			gabiView.getMainGraphicalForm().doAbsoluteTableTranslation(axe, value);
			
			updateCurrentValue();
			
			if (comboAbsoluteValue.getItems().contains(value) == false) {
				comboAbsoluteValue.getItems().add(value);
			}
			
			logger.log(Level.INFO, "Absolute translation " + axe + ": " + value);
		} catch (NumberFormatException ex) {
	        logger.error("Bad absolute translation value. Translation operation cancelled");
	    } catch (NullPointerException ex) {
	    	logger.error("Bad absolute translation value. Translation operation cancelled");
	    }
	}
	
	/**
	 * updateCurrentValue
	 * @return 
	 */
	private void updateCurrentValue() {
		
		try {
			double value = 0;

			switch (axe) {
			case X1:
				value = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTx();
				break;
			case X2:
				value = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTx();
				break;
			case Y1:
				value = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTy();
				break;	
			case Y2:
				value = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTy();
				break;	
			}
			
			textFieldCurrentValue.setText(String.valueOf(value));
			
		} catch (NumberFormatException ex) {
	        logger.error("Bad current value calculated. Updating current value cancelled");
	    }
	}
}
