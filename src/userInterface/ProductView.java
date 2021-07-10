package userInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import backEnd.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ProductView extends JPanel{

	// Frame for product viewing
	private JFrame viewFrame;
	// Product table
	private JTable prodTable;
	// Panel to add JTable
	private JPanel p;
	// Scroll pane to display JTabel
	private JScrollPane scroll;
	// Back button component
	private JButton backBtn;
	// Back end
	private DatabaseConnection dataList;
	// List of products
	private ArrayList<Product> prodList;
	
	
	public ProductView(DatabaseConnection data) {
		dataList = data;
		dataList.createLists();
		
		// Table header
		String [] column = {"UPC", "Item Code", "Description", "Department", "Taxable", "Case Cost", "Items In Case", "Unit Price", "Sale Price", "Num In Stock", "Expiry Date"};
		
		prodList = dataList.getProdlist();
		viewFrame = new JFrame("Product List");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		viewFrame.setSize(1500, 700);
		
		p = new JPanel();
		backBtn = new JButton("Back to Menu");
		
		prodTable = new JTable() {
			// Prevent table editing
			public boolean editCellAt(int r, int c, java.util.EventObject e) {
				return false;
			}
		};
		
		scroll = new JScrollPane(prodTable);
		// Set scroll component size
		scroll.setPreferredSize(new Dimension (1400, 600));
		
		DefaultTableModel model = new DefaultTableModel();
		
		// Add header to table model
		model.setColumnIdentifiers(column);
		
		// Set table model to table
		prodTable.setModel(model);
		
		// Set table cell width 
		prodTable.getColumnModel().getColumn(0).setPreferredWidth(220);
		prodTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		prodTable.getColumnModel().getColumn(2).setPreferredWidth(240);
		prodTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		prodTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		prodTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		prodTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		prodTable.getColumnModel().getColumn(7).setPreferredWidth(100);
		prodTable.getColumnModel().getColumn(8).setPreferredWidth(100);
		prodTable.getColumnModel().getColumn(9).setPreferredWidth(100);
		prodTable.getColumnModel().getColumn(10).setPreferredWidth(200);
	
		// Add products to table
		for(Product i : prodList) {
			model.addRow(new Object[] {i.getUpc(), i.getItemCode(), i.getDescription(), i.getDepartment(), String.valueOf(i.isTaxable()), i.getCaseCost(), 
					i.getItemsInCase(), i.getUnitCost(), (float)Math.round(i.getSalePrice() * 100.0)/100.0, i.getStock(), i.getExpiryDate().toString() });
		}
		
		// Back button action listener
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewFrame.setVisible(false);
				MenuPage menu = new MenuPage(dataList);
				menu.mainMenuVisible();
			}
			
		});
		
		// Add components to panel
		p.add(scroll);
		p.add(backBtn);
		
		// Add panel to frame
		viewFrame.add(p);
	}
	
	public void viewFrameVisible() {
		viewFrame.setVisible(true);;
	}
}

