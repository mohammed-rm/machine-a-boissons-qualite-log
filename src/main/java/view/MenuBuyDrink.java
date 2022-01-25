package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;

import controller.OrderDAO;
import controller.StockDAO;
import launcher.ConnectionDB;

public class MenuBuyDrink implements ActionListener {

	private JLabel orderDrinks;
	private JLabel orderCup;
	private JLabel quantity;
	private JLabel orderSugar;
	private JComboBox<String> drinksList;
	private JRadioButton yes;
	private JRadioButton no;
	private JRadioButton firstQuantity;
	private JRadioButton secondQuantity;
	private JRadioButton noSug;
	private JRadioButton oneSug;
	private JRadioButton twoSug;
	private JRadioButton treeSug;
	private JRadioButton fourSug;
	private JRadioButton fiveSug;
	private ButtonGroup takeCup;
	private ButtonGroup cupSize;
	private ButtonGroup sugar;
	private JButton btnOrder;
	private JLabel orderSoups;
	private JComboBox<String> drinksList_1;
	private JLabel orderCup_1;
	private JRadioButton yes_1;
	private JRadioButton no_1;
	private JLabel quantity_1;
	private JRadioButton firstQuantity_1;
	private JRadioButton secondQuantity_1;
	private ButtonGroup takeCupSoup;
	private ButtonGroup cupSizeSoup;
	private JButton btnOrder_1;
	private JSeparator separator;
	private JSeparator separator_1;
	private ArrayList<JLabel> labelList;
	private ArrayList<JComboBox<String>> comboList;
	private ArrayList<JRadioButton> checkList;
	private ArrayList<JButton> buttonList;
	private ArrayList<JSeparator> sepList;
	private ConnectionDB connection = new ConnectionDB("Boisson.db");
	private StockDAO stock = new StockDAO(connection.getConn());
	private OrderDAO order = new OrderDAO(connection.getConn(), stock);

	public MenuBuyDrink() {

		labelList = new ArrayList<JLabel>();
		comboList = new ArrayList<JComboBox<String>>();
		checkList = new ArrayList<>();
		buttonList = new ArrayList<JButton>();
		sepList = new ArrayList<JSeparator>();

		orderDrinks = new JLabel("Drinks");
		orderCup = new JLabel("Cup");
		quantity = new JLabel("Quantity");
		orderSugar = new JLabel("Sugar");

		drinksList = new JComboBox<String>();
		yes = new JRadioButton("Yes");
		no = new JRadioButton("No");
		firstQuantity = new JRadioButton("35 cl");
		secondQuantity = new JRadioButton("75 cl");
		noSug = new JRadioButton("0");
		oneSug = new JRadioButton("1");
		twoSug = new JRadioButton("2");
		treeSug = new JRadioButton("3");
		fourSug = new JRadioButton("4");
		fiveSug = new JRadioButton("5");
		btnOrder = new JButton("Order");

		sugar = new ButtonGroup();
		takeCup = new ButtonGroup();
		cupSize = new ButtonGroup();

		sugar.add(noSug);
		sugar.add(oneSug);
		sugar.add(twoSug);
		sugar.add(treeSug);
		sugar.add(fourSug);
		sugar.add(fiveSug);

		takeCup.add(yes);
		takeCup.add(no);

		cupSize.add(firstQuantity);
		cupSize.add(secondQuantity);

		orderSoups = new JLabel("Soups");

		drinksList_1 = new JComboBox<String>();
		orderCup_1 = new JLabel("Cup");
		yes_1 = new JRadioButton("Yes");
		no_1 = new JRadioButton("No");
		quantity_1 = new JLabel("Quantity");
		firstQuantity_1 = new JRadioButton("35 cl");
		secondQuantity_1 = new JRadioButton("75 cl");
		btnOrder_1 = new JButton("Order");

		takeCupSoup = new ButtonGroup();
		cupSizeSoup = new ButtonGroup();

		takeCupSoup.add(yes_1);
		takeCupSoup.add(no_1);

		cupSizeSoup.add(firstQuantity_1);
		cupSizeSoup.add(secondQuantity_1);

		separator = new JSeparator();
		separator_1 = new JSeparator();

		drinksList.addActionListener(this);
		yes.setActionCommand("Yes");
		no.setActionCommand("No");
		firstQuantity.setActionCommand("35");
		secondQuantity.setActionCommand("75");
		noSug.setActionCommand("0");
		oneSug.setActionCommand("1");
		twoSug.setActionCommand("2");
		treeSug.setActionCommand("3");
		fourSug.setActionCommand("4");
		fiveSug.setActionCommand("5");
		btnOrder.addActionListener(this);

		drinksList_1.addActionListener(this);
		yes_1.addActionListener(this);
		no_1.addActionListener(this);
		firstQuantity_1.addActionListener(this);
		secondQuantity_1.addActionListener(this);
		btnOrder_1.addActionListener(this);
	}

	public ArrayList<JLabel> createLab() {

		orderDrinks.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		orderDrinks.setBounds(50, 30, 100, 20);
		orderCup.setBounds(50, 130, 60, 20);
		orderCup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quantity.setBounds(300, 130, 80, 20);
		orderSoups.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		orderSoups.setBounds(50, 330, 60, 25);
		orderCup_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		orderCup_1.setBounds(50, 430, 60, 20);
		quantity_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quantity_1.setBounds(300, 430, 80, 20);
		orderSugar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		orderSugar.setBounds(50, 230, 70, 20);

		labelList.add(orderDrinks);
		labelList.add(orderCup);
		labelList.add(quantity);
		labelList.add(orderSoups);
		labelList.add(orderCup_1);
		labelList.add(quantity_1);
		labelList.add(orderSugar);

		return labelList;
	}

