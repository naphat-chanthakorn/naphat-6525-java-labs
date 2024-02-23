/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
*/

package chanthakorn.naphat.lab10;

import javax.swing.*;
import javax.swing.event.*;
import chanthakorn.naphat.lab9.PlayerFormV7;

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {
    protected boolean dialogShown = false;
    public PlayerFormV8(String title) {
        super(title);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        sportsList.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && !dialogShown) {
            Object[] selectedSports = sportsList.getSelectedValues();
            StringBuilder message = new StringBuilder("Selected sports are ");

            for (Object sport : selectedSports) {
                message.append(sport.toString()).append(" ");
            }

            if (message.length() > 0) {
                JOptionPane.showMessageDialog(this, message.toString());
            } 
        }
    }

    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        PlayerFormV8 msw = new PlayerFormV8("Player Form V8");
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