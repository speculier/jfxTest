package com.gbcs.XPSPositioner.panels;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.GabiManager;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FileSequencePanel
 * @author Sébastien
 *
 */
public class FileSequencePanel extends TitledPane {

	// Logger
	private static final Logger logger = Logger.getLogger(FileSequencePanel.class);
	
	private ListView<String> listviewSequences;
	private FileChooser fileChooserOpen = new FileChooser();
	private GabiManager gabiManager;
	
	/**
	 * FileSequencePanel ctor
	 * @param lv
	 * @param text
	 */
	public FileSequencePanel(GabiManager manager, ListView<String> lv, String text) {

		listviewSequences = lv;
		gabiManager = manager;
		
		// Buttons
 	 	Button buttonNewSequence = new Button("Nouveau");
 	 	buttonNewSequence.setOnAction(this::handleNewSequence);
 	 	
	 	Button buttonOpenSequenceFile = new Button("Ouvrir...");
	 	buttonOpenSequenceFile.setOnAction(this::handleOpenSequence);
		
 	 	Button buttonSaveSequenceFile = new Button("Enregistrer...");
 	 	buttonSaveSequenceFile.setOnAction(this::handleSaveSequence);
 	 	
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	 	
	 	grid.setHalignment(buttonNewSequence, HPos.LEFT);
		grid.setHalignment(buttonOpenSequenceFile, HPos.LEFT);
		grid.setHalignment(buttonSaveSequenceFile, HPos.LEFT);
		
		grid.add(buttonNewSequence, 0, 0);
	 	grid.add(buttonOpenSequenceFile, 0, 1);
	 	grid.add(buttonSaveSequenceFile, 0, 2);
	 	
	 	setContent(grid);
	}
	
	/**
	 * handleNewSequence
	 * @param event
	 */
	private void handleNewSequence(ActionEvent event) {
		listviewSequences.getItems().clear();
	}
	
	/**
	 * handleOpenSequence
	 * @param event
	 */
	private void handleOpenSequence(ActionEvent event) {
 		fileChooserOpen = new FileChooser();
 		fileChooserOpen.setTitle("Relire une séquence...");
 
 		List filterList = new ArrayList<String>();
 		filterList.add("*.seq");
 
 		fileChooserOpen.getExtensionFilters().addAll(new ExtensionFilter("GABI Sequence files", filterList));
 		File selectedFile =  fileChooserOpen.showOpenDialog(((Node)event.getSource()).getScene().getWindow());
 		if (selectedFile != null) {
 			List<String> list = gabiManager.openSequenceFromFile(selectedFile);
 			if (list != null) {
 				listviewSequences.getItems().addAll(list);
 			}
 		}
	}

	/**
	 * handleSaveSequence
	 * @param event
	 */
	private void handleSaveSequence(ActionEvent event) {
 		fileChooserOpen = new FileChooser();
	 	fileChooserOpen.setTitle("Enregistrer une séquence...");
	 	
		List filterList = new ArrayList<String>();
 		filterList.add("*.seq");
 
 		fileChooserOpen.getExtensionFilters().addAll(new ExtensionFilter("GABI Sequence files", filterList));
 		File selectedFile = fileChooserOpen.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
 		if (selectedFile != null) {
 			gabiManager.saveSequenceToFile(selectedFile, listviewSequences.getItems());
 		}
	}
}
