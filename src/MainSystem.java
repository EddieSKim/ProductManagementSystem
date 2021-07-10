import userInterface.MenuPage;
import backEnd.DatabaseConnection;


public class MainSystem {

	public static void main(String[] args) {
		
		DatabaseConnection c = new DatabaseConnection();
		c.connectToDatabase();
		c.createLists();
		
		MenuPage main = new MenuPage(c);
		main.getMainPage().setVisible(true);
	}

}

