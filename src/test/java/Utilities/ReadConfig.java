package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop= new Properties();
			prop.load(fis);		
			
		
		}catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
		
		
	}
	
	public String getAppUrl() {
		
		String url= prop.getProperty("baseURL");
		return url;
	}
	
public String getUsername() {
		
		String username= prop.getProperty("username");
		return username;
	}

public String getPass() {
	
	String pass= prop.getProperty("password");
	return pass;
}

public String getchromepath() {
	
	String chromepath= prop.getProperty("chromepath");
	return chromepath;
}

public String getfirefoxpath() {
	
	String firefoxpath= prop.getProperty("firefoxpath");
	return firefoxpath;
}
}
