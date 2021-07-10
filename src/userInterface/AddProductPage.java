package userInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;
import backEnd.*;

public class AddProductPage {
	
	// Back to menu button
	private JButton menuBtn;
	// Confirm new product button
	private JButton confirmBtn;
	// GUI frame
	private JFrame addFrame;
	//
	@SuppressWarnings("rawtypes")
	private JComboBox departDropDown;
	
	// Product labels
	// Product description
	private JLabel descript;
	// Product department
	private JLabel departmt;
	// Product UPC
	private JLabel upc;
	// Product Item code or Order Code
	private JLabel itemID;
	// Product case cost
	private JLabel caseCost;
	// Number of units in case
	private JLabel numUnits;
	// Product unit price
	private JLabel unitCst;
	// Product selling price
	private JLabel saleCst;
	// Number of stocks
	private JLabel stock;
	// Product expire date
	private JLabel expireDate;
	// Product taxable
	private JLabel taxable;
	
	// Filled in with product info
	// Product description
	private JTextField prodDes;
	// Product department
	private JTextField prodDepart;
	// Product UPC
	private JTextField prodUPC;
	// Product item code or order code
	private JTextField prodID;
	// Product case price
	private JTextField prodCase;
	// Product units in case
	private JTextField prodNumUnit;
	// Product unit price
	private JTextField prodUnit;
	// Product selling price
	private JTextField prodSale;
	// Product stock in store
	private JTextField prodStock;
	// Product expire date
	private JTextField prodExpire;
	// Product taxable
	private JTextField prodTax;
	
