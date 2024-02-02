/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 02/02/2024
 */

package chanthakorn.naphat.lab7;

import javax.swing.*;
import java.awt.*;

// Extending PlayerFormV1 to inherit its properties and behaviors
public class PlayerFormV2 extends PlayerFormV1 {
    protected JLabel playerTypeLabel, noteLabel;
    protected JComboBox<String> playerTypeBox;
    protected JTextArea noteTxtArea;
    protected JScrollPane scrollPane;
    protected JPanel bottomPanel, notePanel;

    public PlayerFormV2(String title) {
        // Call superclass constructor to set window title
        super(title);
    }

    // Method to add components to the window
    public void addComponents() {
        // Call superclass method to add components
        super.addComponents();

        // Create panel for components
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        // Adjust layout of topPanel for components
        topPanel.setLayout(new GridLayout(5, 2));

        // Add player type label and combo box
        playerTypeLabel = new JLabel("Player Type:");
        playerTypeBox = new JComboBox<String>();
        playerTypeBox.addItem("Beginner");
        playerTypeBox.addItem("Amateur");
        playerTypeBox.addItem("Professional");
        playerTypeBox.setEditable(false);
        playerTypeBox.setSelectedItem("Amateur");
        topPanel.add(playerTypeLabel);
        topPanel.add(playerTypeBox);

        // Add note label and text area
        noteLabel = new JLabel("Note:");
        noteTxtArea = new JTextArea(3, 35);
        scrollPane = new JScrollPane(noteTxtArea);
        // Set default note text
        noteTxtArea.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, " +
                "on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");
        // Enable line wrap and word wrap for the text area
        noteTxtArea.setLineWrap(true);
        noteTxtArea.setWrapStyleWord(true);
        // Create notePanel with BorderLayout
        notePanel = new JPanel(new BorderLayout());
        // Add note label to the bottomPanel
        notePanel.add(noteLabel, BorderLayout.NORTH);
        notePanel.add(scrollPane, BorderLayout.CENTER);

        bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);
        bottomPanel.add(notePanel, BorderLayout.NORTH);
        // Add bottomPanel to the mainPanel
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
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
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
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