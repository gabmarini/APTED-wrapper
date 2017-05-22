package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HierarchyTree {

	private HierarchyNode root;
	private Map<Integer, List<HierarchyNode>> level2nodes;

	public HierarchyTree(){
		this.root = new HierarchyNode(null, "hierarchy_root",-1, new LinkedList<>());
		this.level2nodes = new HashMap<>();
	}

	public HierarchyTree(HierarchyNode root){
		this.root = root;
		this.level2nodes = new HashMap<>();
	}

	public HierarchyNode getRoot() {
		return root;
	}

	public void setRoot(HierarchyNode root) {
		this.root = root;
	}

	public void addNode2Level(int level, HierarchyNode node){
		if(!this.level2nodes.containsKey(level)) {
			this.level2nodes.put(level, new LinkedList<HierarchyNode>());
		}
		this.level2nodes.get(level).add(node);
	}

	public List<HierarchyNode> getNodesAtLevel(int level){
		return this.level2nodes.get(level);
	}



}
