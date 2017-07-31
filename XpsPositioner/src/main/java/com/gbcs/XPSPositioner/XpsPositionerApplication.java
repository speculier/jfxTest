
package com.gbcs.XPSPositioner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.controls.XpsAngleSpinner;
import com.gbcs.XPSPositioner.tabs.TablesTab;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;

/**
 * XPSPositionner class (Java entry point)
 * @author sp01515
 *
 */
public class XpsPositionerApplication extends Application {

	// Logger
	private static final Logger logger = Logger.getLogger(XpsPositionerApplication.class);
	  
	//
	// Groups
	//
	
	// 3D root group that contains all other groups
	private final Group root3D = new Group();
	private SubScene scene3D;

	// root group that contains 2D panels
	//private final Group root2D = new Group();

    // Axis group: contains the 3 axis X, Y and Z
	private final XForm axisGroup = new XForm();
    
    // Main group that contain usefull shapes for the application
	private final XForm shapesGroup = new XForm();
    
    // Main group that contain the panel group
	private final XForm panelGroup = new XForm();
	
	//
    // XForms
	//
	private final XForm world3D = new XForm();
	private final XForm cameraXform = new XForm();
	private final XForm cameraXform2 = new XForm();
    private final XForm cameraXform3 = new XForm();

    // 3D perspective Camera
    private final PerspectiveCamera camera = new PerspectiveCamera(true);

    //
    // Constants
    //
    private static final double CAMERA_INITIAL_DISTANCE = -450;
    private static final double CAMERA_INITIAL_X_ANGLE = 20.0;
    private static final double CAMERA_INITIAL_Y_ANGLE = 210.0;
    private static final double CAMERA_NEAR_CLIP = 0.1;
    private static final double CAMERA_FAR_CLIP = 10000.0;
    private static final double AXIS_LENGTH = 500.0;
    private static final double CONTROL_MULTIPLIER = 0.1;
    private static final double SHIFT_MULTIPLIER = 10.0;
    private static final double MOUSE_SPEED = 0.1;
    private static final double ROTATION_SPEED = 2.0;
    private static final double TRACK_SPEED = 0.3;
    
    //
    // Positions variables
    //
    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;
    private double mouseDeltaX;
    private double mouseDeltaY;
    
    //
    // Tab panels components
    //
    private final BorderPane main2DPanel = new BorderPane();
    private final TabPane tabPane = new TabPane();   
    private final Tab adminTab = new Tab("Admin");
    private final TablesTab tablesTab = new TablesTab("Tables");
    private final Tab mecaTab = new Tab("Meca");
    private final Tab essaiTab = new Tab("Essai");
    private final Tab sequenceTab = new Tab("Sequence");
    
    // Toolbar components 
    private CheckBox checkBoxDisplayAxes;
    private XpsAngleSpinner spinnerCurrentXAngle;
    private XpsAngleSpinner spinnerCurrentYAngle;
	//private ToolBar toolBar;
          
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

        final Box xAxis = new Box(AXIS_LENGTH, 1, 1);
        final Box yAxis = new Box(1, AXIS_LENGTH, 1);
        final Box zAxis = new Box(1, 1, AXIS_LENGTH);

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
     * buildPanels
     * Tab panels (Tables, meca, ...)
     */
    private void buildPanels() {
       
    	buildAdminTab();
    	
    	// Disable closing panels
    	//tablesTab.setClosable(false);
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
        main2DPanel.setRight(tabPane);
        main2DPanel.setPrefSize(300,300);
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
                    modifier = CONTROL_MULTIPLIER;
                } 
               
                if (se.isShiftDown()) {
                    modifier = SHIFT_MULTIPLIER;
                }  
                
