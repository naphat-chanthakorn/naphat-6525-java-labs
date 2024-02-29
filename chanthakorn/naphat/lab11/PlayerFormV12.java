/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
 */

package chanthakorn.naphat.lab11;

import java.awt.event.*;
import java.time.*;
import java.time.format.*;

import javax.swing.*;
import chanthakorn.naphat.lab10.PlayerFormV11;

// Extending PlayerFormV11 to inherit its properties and behaviors
public class PlayerFormV12 extends PlayerFormV11 {

    // Constructor of the PlayerFormV12 class
    public PlayerFormV12(String title) {
        super(title);
    }

    // Method to handle text field Name and display dialogs
    public void handleNameTextField() {
        String nameField = nameTxtField.getText();

        if (nameField.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in Name");
            // Request focus on the name text field
            nameTxtField.requestFocusInWindow();
            // Disable the text field Nationality
            nationalityTxtField.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Name is changed to " + nameField);
            // Set focus on the text field Nationality
            nationalityTxtField.requestFocusInWindow();
            // Enable the text field Nationality
            nationalityTxtField.setEnabled(true);
        }
    }

    // Method to handle text field Nationality and display dialogs
    public void handleNationalityTextField() {
        String nationalityField = nationalityTxtField.getText();

        if (nationalityField.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in Nationality");
            // Request focus on the name text field
            nationalityTxtField.requestFocusInWindow();
            // Disable the text field Date of birth
            birthTxtField.setEnabled(false);
        } else {
            // Show dialog indicating that the name is changed
            JOptionPane.showMessageDialog(this, "Nationality is changed to " + nationalityField);
            // Enable the text field Date of birth
            birthTxtField.setEnabled(true);
            // Set focus on the text field Date of birth
            birthTxtField.requestFocusInWindow();
        }
    }

    // Method to handle text field Date of birth and display dialogs
    public void handleBirthTextField() {
        String birthField = birthTxtField.getText();
        
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            // Parse the input date using the defined format
            LocalDate dateOfBirth = LocalDate.parse(birthField, dateFormatter);
            
            // If the date is successfully parsed, display the confirmation message
            JOptionPane.showMessageDialog(this, "Date of Birth is changed to " + dateOfBirth.format(dateFormatter));
        } catch (DateTimeParseException e) {
            // If an exception occurs, it means the input date is not in the correct format
            JOptionPane.showMessageDialog(this, "Please enter a valid date in Date of Birth");
        }
    }

    /*
    protected void handleTextField(JTextField textField) {
        if (textField == birthTxtField) {
            handleBirthTextField(textField);
        } else if (textField == nameTxtField) {
            handleNormalTextField(nameTxtField, nationalityTxtField);
        } else if (textField == nationalityTxtField) {
            handleNormalTextField(nationalityTxtField, birthTxtField)
        }
    }
    */    

    @Override
    public void keyPressed(KeyEvent e) {
        // Check if Enter key is pressed
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == nameTxtField) {
                handleNameTextField();
            } else if (e.getSource() == nationalityTxtField) {
                handleNationalityTextField();
            } else if (e.getSource() == birthTxtField) {
                // Handle the birth text field
                handleBirthTextField();
            }
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