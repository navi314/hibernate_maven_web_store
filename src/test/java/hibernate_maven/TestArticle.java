package hibernate_maven;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import hibernate_store.ManageClients;
import order.Articles;

public class TestArticle {
	@Test
	public void searchArticles() {
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
	public void searchArticlesFail() {
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
	public void searchArticlesList() {
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
		articleList.add(ME.searchArticle(4));
		articleList.add(ME.searchArticle(5));
		articleList.add(ME.searchArticle(6));
		articleList.add(ME.searchArticle(7));
		int amount = ME.getAmount(articleList);
		assertTrue(amount > 0);
	}
	
	@Test
	public void searchArticlesListFail() {
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
