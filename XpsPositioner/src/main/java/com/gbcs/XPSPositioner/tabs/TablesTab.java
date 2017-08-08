package com.gbcs.XPSPositioner.tabs;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.GabiApplication;
import com.gbcs.XPSPositioner.GabiManager;
import com.gbcs.XPSPositioner.panels.AxeTranslationManagementPanel;
import com.gbcs.XPSPositioner.panels.MainApplicationPanel;
import com.gbcs.XPSPositioner.stages.SpeedStage;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * TablesTab
 * @author Sébastien
 *
 */
public class TablesTab extends Tab {
	
	// Logger
	private static final Logger logger = Logger.getLogger(TablesTab.class);
	
	private GabiManager gabiManager;
	

	/**
	 * TablesTab ctor
	 * @param manager
	 * @param text
	 */
	public TablesTab(GabiManager manager, String text) {
		
		gabiManager = manager;
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
	 	mainGrid.setHalignment(buttonEmergencyStop, HPos.RIGHT);
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
