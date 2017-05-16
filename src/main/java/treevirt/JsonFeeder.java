package treevirt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFeeder {
	
	private List<JsonNode> jsonRecords;
	
	public JsonFeeder(String jsonRecords){
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.jsonRecords = mapper.readValue(new FileInputStream(jsonRecords), new TypeReference<List<JsonNode>>() {});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<JsonNode> getJsonRecords() {
		return jsonRecords;
	}

	public void setJsonRecords(List<JsonNode> jsonRecords) {
		this.jsonRecords = jsonRecords;
	}
	
	

}
