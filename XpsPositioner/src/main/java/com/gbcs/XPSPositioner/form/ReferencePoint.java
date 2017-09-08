package com.gbcs.XPSPositioner.form;

import com.gbcs.XPSPositioner.util.Constants;

import javafx.scene.shape.Sphere;

/**
 * ReferencePoint
 * @author Sébastien
 *
 */
public class ReferencePoint extends XForm {
  
	private OrthogonalAxes axes;
	private OrthogonalArrows arrows;
	private Sphere referencePoint;
	
	/**
	 * ReferencePoint ctor
	 * @param x
	 * @param y
	 * @param z
	 */
	public ReferencePoint(double x, double y, double z) {
		
		axes = new OrthogonalAxes(x, y, z);
		arrows = new OrthogonalArrows(x, y, z);
		referencePoint = new Sphere(Constants.REFERENCE_POINT_RADIUS);

        // Translate reference
        axes.setTranslate(x, y, z);
        arrows.setTranslate(x, y, z);
        
        System.out.println("x=" + referencePoint.getTranslateX());
        System.out.println("y=" + referencePoint.getTranslateY());
        System.out.println("z=" + referencePoint.getTranslateZ());
        
        referencePoint.setTranslateX(x);
        referencePoint.setTranslateY(y);
        referencePoint.setTranslateZ(z);
        
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
	
	/**
	 * getX
	 */
	public double getX() {
		return referencePoint.getTranslateX();
	}
}
