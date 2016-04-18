
public class State_I extends Roman_State implements Roman_State_Interface {
	
	public State_I() {
		this.roman_value='I';
		this.value = 1;
		this.no_of_times_repeated = 0;
	}
	
	public void set_state(Roman_State previous_state) {
		this.no_of_times_repeated++;
		if (previous_state == null) { Roman_State.current_decimal_value += this.value; return;}
		Roman_State.current_decimal_value += this.value;
		if (this.roman_value != previous_state.roman_value) {previous_state.no_of_times_repeated=0;}
	}
	
	@Override
	public boolean is_transition_allowed(Roman_State next_state) {
		//I can only be repeated 3 times in succession
		if(next_state.get_roman_value() == 'I' && this.no_of_times_repeated <= 3) {return true;}
		//I can be subtracted from V and X only
		else if(next_state.get_roman_value() == 'V' || next_state.get_roman_value() == 'X') {
			if (this.no_of_times_repeated == 1) {return true;}
		}
		return false;		
	}
}
