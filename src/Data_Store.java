
import java.util.HashMap;
import java.util.Map;

public class Data_Store {
	Map<String, String> data_dictionary = new HashMap<String, String>();
	
	public String get_data(String key) {
		String value;
		try {
			value = data_dictionary.get(key);
			return value;
		} catch (NullPointerException e) {
			//Error Code
			return null;
		}
	}
	
	public boolean set_data(String key, String value) {
			data_dictionary.put(key, value);
			return true;
	}
	
}
