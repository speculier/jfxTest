package com.gbcs.XPSPositioner.tabs;

import java.util.Optional;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.SpeedData;
import com.gbcs.XPSPositioner.dialog.SpeedDialog;
import com.gbcs.XPSPositioner.enumeration.MoveAxe;
import com.gbcs.XPSPositioner.form.XForm;
import com.gbcs.XPSPositioner.panel.AxeTranslationManagementPanel;
import com.gbcs.XPSPositioner.panel.GabiView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;

/**
 * TablesTab
 * @author Sébastien
 *
 */
public class TablesTab extends Tab {
	
	// Logger
	private static final Logger logger = Logger.getLogger(TablesTab.class);
	
	private GabiView gabiView;

	/**
	 * TablesTab ctor
	 * @param controller
	 * @param text
	 */
	public TablesTab(GabiView view, String text) {
		
		gabiView = view;
		
		setClosable(false);
		setText(text);
		
		//
		// Buttons for managing axes
		//
   	 	Button buttonInitialisation = new Button("Initialisation");
   	 	buttonInitialisation.setOnAction(e-> initialization());
   	 	
   	 	Button buttonOrigine = new Button("Origine");
   	 	buttonOrigine.setOnAction(e-> origin());
   	 	
 	 	Button buttonEngineOff = new Button("Moteur Off");
 	 	buttonEngineOff.setOnAction(e-> engineOff());
   	 	
 	 	Button buttonVitesses = new Button("Vitesses");
 	 	buttonVitesses.setOnAction(e-> setSpeed());
 	 	
	 	Button buttonEmergencyStop = new Button("Arrêt d'urgence");
	 	buttonEmergencyStop.setOnAction(e-> emergency());
 	 	
 	 	ToolBar buttonToolBar = new ToolBar(buttonInitialisation, buttonOrigine, buttonEngineOff, buttonVitesses);
 	 	
 	 	//
 	 	// Axes panels
 	 	//	 	
 	 	AxeTranslationManagementPanel axesPanelX1 = new AxeTranslationManagementPanel(gabiView, MoveAxe.X1);
 	 	AxeTranslationManagementPanel axesPanelX2 = new AxeTranslationManagementPanel(gabiView, MoveAxe.X2);
 	 	AxeTranslationManagementPanel axesPanelY1 = new AxeTranslationManagementPanel(gabiView, MoveAxe.Y1);
 	 	AxeTranslationManagementPanel axesPanelY2 = new AxeTranslationManagementPanel(gabiView, MoveAxe.Y2);
	 	
	 	GridPane axesPanelsGrid = new GridPane();
	 	axesPanelsGrid.setVgap(20);
	 	axesPanelsGrid.setHgap(20);
	 	axesPanelsGrid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	axesPanelsGrid.add(axesPanelX1, 0, 0);
	 	axesPanelsGrid.add(axesPanelX2, 1, 0);
	 	axesPanelsGrid.add(axesPanelY1, 0, 1);
	 	axesPanelsGrid.add(axesPanelY2, 1, 1);
	 	
	 	// Main panel grid
	 	GridPane mainGrid = new GridPane();
	 	GridPane.setHalignment(buttonEmergencyStop, HPos.RIGHT);
	 	mainGrid.setVgap(20);
	 	mainGrid.setHgap(20);
	 	mainGrid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	mainGrid.add(buttonToolBar, 0, 0);
	 	mainGrid.add(axesPanelsGrid, 0, 1);
	 	mainGrid.add(buttonEmergencyStop, 0, 2);
   	 	
        // Add components in the tables tab
        setContent(mainGrid);
	}
	
	/**
	 * initialization
	 */
	private void initialization() {
		
	}
	
	/**
	 * origin
	 */
	private void origin() {
		gabiView.getMainGraphicalForm().getTranslationTable1Group().reset();
		gabiView.getMainGraphicalForm().getTranslationTable2Group().reset();
		gabiView.getMainGraphicalForm().getSphereM1Group().reset();
		gabiView.getMainGraphicalForm().getSphereM2Group().reset();
		gabiView.getMainGraphicalForm().getTelescopeGroup().reset();
	}
	
	/**
	 * engineOff
	 */
	private void engineOff() {
		
	}
	
	/**
	 * setSpeed
	 */
	private void setSpeed() {
 		SpeedDialog speedDialog = new SpeedDialog("Vitesses");

 		Optional<SpeedData> result = speedDialog.showAndWait();
 		if (result.isPresent()) {
 		   logger.log(Level.DEBUG, result.get().toString());
 		}
	}
	
	/**
	 * emergency
	 */
	private void emergency() {

	}
}
