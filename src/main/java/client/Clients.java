package client;

import java.util.HashSet;
import java.util.Set;

import delivery.DeliveryAddress;
import order.PurchaseOrder;

public class Clients {
   private int id;
   private String userName;
   private String lastName;
   private String password;
   private String email;
   private String name;
   private Set<DeliveryAddress> deliveryAddress = new HashSet<DeliveryAddress>(0);
   private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);
   private Set<PurchaseOrder> purchase = new HashSet<PurchaseOrder>(0);

   public Clients(){}
   
   public Clients(String userName, String lastName, String password, String email, String name) {
		this.id = id;
		this.userName = userName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Set<DeliveryAddress> getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Set<DeliveryAddress> deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Set<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public Set<PurchaseOrder> getPurchase() {
		return purchase;
	}

	public void setPurchase(Set<PurchaseOrder> purchase) {
		this.purchase = purchase;
	}
}
