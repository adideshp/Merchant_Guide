
import java.util.HashMap;

public class State_Factory {
	public static HashMap <Character, Roman_State> state_map;
	
	public State_Factory() {
		State_Factory.state_map = new HashMap<Character, Roman_State>();
	}
	
	public Roman_State get_or_create_state(char roman_char) {
		Roman_State new_state;
		new_state = State_Factory.state_map.get(roman_char);
		if (new_state == null){
			// No such state exists. So create one
			switch(roman_char) {
			case 'I':
				new_state = new State_I();
				break;
			case 'V':
				new_state = new State_V();
				break;
			case 'X':
				new_state = new State_X();
				break;
			case 'L':
				new_state = new State_L();
				break;
			case 'C':
				new_state = new State_C();
				break;
			case 'D':
				new_state = new State_D();
				break;
			case 'M':
				new_state = new State_M();
				break;
			default : 	
				System.out.println("Invalid State");
				return null;
			}
			State_Factory.state_map.put(roman_char, new_state);
		}
		return new_state;
	}
}
