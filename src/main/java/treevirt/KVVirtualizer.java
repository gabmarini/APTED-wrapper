package treevirt;

import java.util.Map;
import java.util.Properties;

import model.VirtualTree;

public class KVVirtualizer {
	
	Properties props = new TreeVirtualizationPropertyReader("treevirt.properties").getProp();
	
	public VirtualTree virtualize(Map<String, Object> record){

		VirtualTree tree = new VirtualTree("root", "root", null, "key value store");
		
		return tree;
	}
	 

}
