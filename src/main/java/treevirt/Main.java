package treevirt;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import costmodel.StringUnitCostModel;
import distance.APTED;
import model.VirtualTree;
import node.Node;
import node.StringNodeData;
import parser.BracketStringInputParser;
import parser.InputParser;

public class Main {

	public static void main(String[] args) {
		virtualizeJSON();
		virtualizeKV();
	}
	
	private static void virtualizeKV() {
		KVFeeder feeder = new KVFeeder("KVs.txt");
		Map<String, Object> records = feeder.getRecords();
		KVVirtualizer virtualizer = new KVVirtualizer();
	}

	private static void virtualizeJSON(){
		
		JsonFeeder feeder = new JsonFeeder("example.json");
		APTED<StringUnitCostModel, StringNodeData> apted = new APTED<StringUnitCostModel, StringNodeData>(new StringUnitCostModel());
		InputParser<StringNodeData> parser = new BracketStringInputParser();

		Node<StringNodeData> primo = null;
		Node<StringNodeData> secondo = null;

		JsonVirtualizer virtualizer = new JsonVirtualizer();

		for (JsonNode node : feeder.getJsonRecords()) {

			VirtualTree tree = virtualizer.virtualize(node);
			if (primo == null)
				primo = parser.fromString("{a{{b}{c}}}");
			secondo = parser.fromString("{a{{c}{b}}}");
			float distance = apted.computeEditDistance(primo, secondo);
			System.out.println(distance);

		}
	}

}
