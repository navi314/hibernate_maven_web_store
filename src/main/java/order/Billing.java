package order;

import java.util.Date;

public class Billing {
	private int id;
	private double invoice;
	private double amount;
	private Date billingDate;
	
	public Billing() {}
	
	public Billing(double invoice, double amount, Date billingDate) {
		this.invoice = invoice;
		this.amount = amount;
		this.billingDate = billingDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInvoice() {
		return invoice;
	}

	public void setInvoice(double invoice) {
		this.invoice = invoice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	
}
