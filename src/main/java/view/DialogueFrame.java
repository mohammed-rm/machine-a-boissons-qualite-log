package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DialogueFrame {

	JFrame addFrame;
	JPanel contentPane;
	JLabel lab;

	/**
	 * Default constructor
	 */
	public DialogueFrame() {
		addFrame = new JFrame();
		addFrame.setPreferredSize(new Dimension(400, 180));
		addFrame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		addFrame.setLocation(screenSize.width / 2 - addFrame.getPreferredSize().width / 2,
				screenSize.height / 2 - addFrame.getPreferredSize().height / 2);
		addFrame.setLayout(null);

	}

	/**
	 * Frame builder to respond when an action is made
	 * 
	 * @param message
	 * @param iconPath
	 */
	public void dialogFrame(String message, String iconPath) {
		contentPane = new JPanel();
		contentPane.setSize(400, 180);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(189, 183, 107));

		lab = new JLabel(message, SwingConstants.CENTER);
		lab.setIcon(IconsResize.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource(iconPath)), 35, 35));
		lab.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lab.setBounds(50, 40, 300, 40);

		contentPane.add(lab);
		addFrame.add(contentPane);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.pack();
		addFrame.setVisible(true);
	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameSB() {

		dialogFrame("Description1...", "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameAmer() {
		dialogFrame("Description2...", "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameLatte() {
		dialogFrame("Description3...", "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameBT() {
		dialogFrame("Description4...", "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameGT() {
		dialogFrame("Description5...", "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameTS() {
		dialogFrame("Description6...", "/icons/description.png");

	}

}
