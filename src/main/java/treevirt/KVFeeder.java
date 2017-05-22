package treevirt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class KVFeeder {

	Map<String, Object> records = new HashMap<String, Object>();

	public KVFeeder(String path) {
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			stream.forEach((line) -> {
				String[] tokens = line.split("\t");
				records.put(tokens[0], tokens[1]);
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map<String, Object> getRecords() {
		return records;
	}
	
}
