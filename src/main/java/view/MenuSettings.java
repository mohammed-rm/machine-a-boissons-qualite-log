package view;

import javax.swing.*;
import java.awt.*;

public class MenuSettings extends Component {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
	private JLabel labLanguage;
	private InternalPanel pan;

	/**
	 * Default constructor
	 */
	public MenuSettings() {
		comboBox = new JComboBox<String>();
		labLanguage = new JLabel("Select a language");
		pan = new InternalPanel();
		pan.setLocation(0,0);
	}

	/**
	 * Settings panel
	 * @return pan
	 */
	public InternalPanel createPan() {
		InternalPanel pan = new InternalPanel();
		pan.setLocation(0,0);
		
		comboBox.setBounds(150, 8, 45, 30);
		comboBox.setBackground(new Color(189, 183, 107));
		comboBox.addItem("Fr");
		comboBox.addItem("En");
		labLanguage.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labLanguage.setBounds(10, 14, 130, 20);

		pan.add(labLanguage);
		pan.add(comboBox);
		
		return pan;
		
	}

}
