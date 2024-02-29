/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
 */

package chanthakorn.naphat.lab11;

import java.awt.event.*;
import javax.swing.*;
import chanthakorn.naphat.lab10.PlayerFormV11;

// Extending PlayerFormV11 to inherit its properties and behaviors
public class PlayerFormV12 extends PlayerFormV11 {

    // Constructor of the PlayerFormV12 class
    public PlayerFormV12(String title) {
        super(title);
    }

    // Method to handle text field Name and display appropriate dialogs
    public void handleNameTextField() {
        String name = nameTxtField.getText();

        if (name.isEmpty()) {
            // Show dialog asking user to enter some data
            JOptionPane.showMessageDialog(this, "Please enter some data in Name");
            // Request focus on the name text field
            nameTxtField.requestFocusInWindow();
            // Disable the next component
            nationalityTxtField.setEnabled(false);
        } else {
            // Show dialog indicating that the name is changed
            JOptionPane.showMessageDialog(this, "Name is changed to " + name);
            // Enable the next component
            nationalityTxtField.setEnabled(true);
            // Set focus on the next component
            nationalityTxtField.requestFocusInWindow();
        }
    }

    public void handleNationalityTextField() {
        
    }

    // Override method to add additional listeners for text field Name
    @Override
    public void addListeners() {
        super.addListeners();
        nameTxtField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Check if the Enter key is pressed
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Handle the text field Name
                    handleNameTextField();
                }
            }
        });
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
        PlayerFormV12 msw = new PlayerFormV12("Player Form V12");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
        msw.addListeners();
        msw.enableKeyboard();
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
