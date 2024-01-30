package chanthakorn.naphat.lab7;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV2 extends PlayerFormV1 {
    protected JLabel playerTypeLabel, noteLabel;
    protected JComboBox<String> playerTypeBox;
    protected JTextArea noteTxtArea;
    protected JScrollPane scrollPane;
    protected JPanel underPanel;

    public PlayerFormV2(String title) {
        // Call superclass constructor to set window title
        super(title);
    }

    // Method to add components to the window
    public void addComponents() {
        // Call superclass method to add components
        super.addComponents();

        // Create panel for components
        underPanel = new JPanel();
        underPanel.setLayout(new BorderLayout());
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
        // Add note label to the underPanel
        underPanel.add(noteLabel, BorderLayout.WEST);
        underPanel.add(scrollPane, BorderLayout.SOUTH);

        // Add underPanel to the mainPanel
        mainPanel.add(underPanel, BorderLayout.CENTER);
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