package com.gbcs.XPSPositioner.data;

/**
 * SpeedData
 * @author Sébastien
 *
 */
public class SpeedData {

	private double xM1Speed;
	private double yM1Speed;
	private double xM2Speed;
	private double yM2Speed;
	
	/**
	 * SpeedData
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public SpeedData(double x1, double y1, double x2, double y2) {
		xM1Speed = x1;
		yM1Speed = y1;
		xM2Speed = x2;
		yM2Speed = y2;
	}
	
	/**
	 * getXM1Speed
	 * @return
	 */
	public double getXM1Speed() {
		return xM1Speed;
	}
	
	/**
	 * getYM1Speed
	 * @return
	 */
	public double getYM1Speed() {
		return yM1Speed;
	}
	
	/**
	 * getXM2Speed
	 * @return
	 */
	public double getXM2Speed() {
		return xM2Speed;
	}
	
	/**
	 * getYM2Speed
	 * @return
	 */
	public double getYM2Speed() {
		return yM2Speed;
	}
	
	@Override
	public String toString() {
		return "Speeds: M1(" + xM1Speed + "," + yM1Speed + "), M2(" + xM2Speed + "," + yM2Speed + ")";
	}
}
