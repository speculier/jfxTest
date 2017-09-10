package com.gbcs.XPSPositioner.tabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.GabiController;
import com.gbcs.XPSPositioner.panel.EditSequencePanel;
import com.gbcs.XPSPositioner.panel.ExecuteSequencePanel;
import com.gbcs.XPSPositioner.panel.FileSequencePanel;
import com.gbcs.XPSPositioner.panel.GabiView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

/**
 * SequenceTab
 * @author Sébastien
 *
 */
public class SequenceTab extends Tab {
	
	// Logger
	private static final Logger logger = LogManager.getLogger(SequenceTab.class);
	
	private GabiView gabiView;
	private ListView<String> listviewSequences;
	
	/**
	 * SequenceTab ctor
	 * @param view
	 * @param text
	 */
	public SequenceTab(GabiView view, String text) {
		
		gabiView = view;
		setClosable(false);
		setText(text);
		
		// Buttons
		
 	 	Button buttonEmergencyStop = new Button("Arrêt d'urgence");
 	 	buttonEmergencyStop.setOnAction(e->{

        });
 	 	
		// ListBox
		listviewSequences = new ListView<String>();
		listviewSequences.setEditable(true);
		listviewSequences.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		EditSequencePanel editSequencePanel = new EditSequencePanel(listviewSequences, "Edition");
		FileSequencePanel fileSequencePanel = new FileSequencePanel(new GabiController(), listviewSequences, "Fichier");
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
	 	GridPane.setHalignment(buttonEmergencyStop, HPos.RIGHT);
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
	public ListView<String> getSequencesListView () {
		return listviewSequences;
	}
}
