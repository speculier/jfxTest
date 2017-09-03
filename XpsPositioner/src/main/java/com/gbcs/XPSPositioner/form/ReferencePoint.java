package com.gbcs.XPSPositioner.form;

import com.gbcs.XPSPositioner.util.Constants;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;

/**
 * OIntPoint
 * @author Sébastien
 *
 */
public class ReferencePoint extends XForm {
  
	private OrthogonalAxes axes;
	private OrthogonalArrows arrows;
	private Sphere referencePoint;
	
	/**
	 * OIntPoint ctor
	 * @param xReference
	 * @param yReference
	 * @param zReference
	 */
	public ReferencePoint(double x, double y, double z) {
		
		axes = new OrthogonalAxes(x, y, z);
		arrows = new OrthogonalArrows(x, y, z);
		referencePoint = new Sphere(Constants.REFERENCE_POINT_RADIUS);

        // Add the axes in the 'axis' group
        getChildren().addAll(axes, arrows, referencePoint);
	}
	
	/**
	 * isAxesVisible
	 * @return
	 */
	public boolean isAxesVisible() {
		return axes.isVisible();
	}

	/**
	 * setAxesVisible
	 * @param showAxes
	 */
	public void setAxesVisible(boolean showAxes) {
		axes.setVisible(showAxes);
	}

	/**
	 * isArrowsVisible
	 * @return
	 */
	public boolean isArrowsVisible() {
		return arrows.isVisible();
	}

	/**
	 * setArrowsVisible
	 * @param showArrows
	 */
	public void setArrowsVisible(boolean showArrows) {
		arrows.setVisible(showArrows);
	}

	/**
	 * isCenterPointVisible
	 * @return
	 */
	public boolean isCenterPointVisible() {
		return referencePoint.isVisible();
	}

	/**
	 * setCenterPointVisible
	 * @param showCenterPoint
	 */
	public void setCenterPointVisible(boolean showCenterPoint) {
		referencePoint.setVisible(showCenterPoint);
	}
}
