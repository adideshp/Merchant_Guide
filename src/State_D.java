

public class State_D extends Roman_State implements Roman_State_Interface{
	public State_D() {
		this.roman_value='D';
		this.value = 500;
		this.no_of_times_repeated = 0;
	}

	
	public void set_state(Roman_State previous_state) {
		this.no_of_times_repeated++;
		if (previous_state == null) { Roman_State.current_decimal_value += this.value; return;}
		if (this.roman_value != previous_state.roman_value) {previous_state.no_of_times_repeated=0;}
		if(previous_state.get_roman_value() == 'C'){
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
		//D cannot be repeated. Just one occurrence is allowed
		//D cannot be subtracted
		// Small Values are allowed
		if(next_state.get_roman_value() == 'C' || next_state.get_roman_value() == 'L' || next_state.get_roman_value() == 'X' ||next_state.get_roman_value() == 'V' || next_state.get_roman_value() == 'I') {return true;}
		return false;		
	}
}
