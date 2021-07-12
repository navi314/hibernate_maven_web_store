package hibernate_maven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import hibernate_store.ManageClients;
import order.Articles;

public class TestPurchaseOrder {
	@Test
	public void addPurchaseOrder() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		// Date
		Date date = new Date();	
		// List of items
		Set<Articles> articleList = new HashSet<Articles>();
		articleList.add(ME.searchArticle(4));
		articleList.add(ME.searchArticle(5));
		articleList.add(ME.searchArticle(6));
		articleList.add(ME.searchArticle(7));
		
		int bill = 1, deliveryAdd = 1, ID = 1, deliPackage = 1;		
		String res = ME.addPurchaseOrder(bill, date, deliPackage, deliveryAdd, ID, articleList);
		assertEquals(res, "Termino");
	}
	
	@Test
	public void addPurchaseOrderFail() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		// Date
		Date date = new Date();	
		// List of items
		Set<Articles> articleList = new HashSet<Articles>();
		articleList.add(ME.searchArticle(4));
		articleList.add(ME.searchArticle(5));
		articleList.add(ME.searchArticle(6));
		articleList.add(ME.searchArticle(7));
		
		int bill = 999, deliveryAdd = 999, ID = 999, deliPackage = 999;		
		String res = ME.addPurchaseOrder(bill, date, deliPackage, deliveryAdd, ID, articleList);
		assertEquals(res, "Error");
	}
}
