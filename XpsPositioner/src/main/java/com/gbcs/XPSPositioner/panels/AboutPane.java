package com.gbcs.XPSPositioner.panels;

import java.net.URISyntaxException;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.tabs.AdminTab;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * AboutPane
 * @author Sébastien
 *
 */
public class AboutPane extends Pane {

	// Logger
	private static final Logger logger = Logger.getLogger(AboutPane.class);
	
	/**
	 * AboutPane ctor
	 */
	public AboutPane() {
 	 	
		// Images
		Image imageAirbus = new Image("file:///c:\\Users\\Sébastien\\git\\jfxTest\\XpsPositioner\\src\\main\\resources\\airbus_logo.jpeg");
		ImageView imageViewAirbus = new ImageView();
		imageViewAirbus.setImage(imageAirbus);
		
		Image imageGbcs = new Image("file:///c:\\Users\\Sébastien\\git\\jfxTest\\XpsPositioner\\src\\main\\resources\\gbcs_logo.jpeg");
		ImageView imageViewGbcs = new ImageView();
		imageViewGbcs.setImage(imageGbcs);

		// Labels
		Label labelSoftwareDescription = new Label("Logiciel de contrôle du GABI");
		Label labelSoftwareVersionText = new Label("Version: ");
		Label labelSoftwareVersion = new Label("1.0");
		Label labelSoftwareVersionDate = new Label("20 juillet 2017");
		Label labelCopyright = new Label("Copyright");
		Label labelContributorEmail1 = new Label("jpg.micro-services@laposte.net");
		Label labelContributorEmail2 = new Label("gbouvree@wanadoo.fr");
	 	
		// Version
	 	GridPane versionGrid = new GridPane();
	 	versionGrid.setVgap(5);
	 	versionGrid.setHgap(10);
	 	versionGrid.setPadding(new Insets(5, 5, 5, 5));
	 	versionGrid.setHalignment(labelSoftwareVersionText, HPos.CENTER);
		versionGrid.setHalignment(labelSoftwareVersion, HPos.CENTER);
	 	versionGrid.add(labelSoftwareVersionText, 0, 0);
	 	versionGrid.add(labelSoftwareVersion, 1, 0);
	 	
	 	// Emails
	 	GridPane emailGrid = new GridPane();
	 	emailGrid.setVgap(5);
	 	emailGrid.setHgap(10);
	 	emailGrid.setPadding(new Insets(5, 5, 5, 5));
	 	emailGrid.setHalignment(labelContributorEmail1, HPos.CENTER);
	 	emailGrid.setHalignment(labelContributorEmail2, HPos.CENTER);
	 	emailGrid.add(labelContributorEmail1, 0, 0);
	 	emailGrid.add(labelContributorEmail2, 1, 0);
	 	
	 	GridPane grid = new GridPane();
	 	grid.setVgap(5);
	 	grid.setHgap(10);
	 	grid.setPadding(new Insets(5, 5, 5, 5));
	 	
		grid.setHalignment(imageViewAirbus, HPos.CENTER);
	 	grid.setHalignment(labelSoftwareDescription, HPos.CENTER);
		grid.setHalignment(versionGrid, HPos.CENTER);
		grid.setHalignment(labelSoftwareVersionDate, HPos.CENTER);
		grid.setHalignment(labelCopyright, HPos.CENTER);
		grid.setHalignment(imageViewGbcs, HPos.CENTER);
		grid.setHalignment(emailGrid, HPos.CENTER);
		
		grid.add(imageViewAirbus, 0, 0);
	 	grid.add(labelSoftwareDescription, 0, 1);
	 	grid.add(versionGrid, 0, 2);
	 	grid.add(labelSoftwareVersionDate, 0, 3);
	 	grid.add(labelCopyright, 0, 4);
	 	grid.add(imageViewGbcs, 0, 5);
	 	grid.add(emailGrid, 0, 6);
	 	
	 	getChildren().add(grid);
	}
}
