package hibernate_store;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import client.CardType;
import client.Clients;
import client.CreditCard;
import delivery.City;
import delivery.Country;
import delivery.DeliveryAddress;
import delivery.DeliveryPackages;
import delivery.State;
import order.Articles;
import order.Billing;
import order.Company;
import order.PurchaseOrder;

public class ManageClients {
	public static SessionFactory factory;

	public State getStatebyID(int ID) {
		State state = new State();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			state = (State) session.get(State.class, ID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return state;
	}
	
	public Country getCountrybyID(int ID) {
		Country country = new Country();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			country = (Country) session.get(Country.class, ID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return country;
	}

	public void listArticleList(Set<Articles> articleList) {
		for (Iterator iterator2 = articleList.iterator(); iterator2.hasNext();) {
			Articles Articles = (Articles) iterator2.next();
			System.out.println("Nombre del articulo: " + Articles.getName());
		}
	}

	public int getAmount(Set<Articles> articleList) {
		int total = 0;
		for (Iterator iterator2 = articleList.iterator(); iterator2.hasNext();) {
			Articles Articles = (Articles) iterator2.next();
			total += Articles.getPrice();
		}
		return total;
	}

	public Articles searchArticle(int ID) {
		Articles article = new Articles();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			article = (Articles) session.get(Articles.class, ID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return article;
	}

	public int createRandom() {
		Double min = 1000000.0, max = 9999990.0;
		double x = (Math.random() * ((max - min) + 1)) + min;
		double xrounded = Math.round(x * 100.0) / 100.0;
		return (int) xrounded;
	}

	public City getCitybyID(int ID) {
		City city = new City();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			city = (City) session.get(City.class, ID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return city;
	}

	// Method to CREATE a Client in the database
	public Integer addClient(String fname, String lname, String user, String password, String email,
			Set<DeliveryAddress> delAdd) {// , Set<CreditCard> credit){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer clientID = null;

		try {
			tx = session.beginTransaction();
			Clients client = new Clients();
			client.setName(fname);
			client.setUserName(user);
			client.setLastName(lname);
			client.setPassword(password);
			client.setEmail(email);
			clientID = (Integer) session.save(client);
			client.setDeliveryAddress(delAdd);
			// client.setCreditCards(credit);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return clientID;
	}

	public void addDeliveryAddress(int clientID, String street, int number, City cityID, State stateID, Country countryID) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer deliveryAddress = null;
		Clients client;

		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM client.Clients WHERE ID=:id")
					.setParameter("id", clientID).list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				Clients employee = (Clients) iterator1.next();
				DeliveryAddress delAdd = new DeliveryAddress();
				delAdd.setStreet(street);
				delAdd.setNumber(number);
				delAdd.setCityID(cityID);
				delAdd.setStateID(stateID);
				delAdd.setCountryID(countryID);

				employee.getDeliveryAddress().add(delAdd);
				session.update(employee);

			}

			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Clients getClientByID(int ID) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer clientID = null;
		Clients client = new Clients();

		try {
			tx = session.beginTransaction();
			client = (Clients) session.get(Clients.class, ID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return client;
	}

	public void addCard(String cardType, String cardHolder) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer clientID = null;

		try {
			tx = session.beginTransaction();
			Clients client = new Clients();
			clientID = (Integer) session.save(client);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public CardType getCardType(int CardType) {
		CardType card = new CardType();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			card = (CardType) session.get(CardType.class, CardType);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return card;
	}

	public void addCreditCard(int clientID, String cardHolder, String number, CardType cardtype) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List clients = session.createQuery("FROM client.Clients WHERE ID=:id").setParameter("id", clientID)
					.list();
			for (Iterator iterator1 = clients.iterator(); iterator1.hasNext();) {
				Clients client = (Clients) iterator1.next();
				CreditCard card = new CreditCard();
				card.setCardHolder(cardHolder);
				card.setCardNumber(number);
				card.setCardTypeID(cardtype);
				client.getCreditCards().add(card);
				session.update(client);
			}

			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}
//			System.out.println("Se agrego la tarjeta al cliente");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void listDeliveryAddress(int clientID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List employees = session.createQuery("FROM client.Clients WHERE ID=:id")
					.setParameter("id", clientID).list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				Clients employee = (Clients) iterator1.next();
				System.out.println("Nombre: " + employee.getName());
				System.out.println("Apellido: " + employee.getLastName());
				System.out.println("********Direcciones***************");

				Set deliveryAddress = employee.getDeliveryAddress();
				session.update(employee);

				for (Iterator iterator2 = deliveryAddress.iterator(); iterator2.hasNext();) {
					DeliveryAddress address = (DeliveryAddress) iterator2.next();
					System.out.println("Calle: " + address.getStreet() + "--- Numero: " + address.getNumber()
							+ "--- Ciudad: " + address.getCityID().getName());
				}

			}

			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void listCreditCards(int clientID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List employees = session.createQuery("FROM client.Clients WHERE ID=:id")
					.setParameter("id", clientID).list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				Clients client = (Clients) iterator1.next();
				System.out.println("Nombre: " + client.getName());
				System.out.println("Apellido: " + client.getLastName());
				System.out.println("********Credit Cards***************");

				Set creditCards = client.getCreditCards();
				session.update(client);

				for (Iterator iterator2 = creditCards.iterator(); iterator2.hasNext();) {
					CreditCard card = (CreditCard) iterator2.next();
					System.out.println("Numero: " + card.getCardNumber() + "--- Nombre: " + card.getCardHolder()
							+ "--- Tipo: " + card.getCardTypeID().getName());
				}

			}

			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void listArticles() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List employees = session.createQuery("FROM order.Articles").list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				Articles client = (Articles) iterator1.next();
				System.out.println("----------------------------------");
				System.out.println("ID: " + client.getId());
				System.out.println("Nombre: " + client.getName());
				System.out.println("Descripcion: " + client.getDescription());
				System.out.println("Precio: " + client.getPrice());
				System.out.println("Cantidad: " + client.getStock());
				session.update(client);
			}
			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void listDeliveryPackages() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List employees = session.createQuery("FROM delivery.DeliveryPackages").list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				DeliveryPackages client = (DeliveryPackages) iterator1.next();
				System.out.println("----------------------------------");
				System.out.println("ID: " + client.getId());
				System.out.println("Dia: " + client.getDeliveryDate());
				System.out.println("Numero: " + client.getPackageNumber());
				System.out.println("Nombre: " + client.getCompany().getName());
				session.update(client);
			}
			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void listBilling() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List employees = session.createQuery("FROM order.Billing").list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				Billing client = (Billing) iterator1.next();
				System.out.println("----------------------------------");
				System.out.println("ID: " + client.getId());
				System.out.println("ID: " + client.getBillingDate());
				session.update(client);
			}
			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Integer addBilling(double invoice, double amount, Date billingDate) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer billingID = null;

		try {
			tx = session.beginTransaction();

			Billing billing = new Billing();
			billing.setInvoice(invoice);
			billing.setAmount(amount);
			billing.setBillingDate(billingDate);

			billingID = (Integer) session.save(billing);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return billingID;
	}

	public void listPurchaseOrders() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List employees = session.createQuery("FROM order.PurchaseOrder").list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				PurchaseOrder client = (PurchaseOrder) iterator1.next();
				System.out.println("----------------------------------");
				System.out.println("ID: " + client.getId());
				System.out.println("ID: " + client.getPurchaseDate());
				System.out.println("ID: " + client.getDeliveryAddress().getStreet());
				System.out.println("ID: " + client.getBillingID().getInvoice());
				System.out.println("ID: " + client.getDeliveryPackageID().getCompany().getName());

				Set deliveryAddress = client.getArticles();
				session.update(client);

				for (Iterator iterator2 = deliveryAddress.iterator(); iterator2.hasNext();) {
					Articles address = (Articles) iterator2.next();
					System.out.println("++++++++++++++++++++++++++++++++++");
					System.out.println("ID: " + address.getId());
					System.out.println("Nombre: " + address.getName());
					System.out.println("Descripcion: " + address.getDescription());
					System.out.println("Precio: " + address.getPrice());
					System.out.println("Cantidad: " + address.getStock());
				}

			}
			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Integer getDeliveryAddress(int clientID) {
		Session session = factory.openSession();
		Transaction tx = null;
		int deliveryID = 0;
		try {
			tx = session.beginTransaction();
			List clients = session.createQuery("FROM client.Clients WHERE ID=:id").setParameter("id", clientID)
					.list();
			Iterator iterator1 = clients.iterator();
			Clients client = (Clients) iterator1.next();
			Set clientsDelivery = client.getDeliveryAddress();
			Iterator iterator2 = clientsDelivery.iterator();
			DeliveryAddress delivery = (DeliveryAddress) iterator2.next();
			deliveryID = delivery.getId();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return deliveryID;
	}

	public Integer addDeliveryPackages(Date date, int packageNumber, Company company) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer packageID = null;

		try {
			tx = session.beginTransaction();

			DeliveryPackages packages = new DeliveryPackages();
			packages.setDeliveryDate(date);
			packages.setPackageNumber(packageNumber);
			packages.setCompany(company);

			packageID = (Integer) session.save(packages);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return packageID;
	}

	public Company getCompany(int companyID) {
		Company company = new Company();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			company = (Company) session.get(Company.class, companyID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return company;
	}

	public void addPurchaseOrder(int billingID, Date purchaseDate, int deliveryPackageID, int deliveryAddressID,
			int clientID, Set<Articles> articleList) {
		Session session = factory.openSession();
		Transaction tx = null;
		int purchaseID;

		try {
			tx = session.beginTransaction();
			PurchaseOrder purchase = new PurchaseOrder();
			Billing bill = (Billing) session.get(Billing.class, billingID);
			Clients client = (Clients) session.get(Clients.class, clientID);
			DeliveryPackages deliveryPackage = (DeliveryPackages) session.get(DeliveryPackages.class,deliveryPackageID);
			DeliveryAddress address = (DeliveryAddress) session.get(DeliveryAddress.class, clientID);

			purchase.setBillingID(bill);
			purchase.setPurchaseDate(purchaseDate);
			purchase.setDeliveryAddress(address);
			purchase.setDeliveryPackageID(deliveryPackage);
			purchase.getClients().add(client);
			purchase.setArticles(articleList);

			purchaseID = (Integer) session.save(purchase);

			tx.commit();
			System.out.println("Termino");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	// Create list of Credit Cards
	/*
	 * Set<CreditCard> credit = new HashSet<CreditCard>(); CreditCard card = new
	 * CreditCard("1231312","Cardholder name", ME.getCardType(1)); credit.add(card);
	 */
	// Random rand = new Random();
	// City city = ME.getCitybyID(1);
	// System.out.println(city.getName());
	// ME.addCreditCard(1, "Ivan Martinez", "123456789",ME.getCardType(1));
	// ME.listDeliveryAddress(1);
	// ME.listCreditCards(1);
	// ME.listArticles();
	// ME.listDeliveryPackages();

	// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	// System.out.println("ID de billing:
	// "+ME.addBilling(ME.createRandom(),rand.nextInt(250),date));
	// ME.listBilling();
	// ME.listPurchaseOrders();
	// ME.addPurchaseOrder(1, date, 1, 36, 1);
// Set<Articles> articleList = new HashSet<Articles>();
// articleList.add(ME.searchArticle(1));
// articleList.add(ME.searchArticle(2));
// articleList.add(ME.searchArticle(3));
// articleList.add(ME.searchArticle(4));
// for (Iterator iterator2 = articleList.iterator(); iterator2.hasNext();) {
// 	Articles Articles = (Articles) iterator2.next();
//		System.out.println("--" + Articles.getName());
//	} 

}