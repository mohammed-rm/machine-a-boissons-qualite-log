package view;

import java.awt.Color;

import javax.swing.JSeparator;

public class MenuSeparators {

	/**
	 * Separators between menu's items
	 * 
	 * @param menu
	 */
	public static void lineSeparator(Menu menu) {
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBounds(15, 250, 200, 1);
		menu.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLUE);
		separator_2.setBounds(15, 310, 200, 1);
		menu.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLUE);
		separator_3.setBounds(15, 370, 200, 1);
		menu.add(separator_3);

		/*JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLUE);
		separator_4.setBounds(15, 390, 200, 1);
		menu.add(separator_4);*/
	}
}
