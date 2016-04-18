
public abstract class Roman_State {
	char roman_value;
	int value;
	int no_of_times_repeated;
	static int current_decimal_value = 0;
	
	public int get_roman_value() {
		// Returns the corresponding decimal value 
		return this.roman_value;
	}
	
	public int get_value() {
		// Returns the corresponding decimal value 
		return this.value;
	}
	
	public abstract void set_state(Roman_State previous_state);
	public abstract boolean is_transition_allowed(Roman_State state);
}
