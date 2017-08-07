
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
	private final Group root3D = new Group();
	private SubScene scene3D;

    // Axis group: contains the 3 axis X, Y and Z
	private final XForm axisGroup = new XForm();
    
    // Main group that contain useful shapes for the application
	private final XForm shapesGroup = new XForm();
	
    // XForms
	private final MainGraphicalForm world3D = new MainGraphicalForm();
	private final XForm cameraXform = new XForm();
	private final XForm cameraXform2 = new XForm();
    private final XForm cameraXform3 = new XForm();

    // 3D perspective Camera
    private final PerspectiveCamera camera = new PerspectiveCamera(true);
    
    // Main application panel
    private GabiManager mainGabiManager;
    private MainApplicationPanel mainApplicationPanel;
    
    // Positions variables
    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;
    private double mouseDeltaX;
    private double mouseDeltaY;

    /**
     * getAxisGroup
     * @return
     */
    public XForm getAxisGroup() {
    	return axisGroup;
    }
    
    /**
     * getPerspectiveCamera
     * @return
     */
    public PerspectiveCamera getPerspectiveCamera() {
    	return camera;
    }
    
    /**
     * buildAxes
     */
    private void buildAxes() {

        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);

        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.DARKBLUE);
        blueMaterial.setSpecularColor(Color.BLUE);

        final Box xAxis = new Box(Constants.AXIS_LENGTH, 1, 1);
        final Box yAxis = new Box(1, Constants.AXIS_LENGTH, 1);
        final Box zAxis = new Box(1, 1, Constants.AXIS_LENGTH);

        xAxis.setMaterial(redMaterial);
        yAxis.setMaterial(greenMaterial);
        zAxis.setMaterial(blueMaterial);

        // Add the axes in the 'axis' group
        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
        
        // Add the 'axis' group in the 'world3D' group
        world3D.getChildren().addAll(axisGroup);
    }

    /**
     * build3DShapes
     */
    private void build3DShapes() {

    	// Materials
        final PhongMaterial bodySatelliteMaterial = new PhongMaterial();
        bodySatelliteMaterial.setDiffuseColor(Color.DARKRED);
        bodySatelliteMaterial.setSpecularColor(Color.RED);

        final PhongMaterial baseSphereMaterial = new PhongMaterial();
        baseSphereMaterial.setDiffuseColor(Color.WHITE);
        baseSphereMaterial.setSpecularColor(Color.LIGHTBLUE);

        final PhongMaterial boxMaterial = new PhongMaterial();
        boxMaterial.setDiffuseColor(Color.DARKBLUE);
        boxMaterial.setSpecularColor(Color.BLUE);

        Box sampleBox = new Box(10.0,10.0,10.0);
        sampleBox.setTranslateX(30.0);
        sampleBox.setTranslateY(30.0);
        sampleBox.setTranslateZ(30.0);
        
        // Body cylinder
        Cylinder bodySatelliteCylinder = new Cylinder(40.0,100.0);
        bodySatelliteCylinder.setMaterial(bodySatelliteMaterial);
        bodySatelliteCylinder.setRotate(90.0);
        
        // Spheres
        Sphere baseSphere1 = new Sphere(10.0);
        baseSphere1.setMaterial(baseSphereMaterial);
        baseSphere1.setTranslateX(0.0);
        Sphere baseSphere2 = new Sphere(10.0);
        baseSphere2.setMaterial(baseSphereMaterial);
        baseSphere2.setTranslateX(0.0);
        
        // Cubes
        Box box1 = new Box(5, 40, 40);
        box1.setMaterial(boxMaterial);
        box1.setTranslateX(0.0);
        Box box2 = new Box(5, 40, 40);
        box2.setMaterial(boxMaterial);
        box2.setTranslateX(0.0);

        // Define satellite groups
        XForm satelliteXForm = new XForm();
        XForm mainCylinderXForm = new XForm();
        XForm sphere1XForm = new XForm();
        XForm sphere2XForm = new XForm();
        XForm box1XForm = new XForm();
        XForm box2XForm = new XForm();
        
        // Add base forms group in the satellite group
        satelliteXForm.getChildren().add(mainCylinderXForm);
        satelliteXForm.getChildren().add(sphere1XForm);
        satelliteXForm.getChildren().add(sphere2XForm);
        satelliteXForm.getChildren().add(box1XForm);
        satelliteXForm.getChildren().add(box2XForm);
        
        // Add shapes in each group
        mainCylinderXForm.getChildren().add(bodySatelliteCylinder);
        mainCylinderXForm.getChildren().add(sampleBox);
        sphere1XForm.getChildren().add(baseSphere1);
        sphere2XForm.getChildren().add(baseSphere2);
        box1XForm.getChildren().add(box1);
        box2XForm.getChildren().add(box2);
        
        // Set sphere group at each cylinder base
        sphere1XForm.setTx(45.0);
        sphere2XForm.setTx(-45.0);
        
        // Set Boxes position 
        box1XForm.setTx(100.0);
        box2XForm.setTx(-100.0);

        // Add the satellite form in the 'shapes' group
        shapesGroup.getChildren().add(satelliteXForm);

        // Add the 'main shapes' group in the 'world3D' group
        world3D.getChildren().addAll(shapesGroup);
    }
   
    /**
     * Handle Mouse for zoom and 3D rotation and translation
     * SHIFT and CTRL are used to decrease and increase speed
     * 
     * @param scene
     * @param root
     */
    private void handleMouse3D(SubScene scene, final Node root) {
              
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
    
    /**
     * buildCameras
     */
    private void buildCameras() {

        root3D.getChildren().add(cameraXform);
        
        cameraXform.getChildren().add(cameraXform2);
        cameraXform2.getChildren().add(cameraXform3);
        cameraXform3.getChildren().add(camera);
        cameraXform3.setRotateZ(180.0);

        camera.setNearClip(Constants.CAMERA_NEAR_CLIP);
        camera.setFarClip(Constants.CAMERA_FAR_CLIP);
        camera.setTranslateZ(Constants.CAMERA_INITIAL_DISTANCE);
        cameraXform.ry.setAngle(Constants.CAMERA_INITIAL_Y_ANGLE);
        cameraXform.rx.setAngle(Constants.CAMERA_INITIAL_X_ANGLE);
    }
    
    /**
     * setCurrentSceneOrientation
     * @param centerScene
     * @param xAngle
     * @param yAngle
     * @param distanceFromCamera
     */
    public void setCurrentSceneOrientation(boolean centerScene, double xAngle, double yAngle, double distanceFromCamera) {
    	
    	// Center in the middle of the scene
    	if (centerScene) {
    		cameraXform2.t.setX(0.0);
    		cameraXform2.t.setY(0.0);
    	}
    	
    	// Set distance from camera and the scene
        camera.setTranslateZ(distanceFromCamera);
        
        // Rotate the scene
        cameraXform.ry.setAngle(yAngle);
        cameraXform.rx.setAngle(xAngle);
    }
    
    /**
     * buildGraphicalScene
     */
    private void buildGraphicalScene() {
	    
    	// Add the group 'world3D' in the root group
        root3D.getChildren().add(world3D);
        root3D.setDepthTest(DepthTest.ENABLE);
        
        // Build camera group
        buildCameras();
        
        // Build Axis group
        buildAxes();
        
        // Build 3D shapes
        build3DShapes();
        
        // Create 3D scene GREY with the root group
        scene3D = new SubScene(root3D, 1024, 768, true, SceneAntialiasing.BALANCED);
        scene3D.setFill(Color.GREY);
        scene3D.setCamera(camera);

        // Create 2D panel for user controls
        mainApplicationPanel.setCenter(scene3D);
    }
    
    /**
     * Javafx entry point
     * @param primaryStage the main stage
     */
    @Override
    public void start(Stage primaryStage) {
       
    	// Creating main manager and main pansel
       	mainGabiManager = new GabiManager(this);
    	mainApplicationPanel = new MainApplicationPanel(mainGabiManager);
    	
    	// Style sheet
        setUserAgentStylesheet(STYLESHEET_MODENA);

        // Build the left 3D graphical scene
    	buildGraphicalScene();
      
        // Create main scene
        Scene mainScene = new Scene(mainApplicationPanel);
	    
        // Set mouse handlers
        handleMouse3D(scene3D, world3D);

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
    	
    	// Start 3D features
        if (Platform.isSupported(javafx.application.ConditionalFeature.SCENE3D) == true) {
        	logger.log(Level.INFO, "3D features supported.");        	
        	launch(args);
        } else {
        	logger.log(Level.INFO, "3D features not supported. Stopping application...");        	
        }
    }
}
