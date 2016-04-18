
public class Roman_Handler {

	public State_Factory state_factory;
	
	public Roman_Handler() {
		this.state_factory = new State_Factory();
	}

	public int get_decimal_equivalent(String roman_letter_string) {
		// TODO Auto-generated method stub
		Roman_State current_state, next_state= null;
		current_state = this.state_factory.get_or_create_state(roman_letter_string.charAt(0));
		current_state.set_state(null); // First State
		for (int pointer=1; pointer < roman_letter_string.length(); pointer++) {
				next_state = this.state_factory.get_or_create_state(roman_letter_string.charAt(pointer));
			if (current_state.is_transition_allowed(next_state)) {
				next_state.set_state(current_state);
				current_state = next_state;
			} else { 
				System.out.println("Invalid Roman Number");
				return -9999;}
		}
		int decimal_value = Roman_State.current_decimal_value;
		Roman_State.current_decimal_value = 0;
		return decimal_value;
	}
}
