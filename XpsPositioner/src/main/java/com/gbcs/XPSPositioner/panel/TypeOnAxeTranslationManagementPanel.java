package com.gbcs.XPSPositioner.panel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.MoveAxe;
import com.gbcs.XPSPositioner.enumeration.MoveSign;
import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

/**
 * TypeOnAxeTranslationManagementPanel
 * @author Sébastien
 *
 */
public class TypeOnAxeTranslationManagementPanel extends AbstractTranslationManagementPanel {

	// Logger
	static final Logger logger = LogManager.getLogger(TypeOnAxeTranslationManagementPanel.class);

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
		updateCurrentValue();
	}

	/**
	 * relativeMovePlus
	 */
	@Override
	protected void relativeMovePlus() {
		relativeMove(MoveSign.MOVE_PLUS);
	}
	
	/**
	 * relativeMoveMine
	 */
	@Override
	protected void relativeMoveMine() {
		relativeMove(MoveSign.MOVE_MINE);
	}
	
	/**
	 * relativeMove
	 * @param sign
	 */
	protected void relativeMove(MoveSign sign) {
		
		try {
			double initialvalueT1 = 0;
			double initialvalueT2 = 0;
			double relativeValue = Double.parseDouble(comboRelativeValue.getEditor().getText());
			
			switch (typeOnAxe) {
			case TX:
				initialvalueT1 = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTx();
				initialvalueT2 = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTx();
				gabiView.getMainGraphicalForm().getTranslationTable1Group().setTx((sign == MoveSign.MOVE_MINE) ? (initialvalueT1 - relativeValue) : (initialvalueT1 + relativeValue));
				gabiView.getMainGraphicalForm().getTranslationTable2Group().setTx((sign == MoveSign.MOVE_MINE) ? (initialvalueT2 - relativeValue) : (initialvalueT2 + relativeValue));
				break;
			case TY:
				initialvalueT1 = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTy();
				initialvalueT2 = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTy();
				gabiView.getMainGraphicalForm().getTranslationTable1Group().setTy((sign == MoveSign.MOVE_MINE) ? (initialvalueT1 - relativeValue) : (initialvalueT1 + relativeValue));
				gabiView.getMainGraphicalForm().getTranslationTable2Group().setTy((sign == MoveSign.MOVE_MINE) ? (initialvalueT2 - relativeValue) : (initialvalueT2 + relativeValue));
				break;
			case RX:
				//initialvalue = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTy();
				//gabiView.getMainGraphicalForm().getTranslationTable1Group().setTy((sign == MoveSign.MOVE_MINE) ? (initialvalue - relativeValue) : (initialvalue + relativeValue));
				break;	
			case RY:
				//initialvalue = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTy();
				//gabiView.getMainGraphicalForm().getTranslationTable2Group().setTy((sign == MoveSign.MOVE_MINE) ? (initialvalue - relativeValue) : (initialvalue + relativeValue));
				break;	
			}
			
			updateCurrentValue();
			
			// comboRelativeValue.getItems().add(relativeValue);
			
			logger.log(Level.INFO, "Relative translation " + typeOnAxe + ": " + relativeValue);
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
			
			switch (typeOnAxe) {
				case TX:
					gabiView.getMainGraphicalForm().getTranslationTable1Group().setTx(value);
					gabiView.getMainGraphicalForm().getTranslationTable2Group().setTx(value);
					break;
				case TY:
					gabiView.getMainGraphicalForm().getTranslationTable1Group().setTy(value);
					gabiView.getMainGraphicalForm().getTranslationTable2Group().setTy(value);
					break;
				case RX:
					//gabiView.getMainGraphicalForm().getTranslationTable1Group().setTy(value);
					break;	
				case RY:
					//gabiView.getMainGraphicalForm().getTranslationTable2Group().setTy(value);
					break;					
			}
			
			updateCurrentValue();
			
			// comboAbsoluteValue.getItems().add(value);
			
			logger.log(Level.INFO, "Absolute translation " + typeOnAxe + ": " + value);
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

			switch (typeOnAxe) {
			case TX:
				value = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTx();
				value = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTx();
				break;
			case TY:
				value = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTy();
				value = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTy();
				break;
			case RX:
				//value = gabiView.getMainGraphicalForm().getTranslationTablesGroup().getTy();
				break;	
			case RY:
				//value = gabiView.getMainGraphicalForm().getTranslationTablesGroup().getTy();
				break;	
			}
			
			textFieldCurrentValue.setText(String.valueOf(value));
			
		} catch (NumberFormatException ex) {
	        logger.error("Bad current value calculated. Updating current value cancelled");
	    }
	}
}
