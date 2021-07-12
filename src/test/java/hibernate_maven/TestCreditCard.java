package hibernate_maven;

import static org.junit.Assert.assertEquals;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import hibernate_store.ManageClients;

public class TestCreditCard {
	@Test
	public void cardTest() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		int ID = 1;
		String result = ME.addCreditCard(ID, "Marlen Estrada 4", "123456789", ME.getCardType(1));
		assertEquals("Se agrego la tarjeta al cliente",result);
	}
	
	@Test
	public void cardTestFail() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		String result = ME.addCreditCard(99, "Marlen Estrada", "723456789", ME.getCardType(2));
		assertEquals("Error",result);
	}
}