                double z = camera.getTranslateZ();
                double newZ = z + mouseDeltaY * MOUSE_SPEED * modifier;
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
                    modifier = CONTROL_MULTIPLIER;
                } 
                
                if (me.isShiftDown()) {
                    modifier = SHIFT_MULTIPLIER;
                }    
                
                // Left click : rotate scene
                if (me.isPrimaryButtonDown()) {
                	cameraXform.ry.setAngle(cameraXform.ry.getAngle() - mouseDeltaX*MOUSE_SPEED*modifier*ROTATION_SPEED);  
                    cameraXform.rx.setAngle(cameraXform.rx.getAngle() + mouseDeltaY*MOUSE_SPEED*modifier*ROTATION_SPEED);
                    
                    spinnerCurrentXAngle.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 360, cameraXform.rx.getAngle()));
                    spinnerCurrentYAngle.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 360, cameraXform.ry.getAngle()));
                }
                
                // Right click : move scene
                else if (me.isSecondaryButtonDown()) {
                    cameraXform2.t.setX(cameraXform2.t.getX() + mouseDeltaX*MOUSE_SPEED*modifier*TRACK_SPEED);  
                    cameraXform2.t.setY(cameraXform2.t.getY() + mouseDeltaY*MOUSE_SPEED*modifier*TRACK_SPEED);  
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

        camera.setNearClip(CAMERA_NEAR_CLIP);
        camera.setFarClip(CAMERA_FAR_CLIP);
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
        cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
        cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
    }
    
    /**
     * setCurrentSceneOrientation
     * @param centerScene
     * @param xAngle
     * @param yAngle
     * @param distanceFromCamera
     */
    private void setCurrentSceneOrientation(boolean centerScene, double xAngle, double yAngle, double distanceFromCamera) {
    	
    	// Center in th middle of ythe scene
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
        main2DPanel.setCenter(scene3D);
    }
    
    /**
     * buildAdminTab
     */
    private void buildAdminTab() {
    	
    	 Button buttonInitialPosition = new Button("Initial Position");
    	 buttonInitialPosition.setOnAction(e->{
         	// Home zoom/rotation/distance to camera
         	setCurrentSceneOrientation(true, CAMERA_INITIAL_X_ANGLE, CAMERA_INITIAL_Y_ANGLE, CAMERA_INITIAL_DISTANCE);
         	
         	// Reet spinners to default values
         	spinnerCurrentXAngle.setDefaultValueFactory();
         	spinnerCurrentYAngle.setDefaultValueFactory();
         });
         
         // Display axis or not
         checkBoxDisplayAxes = new CheckBox("Display/hide axes");
         checkBoxDisplayAxes.setSelected(true);
         checkBoxDisplayAxes.setOnAction(e->{
         	axisGroup.setVisible(checkBoxDisplayAxes.isSelected());
         });
         
         // Spinners for the current X & Y angle values
         spinnerCurrentXAngle = new XpsAngleSpinner(CAMERA_INITIAL_X_ANGLE);
         spinnerCurrentYAngle = new XpsAngleSpinner(CAMERA_INITIAL_Y_ANGLE);
         
         spinnerCurrentXAngle.valueProperty().addListener(new ChangeListener<Double>() {
 			@Override
 			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
 				setCurrentSceneOrientation(false, Double.valueOf(spinnerCurrentXAngle.getValue().toString()), 
 						Double.valueOf(spinnerCurrentYAngle.getValue().toString()),
 						camera.getTranslateZ());
 			}
 		 });
         
         spinnerCurrentYAngle.valueProperty().addListener(new ChangeListener<Double>() {
  			@Override
  			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
 				setCurrentSceneOrientation(false, Double.valueOf(spinnerCurrentXAngle.getValue().toString()), 
 						Double.valueOf(spinnerCurrentYAngle.getValue().toString()),
 						camera.getTranslateZ());
  			}
  		 });
         
         Label labelXAngle = new Label("X angle");
         Label labelYAngle = new Label("Y angle");

         ToolBar toolBar = new ToolBar(checkBoxDisplayAxes, buttonInitialPosition, labelXAngle, spinnerCurrentXAngle, labelYAngle, spinnerCurrentYAngle);
         toolBar.setOrientation(Orientation.HORIZONTAL);
         
         // Add components in the tables tab
         adminTab.setContent(toolBar);
    }
    
    /**
     * Javafx entry point
     * @param primaryStage the main stage
     */
    @Override
    public void start(Stage primaryStage) {
       
    	// Style sheet
        setUserAgentStylesheet(STYLESHEET_MODENA);

        // Build the left 3D graphical scene
    	buildGraphicalScene();
        
    	// Build the right panels
        buildPanels();
        
        // Create main scene
        Scene mainScene = new Scene(main2DPanel);
        
        // Set mouse handlers
        handleMouse3D(scene3D, world3D);

        // Set scene in the stage and show it
        primaryStage.setTitle("Sample shapes in a 3D environment");
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
