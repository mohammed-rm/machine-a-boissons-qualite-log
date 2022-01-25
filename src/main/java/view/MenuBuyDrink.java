package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

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
	
	/**
	 * Configuration of the buying panel
	 */
	/*public InternalPanel buyConfig() {
		InternalPanel pan = new InternalPanel();
		pan.setLocation(0,0);
		
		System.out.print(createLab().size());
		System.out.print(createCombo().size());
		System.out.print(createCheck().size());
		System.out.print(createButton().size());
		System.out.print(createSep().size());
		
		for (int i = 0; i < createLab().size(); i++) {
			pan.add(createLab().get(i));
		}

		for (int i = 0; i <= 1; i++) {
			pan.add(createCombo().get(i));
		}

		for (int i = 0; i <= 13; i++) {
			pan.add(createCheck().get(i));
		}

		for (int i = 0; i <= 1; i++) {
			pan.add(createButton().get(i));
		}

		for (int i = 0; i <= 1; i++) {
			pan.add(createSep().get(i));
		}
		
		return pan;

	}*/

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the orderDrinks
	 */
	public JLabel getOrderDrinks() {
		return orderDrinks;
	}

	/**
	 * @return the orderCup
	 */
	public JLabel getOrderCup() {
		return orderCup;
	}

	/**
	 * @return the quantity
	 */
	public JLabel getQuantity() {
		return quantity;
	}

	/**
	 * @return the orderSugar
	 */
	public JLabel getOrderSugar() {
		return orderSugar;
	}

	/**
	 * @return the drinksList
	 */
	public JComboBox<String> getDrinksList() {
		return drinksList;
	}

	/**
	 * @return the yes
	 */
	public JRadioButton getYes() {
		return yes;
	}

	/**
	 * @return the no
	 */
	public JRadioButton getNo() {
		return no;
	}

	/**
	 * @return the firstQuantity
	 */
	public JRadioButton getFirstQuantity() {
		return firstQuantity;
	}

	/**
	 * @return the secondQuantity
	 */
	public JRadioButton getSecondQuantity() {
		return secondQuantity;
	}

	/**
	 * @return the noSug
	 */
	public JRadioButton getNoSug() {
		return noSug;
	}

	/**
	 * @return the oneSug
	 */
	public JRadioButton getOneSug() {
		return oneSug;
	}

	/**
	 * @return the twoSug
	 */
	public JRadioButton getTwoSug() {
		return twoSug;
	}

	/**
	 * @return the treeSug
	 */
	public JRadioButton getTreeSug() {
		return treeSug;
	}

	/**
	 * @return the four
	 */
	public JRadioButton getFourSug() {
		return fourSug;
	}

	/**
	 * @return the fiveSug
	 */
	public JRadioButton getFiveSug() {
		return fiveSug;
	}

	/**
	 * @return the btnOrder
	 */
	public JButton getBtnOrder() {
		return btnOrder;
	}

	/**
	 * @return the orderSoups
	 */
	public JLabel getOrderSoups() {
		return orderSoups;
	}

	/**
	 * @return the drinksList_1
	 */
	public JComboBox<String> getDrinksList_1() {
		return drinksList_1;
	}

	/**
	 * @return the orderCup_1
	 */
	public JLabel getOrderCup_1() {
		return orderCup_1;
	}

	/**
	 * @return the yes_1
	 */
	public JRadioButton getYes_1() {
		return yes_1;
	}

	/**
	 * @return the no_1
	 */
	public JRadioButton getNo_1() {
		return no_1;
	}

	/**
	 * @return the quantity_1
	 */
	public JLabel getQuantity_1() {
		return quantity_1;
	}

	/**
	 * @return the firstQuantity_1
	 */
	public JRadioButton getFirstQuantity_1() {
		return firstQuantity_1;
	}

	/**
	 * @return the secondQuantity_1
	 */
	public JRadioButton getSecondQuantity_1() {
		return secondQuantity_1;
	}

	/**
	 * @return the btnOrder_1
	 */
	public JButton getBtnOrder_1() {
		return btnOrder_1;
	}

	/**
	 * @return the separator
	 */
	public JSeparator getSeparator() {
		return separator;
	}

	/**
	 * @return the separator_1
	 */
	public JSeparator getSeparator_1() {
		return separator_1;
	}

	/**
	 * @return the labelList
	 */
	public ArrayList<JLabel> getLabelList() {
		return labelList;
	}

	/**
	 * @return the comboList
	 */
	public ArrayList<JComboBox<String>> getComboList() {
		return comboList;
	}

	/**
	 * @return the checkList
	 */
	public ArrayList<JRadioButton> getCheckList() {
		return checkList;
	}

	/**
	 * @return the buttonList
	 */
	public ArrayList<JButton> getButtonList() {
		return buttonList;
	}

	/**
	 * @return the sepList
	 */
	public ArrayList<JSeparator> getSepList() {
		return sepList;
	}

	/**
	 * @param orderDrinks the orderDrinks to set
	 */
	public void setOrderDrinks(JLabel orderDrinks) {
		this.orderDrinks = orderDrinks;
	}

	/**
	 * @param orderCup the orderCup to set
	 */
	public void setOrderCup(JLabel orderCup) {
		this.orderCup = orderCup;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(JLabel quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param orderSugar the orderSugar to set
	 */
	public void setOrderSugar(JLabel orderSugar) {
		this.orderSugar = orderSugar;
	}

	/**
	 * @param drinksList the drinksList to set
	 */
	public void setDrinksList(JComboBox<String> drinksList) {
		this.drinksList = drinksList;
	}

	/**
	 * @param yes the yes to set
	 */
	public void setYes(JRadioButton yes) {
		this.yes = yes;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(JRadioButton no) {
		this.no = no;
	}

	/**
	 * @param firstQuantity the firstQuantity to set
	 */
	public void setFirstQuantity(JRadioButton firstQuantity) {
		this.firstQuantity = firstQuantity;
	}

	/**
	 * @param secondQuantity the secondQuantity to set
	 */
	public void setSecondQuantity(JRadioButton secondQuantity) {
		this.secondQuantity = secondQuantity;
	}

	/**
	 * @param noSug the noSug to set
	 */
	public void setNoSug(JRadioButton noSug) {
		this.noSug = noSug;
	}

	/**
	 * @param oneSug the oneSug to set
	 */
	public void setOneSug(JRadioButton oneSug) {
		this.oneSug = oneSug;
	}

	/**
	 * @param twoSug the twoSug to set
	 */
	public void setTwoSug(JRadioButton twoSug) {
		this.twoSug = twoSug;
	}

	/**
	 * @param treeSug the treeSug to set
	 */
	public void setTreeSug(JRadioButton treeSug) {
		this.treeSug = treeSug;
	}

	/**
	 * @param fourSug the four to set
	 */
	public void setFourSug(JRadioButton fourSug) {
		this.fourSug = fourSug;
	}

	/**
	 * @param fiveSug the fiveSug to set
	 */
	public void setFiveSug(JRadioButton fiveSug) {
		this.fiveSug = fiveSug;
	}

	/**
	 * @param btnOrder the btnOrder to set
	 */
	public void setBtnOrder(JButton btnOrder) {
		this.btnOrder = btnOrder;
	}

	/**
	 * @param orderSoups the orderSoups to set
	 */
	public void setOrderSoups(JLabel orderSoups) {
		this.orderSoups = orderSoups;
	}

	/**
	 * @param drinksList_1 the drinksList_1 to set
	 */
	public void setDrinksList_1(JComboBox<String> drinksList_1) {
		this.drinksList_1 = drinksList_1;
	}

	/**
	 * @param orderCup_1 the orderCup_1 to set
	 */
	public void setOrderCup_1(JLabel orderCup_1) {
		this.orderCup_1 = orderCup_1;
	}

	/**
	 * @param yes_1 the yes_1 to set
	 */
	public void setYes_1(JRadioButton yes_1) {
		this.yes_1 = yes_1;
	}

	/**
	 * @param no_1 the no_1 to set
	 */
	public void setNo_1(JRadioButton no_1) {
		this.no_1 = no_1;
	}

	/**
	 * @param quantity_1 the quantity_1 to set
	 */
	public void setQuantity_1(JLabel quantity_1) {
		this.quantity_1 = quantity_1;
	}

	/**
	 * @param firstQuantity_1 the firstQuantity_1 to set
	 */
	public void setFirstQuantity_1(JRadioButton firstQuantity_1) {
		this.firstQuantity_1 = firstQuantity_1;
	}

	/**
	 * @param secondQuantity_1 the secondQuantity_1 to set
	 */
	public void setSecondQuantity_1(JRadioButton secondQuantity_1) {
		this.secondQuantity_1 = secondQuantity_1;
	}

	/**
	 * @param btnOrder_1 the btnOrder_1 to set
	 */
	public void setBtnOrder_1(JButton btnOrder_1) {
		this.btnOrder_1 = btnOrder_1;
	}

	/**
	 * @param separator the separator to set
	 */
	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	/**
	 * @param separator_1 the separator_1 to set
	 */
	public void setSeparator_1(JSeparator separator_1) {
		this.separator_1 = separator_1;
	}

	/**
	 * @param labelList the labelList to set
	 */
	public void setLabelList(ArrayList<JLabel> labelList) {
		this.labelList = labelList;
	}

	/**
	 * @param comboList the comboList to set
	 */
	public void setComboList(ArrayList<JComboBox<String>> comboList) {
		this.comboList = comboList;
	}

	/**
	 * @param checkList the checkList to set
	 */
	public void setCheckList(ArrayList<JRadioButton> checkList) {
		this.checkList = checkList;
	}

	/**
	 * @param buttonList the buttonList to set
	 */
	public void setButtonList(ArrayList<JButton> buttonList) {
		this.buttonList = buttonList;
	}

	/**
	 * @param sepList the sepList to set
	 */
	public void setSepList(ArrayList<JSeparator> sepList) {
		this.sepList = sepList;
	}

}
