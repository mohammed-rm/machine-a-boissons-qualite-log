package view;

import javax.swing.*;
import java.awt.*;

public class MenuSettings extends Component {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
	private JLabel labLanguage;
	private InternalPanel pan;
	
	private JLabel notFinished;

	/**
	 * Default constructor
	 */
	public MenuSettings() {
		comboBox = new JComboBox<String>();
		labLanguage = new JLabel("Select a language");
		notFinished = new JLabel("To Be Continued...");
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
		notFinished.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		notFinished.setBounds(140, 250, 500, 30);

		pan.add(labLanguage);
		pan.add(notFinished);
		pan.add(comboBox);
		
		return pan;
		
	}

}
