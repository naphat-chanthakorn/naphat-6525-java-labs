/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
*/

package chanthakorn.naphat.lab10;

import javax.swing.*;
import javax.swing.event.*;

// Extending PlayerFormV8 to inherit its properties and behaviors
public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {

    // Constructor of the PlayerFormV9 class
    public PlayerFormV9(String title) {
        super(title);
    }

    // Override method to add additional listeners for slider
    @Override
    public void addListeners() {
        super.addListeners();
        yearExpSlider.addChangeListener(this);
    }

    // Method invoked when the state of the slider changes
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            int yearExp = source.getValue();
            JOptionPane.showMessageDialog(this, "Year of experience in this sport is " + yearExp);
        }
    }

    // Method to set features of the frame
    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
        msw.addListeners();
    }

    // Main method to start
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}