/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
*/

package chanthakorn.naphat.lab10;

import java.util.List;

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
        super.valueChanged(e);
        boolean isAdjusting = e.getValueIsAdjusting();
        if (!isAdjusting && !dialogShown) {
            List<String> selectedsports = sportsList.getSelectedValuesList();
            int numSelected = selectedsports.size();
            StringBuffer message = new StringBuffer();
            for (int i = 0; i < numSelected; i++) {
                message.append(selectedsports.get(i) + " ");
            }
            JOptionPane.showMessageDialog(this, "Selected sports are " + message.toString());
            dialogShown = true;
        } else {
            dialogShown = false;
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