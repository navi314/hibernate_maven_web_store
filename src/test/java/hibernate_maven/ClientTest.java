package hibernate_maven;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import delivery.DeliveryAddress;
import hibernate_store.ManageClients;

public class ClientTest {
	
	// test case
	@Test
	public void clientTest() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		// Create list of delivery address
		Set<DeliveryAddress> delivery = new HashSet<DeliveryAddress>();
		DeliveryAddress delAdd = new DeliveryAddress("Ignacio Zaragoza 0044", 123, ME.getCitybyID(1),
				ME.getStatebyID(1), ME.getCountrybyID(1));
		DeliveryAddress delAdd2 = new DeliveryAddress("Ignacio Zaragoza 0054", 159, ME.getCitybyID(1),
				ME.getStatebyID(1), ME.getCountrybyID(1));

		delivery.add(delAdd);
		delivery.add(delAdd2);

		// Create a new Client
		int ID = ME.addClient("Juan", "Estrada", "user", "password", "correo2@correo.com", delivery);
		//Check that an object isn't null
		assertNotNull(ID);
	}
	
	
	

}
