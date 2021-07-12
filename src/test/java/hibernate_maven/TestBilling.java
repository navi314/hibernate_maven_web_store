package hibernate_maven;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import hibernate_store.ManageClients;
import order.Articles;

public class TestBilling {
	@Test
	public void searchArticle() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Articles article = ME.searchArticle(1);
		assertNotNull(article);
	}
	
	@Test
	public void searchArticleFail() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Articles article = ME.searchArticle(999);
		assertNull(article);
	}
	
	@Test
	public void createBilling() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Articles article = ME.searchArticle(999);
		assertNull(article);
		
		// List of items
		Set<Articles> articleList = new HashSet<Articles>();
		articleList.add(ME.searchArticle(1));
		articleList.add(ME.searchArticle(2));
		articleList.add(ME.searchArticle(3));
		articleList.add(ME.searchArticle(4));
		int amount = ME.getAmount(articleList);
		assertTrue(amount > 0);
	}
	
	@Test
	public void createBillingFail() {
		ManageClients ME = new ManageClients();
		try {
			ManageClients.factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Articles article = ME.searchArticle(999);
		assertNull(article);
		
		// List of items
		Set<Articles> articleList = new HashSet<Articles>();
		articleList.add(ME.searchArticle(999));
		articleList.add(ME.searchArticle(999));
		articleList.add(ME.searchArticle(999));
		articleList.add(ME.searchArticle(999));
		int amount = ME.getAmount(articleList);
		assertFalse(amount > 0);
	}
}
