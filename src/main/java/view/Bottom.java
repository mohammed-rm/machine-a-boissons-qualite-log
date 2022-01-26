package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Bottom extends JPanel {

	/**
	 * Default constructor
	 */
	public Bottom() {
		setOpaque(false);
		new JPanel();
		setLayout(null);
		setSize(800, 40);
		setLocation(0, 560);
	}

	/**
	 * Method to add new shape and color
	 */
	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D graph2D = (Graphics2D) grphcs;
		graph2D.setColor(getBackground());
		graph2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gradPaint = new GradientPaint(0, 0, Color.decode("#111111"), 0, getHeight(),
				Color.decode("#302b63"));
		graph2D.setPaint(gradPaint);
		graph2D.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
		graph2D.fillRect(0, 0, getWidth(), 20);
		super.paintComponent(grphcs);
	}
}
