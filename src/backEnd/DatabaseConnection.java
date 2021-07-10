package backEnd;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
	
	// Connection to database
	private Connection conn;
	
	// SQL Statement executors
	private Statement stment;
	
	// SQL statement results
	private ResultSet prodRslt;
	private PreparedStatement updateStmt;
	private PreparedStatement deleteStmt;
	private PreparedStatement addStmt;
	
	private ArrayList<Product> prodlist;
	
	public DatabaseConnection(){
		prodlist = new ArrayList<Product>();
	}

	public void connectToDatabase() {
		try {
			// Connecting to local MySQL database
			conn = DriverManager.getConnection("Replace with local MySQL database connection");
			
			// Statement
			stment = conn.createStatement();
			
			// Execute SQL Query to retrieve product table
			prodRslt = stment.executeQuery("select * from products");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createLists() {
		try {
			while(prodRslt.next()) {
				// Add products from database to the list of products
				Product temp = new Product(prodRslt.getString("ProductName"), prodRslt.getString("Department"), 
						prodRslt.getString("UPC"), prodRslt.getInt("OrderID"), prodRslt.getFloat("CaseCost"), 
						prodRslt.getFloat("UnitCost"), prodRslt.getFloat("SalePrice"), prodRslt.getInt("Stock"), 
						prodRslt.getInt("ItemsInCase"), prodRslt.getDate("ExpiryDate"), prodRslt.getBoolean("Taxable"));
				
				prodlist.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addToDatabase(Product p) {
		try {
			// Insert query 
			// Set to "?" to avoid SQL injects
			String add = "INSERT INTO products (UPC, ProductName, Department, CaseCost, UnitCost, SalePrice, ItemsInCase, Stock, ExpiryDate, Taxable, OrderID)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			addStmt = conn.prepareStatement("INSERT INTO products (UPC, ProductName, Department, CaseCost, UnitCost, SalePrice, ItemsInCase, Stock, ExpiryDate, Taxable, OrderID)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			
			// Prepare data to put into database table
			addStmt.setString(1, p.getUpc());
			addStmt.setString(2, p.getDescription());
			addStmt.setString(3, p.getDepartment());
			addStmt.setFloat(4, p.getCaseCost());
			addStmt.setFloat(5, p.getUnitCost());
			addStmt.setFloat(6, p.getSalePrice());
			addStmt.setInt(7, p.getItemsInCase());
			addStmt.setInt(8, p.getStock());
			addStmt.setDate(9, p.getExpiryDate());
			addStmt.setBoolean(10, p.isTaxable());
			addStmt.setInt(11, p.getItemCode());
			
			// Execute query
			int addedRow = addStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFromDatabase(Product p) {
		try {
			// Delete statement
			// Set to "?" to avoid SQL injections
			deleteStmt = conn.prepareStatement("DELETE products WHERE OrderID = ?");
			
			// Select row to delete
			deleteStmt.setInt(1, p.getItemCode());
			
			// Execute query
			int deletedRow = deleteStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Updating current product in the database
	public void updateData(Product p) {
		
		try {
			// Update row
			// Set as "?" to avoid SQL injections
			updateStmt = conn.prepareStatement("UPDATE products SET UPC = ?, ProductName = ?, Department = ?, CaseCost = ?, UnitCost = ?, "
					+ "SalePrice = ?, ItemsInCase = ?, Stock = ?, ExpiryDate = ?, Taxable = ? WHERE OrderID = ?");
			
			updateStmt.setString(1, p.getUpc());
			updateStmt.setString(2, p.getDescription());
			updateStmt.setString(3, p.getDepartment());
			updateStmt.setFloat(4, p.getCaseCost());
			updateStmt.setFloat(5, p.getUnitCost());
			updateStmt.setFloat(6, p.getSalePrice());
			updateStmt.setInt(7, p.getItemsInCase());
			updateStmt.setInt(8, p.getStock());
			updateStmt.setDate(9, p.getExpiryDate());
			updateStmt.setBoolean(10, p.isTaxable());
			updateStmt.setInt(11, p.getItemCode());
			
			int updatedRow = updateStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Verify current product with the product list
	// Returns the product if product exists
	public Product verifyProduct(int itemID) {
		
		for(Product i : prodlist) {
			if(i.getItemCode() == itemID) {
				return i;
			}
		};
		
		return null;
	}
	
	public ArrayList<Product> getProdlist() {
		return prodlist;
	}

	public void setProdlist(ArrayList<Product> prodlist) {
		this.prodlist = prodlist;
	}
}


