package launcher;

import java.awt.EventQueue;

import controller.StockDAO;
import model.Stock;
import view.ApplicationWindow;

public class Run {

    public static void main(String[] args){
    	EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					ApplicationWindow app = new ApplicationWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    	
        System.out.println("Hello world");
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        dbManager.createBoissonsTables();
        dbManager.fillBoissonsTables();
    }
}