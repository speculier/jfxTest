package com.gbcs.XPSPositioner.data;

/**
 * NbLoopData
 * @author Sébastien
 *
 */
public class NbLoopData {

	private int nbLoops;
	
	/**
	 * NbLoopData
	 * @param l
	 */
	public NbLoopData (int l) {
		nbLoops = l;
	}
	
	@Override
	public String toString() {
		return "X " + nbLoops;
	}
}
