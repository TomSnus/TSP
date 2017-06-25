package Uebung8;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logging {
	private PrintWriter writer;
	private SimpleDateFormat dt;
	private String path;
	public Logging(String path){
		try {
			this.path = path;
			dt = new SimpleDateFormat("dd.mm.yyyy HH:mm:ss.SSS"); 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void logFirst() {  
	    try {
	    	writer = new PrintWriter(new FileOutputStream(path, true)); 
	    	writer.write(dt.format(new Date()) + System.getProperty("line.separator"));
	    	writer.flush();
	    	writer.close();
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	    }
	}
	
	public void log(String message) {  
	    try {
	    	writer = new PrintWriter(new FileOutputStream(path, true)); 
	    	writer.write(message + System.getProperty("line.separator"));
	    	writer.flush();
	    	writer.close();
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	    }
	}
	
	public void clearLog(){
		try {
		    Files.deleteIfExists(Paths.get(path));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
