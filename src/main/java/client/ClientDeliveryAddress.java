package client;

import java.util.HashSet;
import java.util.Set;

public class ClientDeliveryAddress {
	private int id;
	private int clientID;
	private int deliveryAddressID;
	
	public ClientDeliveryAddress() {}
	
	public ClientDeliveryAddress(int clientID, int deliveryAddressID) {
		this.clientID = clientID;
		this.deliveryAddressID = deliveryAddressID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public int getDeliveryAddressID() {
		return deliveryAddressID;
	}
	public void setDeliveryAddressID(int deliveryAddressID) {
		this.deliveryAddressID = deliveryAddressID;
	}
}
