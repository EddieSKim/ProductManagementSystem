package backEnd;

//Products usually in food retail stores
import java.sql.Date;

public class Product {
	
	// Name of product
	private String description;
	
	// Category of product
	private String department;
	
	// UPC of product
	private String upc;
	
	// Product order code
	private int itemCode;
	
	// Product case cost from supplier
	private float caseCost;
	
	// Unit price of product
	private float unitCost;
	
	// Selling price of product, set by retail 
	private float salePrice;
	
	// Number of products available at retail
	private int stock;
	
	// Number of products in a case
	private int itemsInCase;
	
	// Date of expiration
	private Date expiryDate;
	
	// Item taxable or not
	private boolean taxable;
	
	// Constructor
	public Product(String des, String dep, String u, int i, float c, 
			float unit, float s, int st, int itC, Date e, boolean tax){
		description = des;
		department = dep;
		upc = u;
		itemCode = i;
		caseCost = c;
		unitCost = unit;
		salePrice = s;
		stock = st;
		itemsInCase = itC;
		expiryDate = e;
		taxable = tax;
	}
	
	@Override
	public String toString() {
		return description + " " + department + " " + upc + " " + 
				String.valueOf(itemCode) + " " + String.valueOf(caseCost) + " " + 
				String.valueOf(unitCost) + " " + String.valueOf(salePrice) + " " +
				String.valueOf(stock) + " " + String.valueOf(itemsInCase) + " " +
				expiryDate.toString() + " " + String.valueOf(taxable) + "\n";
	}
	
	// Getters and Setters
	public boolean isTaxable() {
		return taxable;
	}
	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getItemsInCase() {
		return itemsInCase;
	}
	public void setItemsInCase(int itemsInCase) {
		this.itemsInCase = itemsInCase;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}
	public float getCaseCost() {
		return caseCost;
	}
	public void setCaseCost(float caseCost) {
		this.caseCost = caseCost;
	}
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}

