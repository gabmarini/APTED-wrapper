package treevirt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TreeVirtualizationPropertyReader {
	
	Properties prop = new Properties();
	FileInputStream input;
	
	public TreeVirtualizationPropertyReader(String path){
		
		try {
			input = new FileInputStream(path);
			// load a properties file
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void closeStream() throws IOException{
		input.close();
	}
	
	public Properties getProp() {
		return prop;
	}

}
