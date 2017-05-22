package treevirt;

import java.util.Map;

import model.VirtualTree;

public class KVVirtualizer {
	
	public VirtualTree virtualize(Map<String, String> record){

		VirtualTree tree = new VirtualTree("root", "root", null, "key value store");
		
		return tree;
	}

}
