package client;

import java.util.HashSet;
import java.util.Set;

public class CreditCard {
	private int id;
	private String cardNumber;
	private String cardHolder;
	private CardType cardTypeID;
	private Set<Clients> clientsAdd = new HashSet<Clients>(0);
	
	public CreditCard() {}

	public CreditCard(String cardNumber,String cardHolder, CardType cardType) {
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.cardTypeID = cardType;
	}
/*
	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public CardType getCardTypeID() {
		return cardTypeID;
	}

	public void setCardTypeID(CardType cardTypeID) {
		this.cardTypeID = cardTypeID;
	}

	public Set<Clients> getClientsAdd() {
		return clientsAdd;
	}

	public void setClientsAdd(Set<Clients> clientsAdd) {
		this.clientsAdd = clientsAdd;
	}
	
}
