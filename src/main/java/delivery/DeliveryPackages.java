package delivery;

import java.util.Date;

import order.Company;

public class DeliveryPackages {
	private int id;
	private int packageNumber;
	private Date deliveryDate;
	private Company company;
	
	public DeliveryPackages() {}
	
	public DeliveryPackages(Date deliveryDate, int packageNumber, Company company) {
		this.deliveryDate = deliveryDate;
		this.packageNumber = packageNumber;
		this.company = company;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getPackageNumber() {
		return packageNumber;
	}
	public void setPackageNumber(int packageNumber) {
		this.packageNumber = packageNumber;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}	
}
