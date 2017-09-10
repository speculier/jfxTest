package com.gbcs.XPSPositioner.panel;

import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.data.PasswordData;
import com.gbcs.XPSPositioner.dialog.AboutDialog;
import com.gbcs.XPSPositioner.dialog.ChangePasswordDialog;
import com.gbcs.XPSPositioner.dialog.PasswordDialog;
import com.gbcs.XPSPositioner.enumeration.RotationCenter;
import com.gbcs.XPSPositioner.form.MainGraphicalForm;
import com.gbcs.XPSPositioner.parameters.GabiParameters;
import com.gbcs.XPSPositioner.tabs.AdminTab;
import com.gbcs.XPSPositioner.tabs.EssaiTab;
import com.gbcs.XPSPositioner.tabs.MecaTab;
import com.gbcs.XPSPositioner.tabs.SequenceTab;
import com.gbcs.XPSPositioner.tabs.TablesTab;
import com.gbcs.XPSPositioner.util.PasswordEncrypter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

/**
 * GabiView
 * @author Sébastien
 *
 */
public class GabiView extends BorderPane {

	// Logger
	private static final Logger logger = LogManager.getLogger(GabiView.class);
	
	private MainGraphicalForm mainGraphicalForm;

    // Main Menu bar
    private final MenuBar menuBar = new MenuBar();
    private Menu menuConfiguration = new Menu("Configuration");
    private Menu menuMaintenance = new Menu("Maintenance");
    private Menu menuFile = new Menu("Fichier");
    private Menu menuAdvancedFeatures = new Menu("Fonctionnalités avancées");
    private Menu menuHelp = new Menu("Aide");
    private CheckMenuItem checkMenuItemShowMainAxes = new CheckMenuItem("Axes principaux");
    private CheckMenuItem checkMenuItemShowM1Axes = new CheckMenuItem("Axes M1");
    private CheckMenuItem checkMenuItemShowM2Axes = new CheckMenuItem("Axes M2");
    private CheckMenuItem checkMenuItemShowOintAxes = new CheckMenuItem("Axes Oint");
    private CheckMenuItem checkMenuItemShowMainArrows = new CheckMenuItem("Flèches principales");
    private CheckMenuItem checkMenuItemShowM1Arrows = new CheckMenuItem("Flèches M1");
    private CheckMenuItem checkMenuItemShowM2Arrows = new CheckMenuItem("Flèches M2");
    private CheckMenuItem checkMenuItemShowOintArrows = new CheckMenuItem("Flèches Oint");
    
    // Main statusBar 
    private LowerStatusBarPanel statusBar;
    
    // Right tabed panels and its panels
    private final TabPane tabPane = new TabPane();  
    private AdminTab adminTab;
    private TablesTab tablesTab;
    private MecaTab mecaTab;
    private EssaiTab essaiTab;
    private SequenceTab sequenceTab;
	
	/**
	 * getMainGraphicalForm
	 * @return MainGraphicalForm
	 */
	public MainGraphicalForm getMainGraphicalForm () {
		return mainGraphicalForm;
	}
	
	/**
	 * getStatusBar
	 * @return LowerStatusBarPanel
	 */
	public LowerStatusBarPanel getStatusBar () {
		return statusBar;
	}
	
	/**
	 * getAdmainTab
	 * @return AdminTab
	 */
	public AdminTab getAdminTab () {
		return adminTab;
	}
	
	/**
	 * getTablesTab
	 * @return TablesTab
	 */
	public TablesTab getTablesTab () {
		return tablesTab;
	}
	
	/**
	 * getMecaTab
	 * @return MecaTab
	 */
	public MecaTab getMecaTab () {
		return mecaTab;
	}
	
	/**
	 * getEssaiTab
	 * @return EssaiTab
	 */
	public EssaiTab getEssaiTab () {
		return essaiTab;
	}
	
	/**
	 * getSequenceTab
	 * @return AdminTab
	 */
	public SequenceTab getSequenceTab () {
		return sequenceTab;
	}

	/**
	 * GabiView ctor
	 */
	public GabiView () {
		
		// Create graphical area
		Group root = new Group();
		mainGraphicalForm = new MainGraphicalForm(root, this);
		statusBar = new LowerStatusBarPanel(this);
        root.getChildren().add(mainGraphicalForm);

    	// Build menus
    	buildMenus();
    	
    	// Build tabs
    	buildTabs();
    
    	// Insert in the center a split panel, that contains:
    	// - on the left the 3D scene area
    	// - on the right the tab pane (tables, meca, ...)  	
    	setCenter(new SplitPane(new BorderPane(mainGraphicalForm.getSubScene()),tabPane));
      
        // Set menu bar to the top
	    setTop(menuBar);
	    
	    // Set status bar to the bottom
		setBottom(statusBar);
	}
	
