package treevirt;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VirtualTree {
	
	private String label;
	private String value;
	private String fullLabel;
	private String dbms;
	private List<VirtualTree> children;	//needs to be sibling sorted
	
	public VirtualTree(String label, String value, String parentLabel, String dbms, List<VirtualTree> children) {
		this.label = label;
		this.value = value;
		this.fullLabel = parentLabel;
		this.dbms = dbms;
		this.children = children;
	}
	
	public VirtualTree(String label, String value, String parentLabel, String dbms) {
		this.label = label;
		this.value = value;
		this.fullLabel = parentLabel;
		this.dbms = dbms;
		this.children = new LinkedList<VirtualTree>();
	}
	
	public VirtualTree(){
		this.children = new LinkedList<VirtualTree>();
	};

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFullLabel() {
		return fullLabel;
	}

	public void setFullLabel(String parentLabel) {
		this.fullLabel = parentLabel;
	}

	public String getDbms() {
		return dbms;
	}

	public void setDbms(String dbms) {
		this.dbms = dbms;
	}

	public List<VirtualTree> getchildren() {
		return children;
	}

	public void setchildren(List<VirtualTree> children) {
		this.children = children;
	}
	
	public void addchild(VirtualTree node){
		this.children.add(node);
	}
	
	private void siblingSortChildren(){
		this.children.sort(new Comparator<VirtualTree>() {

			public int compare(VirtualTree o1, VirtualTree o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
	}

	@Override
	public String toString() {
		
		String res = "";
		try {
			res = new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		/*return "VirtualTree [label=" + label + ", value=" + value + ", fullLabel=" + fullLabel + ", dbms=" + dbms
				+ ", children=" + children + "]";*/
	}
	
	public String toBracketNotation(){
		siblingSortChildren();
		String res = "{" + this.value;
		for (VirtualTree virtualTree : children) {
			res += virtualTree.toBracketNotation();
		}
		res += "}";
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	 
	
	

}
