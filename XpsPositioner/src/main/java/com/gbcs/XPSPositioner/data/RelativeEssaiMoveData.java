package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

/**
 * RelativeEssaiMoveData
 * @author Sébastien
 *
 */
public class RelativeEssaiMoveData extends MoveData {

	/**
	 * RelativeEssaiMoveData ctor
	 * @param value
	 * @param axe
	 */
	public RelativeEssaiMoveData(double value, MoveTypeOnAxe type) {
		super(value, type);
	}
	
	@Override
	public String toString() {
		return "E " + getMoveType() + " " + getMoveValue();
	}
}
