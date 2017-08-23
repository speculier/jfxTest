package com.gbcs.XPSPositioner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javafx.collections.ObservableList;

/**
 * GabiController
 * @author Sébastien
 *
 */
public class GabiController {

	// Logger
	private static final Logger logger = Logger.getLogger(GabiController.class);

	/**
	 * saveSequenceToFile
	 * @param fileToSave
	 * @param list
	 */
	public void saveSequenceToFile(File fileToSave, ObservableList<String> list) {

		FileOutputStream outStream = null;

		try {
			outStream = new FileOutputStream(fileToSave);	  
		  
			// Save each sequence line to the file
			for (String text : list) {
	            outStream.write(text.getBytes());
	            outStream.write("\n".getBytes());
			}
			
			outStream.close();
        } catch (FileNotFoundException e) {
      	   e.printStackTrace();
        } catch (IOException e) {
     	   e.printStackTrace();
        }
	}
	
	/**
	 * openSequenceFromFile
	 * @param fileToopen
	 * return ObservableList<String> 
	 */
	public List<String> openSequenceFromFile(File fileToOpen) {

		BufferedReader br = null;
		List<String> list = new ArrayList<String>();

		try {
			br = new BufferedReader(new FileReader(fileToOpen));	  
		  
			// Save each sequence line to the file
			String currentLine = "";
			while ((currentLine = br.readLine()) != null) {
				list.add(currentLine);
			}
			
			br.close();
			return list;
			
        } catch (FileNotFoundException e) {
      	   e.printStackTrace();
     	   return null;
        } catch (IOException e) {
     	   e.printStackTrace();
     	   return null;
        }
	}
}
