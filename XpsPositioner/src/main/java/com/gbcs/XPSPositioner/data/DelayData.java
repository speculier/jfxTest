package com.gbcs.XPSPositioner.data;

/**
 * DelayData
 * @author S�bastien
 *
 */
public class DelayData {

	private double delayMs;
	
	/**
	 * DelayData
	 * @param d
	 */
	public DelayData (double d) {
		delayMs = d;
	}
	
	@Override
	public String toString() {
		return "D " + delayMs;
	}
}
