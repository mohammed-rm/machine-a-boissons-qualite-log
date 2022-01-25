package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;

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

	/**
	 * @return the comboBox
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * @return the labLanguage
	 */
	public JLabel getLabLanguage() {
		return labLanguage;
	}

	/**
	 * @return the pan
	 */
	public InternalPanel getPan() {
		return pan;
	}

	/**
	 * @param comboBox the comboBox to set
	 */
	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	/**
	 * @param labLanguage the labLanguage to set
	 */
	public void setLabLanguage(JLabel labLanguage) {
		this.labLanguage = labLanguage;
	}

	/**
	 * @param pan the pan to set
	 */
	public void setPan(InternalPanel pan) {
		this.pan = pan;
	}
}