	private DatabaseConnection dataList;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	AddProductPage(DatabaseConnection data){
		dataList = data;
		// Retrieve new item list
		dataList.createLists();
		
		addFrame = new JFrame("Product Edit");
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrame.setLayout(null);
		addFrame.setSize(1000, 600);
		
		// Item labels
		descript = new JLabel("Description");
		descript.setFont(new Font("SansSerif", Font.PLAIN, 16));
		descript.setBounds(20, 20, 100, 40);
		addFrame.getContentPane().add(descript);
		
		departmt = new JLabel("Department");
		departmt.setFont(new Font("SansSerif", Font.PLAIN, 16));
		departmt.setBounds(500, 20, 100, 40);
		addFrame.getContentPane().add(departmt);
		
		upc = new JLabel("UPC");
		upc.setFont(new Font("SansSerif", Font.PLAIN, 16));
		upc.setBounds(20, 70, 100, 40);
		addFrame.getContentPane().add(upc);
		
		itemID = new JLabel("Item Code");
		itemID.setFont(new Font("SansSerif", Font.PLAIN, 16));
		itemID.setBounds(500, 70, 100, 40);
		addFrame.getContentPane().add(itemID);
		
		caseCost = new JLabel("Case Cost");
		caseCost.setFont(new Font("SansSerif", Font.PLAIN, 16));
		caseCost.setBounds(20, 120, 100, 40);
		addFrame.getContentPane().add(caseCost);
		
		numUnits = new JLabel("Units in Case");
		numUnits.setFont(new Font("SansSerif", Font.PLAIN, 16));
		numUnits.setBounds(500, 120, 100, 40);
		addFrame.getContentPane().add(numUnits);
		
		unitCst = new JLabel("Unit Cost");
		unitCst.setFont(new Font("SansSerif", Font.PLAIN, 16));
		unitCst.setBounds(20, 170, 100, 40);
		addFrame.getContentPane().add(unitCst);
		
		saleCst = new JLabel("Sale Cost");
		saleCst.setFont(new Font("SansSerif", Font.PLAIN, 16));
		saleCst.setBounds(500, 170, 100, 40);
		addFrame.getContentPane().add(saleCst);
		
		stock = new JLabel("In Stock");
		stock.setFont(new Font("SansSerif", Font.PLAIN, 16));
		stock.setBounds(20, 220, 100, 40);
		addFrame.getContentPane().add(stock);
		
		expireDate = new JLabel("Expiry Date");
		expireDate.setFont(new Font("SansSerif", Font.PLAIN, 16));
		expireDate.setBounds(500, 220, 100, 40);
		addFrame.getContentPane().add(expireDate);
		
		taxable = new JLabel("Taxable");
		taxable.setFont(new Font("SansSerif", Font.PLAIN, 16));
		taxable.setBounds(20, 270, 100, 40);
		addFrame.getContentPane().add(taxable);
		
		// Jtextfield added to JFrame
		prodDes = new JTextField();
		prodDes.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodDes.setBounds(110, 20, 300, 40);
		addFrame.getContentPane().add(prodDes);
		
		/*prodDepart = new JTextField();
		prodDepart.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodDepart.setBounds(610, 20, 300, 40);
		addFrame.getContentPane().add(prodDepart);*/
		
		String dropOptions [] = {"Grocery", "Grocery Tax", "Produce", "Dairy", "Meat"};
		departDropDown = new JComboBox(dropOptions);
		departDropDown.setFont(new Font("SansSerif", Font.PLAIN, 16));
		departDropDown.setBounds(610, 20, 300, 40);
		addFrame.getContentPane().add(departDropDown);
		
		
		prodUPC = new JTextField();
		prodUPC.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodUPC.setBounds(110, 70, 300, 40);
		addFrame.getContentPane().add(prodUPC);
		
		prodID = new JTextField();
		prodID.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodID.setBounds(610, 70, 300, 40);
		addFrame.getContentPane().add(prodID);
		
		prodCase = new JTextField();
		prodCase.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodCase.setBounds(110, 120, 300, 40);
		addFrame.getContentPane().add(prodCase);
		
		prodNumUnit = new JTextField();
		prodNumUnit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodNumUnit.setBounds(610, 120, 300 ,40);
		addFrame.getContentPane().add(prodNumUnit);
		
		prodUnit = new JTextField();
		prodUnit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodUnit.setBounds(110, 170, 300, 40);
		addFrame.getContentPane().add(prodUnit);
		// Calculates unit price if case cost and number of units in case exists
		prodUnit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(prodCase.getText().compareTo("") != 0 && prodNumUnit.getText().compareTo("") != 0) {
					float temp = (float) (Math.round((Float.parseFloat(prodCase.getText())/Float.parseFloat(prodNumUnit.getText()))*100.0)/100.0);
					prodUnit.setText(String.valueOf(temp));
				}
			}
		});
		
		prodSale = new JTextField();
		prodSale.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodSale.setBounds(610, 170, 300, 40);
		addFrame.getContentPane().add(prodSale);
		
		prodStock = new JTextField();
		prodStock.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodStock.setBounds(110, 220, 300, 40);
		addFrame.getContentPane().add(prodStock);
		
		prodExpire = new JTextField("(yyyy-mm-dd)");
		prodExpire.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodExpire.setBounds(610, 220, 300, 40);
		addFrame.getContentPane().add(prodExpire);
		// Delete default text when clicked on
		prodExpire.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				prodExpire.setText("");
			}
		});
		
		prodTax = new JTextField("Yes/No");
		prodTax.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodTax.setBounds(110, 270, 300, 40);
		addFrame.getContentPane().add(prodTax);
		// Delete default text when clicked on
		prodTax.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				prodTax.setText("");
			}
		});
		
		
		// Adding buttons to frame
		menuBtn = new JButton("Main Menu");
		menuBtn.setBounds(610, 340, 150, 40);
		// Menu button action
		menuBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addFrame.setVisible(false);
				MenuPage menu = new MenuPage(dataList);
				menu.mainMenuVisible();
			}
			
		});
		addFrame.getContentPane().add(menuBtn);
		
		// Confirm button
		confirmBtn = new JButton("Add Product");
		confirmBtn.setBounds(770, 340, 150, 40);
		// Edit another product button action
		confirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// If any field are empty prompts user to try again
				if(prodDes.getText().compareTo("") == 0  || prodUPC.getText().compareTo("") == 0 || prodID.getText().compareTo("") == 0 || 
						prodCase.getText().compareTo("") == 0 || prodUnit.getText().compareTo("") == 0 || prodSale.getText().compareTo("") == 0 || prodStock.getText().compareTo("") == 0 
						|| prodNumUnit.getText().compareTo("") == 0 || prodExpire.getText().compareTo("") == 0 || prodTax.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(null, "Please fill in the empty fields");
				}else {
				
					// Convert text to boolean
					boolean t = true;
					if(prodTax.getText().compareToIgnoreCase("yes") == 0) {
						t = true;
					}else
						t = false;
				
					// Convert string date to sql date object
					Date tempDate = java.sql.Date.valueOf(prodExpire.getText());
				
					Product temp = new Product(prodDes.getText(), departDropDown.getSelectedItem().toString(), prodUPC.getText(), Integer.parseInt(prodID.getText()),
						Float.parseFloat(prodCase.getText()), Float.parseFloat(prodUnit.getText()), 
						Float.parseFloat(prodSale.getText()), Integer.parseInt(prodStock.getText()), 
						Integer.parseInt(prodNumUnit.getText()), tempDate, t);
				
					// Check if products exists before adding to database
					if(dataList.verifyProduct(temp.getItemCode()) == null) {
						dataList.addToDatabase(temp);
						JOptionPane.showMessageDialog(null, "Product " + prodID.getText() + " has been added");
						addFrame.setVisible(false);
					
						MenuPage main = new MenuPage(dataList);
						main.mainMenuVisible();
					
					}else {
						JOptionPane.showMessageDialog(null, "Product " + prodID.getText() + " already exists. Please try again.");
					}
				}
			}
		});
		addFrame.getContentPane().add(confirmBtn);
		
	}
	
	public void addPageVisible() {
		addFrame.setVisible(true);
	}
}

