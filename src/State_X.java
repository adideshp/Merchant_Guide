
public class State_X extends Roman_State implements Roman_State_Interface{
	public State_X() {
		this.roman_value='X';
		this.value = 10;
		this.no_of_times_repeated = 0;
	}

	public void set_state(Roman_State previous_state) {
		this.no_of_times_repeated++;
		if (previous_state == null) { Roman_State.current_decimal_value += this.value; return;}
		if (this.roman_value != previous_state.roman_value) {previous_state.no_of_times_repeated=0;}
		if(previous_state.get_roman_value() == 'I') {
			//Subtract twice as the old value gets added
			Roman_State.current_decimal_value -= previous_state.value;
			Roman_State.current_decimal_value += (this.value - previous_state.value);
		} else{
			Roman_State.current_decimal_value += this.value;
		}
	}
	
	@Override
	public boolean is_transition_allowed(Roman_State next_state) {
		//X can be repeated 3 times. Three occurrences are allowed
		if(next_state.get_roman_value() == 'X' && this.no_of_times_repeated <= 3) {return true;}
		//V can never be subtracted from L and C only
		else if(next_state.get_roman_value() == 'L' || next_state.get_roman_value() == 'C') {
			if (this.no_of_times_repeated == 1) {return true;}
		}
		// Small Values are allowed
		else if(next_state.get_roman_value() == 'V' || next_state.get_roman_value() == 'I') {return true;}
		return false;		
	}
}
