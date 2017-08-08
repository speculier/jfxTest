package com.gbcs.XPSPositioner.panels;

import com.gbcs.XPSPositioner.GabiApplication;
import com.gbcs.XPSPositioner.GabiManager;
import com.gbcs.XPSPositioner.stages.AboutStage;
import com.gbcs.XPSPositioner.stages.PasswordStage;
import com.gbcs.XPSPositioner.tabs.AdminTab;
import com.gbcs.XPSPositioner.tabs.EssaiTab;
import com.gbcs.XPSPositioner.tabs.MecaTab;
import com.gbcs.XPSPositioner.tabs.SequenceTab;
import com.gbcs.XPSPositioner.tabs.TablesTab;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

/**
 * MainApplicationPanel
 * @author Sébastien
 *
 */
public class MainApplicationPanel extends BorderPane {

	private GabiManager gabiManager;
	
    // Main Menu bar
    private final MenuBar menuBar = new MenuBar();
    
    // Main statusBar 
    private final StatusBarPanel statusBar = new StatusBarPanel();
    
    private final TabPane tabPane = new TabPane();   
    private AdminTab adminTab;
    private TablesTab tablesTab;
    private MecaTab mecaTab;
    private EssaiTab essaiTab;
    private SequenceTab sequenceTab;
    
	/**
	 * setManager
	 * @param a
	 */
	private void setManager (GabiManager manager) {
		gabiManager = manager;
	}
	
