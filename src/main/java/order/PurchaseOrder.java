package order;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import client.Clients;
import delivery.DeliveryAddress;
import delivery.DeliveryPackages;

public class PurchaseOrder {
	private int id;
	private Date purchaseDate;
	private DeliveryAddress deliveryAddress;
	private Billing billingID;
	private DeliveryPackages deliveryPackageID;
	private Set<Articles> articles = new HashSet<Articles>(0);
	private Set<Clients> clients = new HashSet<Clients>(0);
	
	public PurchaseOrder() {}

	public PurchaseOrder(Date purchaseDate, DeliveryAddress deliveryAddress, Billing billingID,
			DeliveryPackages deliveryPackageID, Set<Articles> articles) {
		this.purchaseDate = purchaseDate;
		this.deliveryAddress = deliveryAddress;
		this.billingID = billingID;
		this.deliveryPackageID = deliveryPackageID;
		this.articles = articles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Billing getBillingID() {
		return billingID;
	}

	public void setBillingID(Billing billingID) {
		this.billingID = billingID;
	}

	public DeliveryPackages getDeliveryPackageID() {
		return deliveryPackageID;
	}

	public void setDeliveryPackageID(DeliveryPackages deliveryPackageID) {
		this.deliveryPackageID = deliveryPackageID;
	}

	public Set<Articles> getArticles() {
		return articles;
	}

	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}

	public Set<Clients> getClients() {
		return clients;
	}

	public void setClients(Set<Clients> clients) {
		this.clients = clients;
	}
	
		
}
