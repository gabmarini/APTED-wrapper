package treevirt;

import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonVirtualizer {

	public VirtualTree virtualize(JsonNode node){

		VirtualTree tree = new VirtualTree("root", "root", null, "document store");
		Iterator<String> fieldNames = node.fieldNames();

		virtualize(node, tree);
		
		return tree;
	}

	
	/*
	 * recursion function.
	 */
	private void virtualize(JsonNode node, VirtualTree tree){
		
		Iterator<String> fieldNames = node.fieldNames();
		while(fieldNames.hasNext()){

			String fieldName = fieldNames.next();
			JsonNode fieldValue = node.get(fieldName);

			if (fieldValue.isObject()) {
				VirtualTree child = new VirtualTree(fieldName, fieldName, tree.getLabel() + "." + fieldName, tree.getDbms());
				tree.addchild(child);
				virtualize(fieldValue, child);
			} else {
				String value = fieldValue.asText();
				tree.addchild(new VirtualTree(fieldName, value, tree.getLabel() + "." + fieldName, tree.getDbms()));
			}
		}
	}

}
