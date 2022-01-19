package view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuHome {
	
	private ArrayList<JLabel> drinksList;
	private JLabel labdSoups;
	private JLabel labDrinks;
	private JLabel labSoups;
	private JLabel labSB;
	private JLabel labAmericano;
	private JLabel labLatte;
	private JLabel labBT;
	private JLabel labGT;
	private JLabel labTomato;
	
	
	public MenuHome() {
		this.drinksList = new ArrayList<JLabel>();
		this.labDrinks = new JLabel("Drinks");
		this.labSoups = new JLabel("Soups");
		this.labSB = new JLabel("Short Black");
		this.labAmericano = new JLabel("Americano");
		this.labLatte = new JLabel("Latte");
		this.labBT = new JLabel("Black Tea");
		this.labGT = new JLabel("Green Tea");
		this.labTomato = new JLabel("Tomato Soup");
	}
	
	
	
	public ArrayList<JLabel> createDrinks() {

		labDrinks.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		labDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		labDrinks.setBounds(80, 40, 110, 35);
		drinksList.add(labDrinks);
		

		labdSoups.setHorizontalAlignment(SwingConstants.CENTER);
		labdSoups.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		labdSoups.setBounds(401, 41, 107, 36);
		drinksList.add(labdSoups);

		labSB.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labSB.setHorizontalAlignment(SwingConstants.CENTER);
		labSB.setBounds(60, 118, 63, 14);
		drinksList.add(labSB);

		labAmericano.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labAmericano.setHorizontalAlignment(SwingConstants.CENTER);
		labAmericano.setBounds(60, 152, 63, 14);
		drinksList.add(labAmericano);

		labLatte.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labLatte.setHorizontalAlignment(SwingConstants.CENTER);
		labLatte.setBounds(60, 203, 31, 14);
		drinksList.add(labLatte);

		labBT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labBT.setHorizontalAlignment(SwingConstants.CENTER);
		labBT.setBounds(60, 252, 63, 14);
		drinksList.add(labBT);

		labGT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labGT.setHorizontalAlignment(SwingConstants.CENTER);
		labGT.setBounds(60, 311, 63, 14);
		drinksList.add(labGT);

		labTomato.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labTomato.setHorizontalAlignment(SwingConstants.CENTER);
		labTomato.setBounds(416, 118, 75, 14);
		drinksList.add(labTomato);
	
		return drinksList;

	}

}
