package com.gbcs.XPSPositioner.panel;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.MoveSign;
import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

/**
 * AxeRotationManagementPanel
 * @author Sébastien
 *
 */
public class AxeRotationManagementPanel extends AbstractRotationManagementPanel {

	// Logger
	private static final Logger logger = Logger.getLogger(AxeRotationManagementPanel.class);
	
	private MoveTypeOnAxe typeOnAxe;
	
	/**
	 * AxeRotationManagementPanel ctor
	 * @param view
	 * @param text
	 */
	public AxeRotationManagementPanel(GabiView view, MoveTypeOnAxe a) {
		
		super(view);
		typeOnAxe = a;
		
		setText(typeOnAxe.name());
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
			double initialvalue  = 0;
			double relativeValue  = Double.parseDouble(comboRelativeValue.getSelectionModel().getSelectedItem().toString());

			switch (typeOnAxe) {
				case RX:
					initialvalue = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTranslateX();
					gabiView.getMainGraphicalForm().getTranslationTable1Group().setTranslateX((sign == MoveSign.MOVE_MINE) ? (initialvalue - relativeValue) : (initialvalue + relativeValue));
					break;
				case RY:
					initialvalue = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTranslateX();
					gabiView.getMainGraphicalForm().getTranslationTable2Group().setTranslateX((sign == MoveSign.MOVE_MINE) ? (initialvalue - relativeValue) : (initialvalue + relativeValue));
					break;
			}
			
			updateCurrentValue();
			
			comboRelativeValue.getItems().add(relativeValue);
			
			logger.log(Level.INFO, "Relative move " + typeOnAxe + ": " + Double.parseDouble(comboRelativeValue.getSelectionModel().getSelectedItem().toString()));
		} catch (NumberFormatException ex) {
	        logger.error("Bad relative rotation value. Rotation operation cancelled");
	    } catch (NullPointerException ex) {
	    	logger.error("Bad relative rotation value. Rotation operation cancelled");
	    }
	}
		
	/**
	 * absoluteMove
	 */
	@Override
	protected void absoluteMove() {
		try {
			double value  = Double.parseDouble(comboAbsoluteValue.getSelectionModel().getSelectedItem().toString());
			
			switch (typeOnAxe) {
				case RX:
					gabiView.getMainGraphicalForm().getTranslationTable1Group().setTranslateX(value);
					break;
				case RY:
					gabiView.getMainGraphicalForm().getTranslationTable2Group().setTranslateX(value);
					break;				
			}
			
			updateCurrentValue();
			
			comboAbsoluteValue.getItems().add(value);
			
			logger.log(Level.INFO, "Absolute rotation " + typeOnAxe + ": " + Double.parseDouble(comboAbsoluteValue.getSelectionModel().getSelectedItem().toString()));
		} catch (NumberFormatException ex) {
	        logger.error("Bad absolute rotation value. Rotation operation cancelled");
	    } catch (NullPointerException ex) {
	    	logger.error("Bad absolute rotation value. Rotation operation cancelled");
	    }
	}
	
	/**
	 * updateCurrentValue
	 * @return 
	 */
	private void updateCurrentValue() {
		
		try {
			double value  = 0;

			switch (typeOnAxe) {
			case RX:
				value = gabiView.getMainGraphicalForm().getTranslationTable1Group().getTranslateX();
				break;
			case RY:
				value = gabiView.getMainGraphicalForm().getTranslationTable2Group().getTranslateX();
				break;
			}
			
			textFieldCurrentValue.setText(String.valueOf(value));
			
		} catch (NumberFormatException ex) {
	        logger.error("Bad current value calculated. Updating current value cancelled");
	    }
	}
}
