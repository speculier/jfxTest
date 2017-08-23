package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

/**
 * MoveData
 * @author Sébastien
 *
 */
public abstract class MoveData {

	private double moveValue;
	private MoveTypeOnAxe moveType;
	
	/**
	 * getMoveValue
	 * @return
	 */
	public double getMoveValue() {
		return moveValue;
	}

	/**
	 * getMoveType
	 * @return
	 */
	public MoveTypeOnAxe getMoveType() {
		return moveType;
	}
	
	/**
	 * RelativeMecaMoveData ctor
	 * @param value
	 * @param axe
	 */
	public MoveData(double value, MoveTypeOnAxe type) {
		moveValue = value;
		moveType = type;
	}
}
