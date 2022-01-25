package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuHome {

	private JLabel labdSoups;
	private JLabel drinks;
	private JLabel labSoups;
	private JLabel labSB;
	private JLabel labAmericano;
	private JLabel labLatte;
	private JLabel labBT;
	private JLabel labGT;
	private JLabel labTomato;
	private DialogueFrame frame;

	public MenuHome() {
		this.drinks = new JLabel("  Drinks");
		this.labSoups = new JLabel("  Soups");
		this.labSB = new JLabel("  Short Black : " + "€");
		this.labAmericano = new JLabel("  Americano : " + "€");
		this.labLatte = new JLabel("  Latte : " + "€");
		this.labBT = new JLabel("  Black Tea : " + "€");
		this.labGT = new JLabel("  Green Tea : " + "€");
		this.labTomato = new JLabel("  Tomato Soup : " + "€");
		
		initListener();
	}

	/**
	 * Creates home panel
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
		labSB.setBounds(30, 120, 150, 40);
		labSB.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/short_black.png")), 40, 40));
		

		labAmericano.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labAmericano.setHorizontalAlignment(SwingConstants.LEFT);
		labAmericano.setBounds(30, 180, 150, 40);
		labAmericano.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/americano.png")), 40, 40));
		

		labLatte.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labLatte.setHorizontalAlignment(SwingConstants.LEFT);
		labLatte.setBounds(30, 240, 150, 40);
		labLatte.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/latte.png")), 40, 40));
		

		labBT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labBT.setHorizontalAlignment(SwingConstants.LEFT);
		labBT.setBounds(30, 300, 150, 40);
		labBT.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/black_tea.png")), 40, 40));
		

		labGT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labGT.setHorizontalAlignment(SwingConstants.LEFT);
		labGT.setBounds(30, 360, 150, 50);
		labGT.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/green_tea.png")), 40, 40));
		

		labTomato.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labTomato.setHorizontalAlignment(SwingConstants.LEFT);
		labTomato.setBounds(360, 120, 150, 40);
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

	/**
	 * @return the labdSoups
	 */
	public JLabel getLabdSoups() {
		return labdSoups;
	}

	/**
	 * @return the labDrinks
	 */
	public JLabel getLabDrinks() {
		return drinks;
	}

	/**
	 * @return the labSoups
	 */
	public JLabel getLabSoups() {
		return labSoups;
	}

	/**
	 * @return the labSB
	 */
	public JLabel getLabSB() {
		return labSB;
	}

	/**
	 * @return the labAmericano
	 */
	public JLabel getLabAmericano() {
		return labAmericano;
	}

	/**
	 * @return the labLatte
	 */
	public JLabel getLabLatte() {
		return labLatte;
	}

	/**
	 * @return the labBT
	 */
	public JLabel getLabBT() {
		return labBT;
	}

	/**
	 * @return the labGT
	 */
	public JLabel getLabGT() {
		return labGT;
	}

	/**
	 * @return the labTomato
	 */
	public JLabel getLabTomato() {
		return labTomato;
	}

	/**
	 * @param labdSoups the labdSoups to set
	 */
	public void setLabdSoups(JLabel labdSoups) {
		this.labdSoups = labdSoups;
	}

	/**
	 * @param labDrinks the labDrinks to set
	 */
	public void setLabDrinks(JLabel labDrinks) {
		this.drinks = labDrinks;
	}

	/**
	 * @param labSoups the labSoups to set
	 */
	public void setLabSoups(JLabel labSoups) {
		this.labSoups = labSoups;
	}

	/**
	 * @param labSB the labSB to set
	 */
	public void setLabSB(JLabel labSB) {
		this.labSB = labSB;
	}

	/**
	 * @param labAmericano the labAmericano to set
	 */
	public void setLabAmericano(JLabel labAmericano) {
		this.labAmericano = labAmericano;
	}

	/**
	 * @param labLatte the labLatte to set
	 */
	public void setLabLatte(JLabel labLatte) {
		this.labLatte = labLatte;
	}

	/**
	 * @param labBT the labBT to set
	 */
	public void setLabBT(JLabel labBT) {
		this.labBT = labBT;
	}

	/**
	 * @param labGT the labGT to set
	 */
	public void setLabGT(JLabel labGT) {
		this.labGT = labGT;
	}

	/**
	 * @param labTomato the labTomato to set
	 */
	public void setLabTomato(JLabel labTomato) {
		this.labTomato = labTomato;
	}

}
