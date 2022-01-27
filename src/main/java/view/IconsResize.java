package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IconsResize {

    /**
     * Method to resize an icon for the application window
     *
     * @param srcImg the source image
     * @param width the new width
     * @param height the new height
     * @return res the new image
     */
    public static ImageIcon getScaledImage(ImageIcon srcImg, int width, int height) {
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        // g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        // RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.drawImage(srcImg.getImage(), 0, 0, width, height, null);
        g2.dispose();

        return new ImageIcon(resizedImg);
    }
}
