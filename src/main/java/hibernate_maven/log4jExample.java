package hibernate_maven;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;  
import java.io.*;  
import java.sql.SQLException;  
import java.util.*;  

public class log4jExample {

	private static final Logger log = LogManager.getLogger(log4jExample.class);

	public static void main(String[] args)throws IOException, SQLException{  
	      log.debug("Hello this is a debug message");  
	      log.info("Hello this is an info message");  
	   } 
}