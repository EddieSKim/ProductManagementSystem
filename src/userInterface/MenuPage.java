package userInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import backEnd.*;


public class MenuPage {
	// Button to direct to product viewer page
	private JButton viewPage;
	// Allow deleting items from list
	private JButton editPage;
	// Button to add product page 
	private JButton addProdPage;
	// Main GUI frame
	private JFrame mainPage;
	// Database
	private DatabaseConnection dataList;
	

	public MenuPage(DatabaseConnection data) {
		dataList = data;
		// Retrieve new list
		dataList.createLists();
		
		mainPage = new JFrame("Product Sorter");
		mainPage.setSize(300, 200);
		mainPage.setLayout(null);
		mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		viewPage = new JButton("View Products");
		viewPage.setBounds(40,10,200,30);
		
		editPage = new JButton("Edit Product");
		editPage.setBounds(40, 50, 200, 30);
		
		addProdPage = new JButton("Add New Product");
		addProdPage.setBounds(40, 90, 200, 30);
		
		
		// Add button action listener
		viewPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProductView listView = new ProductView(dataList);
				listView.viewFrameVisible();
				mainPage.setVisible(false);
			}
			
		});
		
		// Edit product page button
		editPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditSearchPage editSearch = new EditSearchPage(dataList);
				editSearch.editSearchVisible();
				
				mainPage.setVisible(false);
			}
			
		});
		
		// Add product page button
		addProdPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddProductPage addProd = new AddProductPage(dataList);
				addProd.addPageVisible();
				mainPage.setVisible(false);
			}
			
		});
		
		// Adding components to frame
		mainPage.getContentPane().add(viewPage);
		mainPage.getContentPane().add(editPage);
		mainPage.getContentPane().add(addProdPage);
		
	}
	
	public void mainMenuVisible() {
		mainPage.setVisible(true);
	}
	
	public DatabaseConnection getDataList() {
		return dataList;
	}
	public void setDataList(DatabaseConnection dataList) {
		this.dataList = dataList;
	}
	public JButton getEditPage() {
		return editPage;
	}
	public void setEditPage(JButton editPage) {
		this.editPage = editPage;
	}
	public JButton getViewPage() {
		return viewPage;
	}
	public void setViewPage(JButton viewPage) {
		this.viewPage = viewPage;
	}
	public JFrame getMainPage() {
		return mainPage;
	}
	public void setMainPage(JFrame mainPage) {
		this.mainPage = mainPage;
	}
	public JButton getAddProdPage() {
		return addProdPage;
	}
	public void setAddProdPage(JButton addProdPage) {
		this.addProdPage = addProdPage;
	}
}

