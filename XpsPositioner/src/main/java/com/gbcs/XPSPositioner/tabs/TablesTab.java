package com.gbcs.XPSPositioner.tabs;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.GabiController;
import com.gbcs.XPSPositioner.panels.AxeTranslationManagementPanel;
import com.gbcs.XPSPositioner.panels.GabiView;
import com.gbcs.XPSPositioner.stages.SpeedStage;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
   	 	buttonInitialisation.setOnAction(e->{

        });
   	 	
   	 	Button buttonOrigine = new Button("Origine");
   	 	buttonOrigine.setOnAction(e->{

        });
   	 	
 	 	Button buttonMoteurOff = new Button("Moteur Off");
 	 	buttonMoteurOff.setOnAction(e->{

        });
   	 	
 	 	Button buttonVitesses = new Button("Vitesses");
 	 	buttonVitesses.setOnAction(e->{
 	 		SpeedStage speedDialog = new SpeedStage("Vitesses", ((Node)e.getSource()).getScene().getWindow());
 	 		speedDialog.showAndWait();
        });
 	 	
	 	Button buttonEmergencyStop = new Button("Arrêt d'urgence");
	 	buttonEmergencyStop.setOnAction(e->{

        });
 	 	
 	 	ToolBar buttonToolBar = new ToolBar(buttonInitialisation, buttonOrigine, buttonMoteurOff, buttonVitesses);
 	 	
 	 	//
 	 	// Axes panels
 	 	//	 	
 	 	AxeTranslationManagementPanel axesPanelX1 = new AxeTranslationManagementPanel("X1");
	 	AxeTranslationManagementPanel axesPanelX2 = new AxeTranslationManagementPanel("X2");
	 	AxeTranslationManagementPanel axesPanelY1 = new AxeTranslationManagementPanel("Y1");
	 	AxeTranslationManagementPanel axesPanelY2 = new AxeTranslationManagementPanel("Y2");
	 	
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
}
