package delivery;

import java.util.HashSet;
import java.util.Set;

import client.Clients;

public class DeliveryAddress {
	private Integer id;
	private String street;
	private Integer number;
	private City cityID;
	private State stateID;
	private Country countryID;
	private Set<Clients> clientsAdd = new HashSet<Clients>(0);
	
	public DeliveryAddress() {}
	
	
	public DeliveryAddress(String street, Integer number, City cityID, State stateID, Country countryID) {
		super();
		this.street = street;
		this.number = number;
		this.cityID = cityID;
		this.stateID = stateID;
		this.countryID = countryID;
		this.clientsAdd = clientsAdd;
	}


	public State getStateID() {
		return stateID;
	}


	public void setStateID(State stateID) {
		this.stateID = stateID;
	}


	public Country getCountryID() {
		return countryID;
	}


	public void setCountryID(Country countryID) {
		this.countryID = countryID;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public City getCityID() {
		return cityID;
	}
	public void setCityID(City cityID) {
		this.cityID = cityID;
	}

	public Set<Clients> getClientsAdd() {
		return clientsAdd;
	}

	public void setClientsAdd(Set<Clients> clients) {
		this.clientsAdd = clients;
	} 

}