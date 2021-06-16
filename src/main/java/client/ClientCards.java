package client;

import java.util.HashSet;
import java.util.Set;


public class ClientCards {
	private int id;
	private Set<Clients> clients = new HashSet<Clients>(0);
	private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);
	
	public ClientCards(){}

	public ClientCards(int id, Set<Clients> clients, Set<CreditCard> creditCards) {
		super();
		this.id = id;
		this.clients = clients;
		this.creditCards = creditCards;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Clients> getClients() {
		return clients;
	}
	public void setClients(Set<Clients> clients) {
		this.clients = clients;
	}
	public Set<CreditCard> getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	
	
}