    /**
     * buildPanels
     * Build all Tab panels (Tables, Meca, ...)
     */
    private void buildTabs() {
          	
	    adminTab = new AdminTab(this, "Admin");
	    tablesTab = new TablesTab(this, "Tables");
	    mecaTab = new MecaTab(this,"Méca");
	    essaiTab = new EssaiTab(this,"Essai");
	    sequenceTab = new SequenceTab(this,"Séquence");
    	
    	// Disable closing panels
    	tablesTab.setClosable(false);
    	mecaTab.setClosable(false);
    	essaiTab.setClosable(false);
    	sequenceTab.setClosable(false);
    	adminTab.setClosable(false);

    	// Add panels to the TapPanel
        tabPane.getTabs().add(tablesTab);
        tabPane.getTabs().add(mecaTab);
        tabPane.getTabs().add(essaiTab);
        tabPane.getTabs().add(sequenceTab);
        tabPane.getTabs().add(adminTab);
    }
	
    /**
     * buildMenus
     */
    private void buildMenus() {
   
    	// File
	    MenuItem menuItemFileQuit = new MenuItem("Quitter");
	    menuItemFileQuit.setOnAction(e -> exitApplication(e));
	    
	    menuFile.getItems().addAll(menuItemFileQuit);
	    
    	// Password
	    MenuItem menuItemShowAdvancedFeatures = new MenuItem("Afficher les fonctionnalités avancées...");
	    menuAdvancedFeatures.setOnAction(e -> showAdvancedFeatures(e));
	    
	    menuAdvancedFeatures.getItems().addAll(menuItemShowAdvancedFeatures);
	    
    	// Configuration
	    menuConfiguration.setVisible(false);
	    MenuItem menuItemConfigurationAdresseXps = new MenuItem("Adresse XPS...");
	    MenuItem menuItemConfigurationSelectAxes = new MenuItem("Sélection des axes...");
	    MenuItem menuItemConfigurationArrowsSize = new MenuItem("Taille des flèches...");
	    
	    menuItemConfigurationAdresseXps.setOnAction(e -> setXpsAddress(e));
	    menuItemConfigurationSelectAxes.setOnAction(e -> selectAxes(e));
	    menuItemConfigurationArrowsSize.setOnAction(e -> setArrowSize(e));
	    
	    // Show / hide
	    Menu menuItemConfigurationShow = new Menu("Montrer");
	    checkMenuItemShowMainAxes.setSelected(true);
	    checkMenuItemShowM1Axes.setSelected(true);
	    checkMenuItemShowM2Axes.setSelected(true);
	    checkMenuItemShowOintAxes.setSelected(true);
	    checkMenuItemShowMainArrows.setSelected(true);
	    checkMenuItemShowM1Arrows.setSelected(true);
	    checkMenuItemShowM2Arrows.setSelected(true);
	    checkMenuItemShowOintArrows.setSelected(true);
	    
	    checkMenuItemShowMainAxes.setOnAction(e -> showMainAxes(e));
	    checkMenuItemShowM1Axes.setOnAction(e -> showM1Axes(e));
	    checkMenuItemShowM2Axes.setOnAction(e -> showM2Axes(e));
	    checkMenuItemShowOintAxes.setOnAction(e -> showOintAxes(e));
	    checkMenuItemShowMainArrows.setOnAction(e -> showMainArrows(e));
	    checkMenuItemShowM1Arrows.setOnAction(e -> showM1Arrows(e));
	    checkMenuItemShowM2Arrows.setOnAction(e -> showM2Arrows(e));
	    checkMenuItemShowOintArrows.setOnAction(e -> showOintArrows(e));
	    
	    menuItemConfigurationShow.getItems().addAll(checkMenuItemShowMainAxes, checkMenuItemShowM1Axes, checkMenuItemShowM2Axes, checkMenuItemShowOintAxes, checkMenuItemShowMainArrows, checkMenuItemShowM1Arrows, checkMenuItemShowM2Arrows, checkMenuItemShowOintArrows);

	    // Rotations
	    final ToggleGroup rotationGroup = new ToggleGroup();
	    Menu menuItemConfigurationRotations = new Menu("Rotations");
	    RadioMenuItem radioMenuItemVirtualPointUnderM1 = new RadioMenuItem("Rotule virtuelle sous M1");
	    radioMenuItemVirtualPointUnderM1.setToggleGroup(rotationGroup);
	    radioMenuItemVirtualPointUnderM1.setSelected(false);
	    RadioMenuItem radioMenuItemNearCenterOfM1M2 = new RadioMenuItem("Proche du milieu de M1 M2");
	    radioMenuItemNearCenterOfM1M2.setToggleGroup(rotationGroup);
	    radioMenuItemNearCenterOfM1M2.setSelected(false);
	    RadioMenuItem radioMenuItemNearPointUnderM2 = new RadioMenuItem("Proche de la rotule sous M2");
	    radioMenuItemNearPointUnderM2.setToggleGroup(rotationGroup);
	    radioMenuItemNearPointUnderM2.setSelected(false);
	    
	    radioMenuItemVirtualPointUnderM1.setOnAction(e -> setRotationCenterUnderM1(e));
	    radioMenuItemNearCenterOfM1M2.setOnAction(e -> setRotationCenterCenterOfM1M2(e));
	    radioMenuItemNearPointUnderM2.setOnAction(e -> setRotationCenterNearUnderM2(e));
	    
	    menuItemConfigurationRotations.getItems().addAll(radioMenuItemVirtualPointUnderM1, radioMenuItemNearCenterOfM1M2, radioMenuItemNearPointUnderM2);

	    switch(GabiParameters.getInstance().getGabiDataParameters().getRotationCenter()) {
	    	case NEAR_MIDDLE_OF_M1M2:
	    		radioMenuItemNearCenterOfM1M2.setSelected(true);
	    		break;
	    	case NEAR_M2_PATELLA:
	    		radioMenuItemNearPointUnderM2.setSelected(true);
	    		break;
	    	case VIRTUAL_PATELLA_UNDER_M1:
	    	default:
	    		radioMenuItemVirtualPointUnderM1.setSelected(true);
	    		break;
	    }
	    
	    MenuItem menuItemConfigurationOrderNumber = new MenuItem("Numéro d'ordre...");
	    MenuItem menuItemConfigurationPassword = new MenuItem("Mot de passe...");
	    
	    menuItemConfigurationOrderNumber.setOnAction(e -> setOrderNumber(e));
	    menuItemConfigurationPassword.setOnAction(e -> modifyPassword(e));
	    
	    menuConfiguration.getItems().addAll(menuItemConfigurationAdresseXps, menuItemConfigurationSelectAxes, menuItemConfigurationArrowsSize, menuItemConfigurationShow, menuItemConfigurationRotations, menuItemConfigurationOrderNumber, menuItemConfigurationPassword);
	    
    	// Maintenance
	    menuMaintenance.setVisible(false);
	    MenuItem menuItemMaintenanceXps = new MenuItem("XPS...");
	    MenuItem menuItemMaintenanceDebug = new MenuItem("Debug...");
	    
	    menuItemMaintenanceXps.setOnAction(e -> xps(e));
	    menuItemMaintenanceDebug.setOnAction(e -> debug(e));
	    
	    menuMaintenance.getItems().addAll(menuItemMaintenanceXps, menuItemMaintenanceDebug);
	    
    	// Help
	    MenuItem menuHelpAPropos = new MenuItem("A Propos...");
	    MenuItem menuHelpManual = new MenuItem("Manuel");

	    menuHelpAPropos.setOnAction(e-> showAboutDialog(e));
	    menuHelpManual.setOnAction(e-> showUserManual(e));

	    menuHelp.getItems().addAll(menuHelpAPropos, menuHelpManual);
	    
	    menuBar.getMenus().addAll(menuFile, menuAdvancedFeatures, menuConfiguration, menuMaintenance, menuHelp);
    }
    
