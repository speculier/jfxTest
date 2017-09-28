package com.gbcs.XPSPositioner.form;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gbcs.XPSPositioner.enumeration.MoveAxe;
import com.gbcs.XPSPositioner.enumeration.MoveSign;
import com.gbcs.XPSPositioner.panel.GabiView;
import com.gbcs.XPSPositioner.parameters.GabiParameters;
import com.gbcs.XPSPositioner.util.Constants;

import javafx.event.EventHandler;
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
	private static final Logger logger = LogManager.getLogger(MainGraphicalForm.class);
	
	private Group root3D;
	private SubScene scene3D;
	private GabiView mainGabiView;

    // Axis groups: contains the 3 axis X, Y and Z
	private final XForm mainAxisGroup = new XForm();
	private final XForm m1AxisGroup = new XForm();
	private final XForm m2AxisGroup = new XForm();
	private final XForm oIntPointAxisGroup = new XForm();
	
	// Camera groups
	private final XForm cameraXform = new XForm();
	private final XForm cameraXform2 = new XForm();
    private final XForm cameraXform3 = new XForm();
    
    // Shapes groups
    private final XForm shapesGroup = new XForm();
 	private final XForm translationTable1Group = new XForm();
 	private final XForm translationTable2Group = new XForm();
 	private final XForm sphereM1Group = new XForm();
 	private final XForm sphereM2Group = new XForm();  
 	private final XForm gabiGroup = new XForm();
 	private final XForm telescopeGroup = new XForm();
 	private final XForm m1Group = new XForm();
 	private final XForm m2Group = new XForm();
 	
 	// Reference point
 	private ReferencePoint mainReferencePoint = new ReferencePoint(0, 0, 0);
 	private ReferencePoint m1ReferencePoint = new ReferencePoint(GabiParameters.getInstance().getGabiDataParameters().getMirror1_X(), 
 			GabiParameters.getInstance().getGabiDataParameters().getMirror1_Y(), 0);
 	private ReferencePoint m2ReferencePoint = new ReferencePoint(GabiParameters.getInstance().getGabiDataParameters().getMirror2_X(), 
 			GabiParameters.getInstance().getGabiDataParameters().getMirror2_Y(), 0);
 
 	// Shapes
    private Cylinder telescopeCylinder = new Cylinder(GabiParameters.getInstance().getGabiDataParameters().getCylinderRadius(),
    		GabiParameters.getInstance().getGabiDataParameters().getCylinderHeight());
    private Sphere patellaM1 = new Sphere(GabiParameters.getInstance().getGabiDataParameters().getPatellaRadius());
    private Sphere patellaM2 = new Sphere(GabiParameters.getInstance().getGabiDataParameters().getPatellaRadius());
    public Box translationTableM1 = new Box(GabiParameters.getInstance().getGabiDataParameters().getTableWidth(), 
    		GabiParameters.getInstance().getGabiDataParameters().getTableHeight(), 
    		GabiParameters.getInstance().getGabiDataParameters().getTableDepth());
    private Box translationTableM2 = new Box(GabiParameters.getInstance().getGabiDataParameters().getTableWidth(), 
    		GabiParameters.getInstance().getGabiDataParameters().getTableHeight(), 
    		GabiParameters.getInstance().getGabiDataParameters().getTableDepth());
    private Cylinder m1Cylinder = new Cylinder(GabiParameters.getInstance().getGabiDataParameters().getMirror1Radius(),
    		GabiParameters.getInstance().getGabiDataParameters().getMirror1Height());
    private Cylinder m2Cylinder = new Cylinder(GabiParameters.getInstance().getGabiDataParameters().getMirror2Radius(),
    		GabiParameters.getInstance().getGabiDataParameters().getMirror2Height());
    // 3D perspective Camera
    private final PerspectiveCamera camera = new PerspectiveCamera(true);
    
    // Mouse positions variables
    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;
    private double mouseDeltaX;
    private double mouseDeltaY;
    
    //new Color(1,1,1,0.6)
    
    // Materials
    private final PhongMaterial bodyTelescopeCylinderMaterial = new PhongMaterial(new Color(0.2,0.2,0.2,0.1));
    private final PhongMaterial baseSphereMaterial = new PhongMaterial(Color.WHITE);
    private final PhongMaterial translationTableMaterial = new PhongMaterial(Color.DARKBLUE);
    private final PhongMaterial mirrorsMaterial = new PhongMaterial(Color.BLUEVIOLET);

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
    
    /**
     * getM1AxisGroup
     * @return
     */
    public XForm getM1AxisGroup() {
    	return m1AxisGroup;
    }
    
    /**
     * getMainReferencePoint
     * @return
     */
    public ReferencePoint getMainReferencePoint() {
    	return mainReferencePoint;
    }
    
    /**
     * getM1ReferencePoint
     * @return
     */
    public ReferencePoint getM1ReferencePoint() {
    	return m1ReferencePoint;
    }
    
    /**
     * getM2ReferencePoint
     * @return
     */
    public ReferencePoint getM2ReferencePoint() {
    	return m2ReferencePoint;
    }
    
    /**
     * getM2ReferencePoint
     * @return
     */
  /*  public ReferencePoint getOintReferencePoint() {
    	return oReferencePoint;
    }
    
    */
    /**
     * getTranslationTable1Group
     * @return
     */
	public XForm getTranslationTable1Group() {
		return translationTable1Group;
	}

	/**
	 * getTranslationTable2Group
	 * @return
	 */
	public XForm getTranslationTable2Group() {
		return translationTable2Group;
	}

	/**
	 * getSphereM1Group
	 * @return
	 */
	public XForm getSphereM1Group() {
		return sphereM1Group;
	}

	/**
	 * getSphereM2Group
	 * @return
	 */
	public XForm getSphereM2Group() {
		return sphereM2Group;
	}

	/**
	 * getTelescopeGroup
	 * @return
	 */
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
    	scene3D = new SubScene(root3D, 800, 600, true, SceneAntialiasing.BALANCED);
        scene3D.setFill(Color.GREY);
        scene3D.setCamera(camera);
        
        // Set mouse handlers
        handleMouse3D(scene3D, this);

	    // Build camera group
        buildCameras();
        
        // Build reference group
        buildReferences();
        
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
     * doRelativeTableTranslation
     * @param axe
     * @param value
     */
    public void doAbsoluteTableTranslation(MoveAxe axe, double value) {
		switch (axe) {
		case X1:
			getTranslationTable1Group().setTx(value);
			break;
		case X2:
			getTranslationTable2Group().setTx(value);
			break;
		case Y1:
			getTranslationTable1Group().setTy(value);
			break;	
		case Y2:
			getTranslationTable2Group().setTy(value);
			break;					
		}
    }
    
    /**
     * doRelativeTableTranslation
     * @param axe
     * @param sign
     * @param value
     */
    public void doRelativeTableTranslation(MoveAxe axe, MoveSign sign, double value) {

		double initialTranslateValue = 0;
		double initialRotateValue = getTelescopeGroup().getRz();

    	// Rotate telescope
    	switch (GabiParameters.getInstance().getGabiDataParameters().getRotationCenter()) {
		case NEAR_M2_PATELLA:
			getTelescopeGroup().setZRotationPivot(patellaM2.getTranslateX(), patellaM2.getTranslateY(), patellaM2.getTranslateZ());
			getTelescopeGroup().setRz((sign == MoveSign.MOVE_MINE) ? (initialRotateValue - 10) : (initialRotateValue + 10));
			break;	
		case NEAR_MIDDLE_OF_M1M2:
			getTelescopeGroup().setZRotationPivot(patellaM1.getTranslateX(), patellaM1.getTranslateY(), patellaM1.getTranslateZ());
			getTelescopeGroup().setRz((sign == MoveSign.MOVE_MINE) ? (initialRotateValue - 10) : (initialRotateValue + 10));
			break;	
		case VIRTUAL_PATELLA_UNDER_M1:
			getTelescopeGroup().setZRotationPivot(patellaM1.getTranslateX(), patellaM1.getTranslateY(), patellaM1.getTranslateZ());
			getTelescopeGroup().setRz((sign == MoveSign.MOVE_MINE) ? (initialRotateValue - 10) : (initialRotateValue + 10));
			break;	
    	}
    	
    	// Translate table
		switch (axe) {
		case X1:
			initialTranslateValue = getTranslationTable1Group().getTx();
	    	getTranslationTable1Group().setTx((sign == MoveSign.MOVE_MINE) ? (initialTranslateValue - value) : (initialTranslateValue + value));
	    	break;
		case X2:
			initialTranslateValue = getTranslationTable2Group().getTx();
			getTranslationTable2Group().setTx((sign == MoveSign.MOVE_MINE) ? (initialTranslateValue - value) : (initialTranslateValue + value));
			break;
		case Y1:
			initialTranslateValue = getTranslationTable1Group().getTy();
			getTranslationTable1Group().setTy((sign == MoveSign.MOVE_MINE) ? (initialTranslateValue - value) : (initialTranslateValue + value));
			break;	
		case Y2:
			initialTranslateValue = getTranslationTable2Group().getTy();
			getTranslationTable2Group().setTy((sign == MoveSign.MOVE_MINE) ? (initialTranslateValue - value) : (initialTranslateValue + value));
			break;	
		}
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
     * buildReferences
     */
    private void buildReferences() {

        // Add the axes in the 'axis' group
        mainAxisGroup.getChildren().add(mainReferencePoint);
         
        // Add the 'axis' group in the 'world3D' group
        getChildren().add(mainAxisGroup);
    }

    /**
     * buildShapes
     */
    private void buildShapes() {

    	buildTranslationTables();
    	
    	buildPalettas();
    	
    	buildTelescope();
    	
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
     * buildTelescope
     */
    private void buildTelescope() {
    	
    	// Axes
        m1AxisGroup.getChildren().add(m1ReferencePoint);
        m2AxisGroup.getChildren().add(m2ReferencePoint);
        
    	// Mirrors
    	m1Cylinder.setMaterial(mirrorsMaterial);
    	m1Cylinder.setRotationAxis(Rotate.Z_AXIS);
    	m1Cylinder.setRotate(90);
    	m1Cylinder.setTranslateX(GabiParameters.getInstance().getGabiDataParameters().getMirror1_X());
    	m1Cylinder.setTranslateY(GabiParameters.getInstance().getGabiDataParameters().getMirror2_Y());
    	
    	m2Cylinder.setMaterial(mirrorsMaterial);
    	m2Cylinder.setRotationAxis(Rotate.Z_AXIS);
    	m2Cylinder.setRotate(90);
    	m2Cylinder.setTranslateX(GabiParameters.getInstance().getGabiDataParameters().getMirror2_X());
    	m2Cylinder.setTranslateY(GabiParameters.getInstance().getGabiDataParameters().getMirror2_Y());
    
    	m1Group.getChildren().add(m1Cylinder);
    	m1Group.getChildren().add(m1AxisGroup);
    	m2Group.getChildren().add(m2Cylinder);
    	m2Group.getChildren().add(m2AxisGroup);
        
        // Telescope body cylinder     
    	bodyTelescopeCylinderMaterial.setSpecularColor(Color.TRANSPARENT);
        telescopeCylinder.setMaterial(bodyTelescopeCylinderMaterial);
        telescopeCylinder.setRotationAxis(Rotate.Z_AXIS);
        telescopeCylinder.setRotate(90);
        telescopeCylinder.setTranslateX((GabiParameters.getInstance().getGabiDataParameters().getCylinderHeight() / 2) - (GabiParameters.getInstance().getGabiDataParameters().getTableWidth() / 2));
        telescopeCylinder.setTranslateY(GabiParameters.getInstance().getGabiDataParameters().getCylinderY());
 
        // Add shapes in each group
        telescopeGroup.getChildren().add(telescopeCylinder);
        telescopeGroup.getChildren().add(m1Group);
        telescopeGroup.getChildren().add(m2Group);
    }
    
    /**
     * buildPalettas
     */
    private void buildPalettas() {
    	
        baseSphereMaterial.setSpecularColor(Color.LIGHTBLUE);

        // M1 and M2 spheres
        patellaM1.setMaterial(baseSphereMaterial);
        patellaM2.setMaterial(baseSphereMaterial);
        
        patellaM1.setTranslateX(GabiParameters.getInstance().getGabiDataParameters().getPatella1_X());
        patellaM1.setTranslateY(GabiParameters.getInstance().getGabiDataParameters().getPatella1_Y());
        patellaM2.setTranslateX(GabiParameters.getInstance().getGabiDataParameters().getPatella2_X());
        patellaM2.setTranslateY(GabiParameters.getInstance().getGabiDataParameters().getPatella2_Y());

        sphereM1Group.getChildren().add(patellaM1);
        sphereM2Group.getChildren().add(patellaM2);
    }
    
    /**
     * buildTranslationTables
     */
    private void buildTranslationTables() {
    	
        translationTableMaterial.setSpecularColor(Color.BLUE);
        
        translationTableM1.setMaterial(translationTableMaterial);
        translationTableM2.setMaterial(translationTableMaterial);
        
        translationTableM1.setTranslateX(GabiParameters.getInstance().getGabiDataParameters().getTable1_X());
        translationTableM1.setTranslateY(GabiParameters.getInstance().getGabiDataParameters().getTable1_Y());
        translationTableM2.setTranslateX(GabiParameters.getInstance().getGabiDataParameters().getTable2_X());
        translationTableM2.setTranslateY(GabiParameters.getInstance().getGabiDataParameters().getTable2_Y());
        
        translationTable1Group.getChildren().add(translationTableM1);
        translationTable2Group.getChildren().add(translationTableM2);
    }
}
