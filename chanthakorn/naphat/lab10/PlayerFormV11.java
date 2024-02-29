/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
*/

package chanthakorn.naphat.lab10;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

// Extending PlayerFormV10 to inherit its properties and behaviors
public class PlayerFormV11 extends PlayerFormV10 {
    protected JMenuItem customMI;
    protected JColorChooser colorChooser;
    protected JFileChooser fileChooser;

    // Constructor of the PlayerFormV11 class
    public PlayerFormV11(String title) {
        super(title);
    }

    // Override method to add custom menu item
    @Override
    public void addMenus() {
        super.addMenus();
        customMI = new JMenuItem("Custom");
        colorMenu.add(customMI);
    }

    // Override method to add additional listeners for custom menu item
    @Override
    public void addListeners() {
        super.addListeners();
        customMI.addActionListener(this);
    }

    // Method to display color chooser dialog and change text color
    public void ColorChooser() {
        colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(this);
        Color newColor = JColorChooser.showDialog(this, "Choose Text Color", Color.BLUE);

        // Change text color of text fields based on selected color
        nameTxtField.setForeground(newColor);
        nationalityTxtField.setForeground(newColor);
        birthTxtField.setForeground(newColor);
    }

    // Method to handle opening file menu item
    public void handleOPenMenu() {
        fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(PlayerFormV11.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Opening file " + file.getPath());
        }
    }

    // Method to handle saving file menu item
    public void handleSaveMenu() {
        fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(PlayerFormV11.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Saving in file " + file.getPath());
        }
    }

    // Method to enable keyboard shortcuts
    public void enableKeyboard() {
        // Set mnemonic key for the file menu
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // Set mnemonic keys and accelerator keys for other menus
        newMI.setMnemonic(KeyEvent.VK_N);
        newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.META_DOWN_MASK));
        openMI.setMnemonic(KeyEvent.VK_O);
        openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_DOWN_MASK));
        saveMI.setMnemonic(KeyEvent.VK_S);
        saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_DOWN_MASK));
        exitMI.setMnemonic(KeyEvent.VK_X);
        exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.META_DOWN_MASK));
    }

    // Method invoked when a menu item is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JMenuItem source = (JMenuItem) e.getSource();

        if (source == customMI) {
            ColorChooser();
        } else if (source == openMI) {
            handleOPenMenu();
        } else if (source == saveMI) {
            handleSaveMenu();
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
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11");
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