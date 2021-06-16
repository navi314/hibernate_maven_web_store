package hibernate_maven;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.Configuration;

import client.Clients;
import delivery.DeliveryAddress;
import hibernate_store.ManageClients;
import order.Articles;

public class App {
	public static void main(String[] args) {
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageClients ME = new ManageClients();

		// Create list of delivery address
		Set<DeliveryAddress> delivery = new HashSet<DeliveryAddress>();
		DeliveryAddress delAdd = new DeliveryAddress("Ignacio Zaragoza 0044", 123, ME.getCitybyID(1),ME.getStatebyID(1),ME.getCountrybyID(1));
		DeliveryAddress delAdd2 = new DeliveryAddress("Ignacio Zaragoza 0054", 159, ME.getCitybyID(1),ME.getStatebyID(1),ME.getCountrybyID(1));

		delivery.add(delAdd);
		delivery.add(delAdd2);

		// Create a new Client
		int ID = ME.addClient("Marlen4", "Estrada", "user", "password", "correo2@correo.com", delivery);// ,credit);
		System.out.println("Se creo el cliente");
		
		// Add a credit card to a client
		ME.addCreditCard(ID, "Marlen Estrada 4", "123456789", ME.getCardType(1));
		System.out.println("Se agrego la tarjeta");
		
		// Get the client by ID
		Clients clientID = ME.getClientByID(ID);
		// System.out.println(clientID.getName());

		// Add another address to the client
		ME.addDeliveryAddress(clientID.getId(), "Ignacio Zaragoza 0064", 889, ME.getCitybyID(1),ME.getStatebyID(1),ME.getCountrybyID(1));

		// List of items
		Set<Articles> articleList = new HashSet<Articles>();
		articleList.add(ME.searchArticle(4));
		articleList.add(ME.searchArticle(5));
		articleList.add(ME.searchArticle(6));
		articleList.add(ME.searchArticle(7));

		int amount = ME.getAmount(articleList);

		// Create billing invoice
		Date date = new Date();
		int bill = ME.addBilling(ME.createRandom(), amount, date);

		// Create a deliveryPackage
		int deliPackage = ME.addDeliveryPackages(date, ME.createRandom(), ME.getCompany(1));

		// Get delivery address
		int deliveryAdd = ME.getDeliveryAddress(ID);

		// Create a new Purchase Order
		ME.addPurchaseOrder(bill, date, deliPackage, deliveryAdd, ID, articleList);

		ME.listDeliveryAddress(ID);
		ME.listCreditCards(ID);
		System.out.println("---Articulos----");
		ME.listArticleList(articleList);

		// Amount paid by the Client
		System.out.println("Cantidad: " + amount);
	}
}
