/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
*/

package chanthakorn.naphat.lab9;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import chanthakorn.naphat.lab8.PlayerFormV5;

// Extending PlayerFormV5 to inherit its properties and behaviors
public class PlayerFormV6 extends PlayerFormV5
        implements ActionListener, ItemListener, ListSelectionListener, KeyListener {
    protected String hobbies, sports;
    protected StringBuilder hobbiesBuilder, sportsBuilder;

    // Constructor of the PlayerFormV6 class
    public PlayerFormV6(String title) {
        super(title);
    }

    // Method to set default text for fields
    public void setText() {
        nameTxtField.setText("Naphat");
        nationalityTxtField.setText("Thai");
        birthTxtField.setText("18-10-2004");

        // Set name for text fields
        nameTxtField.setName("Name");
        nationalityTxtField.setName("Nationality");
        birthTxtField.setName("Date of Birth");
    }

    // Override method to add components, set default text, and add key listeners
    @Override
    public void addComponents() {
        super.addComponents();
        setText();
        // Add key listener to text fields
        nameTxtField.addKeyListener(this);
        nationalityTxtField.addKeyListener(this);
        birthTxtField.addKeyListener(this);
    }

    // Method to register event listeners for components
    public void addListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        readBox.addItemListener(this);
        browBox.addItemListener(this);
        sleepBox.addItemListener(this);
        travelBox.addItemListener(this);
        sportsList.addListSelectionListener(this);
    }

    // Item listener method to handle checkbox selection/deselection events
    public void itemStateChanged(ItemEvent e) {
        // Construct a string with selected hobbies
        hobbiesBuilder = new StringBuilder();

        if (readBox.isSelected()) {
            hobbiesBuilder.append("Reading ");
        }
        if (browBox.isSelected()) {
            hobbiesBuilder.append("Browsing ");
        }
        if (sleepBox.isSelected()) {
            hobbiesBuilder.append("Sleeping ");
        }
        if (travelBox.isSelected()) {
            hobbiesBuilder.append("Traveling ");
        }

        // Remove the trailing space if hobbies are selected
        if (hobbiesBuilder.length() > 2) {
            hobbiesBuilder.setLength(hobbiesBuilder.length() - 1);
        }

        // Store the constructed string
        hobbies = hobbiesBuilder.toString();
    }

    // List selection listener method to handle sports selection
    public void valueChanged(ListSelectionEvent e) {
        // Get selected sports from the list
        Object[] selectedSports = sportsList.getSelectedValues();
        // Construct a string with selected sports
        sportsBuilder = new StringBuilder();

        for (Object sport : selectedSports) {
            sportsBuilder.append(sport.toString()).append(", ");
        }

        // Remove the last comma and space
        if (sportsBuilder.length() > 2) {
            sportsBuilder.setLength(sportsBuilder.length() - 2);
        }

        sports = sportsBuilder.toString();
    }

    // Key listener method to handle key press events
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            JTextField textField = (JTextField) e.getSource();
            String fieldName = textField.getName();
            String fieldValue = textField.getText();
            // Show a message dialog indicating the field name and new value
            JOptionPane.showMessageDialog(PlayerFormV6.this, fieldName + " is changed to " + fieldValue);
        }
    }

    // Key listener methods for unused key events
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    // Action listener method to handle button clicks
    public void actionPerformed(ActionEvent e) {
        Object srcObject = e.getSource();
        if (srcObject == submitButton) {
            // Retrieve values from text fields and components
            String name = nameTxtField.getText();
            String nationality = nationalityTxtField.getText();
            String birth = birthTxtField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String playerType = (String) playerTypeBox.getSelectedItem();

            // Construct a message with the entered information
            StringBuffer message = new StringBuffer();
            message.append(name).append(" has nationality as ").append(nationality)
                    .append(" and was born on ").append(birth).append(", has gender as ")
                    .append(gender).append(", is a ").append(playerType)
                    .append(" player, has hobbies as ").append(hobbies).append(" and plays [")
                    .append(sports).append("]");

            // Show message dialog with the constructed message
            JOptionPane.showMessageDialog(this, message.toString());
        }
        // Set text as blank when use reset button 
        else if (srcObject == resetButton) {
            nameTxtField.setText("");
            nationalityTxtField.setText("");
            birthTxtField.setText("");
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
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");
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