package view;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class InternalPanel extends JPanel {

    /**
     * Default constructor
     */
    public InternalPanel() {
        setOpaque(false);
        new JPanel();
        setLayout(null);
        setSize(580, 534);
        setLocation(220, 26);
    }

    /**
     * Method to add new shape and color
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D graph2D = (Graphics2D) grphcs;
        // graph2D.setColor(getBackground());
        graph2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graph2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradPaint = new GradientPaint(0, 0, Color.decode("#fdbd4f"), getWidth(), getHeight(),
                Color.decode("#5a3a4a"));
        graph2D.setPaint(gradPaint);
        graph2D.fillRect(0, 0, 620, 580);
        super.paintComponent(grphcs);

    }
}