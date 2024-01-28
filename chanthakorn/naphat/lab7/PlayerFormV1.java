package chanthakorn.naphat.lab7;

import java.awt.*;
import javax.swing.*;

public class PlayerFormV1 extends MySimpleWindow {
    // Labels and text fields for player information
    protected JLabel nameLabel, nationalityLabel, birthLabel, genderLabel;
    protected JTextField nameTxtField, nationalityTxtField, birthTxtField;
    // Radio buttons and button group for gender selection
    protected JRadioButton maleRadioButton, femaleRadioButton;
    protected ButtonGroup genderButtonGroup;
    // Panels for
    protected JPanel genderPanel, topPanel;

    // Constructor
    public PlayerFormV1(String title) {
        // Call superclass constructor to set window title
        super(title);
    }

    // Method to add components to the window
    protected void addComponents() {
        // Call superclass method to add buttons panel
        super.addComponents();

        // Create top panel for player information
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4, 2));

        // Add labels and text fields for player information
        nameLabel = new JLabel("Name:");
        nameTxtField = new JTextField(15);
        topPanel.add(nameLabel);
        topPanel.add(nameTxtField);

        nationalityLabel = new JLabel("Nationality:");
        nationalityTxtField = new JTextField(15);
        topPanel.add(nationalityLabel);
        topPanel.add(nationalityTxtField);

        birthLabel = new JLabel("Date of Birth (eg.,31-01-2005):");
        birthTxtField = new JTextField(15);
        topPanel.add(birthLabel);
        topPanel.add(birthTxtField);

        // Add gender selection radio buttons
        genderPanel = new JPanel();
        genderButtonGroup = new ButtonGroup();
        genderLabel = new JLabel("Gender:");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female", true);
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        topPanel.add(genderLabel);
        topPanel.add(genderPanel);

        // Set layout for main panel and add components
        mainPanel.setLayout(new BorderLayout());
        // Top panel at the top
        mainPanel.add(topPanel, BorderLayout.NORTH);
        // Buttons panel at the bottom
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        // Add main panel to the window
        add(mainPanel);
    }

    // Method to set features of the frame
    protected void setFrameFeatures() {
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
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
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