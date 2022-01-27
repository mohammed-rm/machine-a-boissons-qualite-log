package view;

import javax.swing.*;
import java.awt.*;

public class MenuSeparators {

    /**
     * Separators between menu's items
     *
     * @param menu application menu
     */
    public static void lineSeparator(Menu menu) {
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.BLUE);
        separator_1.setBounds(15, 250, 200, 1);
        menu.add(separator_1);

        JSeparator separator_2 = new JSeparator();
        separator_2.setForeground(Color.BLUE);
        separator_2.setBounds(15, 310, 200, 1);
        menu.add(separator_2);

        JSeparator separator_3 = new JSeparator();
        separator_3.setForeground(Color.BLUE);
        separator_3.setBounds(15, 370, 200, 1);
        menu.add(separator_3);

    }
}
