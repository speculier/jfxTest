package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.TargetTypeOfAlignment;

/**
 * MoveTargetPositonData
 * @author Sébastien
 *
 */
public class MoveTargetPositionData {

	private double moveX;
	private double moveY;	
	private double moveZ;
	private TargetTypeOfAlignment targetTypeOfAlignment;
	
	/**
	 * MoveTargetPositonData ctor
	 * @param x
	 * @param y
	 * @param z
	 * @param type
	 * 
	 */
	public MoveTargetPositionData(double x, double y, double z, TargetTypeOfAlignment type) {
		moveX = x;
		moveY = y;
		moveZ = z;
		targetTypeOfAlignment = type;
	}
	
	@Override
	public String toString() {
		return "A (" + moveX + "," + moveY + "," + moveZ + "), target alignement: '" + targetTypeOfAlignment + "'";
	}
}
