package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.RotationCenter;

/**
 * GabiParametersData
 * @author Sébastien
 *
 */
public class GabiParametersData {

	private String pwd;
	private double cylinderRadius;
	private double cylinderHeight;
	private double cylinderY;
	private double mirror1Radius;
	private double mirror1Height;
	private double mirror1_X;
	private double mirror1_Y;
	private double mirror2Radius;
	private double mirror2Height;
	private double mirror2_X;
	private double mirror2_Y;
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
	
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public RotationCenter getRotationCenter() {
		return rotationCenter;
	}

	public void setRotationCenter(RotationCenter rotationCenter) {
		this.rotationCenter = rotationCenter;
	}
	
	public double getMirror1Radius() {
		return mirror1Radius;
	}

	public void setMirror1Radius(double mirror1Radius) {
		this.mirror1Radius = mirror1Radius;
	}

	public double getMirror1Height() {
		return mirror1Height;
	}

	public void setMirror1Height(double mirror1Height) {
		this.mirror1Height = mirror1Height;
	}

	public double getMirror1_X() {
		return mirror1_X;
	}

	public void setMirror1_X(double mirror1_X) {
		this.mirror1_X = mirror1_X;
	}

	public double getMirror1_Y() {
		return mirror1_Y;
	}

	public void setMirror1_Y(double mirror1_Y) {
		this.mirror1_Y = mirror1_Y;
	}

	public double getMirror2Radius() {
		return mirror2Radius;
	}

	public void setMirror2Radius(double mirror2Radius) {
		this.mirror2Radius = mirror2Radius;
	}

	public double getMirror2Height() {
		return mirror2Height;
	}

	public void setMirror2Height(double mirror2Height) {
		this.mirror2Height = mirror2Height;
	}

	public double getMirror2_X() {
		return mirror2_X;
	}

	public void setMirror2_X(double mirror2_X) {
		this.mirror2_X = mirror2_X;
	}

	public double getMirror2_Y() {
		return mirror2_Y;
	}

	public void setMirror2_Y(double mirror2_Y) {
		this.mirror2_Y = mirror2_Y;
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
		pwd = "d5367bacb1bffc74dd5d119786101518";
		cylinderRadius = 40.0;
		cylinderHeight = 140.0;
		cylinderY = 107.0;
		mirror1Radius=30.0;
		mirror1Height=10.0;
		mirror1_X=62.0;
		mirror1_Y=146.0;
		mirror2Radius=20.0;
		mirror2Height=10.0;
		mirror2_X=62.0;
		mirror2_Y=146.0;
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
