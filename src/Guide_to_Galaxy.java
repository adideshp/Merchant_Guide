/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aditya
 *
 */
public class Guide_to_Galaxy {
	public String text_line;
	public Roman_State_Interface current_state, next_state;
	public State_Factory state_factory;
	public Data_Store data_store;
	public Parser parser;
	public Analyzer analyzer; 
	
	/**
	 * @param args
	 * 
	 */
	public Guide_to_Galaxy() {
		this.current_state = this.next_state = null;
		this.text_line = "";
		this.data_store = new Data_Store();
		this.analyzer = new Analyzer(data_store);
		this.parser = new Parser(analyzer);
	}
	
	public String read_line() {
		String input_line = "";
		BufferedReader in
		   = new BufferedReader(new InputStreamReader(System.in));
		try { 
			input_line = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input_line;
	}
	
	
	public static void main(String[] args) {
		Guide_to_Galaxy galaxy_guide = new Guide_to_Galaxy();
		while(true) {
			String line = galaxy_guide.read_line();
			if (line == "quit") {break;}
			else {
				galaxy_guide.parser.parse_line(line);
			}
		}
	}	
}
