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

    // Method to handle text field Name and Nationality
    public void handleNormalTextField(JTextField currentTextField, JTextField nextTextField) {
        String currentFieldName = currentTextField.getName();
        String currentFieldValue = currentTextField.getText();

        if (currentFieldValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + currentFieldName);
            currentTextField.requestFocusInWindow();
            nextTextField.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, currentFieldName + " is changed to " + currentFieldValue);
            nextTextField.setEnabled(true);
            nextTextField.requestFocusInWindow();
        }
    }

    // Method to handle text field Date of birth
    public void handleBirthTextField(JTextField textField) {
        String birthField = textField.getText();
        
        try {
            // Define the date formatter for the format (dd-MM-yyyy)
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            // Parse the input date using the defined format
            LocalDate dateOfBirth = LocalDate.parse(birthField, dateFormatter);
            
            JOptionPane.showMessageDialog(this, "Date of Birth is changed to " + dateOfBirth.format(dateFormatter));
        } catch (DateTimeParseException e) {
            // If an exception occurs, it means the input date is not in the correct format
            JOptionPane.showMessageDialog(this, "Please enter a valid date in Date of Birth");
        }
    }

    // Method to handle all of text fields
    protected void handleTextField(JTextField textField) {
        if (textField == nameTxtField) {
            handleNormalTextField(nameTxtField, nationalityTxtField);
        } else if (textField == nationalityTxtField) {
            handleNormalTextField(nationalityTxtField, birthTxtField);
        } else if (textField == birthTxtField) {
            handleBirthTextField(textField);
        }
    }   
    
    //Override key pressed method to handle each text field
    @Override
    public void keyPressed(KeyEvent e) {
        // Check if Enter key is pressed
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == nameTxtField) {
                handleTextField(nameTxtField);
            } else if (e.getSource() == nationalityTxtField) {
                handleTextField(nationalityTxtField);
            } else if (e.getSource() == birthTxtField) {
                handleTextField(birthTxtField);
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