package com.gbcs.XPSPositioner.controls;

import javafx.collections.ObservableList;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * AngleSpinner
 * @author sp01515
 *
 */
public class XpsAngleSpinner extends Spinner {

	private SpinnerValueFactory<Double> spinnerValue;

	/**
	 * 
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
