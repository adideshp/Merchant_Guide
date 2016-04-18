
public interface Roman_State_Interface {
	public int get_value();
	public void set_state(Roman_State previous_state);
	public boolean is_transition_allowed(Roman_State next_state);
}
