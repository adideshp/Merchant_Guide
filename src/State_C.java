

public class State_C extends Roman_State implements Roman_State_Interface{
	public State_C() {
		this.roman_value='C';
		this.value = 100;
		this.no_of_times_repeated = 0;
	}
	
	public void set_state(Roman_State previous_state) {
		this.no_of_times_repeated++;
		if (previous_state == null) { Roman_State.current_decimal_value += this.value; return;}
		if (this.roman_value != previous_state.roman_value) {previous_state.no_of_times_repeated=0;}
		if(previous_state.get_roman_value() == 'X') {
			//Subtract twice as the old value gets added in the previous state
			Roman_State.current_decimal_value -= previous_state.value;
			Roman_State.current_decimal_value += (this.value - previous_state.value);
		} 
		else{
			Roman_State.current_decimal_value += this.value;
		}
	}

	@Override
	public boolean is_transition_allowed(Roman_State next_state) {
		//C can be repeated 3 times. Three occurrences are allowed
		if(next_state.get_roman_value() == 'C' && this.no_of_times_repeated <= 3) {return true;}
		//C can be subtracted from D and M only
		else if(next_state.get_roman_value() == 'D' || next_state.get_roman_value() == 'M') {
			if (this.no_of_times_repeated == 1) {return true;}
		}
		// Small Values are allowed
		else if(next_state.get_roman_value() == 'L' || next_state.get_roman_value() == 'X' ||next_state.get_roman_value() == 'V' || next_state.get_roman_value() == 'I') {return true;}
		return false;		
	}
}
