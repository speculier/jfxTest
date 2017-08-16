
package com.gbcs.XPSPositioner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.panel.GabiView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GabiLauncher class (Java entry point)
 * @author sp01515
 *
 */
public class GabiLauncher extends Application {

	// Logger
	private static final Logger logger = Logger.getLogger(GabiLauncher.class);
   
    /**
     * Javafx entry point
     * @param primaryStage the main stage
     */
    @Override
    public void start(Stage primaryStage) {
    	    	
        // Create main scene and set inside the 'Gabi View'
    	GabiView mainView = new GabiView();
        Scene mainScene = new Scene(mainView);
    	
        // Set scene in the stage and show it
        primaryStage.setTitle("Démonstration de contrôle de GABI AIRBUS");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as callback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	// Initialize log4j
    	org.apache.log4j.BasicConfigurator.configure();
    	    	
    	logger.log(Level.INFO, "Starting application...");
    	
    	// Style sheet
        setUserAgentStylesheet(STYLESHEET_MODENA);
        
    	// Start 3D features
        if (Platform.isSupported(javafx.application.ConditionalFeature.SCENE3D) == true) {
        	logger.log(Level.INFO, "3D features supported.");        	
        	launch(args);
        } else {
        	logger.log(Level.INFO, "3D features not supported. Stopping application...");        	
        }
    }
}