    /**
     * showMainAxes
     * @param e
     */
    private void showMainAxes(ActionEvent e) {
        getMainGraphicalForm().getMainReferencePoint().setAxesVisible(checkMenuItemShowMainAxes.isSelected());
    }
    
    /**
     * showM1Axes
     * @param e
     */
    private void showM1Axes(ActionEvent e) {
        getMainGraphicalForm().getM1ReferencePoint().setAxesVisible(checkMenuItemShowM1Axes.isSelected());
    }
    
    /**
     * showM2Axes
     * @param e
     */
    private void showM2Axes(ActionEvent e) {
        getMainGraphicalForm().getM2ReferencePoint().setAxesVisible(checkMenuItemShowM2Axes.isSelected());
    }
    
    /**
     * showOintAxes
     * @param e
     */
    private void showOintAxes(ActionEvent e) {
       // getMainGraphicalForm().getM2ReferencePoint().setVisible(checkMenuItemShowOintAxes.isSelected());
    }
    
    /**
     * showMainArrows
     * @param e
     */
    private void showMainArrows(ActionEvent e) {
        getMainGraphicalForm().getMainReferencePoint().setArrowsVisible(checkMenuItemShowMainArrows.isSelected());
    }
    
    /**
     * showM1Arrows
     * @param e
     */
    private void showM1Arrows(ActionEvent e) {
        getMainGraphicalForm().getM1ReferencePoint().setArrowsVisible(checkMenuItemShowM1Arrows.isSelected());
    }
    
