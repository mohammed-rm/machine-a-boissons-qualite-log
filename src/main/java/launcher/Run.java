package launcher;

import view.ApplicationWindow;

import java.awt.*;

public class Run {

    public static void main(String[] args){
		ConnectionDB dbManager = new ConnectionDB("Boissons.db");
		dbManager.createBoissonsTables();
		dbManager.fillBoissonsTables();

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
    }
}