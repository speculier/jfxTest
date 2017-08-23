package com.gbcs.XPSPositioner.panel;

import com.gbcs.XPSPositioner.tabs.AdminTab;
import com.gbcs.XPSPositioner.tabs.EssaiTab;
import com.gbcs.XPSPositioner.tabs.MecaTab;
import com.gbcs.XPSPositioner.tabs.SequenceTab;
import com.gbcs.XPSPositioner.tabs.TablesTab;

import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class Toto extends AnchorPane {

    private final TabPane tabPane = new TabPane();  
    private AdminTab adminTab;
    private TablesTab tablesTab;
    private MecaTab mecaTab;
    private EssaiTab essaiTab;
    private SequenceTab sequenceTab;
    
    private GabiView gabiView;
    
	public Toto (GabiView view) {
		
		gabiView = view;
		
	   	// Build tabs
    	buildTabs();
	}
	
    /**
     * buildPanels
     * Build all Tab panels (Tables, Meca, ...)
     */
    private void buildTabs() {
          	
	    adminTab = new AdminTab(gabiView, "Admin");
	    tablesTab = new TablesTab(gabiView, "Tables");
	    mecaTab = new MecaTab(gabiView,"Méca");
	    essaiTab = new EssaiTab(gabiView,"Essai");
	    sequenceTab = new SequenceTab(gabiView,"Séquence");
    	
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
}
