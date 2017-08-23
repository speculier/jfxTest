package com.gbcs.XPSPositioner.data;

import com.gbcs.XPSPositioner.enumeration.MoveTypeOnAxe;

/**
 * RelativeMecaMoveData
 * @author Sébastien
 *
 */
public class RelativeMecaMoveData extends MoveData {

	/**
	 * RelativeMecaMoveData ctor
	 * @param value
	 * @param axe
	 */
	public RelativeMecaMoveData(double value, MoveTypeOnAxe type) {
		super(value, type);
	}
	
	@Override
	public String toString() {
		return "M " + getMoveType() + " " + getMoveValue();
	}
}
