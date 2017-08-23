package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

/**
 * AbsoluteMecaMoveData
 * @author Sébastien
 *
 */
public class AbsoluteMecaMoveData extends MoveData {

	/**
	 * AbsoluteMecaMoveData ctor
	 * @param value
	 * @param axe
	 */
	public AbsoluteMecaMoveData(double value, MoveTypeOnAxe type) {
		super(value, type);
	}
	
	@Override
	public String toString() {
		return "A " + getMoveType() + " " + getMoveValue();
	}
}
