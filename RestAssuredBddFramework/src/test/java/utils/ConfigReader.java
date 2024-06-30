package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
   public String readConfigData(String proprtyToRead) throws IOException {
	   //config con = new config();
	   Properties pro = new Properties(); 
	  String path = System.getProperty("user.dir")+ "\\src\\test\\resources\\config.properties"; 
	  FileInputStream fis = new FileInputStream(path);
	  pro.load(fis);
	 String value= pro.getProperty(proprtyToRead);
	 return value;
	 
   }
    
}
