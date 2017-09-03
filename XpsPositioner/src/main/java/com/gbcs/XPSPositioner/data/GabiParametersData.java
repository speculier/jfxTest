package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.RotationCenter;

/**
 * GabiParametersData
 * @author Sébastien
 *
 */
public class GabiParametersData {

	private double cylinderRadius;
	private double cylinderHeight;
	private double cylinderZAngle;
	private double cylinderX;
	private double cylinderY;
	private double patellaRadius;
	private double patella1_X;
	private double patella1_Y;
	private double patella2_X;
	private double patella2_Y;
	private double tableWidth;
	private double tableHeight;;
	private double tableDepth;
	private double table1_X;
	private double table1_Y;
	private double table2_X;
	private double table2_Y;
	private RotationCenter rotationCenter;
	
	public RotationCenter getRotationCenter() {
		return rotationCenter;
	}

	public void setRotationCenter(RotationCenter rotationCenter) {
		this.rotationCenter = rotationCenter;
	}

	public double getPatella1_X() {
		return patella1_X;
	}

	public void setPatella1_X(double patella1_X) {
		this.patella1_X = patella1_X;
	}

	public double getPatella1_Y() {
		return patella1_Y;
	}

	public void setPatella1_Y(double patella1_Y) {
		this.patella1_Y = patella1_Y;
	}

	public double getPatella2_X() {
		return patella2_X;
	}

	public void setPatella2_X(double patella2_X) {
		this.patella2_X = patella2_X;
	}

	public double getPatella2_Y() {
		return patella2_Y;
	}

	public void setPatella2_Y(double patella2_Y) {
		this.patella2_Y = patella2_Y;
	}
	
	public double getPatellaRadius() {
		return patellaRadius;
	}

	public void setPatellaRadius(double patellaRadius) {
		this.patellaRadius = patellaRadius;
	}
	
	public double getCylinderX() {
		return cylinderX;
	}

	public void setCylinderX(double cylinderX) {
		this.cylinderX = cylinderX;
	}
	
	public double getCylinderY() {
		return cylinderY;
	}

	public void setCylinderY(double cylinderY) {
		this.cylinderY = cylinderY;
	}

	/**
	 * setCylinderRadius
	 * @param cylinderDiameter
	 */
	public void setCylinderRadius(double cylinderRadius) {
		this.cylinderRadius = cylinderRadius;
	}

	/**
	 * setCylinderHeight
	 * @param cylinderHeight
	 */
	public void setCylinderHeight(double cylinderHeight) {
		this.cylinderHeight = cylinderHeight;
	}

	/**
	 * setCylinderZAngle
	 * @param cylinderZAngle
	 */
	public void setCylinderZAngle(double cylinderZAngle) {
		this.cylinderZAngle = cylinderZAngle;
	}

	/**
	 * getCylinderRadius
	 * @return
	 */
	public double getCylinderRadius() {
		return cylinderRadius;
	}

	/**
	 * getCylinderHeight
	 * @return
	 */
	public double getCylinderHeight() {
		return cylinderHeight;
	}
	
	/**
	 * getCylinderZAngle
	 * @return
	 */
	public double getCylinderZAngle() {
		return cylinderZAngle;
	}

	public double getTableWidth() {
		return tableWidth;
	}

	public void setTableWidth(double tableWidth) {
		this.tableWidth = tableWidth;
	}

	public double getTableHeight() {
		return tableHeight;
	}

	public void setTableHeight(double tableHeight) {
		this.tableHeight = tableHeight;
	}

	public double getTableDepth() {
		return tableDepth;
	}

	public void setTableDepth(double tableDepth) {
		this.tableDepth = tableDepth;
	}

	public double getTable1_X() {
		return table1_X;
	}

	public void setTable1_X(double table1_X) {
		this.table1_X = table1_X;
	}

	public double getTable1_Y() {
		return table1_Y;
	}

	public void setTable1_Y(double table1_Y) {
		this.table1_Y = table1_Y;
	}

	public double getTable2_X() {
		return table2_X;
	}

	public void setTable2_X(double table2_X) {
		this.table2_X = table2_X;
	}

	public double getTable2_Y() {
		return table2_Y;
	}

	public void setTable2_Y(double table2_Y) {
		this.table2_Y = table2_Y;
	}
	
	/**
	 * setDefaultParameters
	 */
	public void setDefaultParameters() {
		cylinderRadius = 40.0;
		cylinderHeight = 140.0;
		cylinderZAngle = 100.0;
		cylinderX = 62.0;
		cylinderY = 107.0;
		patellaRadius = 3.0;
		patella1_X=0.0;
		patella1_Y=53.0;
		patella2_X=135.0;
		patella2_Y=76.0;
		tableWidth=5.0;
		tableHeight=100.0;
		tableDepth=40.0;
		table1_X=0.0;
		table1_Y=0.0;
		table2_X=135.0;
		table2_Y=23.0;
	}
}
