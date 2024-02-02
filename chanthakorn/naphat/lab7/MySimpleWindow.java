/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 02/02/2024
 */

package chanthakorn.naphat.lab7;

import javax.swing.*;

public class MySimpleWindow extends JFrame {
    
    protected JPanel mainPanel, buttonsPanel;
    protected JButton resetButton, submitButton;

    public MySimpleWindow(String title) {
        // Call superclass constructor to set window title
        super(title);
    }

    // Method to add components to the window
    public void addComponents() {
        // Create main panel and buttons panel
        mainPanel = new JPanel();
        buttonsPanel = new JPanel();
        // Create reset and submit buttons
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
        // Add buttons to the buttons panel
        buttonsPanel.add(resetButton);
        buttonsPanel.add(submitButton);

        // Add the buttons panel to the main panel
        add(buttonsPanel);
    }

    // Method to set features of the frame
    public void setFrameFeatures() {
        // Set the window to appear in the center of the screen
        setLocationRelativeTo(null);
        // Make the window visible
        setVisible(true);
        // Exit application on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Automatically size the window to fit its components
        pack();
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        // Call the method addComponents to the window
        msw.addComponents();
        // Call the method setFrameFeatures
        msw.setFrameFeatures();
    }

    // Main method to start
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Call the method createAndShowGUI
                createAndShowGUI();
            }
        });
    }
}