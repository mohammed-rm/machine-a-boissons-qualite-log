package launcher;

import view.ApplicationWindow;

import java.awt.*;

import controller.OrderDAO;
import controller.StockDAO;

public class Run {

    public static void main(String[] args){
		ConnectionDB dbManager = new ConnectionDB("Boissons.db");
		dbManager.createBoissonsTables();
		dbManager.fillBoissonsTables();
		
		StockDAO stockDAO = new StockDAO(dbManager.getConn());
		OrderDAO orderDAO = new OrderDAO(dbManager.getConn(), stockDAO);

    	EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					ApplicationWindow app = new ApplicationWindow(dbManager, stockDAO, orderDAO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}