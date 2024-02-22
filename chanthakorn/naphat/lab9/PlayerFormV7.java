/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
*/

package chanthakorn.naphat.lab9;

import java.awt.event.*;
import javax.swing.*;

// Extending PlayerFormV6 to inherit its properties and behaviors
public class PlayerFormV7 extends PlayerFormV6 {

    // Constructor of the PlayerFormV7 class
    public PlayerFormV7(String title) {
        super(title);
    }

    // Override method to add additional listeners for radio buttons
    @Override
    public void addListeners() {
        super.addListeners();
        maleRadioButton.addItemListener(this);
        femaleRadioButton.addItemListener(this);
    }

    // Override method to handle item state changes for radio buttons and checkboxes
    @Override
    public void itemStateChanged(ItemEvent e) {
        super.itemStateChanged(e);
        Object source = e.getItemSelectable();
        StringBuilder message = new StringBuilder();

        // Handle item state changes for radio buttons (male and female)
        if (source == maleRadioButton || source == femaleRadioButton) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                message.append("Gender is updated to ");
                message.append(((JRadioButton) source).getText());
            }
        }
        // Handle item state changes for checkboxes (hobbies)
        else if (source == readBox || source == browBox || source == sleepBox || source == travelBox) {
            message.append(((JCheckBox) source).getText());
            message.append(e.getStateChange() == ItemEvent.SELECTED ? " is one of your hobbies"
                    : " is no longer one of your hobbies");
        }

        // Display the message if it is not empty
        if (message.length() > 0) {
            JOptionPane.showMessageDialog(this, message.toString());
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
        PlayerFormV7 msw = new PlayerFormV7("Player Form V7");
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