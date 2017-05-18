package treevirt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TreeVirtualizationPropertyReader {
	
	Properties prop = new Properties();
	FileInputStream input;
	
	public TreeVirtualizationPropertyReader(String path) throws IOException{
		
		input = new FileInputStream(path);

		// load a properties file
		prop.load(input);
	}
	
	public void closeStream() throws IOException{
		input.close();
	}

}
