package com.gbcs.XPSPositioner.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * PasswordEncrypter
 * @author Sébastien
 *
 */
public class PasswordEncrypter {
	
	private static PasswordEncrypter instance;
	
	/**
	 * PasswordEncrypter ctor
	 */
	private PasswordEncrypter() {
	}
	
	/**
	 * getInstance
	 * @return
	 */
	public static PasswordEncrypter getInstance() {
	    if (null == instance) { 
	            if (null == instance) {
	                instance = new PasswordEncrypter();
	            }
	    }
	    return instance;
	}
	
	/**
	 * 
	 * @param passwordToEncrypt
	 * @return
	 */
	public String getMd5EncryptedPassword(String passwordToEncrypt) {

		String generatedPassword =  null;
		
	    try {
	        // Create MessageDigest instance for MD5
	        MessageDigest md = MessageDigest.getInstance("MD5");
	       
	        // Add password bytes to digest
	        md.update(passwordToEncrypt.getBytes());
	        
	        // Get the hash's bytes
	        byte[] bytes = md.digest();
	        
	        // This bytes[] has bytes in decimal format; Convert it to hexadecimal format
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++) {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        // Get complete hashed password in hex format
	        generatedPassword = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    
	    return generatedPassword;
	}
}
