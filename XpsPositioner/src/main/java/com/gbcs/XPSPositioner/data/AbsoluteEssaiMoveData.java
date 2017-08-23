package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

/**
 * AbsoluteEssaiMoveData
 * @author Sébastien
 *
 */
public class AbsoluteEssaiMoveData extends MoveData {

	/**
	 * AbsoluteEssaiMoveData ctor
	 * @param value
	 * @param axe
	 */
	public AbsoluteEssaiMoveData(double value, MoveTypeOnAxe type) {
		super(value, type);
	}
	
	@Override
	public String toString() {
		return "C " + getMoveType() + " " + getMoveValue();
	}
}
