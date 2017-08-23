package com.gbcs.XPSPositioner.parameters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gbcs.XPSPositioner.data.AbsoluteEssaiMoveData;
import com.gbcs.XPSPositioner.data.AbsoluteMecaMoveData;
import com.gbcs.XPSPositioner.data.GabiParametersData;
import com.gbcs.XPSPositioner.data.RelativeEssaiMoveData;
import com.gbcs.XPSPositioner.data.RelativeMecaMoveData;
import com.gbcs.XPSPositioner.tabs.AdminTab;

import javafx.scene.control.ButtonType;
import javafx.util.Callback;

/**
 * GabiParameters
 * @author Sébastien
 *
 */
public class GabiParameters {

	// Logger
	private static final Logger logger = Logger.getLogger(GabiParameters.class);
	
	private final String GABI_CONFILE_FILE = "gabi.properties";
	
	private Properties prop = new Properties();
	private OutputStream output;
	private InputStream input;
	private GabiParametersData gabiDataParameters = new GabiParametersData();
	
	private static GabiParameters instance;
	private static Object objetSynchrone;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * GabiParameters ctor
	 */
	private GabiParameters() {
		load();
	}
	
	/**
	 * getInstance
	 * @return
	 */
	public static GabiParameters getInstance() {
	    if (null == instance) { // Premier appel
	        synchronized(objetSynchrone) {
	            if (null == instance) {
	                instance = new GabiParameters();
	            }
	        }
	    }
	    return instance;
	}
	
	/**
	 * load
	 */
	public void load() {
		try {
			input = new FileInputStream(GABI_CONFILE_FILE);

			// Load properties file
			prop.load(input);

			gabiDataParameters.setDeltaXBati(Double.parseDouble(prop.getProperty("deltaXBati")));
			
			logger.log(Level.DEBUG, "deltaXBati=" + gabiDataParameters.getDeltaXBati());

		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e.toString());
					e.printStackTrace();
				}
			}
		}	
	}

	/**
	 * save
	 */
	public void save() {
		
		try {
			output = new FileOutputStream(GABI_CONFILE_FILE);
	
			// Set properties values
			prop.setProperty("deltaXBati", String.valueOf(gabiDataParameters.getDeltaXBati()));
	
			// Save properties to project root folder
			prop.store(output, null);
	
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.error(e.toString());
					e.printStackTrace();
				}
			}
		}
	}
}
