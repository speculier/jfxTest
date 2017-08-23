package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.MoveAxe;

/**
 * RelativeTablePositionData
 * @author S�bastien
 *
 */
public class RelativeTablePositionData {

	private double moveValue;
	private MoveAxe moveAxe;
	
	/**
	 * RelativeTablePositionData ctor
	 * @param value
	 * @param axe
	 */
	public RelativeTablePositionData(double value, MoveAxe axe) {
		moveValue = value;
		moveAxe = axe;
	}
	
	@Override
	public String toString() {
		return "R " + moveAxe + " " + moveValue;
	}
}
