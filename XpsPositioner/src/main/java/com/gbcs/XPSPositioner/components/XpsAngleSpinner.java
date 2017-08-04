package com.gbcs.XPSPositioner.components;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.panels.AxeRotationManagementPanel;

import javafx.collections.ObservableList;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * XpsAngleSpinner
 * @author Sébastien
 *
 */
public class XpsAngleSpinner extends Spinner {

	// Logger
	private static final Logger logger = Logger.getLogger(XpsAngleSpinner.class);
	
	private SpinnerValueFactory<Double> spinnerValue;

	/**
	 * XpsAngleSpinner ctor
	 * @param arg0
	 */
	public XpsAngleSpinner(double intialValue) {
		spinnerValue = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 360, intialValue);
		setValueFactory(spinnerValue);
		customizeSpinner();
	}

	/**
	 * customizeSpinner
	 */
	private void customizeSpinner() {
        setEditable(true);
        getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
	}
	
	/**
	 * setDefaultValueFactory
	 */
	public void setDefaultValueFactory() {
		setValueFactory(spinnerValue);
	}
}
