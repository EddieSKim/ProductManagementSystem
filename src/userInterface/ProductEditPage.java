package userInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import backEnd.*;

public class ProductEditPage {

	private JButton menuBtn;
	private JButton editAgainBtn;
	private JButton confirmBtn;
	private JButton deleteBtn;
	private JFrame editFrame;
	
	// Product labels
	private JLabel descript;
	private JLabel departmt;
	private JLabel upc;
	private JLabel itemID;
	private JLabel caseCost;
	private JLabel numUnits;
	private JLabel unitCst;
	private JLabel saleCst;
	private JLabel stock;
	private JLabel expireDate;
	private JLabel taxable;
	
	// Filled in with product info
	private JTextField prodDes;
	private JTextField prodDepart;
	private JTextField prodUPC;
	private JTextField prodID;
	private JTextField prodCase;
	private JTextField prodNumUnit;
	private JTextField prodUnit;
	private JTextField prodSale;
	private JTextField prodStock;
	private JTextField prodExpire;
	private JTextField prodTax;
	
	private DatabaseConnection dataList;
	
	
	ProductEditPage(DatabaseConnection data, Product p){
		dataList = data;
		// Retrieve new item list
		dataList.createLists();
		
		editFrame = new JFrame("Product Edit");
		editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editFrame.setLayout(null);
		editFrame.setSize(1000, 600);
		
		// Item labels
		descript = new JLabel("Description");
		descript.setFont(new Font("SansSerif", Font.PLAIN, 16));
		descript.setBounds(20, 20, 100, 40);
		editFrame.getContentPane().add(descript);
		
		departmt = new JLabel("Department");
		departmt.setFont(new Font("SansSerif", Font.PLAIN, 16));
		departmt.setBounds(500, 20, 100, 40);
		editFrame.getContentPane().add(departmt);
		
		upc = new JLabel("UPC");
		upc.setFont(new Font("SansSerif", Font.PLAIN, 16));
		upc.setBounds(20, 70, 100, 40);
		editFrame.getContentPane().add(upc);
		
		itemID = new JLabel("Item Code");
		itemID.setFont(new Font("SansSerif", Font.PLAIN, 16));
		itemID.setBounds(500, 70, 100, 40);
		editFrame.getContentPane().add(itemID);
		
		caseCost = new JLabel("Case Cost");
		caseCost.setFont(new Font("SansSerif", Font.PLAIN, 16));
		caseCost.setBounds(20, 120, 100, 40);
		editFrame.getContentPane().add(caseCost);
		
		numUnits = new JLabel("Units in Case");
		numUnits.setFont(new Font("SansSerif", Font.PLAIN, 16));
		numUnits.setBounds(500, 120, 100, 40);
		editFrame.getContentPane().add(numUnits);
		
		unitCst = new JLabel("Unit Cost");
		unitCst.setFont(new Font("SansSerif", Font.PLAIN, 16));
		unitCst.setBounds(20, 170, 100, 40);
		editFrame.getContentPane().add(unitCst);
		
		saleCst = new JLabel("Sale Cost");
		saleCst.setFont(new Font("SansSerif", Font.PLAIN, 16));
		saleCst.setBounds(500, 170, 100, 40);
		editFrame.getContentPane().add(saleCst);
		
		stock = new JLabel("In Stock");
		stock.setFont(new Font("SansSerif", Font.PLAIN, 16));
		stock.setBounds(20, 220, 100, 40);
		editFrame.getContentPane().add(stock);
		
		expireDate = new JLabel("Expiry Date");
		expireDate.setFont(new Font("SansSerif", Font.PLAIN, 16));
		expireDate.setBounds(500, 220, 100, 40);
		editFrame.getContentPane().add(expireDate);
		
		taxable = new JLabel("Taxable");
		taxable.setFont(new Font("SansSerif", Font.PLAIN, 16));
		taxable.setBounds(20, 270, 100, 40);
		editFrame.getContentPane().add(taxable);
		
		// Item Info
		prodDes = new JTextField();
		prodDes.setText(p.getDescription());
		prodDes.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodDes.setBounds(110, 20, 300, 40);
		editFrame.getContentPane().add(prodDes);
		
		prodDepart = new JTextField();
		prodDepart.setText(p.getDepartment());
		prodDepart.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodDepart.setBounds(610, 20, 300, 40);
		editFrame.getContentPane().add(prodDepart);
		
		prodUPC = new JTextField();
		prodUPC.setText(p.getUpc());
		prodUPC.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodUPC.setBounds(110, 70, 300, 40);
		editFrame.getContentPane().add(prodUPC);
		
		prodID = new JTextField();
		prodID.setText(String.valueOf(p.getItemCode()));
		prodID.setEditable(false);
		prodID.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodID.setBounds(610, 70, 300, 40);
		editFrame.getContentPane().add(prodID);
		
		prodCase = new JTextField();
		prodCase.setText(String.valueOf(p.getCaseCost()));
		prodCase.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodCase.setBounds(110, 120, 300, 40);
		editFrame.getContentPane().add(prodCase);
		
		prodNumUnit = new JTextField();
		prodNumUnit.setText(String.valueOf(p.getItemsInCase()));
		prodNumUnit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodNumUnit.setBounds(610, 120, 300 ,40);
		editFrame.getContentPane().add(prodNumUnit);
		
		prodUnit = new JTextField();
		prodUnit.setText(String.valueOf(p.getUnitCost()));
		prodUnit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodUnit.setBounds(110, 170, 300, 40);
		editFrame.getContentPane().add(prodUnit);
		
		prodSale = new JTextField();
		prodSale.setText(String.valueOf(p.getSalePrice()));
		prodSale.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodSale.setBounds(610, 170, 300, 40);
		editFrame.getContentPane().add(prodSale);
		
		prodStock = new JTextField();
		prodStock.setText(String.valueOf(p.getStock()));
		prodStock.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodStock.setBounds(110, 220, 300, 40);
		editFrame.getContentPane().add(prodStock);
		
		prodExpire = new JTextField();
		prodExpire.setText(p.getExpiryDate().toString());
		prodExpire.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodExpire.setBounds(610, 220, 300, 40);
		editFrame.getContentPane().add(prodExpire);
		
		prodTax = new JTextField();
		if(p.isTaxable())
			prodTax.setText("Yes");
		else
			prodTax.setText("No");
		prodTax.setFont(new Font("SansSerif", Font.PLAIN, 16));
		prodTax.setBounds(110, 270, 300, 40);
		editFrame.getContentPane().add(prodTax);
		
		// Buttons
		// Menu button
		menuBtn = new JButton("Main Menu");
		menuBtn.setBounds(290, 340, 150, 40);
		// Menu button action
		menuBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editFrame.setVisible(false);
				MenuPage menu = new MenuPage(dataList);
				menu.mainMenuVisible();
			}
			
		});
		editFrame.getContentPane().add(menuBtn);
		
		// Edit another product button
		editAgainBtn = new JButton("Edit Another");
		editAgainBtn.setBounds(450, 340, 150, 40);
		// Edit another product button action
		editAgainBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editFrame.setVisible(false);
				EditSearchPage edit = new EditSearchPage(dataList);
				edit.editSearchVisible();
			}
			
		});
		editFrame.getContentPane().add(editAgainBtn);
		
		// Confirmation button
		confirmBtn = new JButton("Confirm Edit");
		confirmBtn.setBounds(610, 340, 150, 40);
		// Edit Confirmation button action
		confirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//editFrame.setVisible(false);
				boolean t = true;
				if(prodTax.getText().compareToIgnoreCase("yes") == 0) {
					t = true;
				}else
					t = false;
				
				Date tempDate = Date.valueOf(prodExpire.getText());
				
				Product temp = new Product(prodDes.getText(), prodDepart.getText(), prodUPC.getText(), Integer.parseInt(prodID.getText()),
						Float.parseFloat(prodCase.getText()), Float.parseFloat(prodUnit.getText()), 
						Float.parseFloat(prodSale.getText()), Integer.parseInt(prodStock.getText()), 
						Integer.parseInt(prodNumUnit.getText()), tempDate, t);
				
				dataList.updateData(temp);
				
			}
			
		});
		editFrame.getContentPane().add(confirmBtn);
		
		// Delete item button
		deleteBtn = new JButton("Delete Item");
		deleteBtn.setBounds(770, 340, 150, 40);
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean t = true;
				if(prodTax.getText().compareToIgnoreCase("yes") == 0) {
					t = true;
				}else
					t = false;
				
				Date tempDate = Date.valueOf(prodExpire.getText());
				
				Product temp = new Product(prodDes.getText(), prodDepart.getText(), prodUPC.getText(), Integer.parseInt(prodID.getText()),
						Float.parseFloat(prodCase.getText()), Float.parseFloat(prodUnit.getText()), 
						Float.parseFloat(prodSale.getText()), Integer.parseInt(prodStock.getText()), 
						Integer.parseInt(prodNumUnit.getText()), tempDate, t);
				
				dataList.deleteFromDatabase(temp);
				
				JOptionPane.showMessageDialog(null, "Product " + prodID.getText() + " has been deleted");
				editFrame.setVisible(false);
				
				EditSearchPage search = new EditSearchPage(dataList);
				search.editSearchVisible();
			}
			
		});
		editFrame.getContentPane().add(deleteBtn);
	}
	
	public void editSetVisible() {
		editFrame.setVisible(true);
	}
}

