
package com.gbcs.XPSPositioner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.forms.MainGraphicalForm;
import com.gbcs.XPSPositioner.forms.XForm;
import com.gbcs.XPSPositioner.panels.MainApplicationPanel;
import com.gbcs.XPSPositioner.utils.Constants;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * GabiApplication class (Java entry point)
 * @author sp01515
 *
 */
public class GabiApplication extends Application {

	// Logger
	private static final Logger logger = Logger.getLogger(GabiApplication.class);
	  
	// 3D root group that contains all other groups
	private final Group root = new Group();
	private SubScene scene3D;
    
    // Main panels
    private GabiManager mainGabiManager;
    private MainApplicationPanel mainApplicationPanel;
    private MainGraphicalForm mainGraphicalForm;
   
    /**
     * Handle Mouse for zoom and 3D rotation and translation
     * SHIFT and CTRL are used to decrease and increase speed
     * 
     * @param scene
     * @param root
     */
  /*  private void handleMouse3D(SubScene scene, final Node root) {
              
        scene.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override public void handle(ScrollEvent se) {
                mouseDeltaY = se.getDeltaY(); 
                double modifier = 1.0;
                
                if (se.isControlDown()) {
                    modifier = Constants.CONTROL_MULTIPLIER;
                } 
               
                if (se.isShiftDown()) {
                    modifier = Constants.SHIFT_MULTIPLIER;
                }  
                
                double z = camera.getTranslateZ();
                double newZ = z + mouseDeltaY * Constants.MOUSE_SPEED * modifier;
                camera.setTranslateZ(newZ);
            }
        });
    	
        // Manage mouse
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent me) {
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseOldX = me.getSceneX();
                mouseOldY = me.getSceneY();
            }
        });
        
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent me) {
                mouseOldX = mousePosX;
                mouseOldY = mousePosY;
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseDeltaX = (mousePosX - mouseOldX); 
                mouseDeltaY = (mousePosY - mouseOldY); 

                double modifier = 1.0;
                
                if (me.isControlDown()) {
                    modifier = Constants.CONTROL_MULTIPLIER;
                } 
                
                if (me.isShiftDown()) {
                    modifier = Constants.SHIFT_MULTIPLIER;
                }    
                
                // Left click : rotate scene
                if (me.isPrimaryButtonDown()) {
                	cameraXform.ry.setAngle(cameraXform.ry.getAngle() - mouseDeltaX * Constants.MOUSE_SPEED * modifier * Constants.ROTATION_SPEED);  
                    cameraXform.rx.setAngle(cameraXform.rx.getAngle() + mouseDeltaY * Constants.MOUSE_SPEED * modifier * Constants.ROTATION_SPEED);
                    
                    mainApplicationPanel.getAdminTab().setXAngleSpinnerValue(cameraXform.rx.getAngle());
                    mainApplicationPanel.getAdminTab().setYAngleSpinnerValue(cameraXform.ry.getAngle());
                }
                
                // Right click : move scene
                else if (me.isSecondaryButtonDown()) {
                    cameraXform2.t.setX(cameraXform2.t.getX() + mouseDeltaX * Constants.MOUSE_SPEED * modifier * Constants.TRACK_SPEED);  
                    cameraXform2.t.setY(cameraXform2.t.getY() + mouseDeltaY * Constants.MOUSE_SPEED * modifier * Constants.TRACK_SPEED);  
                }
            }
        });
    }
    */

    
    /**
     * Javafx entry point
     * @param primaryStage the main stage
     */
    @Override
    public void start(Stage primaryStage) {
       
    	// Creating main manager and main panel
       	mainGabiManager = new GabiManager(this);
    	mainApplicationPanel = new MainApplicationPanel(mainGabiManager);
    	mainGraphicalForm = new MainGraphicalForm(root);

        // Build the left 3D graphical scene
        root.getChildren().add(mainGraphicalForm);
        root.setDepthTest(DepthTest.ENABLE);
        
        // Create 3D scene GREY with the root group
        scene3D = new SubScene(root, 1024, 768, true, SceneAntialiasing.BALANCED);
        scene3D.setFill(Color.GREY);
        scene3D.setCamera(mainGraphicalForm.getPerspectiveCamera());

        // Create 2D panel for user controls
        mainApplicationPanel.setCenter(scene3D);
      
        // Create main scene
        Scene mainScene = new Scene(mainApplicationPanel);
	    
        // Set mouse handlers
       // handleMouse3D(scene3D, mainGraphicalForm);

        // Set scene in the stage and show it
        primaryStage.setTitle("Démonstration de controle de GABI AIRBUS");
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
