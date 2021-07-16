package hibernate_maven;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import delivery.City;
import delivery.Country;
import delivery.DeliveryAddress;
import delivery.State;
import hibernate_store.ManageClients;

public class TestClient {
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
		// Check that an object isn't null
		assertNotNull(ID);
	}

	@Test
	public void clientTestFail() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		// Create list of delivery address
		Set<DeliveryAddress> delivery = new HashSet<DeliveryAddress>();
		City cityID = ME.getCitybyID(1);
		State stateID = ME.getStatebyID(1);
		Country countryID = ME.getCountrybyID(1);

		if (cityID != null && stateID != null && countryID != null) {
			DeliveryAddress delAdd = new DeliveryAddress("Ignacio Zaragoza 0044", 123, cityID, stateID, countryID);
			delivery.add(delAdd);
			int ID = ME.addClient("Juan", "Estrada", "user", "password", "correo2@correo.com", delivery);
			assertNotNull(ID);
		} else {
			assertNull(cityID);
			assertNull(stateID);
			assertNull(countryID);
		}
	}
}
