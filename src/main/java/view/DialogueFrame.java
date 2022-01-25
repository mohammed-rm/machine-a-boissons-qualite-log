package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.DrinkDAO;
import launcher.ConnectionDB;
import model.Drink;

public class DialogueFrame {

	JFrame addFrame;
	JPanel contentPane;
	JLabel lab;
	ConnectionDB connection;
	DrinkDAO drinks;
	List<Drink> list;
	
	/**
	 * Initialize connection and list of drinks
	 */
	public void init() {
		connection = new ConnectionDB("Boissons.db");
		drinks = new DrinkDAO(connection.getConn());
		list = drinks.getAllDrinks();
	}

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
		init();
		dialogFrame(list.get(0).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameAmer() {
		init();
		dialogFrame(list.get(1).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameLatte() {
		init();
		dialogFrame(list.get(2).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameBT() {
		init();
		dialogFrame(list.get(3).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameGT() {
		init();
		dialogFrame(list.get(4).getDescription(), "/icons/description.png");

	}

	/**
	 * Sub frame that shows the drinks description
	 */
	public void dialogFrameTS() {
		init();
		dialogFrame(list.get(5).getDescription(), "/icons/description.png");

	}

	/**
	 * @return the addFrame
	 */
	public JFrame getAddFrame() {
		return addFrame;
	}

	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @return the lab
	 */
	public JLabel getLab() {
		return lab;
	}

	/**
	 * @return the connection
	 */
	public ConnectionDB getConnection() {
		return connection;
	}

	/**
	 * @return the drinks
	 */
	public DrinkDAO getDrinks() {
		return drinks;
	}

	/**
	 * @return the list
	 */
	public List<Drink> getList() {
		return list;
	}

	/**
	 * @param addFrame the addFrame to set
	 */
	public void setAddFrame(JFrame addFrame) {
		this.addFrame = addFrame;
	}

	/**
	 * @param contentPane the contentPane to set
	 */
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	/**
	 * @param lab the lab to set
	 */
	public void setLab(JLabel lab) {
		this.lab = lab;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(ConnectionDB connection) {
		this.connection = connection;
	}

	/**
	 * @param drinks the drinks to set
	 */
	public void setDrinks(DrinkDAO drinks) {
		this.drinks = drinks;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Drink> list) {
		this.list = list;
	}

}
