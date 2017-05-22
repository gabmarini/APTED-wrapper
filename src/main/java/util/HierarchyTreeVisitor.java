package util;

import model.HierarchyNode;
import model.HierarchyTree;

public class HierarchyTreeVisitor {
	
	private HierarchyNode root;
	
	public HierarchyTreeVisitor(){}
	
	
	
	public HierarchyTreeVisitor(HierarchyTree tree) {
		this.root = tree.getRoot();
	}
	
}