	/**
	 * getManager
	 * @return GabiManager
	 */
	public GabiManager getManager () {
		return gabiManager;
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
	 * MainApplicationPanel ctor
	 */
	public MainApplicationPanel (GabiManager manager) {
		
		setManager(manager);
		
    	// Build menus
    	buildMenus();
    	
    	// Build tabs
    	buildTabs();
	}
	
    /**
     * buildPanels
     * Build all Tab panels (Tables, Meca, ...)
     */
    private void buildTabs() {
          	
	    adminTab = new AdminTab(getManager(), "Admin");
	    tablesTab = new TablesTab(getManager(), "Tables");
	    mecaTab = new MecaTab(getManager(),"Méca");
	    essaiTab = new EssaiTab(getManager(),"Essai");
	    sequenceTab = new SequenceTab(getManager(),"Séquence");
    	
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
        
        // Set the tab pane to the right 
        setRight(tabPane);
        
        // Set menu bar to the top
	    setTop(menuBar);
	    
	    // Set status bar to the bottom
		setBottom(statusBar);
        
		// Set size
        setPrefSize(800,600);
    }
	
    /**
     * buildMenus
     */
    private void buildMenus() {
   
    	//
    	// File
    	//
	    Menu menuFile = new Menu("File");
	    
	    MenuItem menuItemFileQuit = new MenuItem("Quitter");
	    menuItemFileQuit.setOnAction(e->{
	    	Platform.exit();
        });
	    
	    menuFile.getItems().addAll(menuItemFileQuit);
	    
		//
    	// Password
    	//
	    Menu menuAdvancedFeatures = new Menu("Fonctionnalités avancées");
	    MenuItem menuItemShowAdvancedFeatures = new MenuItem("Afficher les fonctionnalités avancées...");
	    menuAdvancedFeatures.setOnAction(e->{
	    	PasswordStage passwordDialog = new PasswordStage("Mot de passe", null);
	    	passwordDialog.showAndWait();
        });
	    menuAdvancedFeatures.getItems().addAll(menuItemShowAdvancedFeatures);
	    
		//
    	// Configuration
    	//
	    Menu menuConfiguration = new Menu("Configuration");
	    menuConfiguration.setVisible(false);
	    MenuItem menuItemConfigurationAdresseXps = new MenuItem("Adresse XPS");
	    MenuItem menuItemConfigurationSelectAxes = new MenuItem("Sélection des axes");
	    MenuItem menuItemConfigurationArrowsSize = new MenuItem("Taille des flèches");
	    
	    // Show / hide
	    Menu menuItemConfigurationShow = new Menu("Montrer");
	    CheckMenuItem checkMenuItemShowM1Axes = new CheckMenuItem("Axes M1");
	    CheckMenuItem checkMenuItemShowM2Axes = new CheckMenuItem("Axes M1");
	    CheckMenuItem checkMenuItemShowOintAxes = new CheckMenuItem("Axes Oint");
	    CheckMenuItem checkMenuItemShowM1Arrows = new CheckMenuItem("Flèches M1");
	    CheckMenuItem checkMenuItemShowM2Arrows = new CheckMenuItem("Flèches M2");
	    CheckMenuItem checkMenuItemShowOintArrows = new CheckMenuItem("Flèches Oint");
	    menuItemConfigurationShow.getItems().addAll(checkMenuItemShowM1Axes, checkMenuItemShowM2Axes, checkMenuItemShowOintAxes, checkMenuItemShowM1Arrows, checkMenuItemShowM2Arrows, checkMenuItemShowOintArrows);

	    // Rotations
	    final ToggleGroup rotationGroup = new ToggleGroup();
	    Menu menuItemConfigurationRotations = new Menu("Rotations");
	    RadioMenuItem radioMenuItemVirtualPointUnderM1 = new RadioMenuItem("Rotule virtuelle sous M1");
	    radioMenuItemVirtualPointUnderM1.setToggleGroup(rotationGroup);
	    radioMenuItemVirtualPointUnderM1.setSelected(false);
	    RadioMenuItem radioMenuItemNearCenterOfM1M2 = new RadioMenuItem("Proche du milieu de M1 M2");
	    radioMenuItemNearCenterOfM1M2.setToggleGroup(rotationGroup);
	    radioMenuItemNearCenterOfM1M2.setSelected(true);
	    RadioMenuItem radioMenuItemNearPointUnderM2 = new RadioMenuItem("Proche de la rotule sous M2");
	    radioMenuItemNearPointUnderM2.setToggleGroup(rotationGroup);
	    radioMenuItemNearPointUnderM2.setSelected(false);
	    menuItemConfigurationRotations.getItems().addAll(radioMenuItemVirtualPointUnderM1, radioMenuItemNearCenterOfM1M2, radioMenuItemNearPointUnderM2);

	    MenuItem menuItemConfigurationOrderNumber = new MenuItem("Numéro d'ordre");
	    MenuItem menuItemConfigurationPassword = new MenuItem("Mot de passe");
	    menuConfiguration.getItems().addAll(menuItemConfigurationAdresseXps, menuItemConfigurationSelectAxes, menuItemConfigurationArrowsSize, menuItemConfigurationShow, menuItemConfigurationRotations, menuItemConfigurationOrderNumber, menuItemConfigurationPassword);
	    
		//
    	// Maintenance
    	//
	    Menu menuMaintenance = new Menu("Maintenance");
	    menuMaintenance.setVisible(false);
	    MenuItem menuItemMaintenanceXps = new MenuItem("XPS");
	    MenuItem menuItemMaintenanceDebug = new MenuItem("Debug");
	    menuMaintenance.getItems().addAll(menuItemMaintenanceXps, menuItemMaintenanceDebug);
	    
		//
    	// Help
    	//
	    Menu menuHelp = new Menu("Aide");
	    
	    MenuItem menuHelpAPropos = new MenuItem("A Propos...");
	    menuHelpAPropos.setOnAction(e->{
	    	AboutStage about = new AboutStage("A Propos de GABI", null );
	    	about.showAndWait();
        });
	    
	    MenuItem menuHelpManual = new MenuItem("Manuel");
	    menuHelpManual.setOnAction(e->{
	    	
        });
	   
	    menuHelp.getItems().addAll(menuHelpAPropos, menuHelpManual);
	    
	    menuBar.getMenus().addAll(menuFile, menuAdvancedFeatures, menuConfiguration, menuMaintenance, menuHelp);
    }
}