    /**
     * showM2Arrows
     * @param e
     */
    private void showM2Arrows(ActionEvent e) {
        getMainGraphicalForm().getM2ReferencePoint().setArrowsVisible(checkMenuItemShowM2Arrows.isSelected());
    }
    
    /**
     * showOintArrows
     * @param e
     */
    private void showOintArrows(ActionEvent e) {
       // getMainGraphicalForm().getAxisGroup().setVisible(checkMenuItemShowOintArrows.isSelected());
    }

    /**
     * setRotationCenterUnderM1
     * @param e
     */
    private void setRotationCenterUnderM1(ActionEvent e) {
    	GabiParameters.getInstance().getGabiDataParameters().setRotationCenter(RotationCenter.VIRTUAL_PATELLA_UNDER_M1);
    }
    
    /**
     * setRotationCenterCenterOfM1M2
     * @param e
     */
    private void setRotationCenterCenterOfM1M2(ActionEvent e) {
    	GabiParameters.getInstance().getGabiDataParameters().setRotationCenter(RotationCenter.NEAR_MIDDLE_OF_M1M2);
    }
    
    /**
     * setRotationCenterNearUnderM2
     * @param e
     */
    private void setRotationCenterNearUnderM2(ActionEvent e) {
    	GabiParameters.getInstance().getGabiDataParameters().setRotationCenter(RotationCenter.NEAR_M2_PATELLA);
    }
    
    /**
     * showAdvancedFeatures
     * @param e
     */
	private void showAdvancedFeatures(ActionEvent e) {
    	PasswordDialog passwordDialog = new PasswordDialog("Mot de passe");
    	
 		Optional<PasswordData> result = passwordDialog.showAndWait();
 		if (result.isPresent()) {
 			String md5InputPassword = PasswordEncrypter.getInstance().getMd5EncryptedPassword(result.get().getPassword());
 			if (md5InputPassword != null && md5InputPassword.equals("d5367bacb1bffc74dd5d119786101518")) {
 				menuMaintenance.setVisible(true);
 			    menuConfiguration.setVisible(true);
 			} else {
 				logger.log(Level.INFO, "Bad password !");
				menuMaintenance.setVisible(false);
 			    menuConfiguration.setVisible(false);
 			}
 		}
	}
	
	/**
	 * setXpsAddress
	 * @param e
	 */
	private void setXpsAddress(ActionEvent e) {
		
	}

	/**
	 * selectAxes
	 * @param e
	 */
	private void selectAxes(ActionEvent e) {
		
	}

	/**
	 * setArrowSize
	 * @param e
	 */
	private void setArrowSize(ActionEvent e) {
		
	}
	
	/**
	 * setOrderNumber
	 * @param e
	 */
	private void setOrderNumber(ActionEvent e) {
		
	}
	
	/**
	 * xps
	 * @param e
	 */
	private void xps(ActionEvent e) {
		
	}
	
	/**
	 * debug
	 * @param e
	 */
	private void debug(ActionEvent e) {
		
	}
	
	/**
	 * showUserManual
	 * @param e
	 */
	private void showUserManual(ActionEvent e) {
		
	}
 	
	/**
	 * modifyPassword
	 * @param e
	 */
	private void modifyPassword(ActionEvent e) {
		ChangePasswordDialog passwordDialog = new ChangePasswordDialog("Changement du mot de passe");
    	
 		Optional<PasswordData> result = passwordDialog.showAndWait();
 		if (result.isPresent()) {
 			logger.log(Level.INFO, "Password changed successfully");
 			GabiParameters.getInstance().getGabiDataParameters().setPwd(result.get().getPassword());
 			GabiParameters.getInstance().save();
 		} else {
 			logger.log(Level.INFO, "Bad password !");	
 		}
	}
	
	/**
	 * showAboutDialog
	 * @param e
	 */
	private void showAboutDialog(ActionEvent e) {
	    AboutDialog about = new AboutDialog("A Propos de GABI");
	    about.showAndWait();
	}
	
    /**
     * exitApplication
     * @param e
     */
	private void exitApplication(ActionEvent e) {
		Platform.exit();
	}
}
