package com.gbcs.XPSPositioner.tabs;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.GabiApplication;
import com.gbcs.XPSPositioner.GabiManager;
import com.gbcs.XPSPositioner.panels.AxeRotationManagementPanel;
import com.gbcs.XPSPositioner.panels.AxeTranslationManagementPanel;
import com.gbcs.XPSPositioner.panels.EditSequencePanel;
import com.gbcs.XPSPositioner.panels.EssaiPointManagementPanel;
import com.gbcs.XPSPositioner.panels.ExecuteSequencePanel;
import com.gbcs.XPSPositioner.panels.FileSequencePanel;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

/**
 * SequenceTab
 * @author Sébastien
 *
 */
public class SequenceTab extends Tab {
	
	// Logger
	private static final Logger logger = Logger.getLogger(SequenceTab.class);
	
	private GabiManager gabiManager;
	private ListView<String> listviewSequences;
	
	/**
	 * SequenceTab ctor
	 * @param a
	 * @param text
	 */
	public SequenceTab(GabiManager manager, String text) {
		
		gabiManager = manager;
		setClosable(false);
		setText(text);
		
		// Buttons
		
 	 	Button buttonEmergencyStop = new Button("Arrêt d'urgence");
 	 	buttonEmergencyStop.setOnAction(e->{

        });
 	 	
		// ListBox
		listviewSequences = new ListView<String>();
		listviewSequences.setEditable(true);
		
		EditSequencePanel editSequencePanel = new EditSequencePanel(listviewSequences, "Edition");
		FileSequencePanel fileSequencePanel = new FileSequencePanel(gabiManager, listviewSequences, "Fichier");
		ExecuteSequencePanel executeSequencePanel = new ExecuteSequencePanel("Exécution");
		
		// Upper grid
	 	GridPane upperGrid = new GridPane();
	 	upperGrid.setVgap(20);
	 	upperGrid.setHgap(20);
	 	upperGrid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	upperGrid.add(listviewSequences, 0, 0);
	 	upperGrid.add(editSequencePanel, 1, 0);

		// Lower grid
	 	GridPane lowerGrid = new GridPane();
	 	lowerGrid.setVgap(20);
	 	lowerGrid.setHgap(20);
	 	lowerGrid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	lowerGrid.add(fileSequencePanel, 0, 0);
	 	lowerGrid.add(executeSequencePanel, 1, 0);
	 	
	 	// Main panel grid
	 	GridPane mainGrid = new GridPane();
	 	mainGrid.setHalignment(buttonEmergencyStop, HPos.RIGHT);
	 	mainGrid.setVgap(20);
	 	mainGrid.setHgap(20);
	 	mainGrid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	mainGrid.add(upperGrid, 0, 0);
	 	mainGrid.add(lowerGrid, 0, 1);
	 	mainGrid.add(buttonEmergencyStop, 0, 2);

        // Add components in the tables tab
        setContent(mainGrid);
	}
	
	/**
	 * getSequencesListView
	 * @return
	 */
	public ListView getSequencesListView () {
		return listviewSequences;
	}
}
