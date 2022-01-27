package view;

import controller.DrinkDAO;
import launcher.ConnectionDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogueFrame {

    private final JFrame addFrame;
    private JPanel contentPane;
    private JLabel lab;
    private JButton btnConfirm;
    private JButton btnCancel;
    private JProgressBar bar;
    private final DrinkDAO drinks;

    Timer timer = new Timer(50, new ActionListener() {
        int counter = 1;

        @Override
        public void actionPerformed(ActionEvent ae) {
            bar.setValue(++counter);
            if (counter > 100) {
                timer.stop();
                lab.setText("Order ready, enjoy your drink :)");
                lab.setIcon(IconsResize.getScaledImage(
                        new ImageIcon(ApplicationWindow.class.getResource("/icons/ready.png")), 80, 80));

            }
        }
    });

    /**
     * Default constructor
     */
    public DialogueFrame(ConnectionDB conn) {
        drinks = new DrinkDAO(conn.getConn());

        addFrame = new JFrame();
        addFrame.setPreferredSize(new Dimension(400, 180));
        addFrame.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        addFrame.setLocation(screenSize.width / 2 - addFrame.getPreferredSize().width / 2,
                screenSize.height / 2 - addFrame.getPreferredSize().height / 2);
        addFrame.setLayout(null);

    }

    /**
     * Frame builder to respond when an action is made
     *
     * @param message
     * @param iconPath
     */
    public void dialogFrame(String message, String iconPath) {
        contentPane = new JPanel();
        contentPane.setSize(400, 180);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(189, 183, 107));

        lab = new JLabel(message, SwingConstants.CENTER);
        lab.setIcon(IconsResize.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource(iconPath)), 35, 35));
        lab.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lab.setBounds(0, 40, 400, 40);

        contentPane.add(lab);
        addFrame.add(contentPane);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.pack();
        addFrame.setVisible(true);
    }

    /**
     *
     */
    public void dialogCanceled() {
        dialogFrame("Your order has been canceled!", "/icons/cancel.png");
        lab.setSize(400, 100);
        lab.setLocation(addFrame.getPreferredSize().width / 2 - 208, 5);
        lab.setIcon(IconsResize.getScaledImage(
                new ImageIcon(ApplicationWindow.class.getResource("/icons/cancel.png")), 80, 80));
    }

    /**
     * @param drink    the drink id
     * @param quantity the drink quantity
     * @param cup      selection of the cup
     * @param sugar    amount of sugar
     * @param price    order price
     */
    public void dialogConfirmation(String drink, String quantity, String cup, String sugar, Double price) {
        contentPane = new JPanel();
        contentPane.setSize(400, 180);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(189, 183, 107));

        lab = new JLabel("Order Confirmation", SwingConstants.CENTER);
        lab.setSize(400, 40);
        lab.setLocation(addFrame.getPreferredSize().width / 2 - 208, 5);
        lab.setIcon(IconsResize.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/confirm.png")),
                35, 35));
        lab.setFont(new Font("Times New Roman", Font.BOLD, 14));

        JLabel labDrinkQ = new JLabel(drink + " " + quantity + " cl with " + sugar + " sugar(s)", SwingConstants.LEFT);
        labDrinkQ.setSize(300, 40);
        labDrinkQ.setLocation(addFrame.getPreferredSize().width / 2 - 50, 30);

        JLabel labCup = new JLabel("Cup : " + cup, SwingConstants.LEFT);
        labCup.setSize(200, 40);
        labCup.setLocation(addFrame.getPreferredSize().width / 2 - 50, 50);

        JLabel labPrice = new JLabel("Total Price : " + price + " €", SwingConstants.LEFT);
        labPrice.setSize(200, 40);
        labPrice.setLocation(addFrame.getPreferredSize().width / 2 - 50, 70);

        btnConfirm = new JButton("Confirm");
        btnCancel = new JButton("Cancel");
        btnConfirm.setBounds(addFrame.getPreferredSize().width / 2 + 5, 100, 90, 25);
        btnCancel.setBounds(addFrame.getPreferredSize().width / 2 - 95, 100, 90, 25);
        btnConfirm.setBackground(Color.GREEN);
        btnCancel.setBackground(Color.RED);

        contentPane.add(lab);
        contentPane.add(btnConfirm);
        contentPane.add(btnCancel);
        contentPane.add(labDrinkQ);
        contentPane.add(labCup);
        contentPane.add(labPrice);
        addFrame.add(contentPane);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.pack();
        addFrame.setVisible(true);
    }

    /**
     *
     */
    public void dialogConfirmed() {
        contentPane = new JPanel();
        contentPane.setSize(400, 180);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(189, 183, 107));

        lab = new JLabel("In Preparation...", SwingConstants.CENTER);
        lab.setSize(400, 100);
        lab.setLocation(addFrame.getPreferredSize().width / 2 - 208, 5);
        lab.setIcon(IconsResize.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/confirm.png")),
                35, 35));
        lab.setFont(new Font("Times New Roman", Font.BOLD, 14));

        bar = new JProgressBar();
        bar.setBounds(addFrame.getPreferredSize().width / 2 - 50, 100, 100, 20);
        bar.setMinimum(0);
        bar.setMaximum(100);
        bar.setStringPainted(true);
        bar.setValue(0);
        timer.start();

        contentPane.add(bar);
        contentPane.add(lab);
        addFrame.add(contentPane);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.pack();
        addFrame.setVisible(true);

    }

    /**
     * Sub frame that shows the drinks description
     */
    public void dialogFrameAmer() {
        dialogFrame(drinks.getAllDrinks().get(1).getDescription(), "/icons/description.png");

    }

    /**
     * Sub frame that shows the drinks description
     */
    public void dialogFrameBT() {
        dialogFrame(drinks.getAllDrinks().get(3).getDescription(), "/icons/description.png");

    }

    /**
     * Sub frame that shows the drinks description
     */
    public void dialogFrameGT() {
        dialogFrame(drinks.getAllDrinks().get(4).getDescription(), "/icons/description.png");

    }

    /**
     * Sub frame that shows the drinks description
     */
    public void dialogFrameLatte() {
        dialogFrame(drinks.getAllDrinks().get(2).getDescription(), "/icons/description.png");

    }

    /**
     * Sub frame that shows the drinks description
     */
    public void dialogFrameSB() {
        dialogFrame(drinks.getAllDrinks().get(0).getDescription(), "/icons/description.png");

    }

    /**
     * Sub frame that shows the drinks description
     */
    public void dialogFrameTS() {
        dialogFrame(drinks.getAllDrinks().get(5).getDescription(), "/icons/description.png");

    }

    /**
     *
     */
    public void dialogueCheckAllBoxes() {
        dialogFrame("You need to check all boxes beforing ordering!", "/icons/failure.png");
    }

    /**
     *
     */
    public void dialogueNotEnough(String missing) {
        dialogFrame("Not enough " + missing + " !", "/icons/failure.png");
    }

    /**
     * @return the addFrame
     */
    public JFrame getAddFrame() {
        return addFrame;
    }

    /**
     * @return the btnCancel
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }

    /**
     * @return the btnConfirm
     */
    public JButton getBtnConfirm() {
        return btnConfirm;
    }

}
