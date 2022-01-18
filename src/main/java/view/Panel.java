package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Panel() {
		setOpaque(false);
		new JPanel();
		setLayout(null);
	}

	/**
	 * To change shape and color
	 */
	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D grad2D = (Graphics2D) grphcs;
		grad2D.setColor(getBackground());
		grad2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gradPaint = new GradientPaint(0, 0, Color.decode("#3a4a4c"), 0, getHeight(),
				Color.decode("#fdbb2d"));
		grad2D.setPaint(gradPaint);
		grad2D.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
		super.paintComponent(grphcs);

	}
}
