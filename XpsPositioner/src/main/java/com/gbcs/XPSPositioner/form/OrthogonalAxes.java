package com.gbcs.XPSPositioner.form;

import com.gbcs.XPSPositioner.util.Constants;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;

/**
 * OrthogonalAxes
 * @author Sébastien
 *
 */
public class OrthogonalAxes extends XForm {

	private Cylinder xAxis;
	private Cylinder yAxis;
	private Cylinder zAxis;

	private PhongMaterial redMaterial = new PhongMaterial(Color.DARKRED);
	private PhongMaterial greenMaterial = new PhongMaterial(Color.DARKGREEN);
	private PhongMaterial blueMaterial = new PhongMaterial(Color.DARKBLUE);
    
	/**
	 * OrthogonalAxes ctor
	 * @param xReference
	 * @param yReference
	 * @param zReference
	 */
	public OrthogonalAxes(double xReference, double yReference, double zReference) {

        xAxis = new Cylinder(Constants.AXIS_RADIUS, Constants.AXIS_LENGTH);
        xAxis.setRotationAxis(Rotate.Z_AXIS);
        xAxis.setRotate(90);
        xAxis.setMaterial(redMaterial);
        
        yAxis = new Cylinder(Constants.AXIS_RADIUS, Constants.AXIS_LENGTH);
        yAxis.setMaterial(greenMaterial);
        
        zAxis = new Cylinder(Constants.AXIS_RADIUS, Constants.AXIS_LENGTH);
        zAxis.setRotationAxis(Rotate.X_AXIS);
        zAxis.setRotate(90);
        zAxis.setMaterial(blueMaterial);

        // Add the axes in the 'axis' group
        getChildren().addAll(xAxis, yAxis, zAxis);
	}
}
