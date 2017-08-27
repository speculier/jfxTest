package com.gbcs.XPSPositioner.form;

import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.panel.GabiView;
import com.gbcs.XPSPositioner.util.Constants;

import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

/**
 * MainGraphicalForm
 * @author Sébastien
 *
 */
public class MainGraphicalForm extends XForm {

	// Logger
	private static final Logger logger = Logger.getLogger(MainGraphicalForm.class);
	
	private Group root3D;
	private SubScene scene3D;
	private GabiView mainGabiView;
		
    // Axis group: contains the 3 axis X, Y and Z
	private final XForm axisGroup = new XForm();
    	
	private final XForm cameraXform = new XForm();
	private final XForm cameraXform2 = new XForm();
    private final XForm cameraXform3 = new XForm();
    
    // Shapes and group
  	public final XForm shapesGroup = new XForm();
 	private final XForm translationTable1Group = new XForm();
 	private final XForm translationTable2Group = new XForm();
 	private final XForm sphereM1Group = new XForm();
 	private final XForm sphereM2Group = new XForm();  
 	private final XForm gabiGroup = new XForm();
 	private final XForm telescopeGroup = new XForm();
 	
    // 3D perspective Camera
    private final PerspectiveCamera camera = new PerspectiveCamera(true);
    
    // Positions variables
    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;
    private double mouseDeltaX;
    private double mouseDeltaY;
    
    // Materials
    private final PhongMaterial bodyTelescopeCylinderMaterial = new PhongMaterial(Color.DARKRED);
    private final PhongMaterial baseSphereMaterial = new PhongMaterial(Color.WHITE);
    private final PhongMaterial translationTableMaterial = new PhongMaterial(Color.DARKBLUE);
    		
    /**
     * getAxisGroup
     * @return
     */
    public XForm getAxisGroup() {
    	return axisGroup;
    }
    
    /**
     * getSubScene
     * @return
     */
    public SubScene getSubScene() {
    	return scene3D;
    }
    
    /**
     * getPerspectiveCamera
     * @return PerspectiveCamera
     */
    public PerspectiveCamera getPerspectiveCamera() {
    	return camera;
    }
    
    /**
     * getGabiView
     * @return GabiView
     */
    public GabiView getGabiView() {
    	return mainGabiView;
    }
    
	public XForm getTranslationTable1Group() {
		return translationTable1Group;
	}

	public XForm getTranslationTable2Group() {
		return translationTable2Group;
	}

	public XForm getSphereM1Group() {
		return sphereM1Group;
	}

	public XForm getSphereM2Group() {
		return sphereM2Group;
	}

	public XForm getTelescopeGroup() {
		return telescopeGroup;
	}
       
