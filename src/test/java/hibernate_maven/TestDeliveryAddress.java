package hibernate_maven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import hibernate_store.ManageClients;

public class TestDeliveryAddress {
	@Test
	public void deliveryAddress() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
				
		String result = ME.addDeliveryAddress(1, "Ignacio Zaragoza 0064", 889, 
				ME.getCitybyID(1),ME.getStatebyID(1),ME.getCountrybyID(1));
		assertEquals("Se agrego la direccion",result);
	}
	
	@Test
	public void deliveryAddressFail() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
				
		String result = ME.addDeliveryAddress(999, "Ignacio Zaragoza 0064", 889, 
				ME.getCitybyID(1),ME.getStatebyID(1),ME.getCountrybyID(1));
		assertEquals("Error",result);
	}
	
	@Test
	public void deliveryAddressSearch() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
			
		int deliveryAdd = ME.getDeliveryAddress(1);
		assertNotNull(deliveryAdd);
	}
	
	@Test
	public void deliveryAddressSearchFail() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
			
		int deliveryAdd = ME.getDeliveryAddress(999);
		assertEquals(deliveryAdd,0);
	}
}
