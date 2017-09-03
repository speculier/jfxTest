package com.gbcs.XPSPositioner.form;

import com.gbcs.XPSPositioner.form.cone.Cone;
import com.gbcs.XPSPositioner.util.Constants;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;

/**
 * OrthogonalArrows
 * @author Sébastien
 *
 */
public class OrthogonalArrows extends XForm {
    
	private Cone xArrayCone = new Cone(200, Constants.ARROW_CONE_RADIUS, Constants.ARROW_CONE_LENGTH);
	private Cone yArrayCone = new Cone(200, Constants.ARROW_CONE_RADIUS, Constants.ARROW_CONE_LENGTH);
	private Cone zArrayCone = new Cone(200, Constants.ARROW_CONE_RADIUS, Constants.ARROW_CONE_LENGTH);
	
	private Cylinder xArrow = new Cylinder(Constants.ARROW_RADIUS, Constants.ARROW_LENGTH);
	private Cylinder yArrow = new Cylinder(Constants.ARROW_RADIUS, Constants.ARROW_LENGTH);
	private Cylinder zArrow = new Cylinder(Constants.ARROW_RADIUS, Constants.ARROW_LENGTH);
    
	private PhongMaterial redMaterial = new PhongMaterial(Color.DARKRED);
	private PhongMaterial greenMaterial = new PhongMaterial(Color.DARKGREEN);
	private PhongMaterial blueMaterial = new PhongMaterial(Color.DARKBLUE);
	
	/**
	 * OrthogonalArrows ctor
	 * @param xReference
	 * @param yReference
	 * @param zReference
	 */
	public OrthogonalArrows(double xReference, double yReference, double zReference) {

		// Cones
		xArrayCone.setTranslateX(Constants.ARROW_LENGTH + (Constants.ARROW_CONE_LENGTH / 2));
		xArrayCone.setTranslateY(-(Constants.ARROW_CONE_LENGTH / 2));
		xArrayCone.setRotationAxis(Rotate.Z_AXIS);
		xArrayCone.setRotate(90);
		xArrayCone.setMaterial(redMaterial);
        
		yArrayCone.setTranslateY(Constants.ARROW_LENGTH);
		yArrayCone.setRotationAxis(Rotate.Z_AXIS);
		yArrayCone.setRotate(180);
		yArrayCone.setMaterial(greenMaterial);
		
		zArrayCone.setTranslateZ(Constants.ARROW_LENGTH + (Constants.ARROW_CONE_LENGTH / 2) );
		zArrayCone.setTranslateY(-(Constants.ARROW_CONE_LENGTH / 2));
		zArrayCone.setRotationAxis(Rotate.X_AXIS);
		zArrayCone.setRotate(-90);
		zArrayCone.setMaterial(blueMaterial);
		
		// Arrays
        xArrow.setTranslateX(Constants.ARROW_LENGTH / 2);
        xArrow.setRotationAxis(Rotate.Z_AXIS);
        xArrow.setRotate(90);
        xArrow.setMaterial(redMaterial);
        
        yArrow.setTranslateY(Constants.ARROW_LENGTH / 2);
        yArrow.setMaterial(greenMaterial);
        
        zArrow.setTranslateZ(Constants.ARROW_LENGTH / 2);
        zArrow.setRotationAxis(Rotate.X_AXIS);
        zArrow.setRotate(90);
        zArrow.setMaterial(blueMaterial);

        // Add the axes in the 'axis' group
        getChildren().addAll(xArrayCone, yArrayCone, zArrayCone, xArrow, yArrow, zArrow);
	}
}