	/**
	 * MainGraphicalForm
	 */
	public MainGraphicalForm(Group root, GabiView view) {
		
		root3D = root;
		mainGabiView = view;
		
        // Create 3D scene GREY with the root group
    	scene3D = new SubScene(root3D, 1100, 900, true, SceneAntialiasing.BALANCED);
        scene3D.setFill(Color.GREY);
        scene3D.setCamera(camera);
        
        // Set mouse handlers
        handleMouse3D(scene3D, this);

	    // Build camera group
        buildCameras();
        
        // Build Axis group
        buildAxes();
        
        // Build 3D shapes
        buildShapes();
        
        // Set initial scene orientation
        setCurrentSceneOrientation(true, Constants.CAMERA_INITIAL_X_ANGLE, Constants.CAMERA_INITIAL_Y_ANGLE, Constants.CAMERA_INITIAL_DISTANCE);
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
                    
                    getGabiView().getAdminTab().setXAngleSpinnerValue(cameraXform.rx.getAngle());
                    getGabiView().getAdminTab().setYAngleSpinnerValue(cameraXform.ry.getAngle());
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
     * setCurrentSceneOrientation
     * @param centerScene
     * @param xAngle
     * @param yAngle
     * @param distanceFromCamera
     */
    public void setCurrentSceneOrientation(boolean centerScene, double xAngle, double yAngle, double distanceFromCamera) {
    	
    	// Do not center in the middle of the scene, center with main shapes
    	if (centerScene) {
    		cameraXform2.t.setX(Constants.CAMERA_INITIAL_X_POSITION);
    		cameraXform2.t.setY(Constants.CAMERA_INITIAL_Y_POSITION);
    	}
    	
    	// Set distance from camera and the scene
        camera.setTranslateZ(distanceFromCamera);
        
        // Rotate the scene
        cameraXform.ry.setAngle(yAngle);
        cameraXform.rx.setAngle(xAngle);
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

        final Box xAxis = new Box(1, Constants.AXIS_LENGTH, 1);
        final Box yAxis = new Box(Constants.AXIS_LENGTH, 1, 1);
        final Box zAxis = new Box(1, 1, Constants.AXIS_LENGTH);

        xAxis.setMaterial(greenMaterial);
        yAxis.setMaterial(redMaterial);
        zAxis.setMaterial(blueMaterial);

        // Add the axes in the 'axis' group
        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
        
        // Add the 'axis' group in the 'world3D' group
        getChildren().addAll(axisGroup);
    }

    /**
     * buildShapes
     */
    private void buildShapes() {

    	buildTranslationTables();
    	
    	buildPalettas();
    	
    	buildCylinder();
    	 
        // Add base forms group in the groups
        gabiGroup.getChildren().add(telescopeGroup);
        gabiGroup.getChildren().add(sphereM1Group);
        gabiGroup.getChildren().add(sphereM2Group);
        gabiGroup.getChildren().add(translationTable1Group);
        gabiGroup.getChildren().add(translationTable2Group);
        
        // Add the gabi form in the 'shapes' group
        shapesGroup.getChildren().add(gabiGroup);

        // Add the 'main shapes' group in the 'world3D' group
        getChildren().addAll(shapesGroup);
    }
    
    /**
     * buildCylinder
     */
    private void buildCylinder() {
    	
    	// Materials
        bodyTelescopeCylinderMaterial.setSpecularColor(Color.RED);
 
        // Cylinder
        Cylinder telescopeCylinder = new Cylinder(40.0,140.0);
        telescopeCylinder.setMaterial(bodyTelescopeCylinderMaterial);
        telescopeCylinder.setRotationAxis(Rotate.Z_AXIS);
        telescopeCylinder.setRotate(100.0);
        telescopeCylinder.setTranslateY(107);
        telescopeCylinder.setTranslateX(62);
        
        // Add shapes in each group
        telescopeGroup.getChildren().add(telescopeCylinder);
    }
    
    /**
     * buildPalettas
     */
    private void buildPalettas() {
    	
        baseSphereMaterial.setSpecularColor(Color.LIGHTBLUE);

        // M1 and M2 spheres
        Sphere patellaM1 = new Sphere(3.0);
        patellaM1.setMaterial(baseSphereMaterial);
        Sphere patellaM2 = new Sphere(3.0);
        patellaM2.setMaterial(baseSphereMaterial);
        
        sphereM1Group.getChildren().add(patellaM1);
        sphereM2Group.getChildren().add(patellaM2);
        patellaM1.setTranslateY(53);
        patellaM2.setTranslateY(76);
        patellaM2.setTranslateX(135);
    }
    
    /**
     * buildTranslationTables
     */
    private void buildTranslationTables() {
    	
        translationTableMaterial.setSpecularColor(Color.BLUE);
        
        Box translationTableM1 = new Box(5, 100, 40);
        translationTableM1.setMaterial(translationTableMaterial);
        Box translationTableM2 = new Box(5, 100, 40);
        translationTableM2.setMaterial(translationTableMaterial);
        translationTableM2.setTranslateY(23);
        translationTableM2.setTranslateX(135);
        
        translationTable1Group.getChildren().add(translationTableM1);
        translationTable2Group.getChildren().add(translationTableM2);
    }
}
