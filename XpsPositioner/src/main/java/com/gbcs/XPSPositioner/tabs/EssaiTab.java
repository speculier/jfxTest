package com.gbcs.XPSPositioner.tabs;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.GabiController;
import com.gbcs.XPSPositioner.panels.AxeRotationManagementPanel;
import com.gbcs.XPSPositioner.panels.AxeTranslationManagementPanel;
import com.gbcs.XPSPositioner.panels.EssaiPointManagementPanel;
import com.gbcs.XPSPositioner.panels.GabiView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

/**
 * EssaiTab
 * @author Sébastien
 *
 */
public class EssaiTab extends Tab {
	
	// Logger
	private static final Logger logger = Logger.getLogger(EssaiTab.class);
	
	private GabiView gabiView;
	
	/**
	 * EssaiTab ctor
	 * @param view
	 * @param text
	 */
	public EssaiTab(GabiView view, String text) {
		
		gabiView = view;
		setClosable(false);
		setText(text);
   	 	
		// Buttons
	 	Button buttonEmergencyStop = new Button("Arrêt d'urgence");
	 	buttonEmergencyStop.setOnAction(e->{

        });
	 	
 	 	//
 	 	// Axes panels
 	 	//	 	
 	 	AxeTranslationManagementPanel axesPanelX1 = new AxeTranslationManagementPanel("TX");
	 	AxeRotationManagementPanel axesPanelX2 = new AxeRotationManagementPanel("RX");
	 	AxeTranslationManagementPanel axesPanelY1 = new AxeTranslationManagementPanel("TY");
	 	AxeRotationManagementPanel axesPanelY2 = new AxeRotationManagementPanel("RY");
	 	
	 	// Essai point panel
	 	EssaiPointManagementPanel essaiPanel = new EssaiPointManagementPanel("Oint");
	 	
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
	 	
	 	mainGrid.add(axesPanelsGrid, 0, 0);
	 	mainGrid.add(essaiPanel, 0, 1);
	 	mainGrid.add(buttonEmergencyStop, 0, 2);

        // Add components in the tables tab
        setContent(mainGrid);
	}
}
