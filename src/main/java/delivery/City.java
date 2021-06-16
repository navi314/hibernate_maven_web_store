package delivery;

import java.util.HashSet;
import java.util.Set;

public class City {
	private int id;
	private String name;
	private Set<State> state_id = new HashSet<State>(0);
	
	public City() {}
	
	public City(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Set<State> getState_id() {
		return state_id;
	}

	public void setState_id(Set<State> state_id) {
		this.state_id = state_id;
	}
}
