package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class ApplicationWindow extends JFrame {

	private final JFrame frame;
	private Panel panel;
	private InternalPanel internalPanel;
	private BottomItems itemRights;
	private Menu menu;
	private Bottom bottom;
	private MenuHome home;

	private final JLabel labClose;
	private final JLabel labMin;
	private final JLabel labLogo;
	private final JLabel labHome;
	private final JLabel labDrinks;
	private final JLabel labSettings;

	private JLabel drinksTitle;
	private JLabel soupsTitle;
	private JLabel shortCoffee;
	private JLabel americanonCoffee;
	private JLabel latteCoffee;
	private JLabel blackTea;
	private JLabel greenTea;
	private JLabel tomatoSoup;

	private int xMouse;
	private int yMouse;

	/**
	 * Create the frame.
	 */
	public ApplicationWindow() {
		this.frame = new JFrame();
		this.labClose = new JLabel();
		this.labMin = new JLabel();
		this.labLogo = new JLabel();
		this.labHome = new JLabel("Home");
		this.labDrinks = new JLabel("Buy a drink");
		this.labSettings = new JLabel("Settings");

		initFrame();
		initComponents();
		iconsConfig();
		menuConfig();
		//homeConfig();
		frameListener();
		panelListener();

		bottom.add(itemRights.createLabName());
		bottom.add(itemRights.createTime());

		frame.getContentPane().add(panel);
		panel.add(internalPanel);
		
		//DONE
		JLabel orderDrinks = new JLabel("Drinks");
		orderDrinks.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		orderDrinks.setBounds(50, 30, 100, 20);
		internalPanel.add(orderDrinks);
		
		//DONE
		JLabel orderCup = new JLabel("Cup");
		orderCup.setBounds(50, 130, 60, 20);
		orderCup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		internalPanel.add(orderCup);
		
		//DONE
		JLabel quantity = new JLabel("Quantity");
		quantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quantity.setBounds(300, 130, 80, 20);
		internalPanel.add(quantity);
		
		//DONE
		JLabel orderSugar = new JLabel("Sugar");
		orderSugar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		orderSugar.setBounds(50, 230, 70, 20);
		internalPanel.add(orderSugar);
		
		//DONE
		JComboBox drinksList = new JComboBox();
		drinksList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		drinksList.setModel(new DefaultComboBoxModel(new String[] {"Short Black", "Americano", "Latte", "Black Tea", "Green Tea"}));
		drinksList.setBackground(new Color(173, 216, 230));
		drinksList.setForeground(new Color(0, 0, 128));
		drinksList.setBounds(50, 80, 160, 22);
		internalPanel.add(drinksList);
		
		//DONE
		JCheckBox yes = new JCheckBox("Yes");
		yes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		yes.setBackground(new Color(173, 216, 230));
		yes.setBounds(50, 160, 50, 20);
		internalPanel.add(yes);
		
		//DONE
		JCheckBox no = new JCheckBox("No");
		no.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		no.setBackground(new Color(173, 216, 230));
		no.setBounds(120, 160, 50, 20);
		internalPanel.add(no);
		
		//DONE
		JCheckBox firstQuantity = new JCheckBox("35 cl");
		firstQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		firstQuantity.setBackground(new Color(173, 216, 230));
		firstQuantity.setBounds(300, 160, 55, 20);
		internalPanel.add(firstQuantity);
		
		//DONE
		JCheckBox secondQuantity = new JCheckBox("75 cl");
		secondQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		secondQuantity.setBackground(new Color(173, 216, 230));
		secondQuantity.setBounds(370, 160, 55, 20);
		internalPanel.add(secondQuantity);
		
		JCheckBox noSug = new JCheckBox("0");
		noSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		noSug.setBackground(new Color(173, 216, 230));
		noSug.setBounds(50, 260, 40, 20);
		internalPanel.add(noSug);
		
		JCheckBox oneSug = new JCheckBox("1");
		oneSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		oneSug.setBackground(new Color(173, 216, 230));
		oneSug.setBounds(100, 260, 40, 20);
		internalPanel.add(oneSug);
		
		JCheckBox twoSug = new JCheckBox("2");
		twoSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		twoSug.setBackground(new Color(173, 216, 230));
		twoSug.setBounds(150, 260, 40, 20);
		internalPanel.add(twoSug);
		
		JCheckBox treeSug = new JCheckBox("3");
		treeSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		treeSug.setBackground(new Color(173, 216, 230));
		treeSug.setBounds(200, 260, 40, 20);
		internalPanel.add(treeSug);
		
		JCheckBox four = new JCheckBox("4");
		four.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		four.setBackground(new Color(173, 216, 230));
		four.setBounds(250, 260, 40, 20);
		internalPanel.add(four);
		
		//DONE
		JLabel orderSoups = new JLabel("Soups");
		orderSoups.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		orderSoups.setBounds(50, 330, 60, 25);
		internalPanel.add(orderSoups);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnOrder.setBackground(new Color(0, 128, 0));
		btnOrder.setBounds(480, 300, 90, 25);
		internalPanel.add(btnOrder);
		
		JCheckBox fiveSug = new JCheckBox("5");
		fiveSug.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fiveSug.setBackground(new Color(173, 216, 230));
		fiveSug.setBounds(300, 260, 40, 20);
		internalPanel.add(fiveSug);
		
		JComboBox drinksList_1 = new JComboBox();
		drinksList_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		drinksList_1.setModel(new DefaultComboBoxModel(new String[] {"Tomato Soup"}));
		drinksList_1.setForeground(new Color(0, 0, 128));
		drinksList_1.setBackground(new Color(173, 216, 230));
		drinksList_1.setBounds(50, 380, 160, 22);
		internalPanel.add(drinksList_1);
		
		JLabel orderCup_1 = new JLabel("Cup");
		orderCup_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		orderCup_1.setBounds(50, 430, 60, 20);
		internalPanel.add(orderCup_1);
		
		JCheckBox yes_1 = new JCheckBox("Yes");
		yes_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		yes_1.setBackground(new Color(173, 216, 230));
		yes_1.setBounds(50, 460, 50, 20);
		internalPanel.add(yes_1);
		
		JCheckBox no_1 = new JCheckBox("No");
		no_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		no_1.setBackground(new Color(173, 216, 230));
		no_1.setBounds(120, 460, 50, 20);
		internalPanel.add(no_1);
		
		JLabel quantity_1 = new JLabel("Quantity");
		quantity_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quantity_1.setBounds(300, 430, 80, 20);
		internalPanel.add(quantity_1);
		
		JCheckBox firstQuantity_1 = new JCheckBox("35 cl");
		firstQuantity_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		firstQuantity_1.setBackground(new Color(173, 216, 230));
		firstQuantity_1.setBounds(300, 460, 55, 20);
		internalPanel.add(firstQuantity_1);
		
		JCheckBox secondQuantity_1 = new JCheckBox("75 cl");
		secondQuantity_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		secondQuantity_1.setBackground(new Color(173, 216, 230));
		secondQuantity_1.setBounds(370, 460, 55, 20);
		internalPanel.add(secondQuantity_1);
		
		JButton btnOrder_1 = new JButton("Order");
		btnOrder_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnOrder_1.setBackground(new Color(0, 128, 0));
		btnOrder_1.setBounds(480, 500, 90, 25);
		internalPanel.add(btnOrder_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 0, 128));
		separator.setBounds(10, 323, 460, 2);
		internalPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(128, 0, 128));
		separator_1.setBounds(10, 523, 460, 2);
		internalPanel.add(separator_1);
		panel.add(menu);
		panel.add(bottom);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Initialize the main frame
	 */
	public void initFrame() {
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width / 2 - frame.getPreferredSize().width / 2,
				screenSize.height / 2 - frame.getPreferredSize().height / 2);
	}

	/**
	 * Initialize the frame components
	 */
	public void initComponents() {
		panel = new Panel();
		internalPanel = new InternalPanel();
		itemRights = new BottomItems();
		menu = new Menu();
		bottom = new Bottom();
		home = new MenuHome();
	}

	/**
	 * Close and minimize icons
	 */
	public void iconsConfig() {
		labClose.setHorizontalAlignment(SwingConstants.CENTER);
		labClose.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/close_in.png")), 18, 18));
		labClose.setBounds(770, 2, 20, 20);
		labClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labClose.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/close.png")), 18, 18));
				labClose.setBounds(770, 2, 20, 20);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labClose.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/close_in.png")), 18, 18));
				labClose.setBounds(770, 2, 20, 20);
			}
		});
		panel.add(labClose);

		labMin.setHorizontalAlignment(SwingConstants.CENTER);
		labMin.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/minimize.png")), 18, 18));
		labMin.setBounds(740, 2, 20, 20);
		labMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labMin.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/minimize_in.png")), 18, 18));
				labMin.setBounds(740, 2, 20, 20);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labMin.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/minimize.png")), 18, 18));
				labMin.setBounds(740, 2, 20, 20);
			}
		});
		panel.add(labMin);
	}

	/**
	 * Add listeners to the frame to change back the minimize icon to its original
	 * state
	 */
	public void frameListener() {
		frame.addWindowListener((WindowListener) new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				labMin.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/minimize.png")), 18, 18));
				labMin.setBounds(740, 2, 20, 20);
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});
	}

	/**
	 * Add listeners to move the undecorated frame when the mouse is dragged
	 */
	public void panelListener() {
		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getLocation().x + e.getX() - xMouse, frame.getLocation().y + e.getY() - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
	}

	/**
	 * Configuration of the menu items
	 */
	public void menuConfig() {

		// App Logo
		labLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labLogo.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/logo.png")), 210, 210));
		labLogo.setBounds(0, -30, 220, 230);
		menu.add(labLogo);
		menu.add(labLogo);

		labHome.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/home.png")), 40, 40));
		labHome.setHorizontalAlignment(SwingConstants.LEFT);
		labHome.setVerticalAlignment(SwingConstants.BOTTOM);
		labHome.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		labHome.setBounds(5, 210, 215, 40);
		labHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labHome.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labHome.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				internalPanel.removeAll();

				internalPanel.add(drinksTitle);
				internalPanel.add(soupsTitle);
				internalPanel.add(shortCoffee);
				internalPanel.add(americanonCoffee);
				internalPanel.add(latteCoffee);
				internalPanel.add(blackTea);
				internalPanel.add(greenTea);
				internalPanel.add(tomatoSoup);

				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labHome);

		labDrinks.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/drinks.png")), 40, 40));
		labDrinks.setHorizontalAlignment(SwingConstants.LEFT);
		labDrinks.setVerticalAlignment(SwingConstants.BOTTOM);
		labDrinks.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		labDrinks.setBounds(5, 270, 215, 40);
		labDrinks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labDrinks.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labDrinks.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				internalPanel.removeAll();

				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labDrinks);

		labSettings.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/settings.png")), 40, 40));
		labSettings.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		labSettings.setHorizontalAlignment(SwingConstants.LEFT);
		labSettings.setVerticalAlignment(SwingConstants.BOTTOM);
		labSettings.setBounds(5, 330, 215, 40);
		labSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labSettings.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labSettings.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				MenuSettings settings = new MenuSettings();
				internalPanel.removeAll();

				internalPanel.add(settings.createLabel());
				internalPanel.add(settings.createCombo());

				frame.pack();
				frame.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		menu.add(labSettings);

		MenuSeparators.lineSeparator(menu);

	}

	/**
	 * Configuration of the Home 
	 */
	public void homeConfig() {

		drinksTitle = home.createDrinks().get(0);
		soupsTitle = home.createDrinks().get(1);
		shortCoffee = home.createDrinks().get(2);
		americanonCoffee = home.createDrinks().get(3);
		latteCoffee = home.createDrinks().get(4);
		blackTea = home.createDrinks().get(5);
		greenTea = home.createDrinks().get(6);
		tomatoSoup = home.createDrinks().get(7);

		internalPanel.add(drinksTitle);
		internalPanel.add(soupsTitle);
		internalPanel.add(shortCoffee);
		internalPanel.add(americanonCoffee);
		internalPanel.add(latteCoffee);
		internalPanel.add(blackTea);
		internalPanel.add(greenTea);
		internalPanel.add(tomatoSoup);
	}
}
