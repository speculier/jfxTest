package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
	static final Logger logger = Logger.getLogger(AxeTranslationManagementPanel.class);

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
	}
	
	/**
	 * relativeMovePlus
	 */
	@Override
	protected void relativeMovePlus() {		        		
		relativeMove(MoveSign.MOVE_PLUS);
	}
	
	/**
	 * relativeMove
	 * @param sign
	 */
	protected void relativeMove(MoveSign sign) {
		
		try {
			double initialvalue = 0;
			double relativeValue = Double.parseDouble(comboRelativeValue.getEditor().getText());
			
			switch (axe) {
			case X1:
				initialvalue = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTx();
				gabiView.getMainGraphicalForm().getTranslationTable1Group().setTx((sign == MoveSign.MOVE_MINE) ? (initialvalue - relativeValue) : (initialvalue + relativeValue));
				break;
			case X2:
				initialvalue = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTx();
				gabiView.getMainGraphicalForm().getTranslationTable2Group().setTx((sign == MoveSign.MOVE_MINE) ? (initialvalue - relativeValue) : (initialvalue + relativeValue));
				break;
			case Y1:
				initialvalue = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTy();
				gabiView.getMainGraphicalForm().getTranslationTable1Group().setTy((sign == MoveSign.MOVE_MINE) ? (initialvalue - relativeValue) : (initialvalue + relativeValue));
				break;	
			case Y2:
				initialvalue = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTy();
				gabiView.getMainGraphicalForm().getTranslationTable2Group().setTy((sign == MoveSign.MOVE_MINE) ? (initialvalue - relativeValue) : (initialvalue + relativeValue));
				break;	
			}
			
			updateCurrentValue();
			
			// comboRelativeValue.getItems().add(relativeValue);
			
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
			
			switch (axe) {
				case X1:
					gabiView.getMainGraphicalForm().getTranslationTable1Group().setTx(value);
					break;
				case X2:
					gabiView.getMainGraphicalForm().getTranslationTable2Group().setTx(value);
					break;
				case Y1:
					gabiView.getMainGraphicalForm().getTranslationTable1Group().setTy(value);
					break;	
				case Y2:
					gabiView.getMainGraphicalForm().getTranslationTable2Group().setTy(value);
					break;					
			}
			
			updateCurrentValue();
			
			// comboAbsoluteValue.getItems().add(value);
			
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
