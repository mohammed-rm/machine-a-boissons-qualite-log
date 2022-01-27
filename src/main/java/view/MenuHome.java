package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.DrinkDAO;
import launcher.ConnectionDB;
import model.Drink;

public class MenuHome {

	private JLabel drinks;
	private JLabel labSoups;
	private JLabel labSB;
	private JLabel labAmericano;
	private JLabel labLatte;
	private JLabel labBT;
	private JLabel labGT;
	private JLabel labTomato;
	private DialogueFrame frame;
	private ConnectionDB connection;
	private DrinkDAO drinkDAO = new DrinkDAO(connection.getConn());
	private List<Drink> list;

	public MenuHome() {

		list = drinkDAO.getAllDrinks();

		this.drinks = new JLabel("  Drinks");
		this.labSoups = new JLabel("  Soups");
		this.labSB = new JLabel("  Short Black : " + list.get(0).getPrice() + "€");
		this.labAmericano = new JLabel("  Americano : " + list.get(1).getPrice() + "€");
		this.labLatte = new JLabel("  Latte : " + list.get(2).getPrice() + "€");
		this.labBT = new JLabel("  Black Tea : " + list.get(3).getPrice() + "€");
		this.labGT = new JLabel("  Green Tea : " + list.get(4).getPrice() + "€");
		this.labTomato = new JLabel("  Tomato Soup : " + list.get(5).getPrice() + "€");

		initListener();
	}

	/**
	 * Creates home panel
	 * 
	 * @return pan
	 */
	public InternalPanel createDrinks() {

		InternalPanel pan = new InternalPanel();
		pan.setLocation(0, 0);
		drinks.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		drinks.setHorizontalAlignment(SwingConstants.LEFT);
		drinks.setBounds(70, 40, 110, 40);

		labSoups.setFont(new Font("Script MT Bold", Font.ITALIC, 22));
		labSoups.setHorizontalAlignment(SwingConstants.LEFT);
		labSoups.setBounds(400, 40, 110, 40);

		labSB.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labSB.setHorizontalAlignment(SwingConstants.LEFT);
		labSB.setBounds(30, 120, 160, 40);
		labSB.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/short_black.png")), 40, 40));

		labAmericano.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labAmericano.setHorizontalAlignment(SwingConstants.LEFT);
		labAmericano.setBounds(30, 180, 160, 40);
		labAmericano.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/americano.png")), 40, 40));

		labLatte.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labLatte.setHorizontalAlignment(SwingConstants.LEFT);
		labLatte.setBounds(30, 240, 160, 40);
		labLatte.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/latte.png")), 40, 40));

		labBT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labBT.setHorizontalAlignment(SwingConstants.LEFT);
		labBT.setBounds(30, 300, 160, 40);
		labBT.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/black_tea.png")), 40, 40));

		labGT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labGT.setHorizontalAlignment(SwingConstants.LEFT);
		labGT.setBounds(30, 360, 160, 50);
		labGT.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/green_tea.png")), 40, 40));

		labTomato.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labTomato.setHorizontalAlignment(SwingConstants.LEFT);
		labTomato.setBounds(360, 120, 190, 40);
		labTomato.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/tomato_soup.png")), 40, 40));

		pan.add(drinks);
		pan.add(labSoups);
		pan.add(labSB);
		pan.add(labAmericano);
		pan.add(labLatte);
		pan.add(labBT);
		pan.add(labGT);
		pan.add(labTomato);

		return pan;

	}

	/**
	 * Method to add listeners to drinks
	 */
	public void initListener() {
		labSB.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				labSB.setForeground(Color.WHITE);
				labSB.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/short_black_in.png")), 40, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labSB.setForeground(Color.BLACK);
				labSB.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/short_black.png")), 40, 40));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dialogFrameSB();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				frame = new DialogueFrame();
			}
		});

		labAmericano.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labAmericano.setForeground(Color.WHITE);
				labAmericano.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/americano_in.png")), 40, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labAmericano.setForeground(Color.BLACK);
				labAmericano.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/americano.png")), 40, 40));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dialogFrameAmer();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				frame = new DialogueFrame();
			}
		});

		labLatte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labLatte.setForeground(Color.WHITE);
				labLatte.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/latte_in.png")), 40, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labLatte.setForeground(Color.BLACK);
				labLatte.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/latte.png")), 40, 40));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dialogFrameLatte();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				frame = new DialogueFrame();
			}
		});

		labBT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labBT.setForeground(Color.WHITE);
				labBT.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/black_tea_in.png")), 40, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labBT.setForeground(Color.BLACK);
				labBT.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/black_tea.png")), 40, 40));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dialogFrameBT();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				frame = new DialogueFrame();
			}
		});

		labGT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labGT.setForeground(Color.WHITE);
				labGT.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/green_tea_in.png")), 40, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labGT.setForeground(Color.BLACK);
				labGT.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/green_tea.png")), 40, 40));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dialogFrameGT();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				frame = new DialogueFrame();
			}
		});

		labTomato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labTomato.setForeground(Color.WHITE);
				labTomato.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/tomato_soup_in.png")), 40, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labTomato.setForeground(Color.BLACK);
				labTomato.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/tomato_soup.png")), 40, 40));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dialogFrameTS();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				frame = new DialogueFrame();
			}
		});
	}
}
