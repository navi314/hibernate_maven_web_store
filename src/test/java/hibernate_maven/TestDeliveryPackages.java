package hibernate_maven;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import hibernate_store.ManageClients;
import order.Articles;
import order.Company;

public class TestDeliveryPackages {
	@Test
	public void addDeliveryPackage() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Date date = new Date();
		int deliPackage = ME.addDeliveryPackages(date, ME.createRandom(), ME.getCompany(1));
		assertNotNull(deliPackage);
	}
	
	@Test
	public void addDeliveryPackageFail() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Date date = new Date();
		Company company = ME.getCompany(999);
		//int deliPackage = ME.addDeliveryPackages(date, ME.createRandom(), company);
		assertNull(company);
	}
}
