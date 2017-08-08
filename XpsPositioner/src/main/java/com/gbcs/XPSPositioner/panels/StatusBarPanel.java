package com.gbcs.XPSPositioner.panels;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.tabs.AdminTab;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * StatusBarPanel
 * @author Sébastien
 *
 */
public class StatusBarPanel extends Pane {

	// Logger
	private static final Logger logger = Logger.getLogger(StatusBarPanel.class);
	
	/**
	 * StatusBarPanel ctor
	 */
	public StatusBarPanel() {
 	 	
		// Labels
		Label status1 = new Label("status1");
		Label status2 = new Label("status2");
		Label status3 = new Label("status3");
		Label status4 = new Label("status4");
		Label status5 = new Label("status5");
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(5);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
	 	grid.setHalignment(status1, HPos.LEFT);
		grid.setHalignment(status2, HPos.LEFT);
		grid.setHalignment(status3, HPos.LEFT);
		grid.setHalignment(status4, HPos.LEFT);
		grid.setHalignment(status5, HPos.LEFT);
		
	 	grid.add(status1, 0, 0);
	 	grid.add(status2, 1, 0);
	 	grid.add(status3, 2, 0);
	 	grid.add(status4, 3, 0);
	 	grid.add(status5, 4, 0);
	 	
	 	getChildren().add(grid);
	}
}
