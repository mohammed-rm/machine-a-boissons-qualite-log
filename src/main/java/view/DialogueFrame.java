package view;

import controller.DrinkDAO;
import launcher.ConnectionDB;
import model.Drink;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DialogueFrame {

	JFrame addFrame;
	JPanel contentPane;
	JLabel lab;
	ConnectionDB connection = new ConnectionDB("Boissons.db");
	DrinkDAO drinks = new DrinkDAO(connection.getConn());
	List<Drink> list;
	
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
		lab.setBounds(0, 40, 400, 40);

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
		dialogFrame(drinks.getAllDrinks().get(0).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameAmer() {
		dialogFrame(drinks.getAllDrinks().get(1).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameLatte() {
		dialogFrame(drinks.getAllDrinks().get(2).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameBT() {
		dialogFrame(drinks.getAllDrinks().get(3).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameGT() {
		dialogFrame(drinks.getAllDrinks().get(4).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameTS() {
		dialogFrame(drinks.getAllDrinks().get(5).getDescription(), "/icons/description.png");

	}
	
	public void dialogueCheckAllBoxes() {
		dialogFrame("You need to check all boxes beforing ordering!", "/icons/failure.png");
	}
	
	public void dialogConfirm() {
		contentPane = new JPanel();
		contentPane.setSize(400, 180);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(189, 183, 107));

		lab = new JLabel("Order Confirmation", SwingConstants.CENTER);
		lab.setIcon(IconsResize.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/succes.png")), 35, 35));
		lab.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lab.setBounds(0, 40, 400, 40);
		
		JButton btnConfirm = new JButton("Confirm");
		JButton btnCancel = new JButton("Cancel");
		btnConfirm.setBounds(addFrame.getPreferredSize().width-160, 100, 90, 25);
		btnCancel.setBounds(addFrame.getPreferredSize().width-325, 100, 90, 25);
		btnConfirm.setBackground(Color.GREEN);
		btnCancel.setBackground(Color.RED);

		contentPane.add(lab);
		contentPane.add(btnConfirm);
		contentPane.add(btnCancel);
		addFrame.add(contentPane);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.pack();
		addFrame.setVisible(true);
	}
}
