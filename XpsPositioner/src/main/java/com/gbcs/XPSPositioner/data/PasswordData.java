package com.gbcs.XPSPositioner.data;

/**
 * PasswordData
 * @author Sébastien
 *
 */
public class PasswordData {

	private String appPassword;
	
	/**
	 * PasswordData ctor
	 * @param pwd
	 */
	public PasswordData(String pwd) {
		appPassword = pwd;
	}
	
	/**
	 * getPassword
	 * @return
	 */
	public String getPassword() {
		return appPassword;
	}
	
	@Override
	public String toString() {
		return "<CRYPTED PASSWORD>";
	}
}
