package com.gbcs.XPSPositioner.data;

/**
 * AbsoluteTablePositionData
 * @author Sébastien
 *
 */
public class AbsoluteTablePositionData {

	private double xM1;
	private double xM2;
	private double yM1;
	private double yM2;
	
	/**
	 * AbsoluteTablePositionData ctor
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 */
	public AbsoluteTablePositionData(double x1, double x2, double y1, double y2) {
		xM1 = x1;
		xM2 = x2;
		yM1 = y1;
		yM2 = y2;
	}
	
	@Override
	public String toString() {
		return "P " + xM1 + " " + yM1 + " " + xM2 + " " + yM2;
	}
}
