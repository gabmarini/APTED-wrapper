package treevirt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import costmodel.StringUnitCostModel;
import distance.APTED;
import node.Node;
import node.StringNodeData;
import parser.BracketStringInputParser;
import parser.InputParser;

public class Main {

	public static void main(String[] args) {
		JsonFeeder feeder = new JsonFeeder("example.json");
		APTED<StringUnitCostModel, StringNodeData> apted = new APTED<StringUnitCostModel, StringNodeData>(new StringUnitCostModel());
		InputParser<StringNodeData> parser = new BracketStringInputParser();

		Node<StringNodeData> primo = null;
		Node<StringNodeData> secondo = null;

		JsonVirtualizer virtualizer = new JsonVirtualizer();

		for (JsonNode node : feeder.getJsonRecords()) {

			VirtualTree tree = virtualizer.virtualize(node);
			if (primo == null)
				primo = parser.fromString(tree.toBracketNotation());
			secondo = parser.fromString(tree.toBracketNotation());
		}
		
		float distance = apted.computeEditDistance(primo, secondo);
		LinkedList<int[]> mapped = apted.computeEditMapping();
		System.out.println(distance);
		for (int[] is : mapped) {
				System.out.println("\n");
				for (int i : is) {
					System.out.print(i + " ");
				}
		}


	}

}
