package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	Properties properties;
	FileInputStream fis;
	public String browser;
	//public String url;
	
	
	public void readFile() throws IOException {
		String path =System.getProperty("user.dir")+"/src/main/java/Resources/Config.properties";
		
		fis = new FileInputStream(path);
		properties.load(fis);		
		
		setValues();
	}	
	
	public void setValues() {
		browser = properties.getProperty("browser");
		//url = properties.getProperty("baseURL");
	}
			
}
