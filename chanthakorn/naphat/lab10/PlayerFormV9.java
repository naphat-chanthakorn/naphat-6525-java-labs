package chanthakorn.naphat.lab10;

import javax.swing.*;
import javax.swing.event.*;

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {
    public PlayerFormV9(String title) {
        super(title);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        yearExpSlider.addChangeListener(this);
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            int yearExp = source.getValue();
            JOptionPane.showMessageDialog(this, "Year of experience in this sport is " + yearExp);
        }
    }

    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
        msw.addListeners();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}