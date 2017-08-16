package com.gbcs.XPSPositioner.panel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.GabiController;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
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
	private GabiController gabiManager;
	
	/**
	 * FileSequencePanel ctor
	 * @param lv
	 * @param text
	 */
	public FileSequencePanel(GabiController manager, ListView<String> lv, String text) {

		listviewSequences = lv;
		gabiManager = manager;
		
		// Buttons
 	 	Button buttonNewSequence = new Button("Nouveau");
 	 	buttonNewSequence.setOnAction(e -> newSequence(e));
 	 	
	 	Button buttonOpenSequenceFile = new Button("Ouvrir...");
	 	buttonOpenSequenceFile.setOnAction(e -> openSequence(e));
		
 	 	Button buttonSaveSequenceFile = new Button("Enregistrer...");
 	 	buttonSaveSequenceFile.setOnAction(e -> saveSequence(e));
 	 	
	 	setText(text);
	 	setCollapsible(false);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(10);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	 	
	 	GridPane.setHalignment(buttonNewSequence, HPos.LEFT);
	 	GridPane.setHalignment(buttonOpenSequenceFile, HPos.LEFT);
	 	GridPane.setHalignment(buttonSaveSequenceFile, HPos.LEFT);
		
		grid.add(buttonNewSequence, 0, 0);
	 	grid.add(buttonOpenSequenceFile, 0, 1);
	 	grid.add(buttonSaveSequenceFile, 0, 2);
	 	
	 	setContent(grid);
	}
	
	/**
	 * newSequence
	 * @param event
	 */
	private void newSequence(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Nouvelle séquence");
		alert.setHeaderText("Confirmation");
		alert.setContentText("Effacer la séquence courante pour une nouvelle ?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			listviewSequences.getItems().clear();
		}
	}
	
	/**
	 * openSequence
	 * @param event
	 */
	private void openSequence(ActionEvent event) {
 		fileChooserOpen = new FileChooser();
 		fileChooserOpen.setTitle("Relire une séquence...");
 
 		List<String> filterList = new ArrayList<String>();
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
	 * saveSequence
	 * @param event
	 */
	private void saveSequence(ActionEvent event) {
 		fileChooserOpen = new FileChooser();
	 	fileChooserOpen.setTitle("Enregistrer une séquence...");
	 	
		List<String> filterList = new ArrayList<String>();
 		filterList.add("*.seq");
 
 		fileChooserOpen.getExtensionFilters().addAll(new ExtensionFilter("GABI Sequence files", filterList));
 		File selectedFile = fileChooserOpen.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
 		if (selectedFile != null) {
 			gabiManager.saveSequenceToFile(selectedFile, listviewSequences.getItems());
 		}
	}
}
