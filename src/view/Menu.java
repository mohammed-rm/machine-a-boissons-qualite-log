package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel {

	/**
	 * 
	 */
	public Menu() {
		setOpaque(false);
		new JPanel();
		setLayout(null);
		setSize(220, 560);
		setLocation(0, 0);
	}

	/**
	 * Method to change shape and color
	 */
	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D graph2D = (Graphics2D) grphcs;
		graph2D.setColor(getBackground());
		graph2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gradPaint = new GradientPaint(0, 0, Color.decode("#ffd552"), 0, getHeight(),
				Color.decode("#1a5b6c"));
		graph2D.setPaint(gradPaint);
		graph2D.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
		graph2D.fillRect(getWidth() - 25, 0, getWidth(), getHeight()); // Top right edge
		graph2D.fillRect(0, getHeight() - 25, getWidth(), getHeight()); // Bottom right edge
		super.paintComponent(grphcs);
	}

}