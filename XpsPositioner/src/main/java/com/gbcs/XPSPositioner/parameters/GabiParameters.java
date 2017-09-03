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
import com.gbcs.XPSPositioner.enumeration.RotationCenter;
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
	
	/**
	 * getGabiDataParameters
	 * @return GabiParametersData
	 */
	public GabiParametersData getGabiDataParameters() {
		return gabiDataParameters;
	}

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
	      //  synchronized(objetSynchrone) {
	            if (null == instance) {
	                instance = new GabiParameters();
	            }
	       // }
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

			try {
				gabiDataParameters.setCylinderRadius(Double.parseDouble(prop.getProperty("cylinderRadius")));
				gabiDataParameters.setCylinderHeight(Double.parseDouble(prop.getProperty("cylinderHeight")));
				gabiDataParameters.setCylinderZAngle(Double.parseDouble(prop.getProperty("cylinderZAngle")));
				gabiDataParameters.setCylinderX(Double.parseDouble(prop.getProperty("cylinder_X")));
				gabiDataParameters.setCylinderY(Double.parseDouble(prop.getProperty("cylinder_Y")));
				
				gabiDataParameters.setPatellaRadius(Double.parseDouble(prop.getProperty("patellaRadius")));
				gabiDataParameters.setPatella1_X(Double.parseDouble(prop.getProperty("patella1_X")));
				gabiDataParameters.setPatella1_Y(Double.parseDouble(prop.getProperty("patella1_Y")));
				gabiDataParameters.setPatella2_X(Double.parseDouble(prop.getProperty("patella2_X")));
				gabiDataParameters.setPatella2_Y(Double.parseDouble(prop.getProperty("patella2_Y")));
				
				gabiDataParameters.setTableWidth(Double.parseDouble(prop.getProperty("tableWidth")));
				gabiDataParameters.setTableHeight(Double.parseDouble(prop.getProperty("tableHeight")));
				gabiDataParameters.setTableDepth(Double.parseDouble(prop.getProperty("tableDepth")));
				gabiDataParameters.setTable1_X(Double.parseDouble(prop.getProperty("table1_X")));
				gabiDataParameters.setTable1_Y(Double.parseDouble(prop.getProperty("table1_Y")));
				gabiDataParameters.setTable2_X(Double.parseDouble(prop.getProperty("table2_X")));
				gabiDataParameters.setTable2_Y(Double.parseDouble(prop.getProperty("table2_Y")));

				gabiDataParameters.setRotationCenter(RotationCenter.valueOf(prop.getProperty("rotationCenter")));
				
			} catch (NullPointerException e) {
				gabiDataParameters.setDefaultParameters();
			}
			
			logger.log(Level.DEBUG, "cylinderRadius=" + gabiDataParameters.getCylinderRadius());
			logger.log(Level.DEBUG, "cylinderHeight=" + gabiDataParameters.getCylinderHeight());
			logger.log(Level.DEBUG, "cylinderZAngle=" + gabiDataParameters.getCylinderZAngle());
			logger.log(Level.DEBUG, "cylinder_X=" + gabiDataParameters.getCylinderX());
			logger.log(Level.DEBUG, "cylinder_Y=" + gabiDataParameters.getCylinderY());
			
			logger.log(Level.DEBUG, "patellaRadius=" + gabiDataParameters.getPatellaRadius());
			logger.log(Level.DEBUG, "patella1_X=" + gabiDataParameters.getPatella1_X());
			logger.log(Level.DEBUG, "patella1_Y=" + gabiDataParameters.getPatella1_Y());
			logger.log(Level.DEBUG, "patella2_X=" + gabiDataParameters.getPatella2_X());
			logger.log(Level.DEBUG, "patella2_Y=" + gabiDataParameters.getPatella2_Y());
			
			logger.log(Level.DEBUG, "tableWidth=" + gabiDataParameters.getTableWidth());
			logger.log(Level.DEBUG, "tableHeight=" + gabiDataParameters.getTableHeight());
			logger.log(Level.DEBUG, "tableDepth=" + gabiDataParameters.getTableDepth());
			logger.log(Level.DEBUG, "table1_X=" + gabiDataParameters.getTable1_X());
			logger.log(Level.DEBUG, "table1_Y=" + gabiDataParameters.getTable1_Y());
			logger.log(Level.DEBUG, "table2_X=" + gabiDataParameters.getTable2_X());
			logger.log(Level.DEBUG, "table2_Y=" + gabiDataParameters.getTable2_Y());
			
			logger.log(Level.DEBUG, "rotationCenter=" + gabiDataParameters.getRotationCenter());
		
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
			//prop.setProperty("cylinderDiameter", String.valueOf(gabiDataParameters.getCylinderDiameter()));
	
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
