package order;

import java.util.HashSet;
import java.util.Set;

public class ArticleList {
	private int id;
	private Set<Articles> articles = new HashSet<Articles>(0);
	private Set<PurchaseOrder> purchaseOrder = new HashSet<PurchaseOrder>(0);
	
	public ArticleList() {}
	
	public ArticleList(int id, Set<Articles> articles, Set<PurchaseOrder> purchaseOrder) {
		super();
		this.id = id;
		this.articles = articles;
		this.purchaseOrder = purchaseOrder;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Articles> getArticles() {
		return articles;
	}
	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}
	public Set<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}	
}
