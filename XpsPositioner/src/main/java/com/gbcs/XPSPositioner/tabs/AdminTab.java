package com.gbcs.XPSPositioner.tabs;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.components.XpsAngleSpinner;
import com.gbcs.XPSPositioner.panel.GabiView;
import com.gbcs.XPSPositioner.util.Constants;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.ToolBar;

/**
 * AdminTab
 * @author Sébastien
 *
 */
public class AdminTab extends Tab {
	
	// Logger
	private static final Logger logger = Logger.getLogger(AdminTab.class);
	
	private GabiView gabiView;
	
    private CheckBox checkBoxDisplayAxes;
    private XpsAngleSpinner spinnerCurrentXAngle;
    private XpsAngleSpinner spinnerCurrentYAngle;
    
	/**
	 * AdminTab ctor
	 * @param view
	 * @param text
	 */
	public AdminTab(GabiView view, String text) {
		
		gabiView = view;
		setClosable(false);
		setText(text);
		
		 Button buttonInitialPosition = new Button("Initial Position");
    	 buttonInitialPosition.setOnAction(e->{
    		 
         	// Home zoom/rotation/distance to camera
    		gabiView.getMainGraphicalForm().setCurrentSceneOrientation(true, Constants.CAMERA_INITIAL_X_ANGLE, Constants.CAMERA_INITIAL_Y_ANGLE, Constants.CAMERA_INITIAL_DISTANCE);
         	
         	// Reset spinners to default values
         	spinnerCurrentXAngle.setDefaultValueFactory();
         	spinnerCurrentYAngle.setDefaultValueFactory();
         });
         
         // Display axis or not
         checkBoxDisplayAxes = new CheckBox("Display/hide axes");
         checkBoxDisplayAxes.setSelected(true);
         checkBoxDisplayAxes.setOnAction(e->{
        	 gabiView.getMainGraphicalForm().getAxisGroup().setVisible(checkBoxDisplayAxes.isSelected());
         });
         
         // Spinners for the current X & Y angle values
         spinnerCurrentXAngle = new XpsAngleSpinner(Constants.CAMERA_INITIAL_X_ANGLE);
         spinnerCurrentYAngle = new XpsAngleSpinner(Constants.CAMERA_INITIAL_Y_ANGLE);
         
         spinnerCurrentXAngle.valueProperty().addListener(new ChangeListener<Double>() {
 			@Override
 			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
 				gabiView.getMainGraphicalForm().setCurrentSceneOrientation(false, Double.valueOf(spinnerCurrentXAngle.getValue().toString()), 
 						Double.valueOf(spinnerCurrentYAngle.getValue().toString()),
 						gabiView.getMainGraphicalForm().getPerspectiveCamera().getTranslateZ());
 			}
 		 });
         
         spinnerCurrentYAngle.valueProperty().addListener(new ChangeListener<Double>() {
  			@Override
  			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
  				gabiView.getMainGraphicalForm().setCurrentSceneOrientation(false, Double.valueOf(spinnerCurrentXAngle.getValue().toString()), 
 						Double.valueOf(spinnerCurrentYAngle.getValue().toString()),
 						gabiView.getMainGraphicalForm().getPerspectiveCamera().getTranslateZ());
  			}
  		 });
         
         Label labelXAngle = new Label("X angle");
         Label labelYAngle = new Label("Y angle");

         ToolBar toolBar = new ToolBar(checkBoxDisplayAxes, buttonInitialPosition, labelXAngle, spinnerCurrentXAngle, labelYAngle, spinnerCurrentYAngle);
         toolBar.setOrientation(Orientation.HORIZONTAL);
         
         // Add components in the tables tab
         setContent(toolBar);
	}
	
    /**
     * setXAngleSpinnerValue
     * @param angle
     */
    public void setXAngleSpinnerValue(double angle) {
    	spinnerCurrentXAngle.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 360, angle));
    }
    
    /**
     * setYAngleSpinnerValue
     * @param angle
     */
    public void setYAngleSpinnerValue(double angle) {
    	spinnerCurrentYAngle.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 360, angle));
    }
}
