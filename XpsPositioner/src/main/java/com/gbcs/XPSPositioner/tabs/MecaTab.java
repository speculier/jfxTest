package com.gbcs.XPSPositioner.tabs;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.GabiController;
import com.gbcs.XPSPositioner.panel.AxeRotationManagementPanel;
import com.gbcs.XPSPositioner.panel.AxeTranslationManagementPanel;
import com.gbcs.XPSPositioner.panel.GabiView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

/**
 * MecaTab
 * @author Sébastien
 *
 */
public class MecaTab extends Tab {
	
	// Logger
	private static final Logger logger = Logger.getLogger(MecaTab.class);

	private GabiView gabiView;
	
	/**
	 * MecaTab ctor
	 * @param manager
	 * @param text
	 */
	public MecaTab(GabiView view, String text) {
		
		gabiView = view;
		setClosable(false);
		setText(text);
	 	 	
		// Labels
		Label labelCenter = new Label("Centre de la rotation:");
		Label labelRotationCenter = new Label("Rotule virtuelle sous M1");
		
		GridPane gridRotationCenter = new GridPane();
		gridRotationCenter.setVgap(20);
		gridRotationCenter.setHgap(20);
		gridRotationCenter.setPadding(new Insets(5, 5, 5, 5));
	 	gridRotationCenter.add(labelCenter, 0, 0);
	 	gridRotationCenter.add(labelRotationCenter, 1, 0);
   	 	
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
	 	
	 	mainGrid.add(gridRotationCenter, 0, 0);
	 	mainGrid.add(axesPanelsGrid, 0, 1);
	 	mainGrid.add(buttonEmergencyStop, 0, 2);
   	 	
        // Add components in the tables tab
        setContent(mainGrid);
	}
}
