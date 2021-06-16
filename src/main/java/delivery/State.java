package delivery;

public class State {
	private int id;
	private String name;
	private Country country_id;
	
	public State() {}
	
	public State(String name, int id) {
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

	public Country getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Country country_id) {
		this.country_id = country_id;
	}
	
}
