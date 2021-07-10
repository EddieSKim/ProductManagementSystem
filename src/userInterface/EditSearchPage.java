package userInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import backEnd.*;

public class EditSearchPage {
	// Product search frame
	private JFrame searchFrame;
	// Enter item code label
	private JLabel label;
	// Search item button
	private JButton searchBtn;
	// Back button
	private JButton backBtn;
	// Field to enter item code
	private JTextField searchField;
	// database connection
	private DatabaseConnection dataList;


	EditSearchPage(DatabaseConnection data){
		dataList = data;
		dataList.createLists();
		
		searchFrame = new JFrame("Find Item");
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchFrame.setLayout(null);
		searchFrame.setSize(500, 200);
		
		
		label = new JLabel("UPC / Item Code");
		//label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label.setBounds(30, 50, 200, 30);
		
		searchBtn = new JButton("Edit Item");
		//searchBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		searchBtn.setBounds(250, 100, 100, 30);
		
		backBtn = new JButton("Main Menu");
		backBtn.setBounds(140, 100, 100, 30);
		
		searchField = new JTextField();
		searchField.setBounds(180, 50, 250, 30);
		
		// Search the item to edit
		// If item not found, display error
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int codeID = Integer.parseInt(searchField.getText());
				Product prod = dataList.verifyProduct(codeID);
				// Check product in system
				if(prod == null) {
					JOptionPane.showMessageDialog(null, "Item does not exist in the system");
					searchField.setText("");
				}else {
					ProductEditPage edit = new ProductEditPage(dataList, prod);
					edit.editSetVisible();
				}
			}
		});
		
		// Going back to main menu
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchFrame.setVisible(false);
				MenuPage main = new MenuPage(dataList);
				main.mainMenuVisible();
			}
		});
		
		// Add to frame
		searchFrame.getContentPane().add(label);
		searchFrame.getContentPane().add(searchBtn);
		searchFrame.getContentPane().add(backBtn);
		searchFrame.getContentPane().add(searchField);
	}
	
	public void editSearchVisible() {
		searchFrame.setVisible(true);
	}

	
	// Getters and Setters
	public JFrame getSearchFrame() {
		return searchFrame;
	}
	public void setSearchFrame(JFrame searchFrame) {
		this.searchFrame = searchFrame;
	}
	public JTextField getSearchField() {
		return searchField;
	}
	public void setSearchField(JTextField searchField) {
		this.searchField = searchField;
	}
	public JButton getSearchBtn() {
		return searchBtn;
	}
	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
}