	public ArrayList<JComboBox<String>> createCombo() {

		drinksList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		drinksList.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Short Black", "Americano", "Latte", "Black Tea", "Green Tea" }));
		drinksList.setBackground(new Color(173, 216, 230));
		drinksList.setForeground(new Color(0, 0, 128));
		drinksList.setBounds(50, 80, 160, 22);

		drinksList_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		drinksList_1.setModel(new DefaultComboBoxModel<String>(new String[] { "Tomato Soup" }));
		drinksList_1.setForeground(new Color(0, 0, 128));
		drinksList_1.setBackground(new Color(173, 216, 230));
		drinksList_1.setBounds(50, 380, 160, 22);

		comboList.add(drinksList);
		comboList.add(drinksList_1);
		return comboList;
	}

	public ArrayList<JRadioButton> createCheck() {

		yes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		yes.setBackground(new Color(173, 216, 230));
		yes.setBounds(50, 160, 50, 20);
		no.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		no.setBackground(new Color(173, 216, 230));
		no.setBounds(120, 160, 50, 20);
		firstQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		firstQuantity.setBackground(new Color(173, 216, 230));
		firstQuantity.setBounds(300, 160, 55, 20);
		secondQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		secondQuantity.setBackground(new Color(173, 216, 230));
		secondQuantity.setBounds(370, 160, 55, 20);
		noSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		noSug.setBackground(new Color(173, 216, 230));
		noSug.setBounds(50, 260, 40, 20);
		oneSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		oneSug.setBackground(new Color(173, 216, 230));
		oneSug.setBounds(100, 260, 40, 20);
		twoSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		twoSug.setBackground(new Color(173, 216, 230));
		twoSug.setBounds(150, 260, 40, 20);
		treeSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		treeSug.setBackground(new Color(173, 216, 230));
		treeSug.setBounds(200, 260, 40, 20);
		fourSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fourSug.setBackground(new Color(173, 216, 230));
		fourSug.setBounds(250, 260, 40, 20);
		fiveSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fiveSug.setBackground(new Color(173, 216, 230));
		fiveSug.setBounds(300, 260, 40, 20);
		yes_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		yes_1.setBackground(new Color(173, 216, 230));
		yes_1.setBounds(50, 460, 50, 20);
		no_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		no_1.setBackground(new Color(173, 216, 230));
		no_1.setBounds(120, 460, 50, 20);
		firstQuantity_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		firstQuantity_1.setBackground(new Color(173, 216, 230));
		firstQuantity_1.setBounds(300, 460, 55, 20);
		secondQuantity_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		secondQuantity_1.setBackground(new Color(173, 216, 230));
		secondQuantity_1.setBounds(370, 460, 55, 20);

		checkList.add(fiveSug);
		checkList.add(oneSug);
		checkList.add(secondQuantity);
		checkList.add(secondQuantity_1);
		checkList.add(treeSug);
		checkList.add(yes);
		checkList.add(yes_1);
		checkList.add(firstQuantity);
		checkList.add(firstQuantity_1);
		checkList.add(fourSug);
		checkList.add(no);
		checkList.add(noSug);
		checkList.add(no_1);
		checkList.add(twoSug);

		return checkList;
	}

	public ArrayList<JButton> createButton() {

		btnOrder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnOrder.setBackground(new Color(0, 128, 0));
		btnOrder.setBounds(480, 300, 90, 25);
		btnOrder_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnOrder_1.setBackground(new Color(0, 128, 0));
		btnOrder_1.setBounds(480, 500, 90, 25);

		buttonList.add(btnOrder);
		buttonList.add(btnOrder_1);

		return buttonList;
	}

	public ArrayList<JSeparator> createSep() {

		separator.setBackground(new Color(128, 0, 128));
		separator.setBounds(10, 323, 460, 2);
		separator_1.setBackground(new Color(128, 0, 128));
		separator_1.setBounds(10, 523, 460, 2);

		sepList.add(separator);
		sepList.add(separator_1);
		
		return sepList;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//StockDAO stock = new StockDAO(connection.getConn());
		//OrderDAO order = new OrderDAO(connection.getConn(), stock);
		DialogueFrame frame = new DialogueFrame();
		Object source = event.getSource();
		String inputDrinks = new String();
		String inputCup = new String();
		String inputQuantity = new String();
		String inputSugar = new String();

		/*****/
		if(source == btnOrder) {
			if( (yes.isSelected() || no.isSelected() ) 
			&&  (firstQuantity.isSelected() || secondQuantity.isSelected() ) 
			&&  (noSug.isSelected() || oneSug.isSelected() || twoSug.isSelected() || treeSug.isSelected() || fourSug.isSelected() || fiveSug.isSelected()))
			{
			inputDrinks = String.valueOf(drinksList.getSelectedItem());
			inputCup = takeCup.getSelection().getActionCommand();
			inputQuantity = cupSize.getSelection().getActionCommand();
			inputSugar = sugar.getSelection().getActionCommand();
			System.out.print(inputDrinks + "\n" + inputCup + "\n" + inputQuantity + "\n" + inputSugar + "\n");}
			else {
				frame.dialogueCheckAllBoxes();
				System.out.print("Need to check all boxes\n");
			}
		}
		/*****/
		
		/*****/
		else if(source == btnOrder_1) {
			System.out.print("Test");
		}
		/*****/
	}
}
