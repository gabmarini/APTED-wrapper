package model;

import java.util.LinkedList;
import java.util.List;

public class HierarchyNode {
	
	private String label;
	private String value;
	private int witnessCount;
	private int treeLevel;
	private List<HierarchyNode> children;
	private HierarchyTree tree;
	
	
	public HierarchyNode(String label, String value, int treeLevel, List<HierarchyNode> children) {
		this.label = label;
		this.value = value;
		this.children = children;
		this.witnessCount = 0;
		this.treeLevel = treeLevel;
	}


	public HierarchyNode() {}


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
	
	public int getTreeLevel() {
		return treeLevel;
	}
	
	public void setTreeLevel(int treeLevel) {
		this.treeLevel = treeLevel;
	}
	
	public int getWitnessCount() {
		return witnessCount;
	}
	
	public void setWitnessCount(int witnessCount) {
		this.witnessCount = witnessCount;
	}


	public List<HierarchyNode> getChildren() {
		return children;
	}


	public void setChildren(List<HierarchyNode> children) {
		this.children = children;
	}
	
	public HierarchyTree getTree() {
		return tree;
	}
	
	
	
	
	
	

}
