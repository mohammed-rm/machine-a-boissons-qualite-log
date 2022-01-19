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

@SuppressWarnings("serial")
public class ApplicationWindow extends JFrame {
	private final JFrame frame;
	private Panel panel;
	private InternalPanel internalPanel;
	private Menu menu;
	private Bottom bottom;
	private final JLabel labClose;
	private final JLabel labMin;
	private final JLabel labLogo;
	private final JLabel labHome;
	private final JLabel labDrinks;
	private final JLabel labSettings;
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
		frameListener();
		panelListener();

		BottomItems itemRights = new BottomItems();
		bottom.add(itemRights.createLabName());
		bottom.add(itemRights.createTime());

		/*JLabel homePan = new JLabel();
		homePan.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/home_pan.png")), 450, 450));
		homePan.setHorizontalAlignment(SwingConstants.CENTER);
		homePan.setVerticalAlignment(SwingConstants.CENTER);
		homePan.setBounds(50, 0, 500, 500);
		internalPanel.add(homePan);*/

		frame.getContentPane().add(panel);
		panel.add(internalPanel);
		
		JLabel labdDrinks = new JLabel("Drinks");
		labdDrinks.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		labdDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		labdDrinks.setBounds(80, 40, 110, 35);
		internalPanel.add(labdDrinks);
		
		JLabel labdSoups = new JLabel("Soups");
		labdSoups.setHorizontalAlignment(SwingConstants.CENTER);
		labdSoups.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		labdSoups.setBounds(401, 41, 107, 36);
		internalPanel.add(labdSoups);
		
		JLabel labSB = new JLabel("Short Black");
		labSB.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labSB.setHorizontalAlignment(SwingConstants.CENTER);
		labSB.setBounds(60, 118, 63, 14);
		internalPanel.add(labSB);
		
		JLabel labAmericano = new JLabel("Americano");
		labAmericano.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labAmericano.setHorizontalAlignment(SwingConstants.CENTER);
		labAmericano.setBounds(60, 152, 63, 14);
		internalPanel.add(labAmericano);
		
		JLabel labLatte = new JLabel("Latte");
		labLatte.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labLatte.setHorizontalAlignment(SwingConstants.CENTER);
		labLatte.setBounds(60, 203, 31, 14);
		internalPanel.add(labLatte);
		
		JLabel labBT = new JLabel("Black Tea");
		labBT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labBT.setHorizontalAlignment(SwingConstants.CENTER);
		labBT.setBounds(60, 252, 63, 14);
		internalPanel.add(labBT);
		
		JLabel labGT = new JLabel("Green Tea");
		labGT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labGT.setHorizontalAlignment(SwingConstants.CENTER);
		labGT.setBounds(60, 311, 63, 14);
		internalPanel.add(labGT);
		
		JLabel labTomato = new JLabel("Tomato Soup");
		labTomato.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labTomato.setBounds(416, 118, 75, 14);
		internalPanel.add(labTomato);
		
		
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
		menu = new Menu();
		bottom = new Bottom();

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
}
