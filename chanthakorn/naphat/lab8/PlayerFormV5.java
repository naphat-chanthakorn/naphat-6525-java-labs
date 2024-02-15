/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 15/02/2024
*/

package chanthakorn.naphat.lab8;

import java.awt.*;
import javax.swing.*;

// Extending PlayerFormV4 to inherit its properties and behaviors
public class PlayerFormV5 extends PlayerFormV4 {
    protected ReadImage imagePanel;

    // Constructor of the PlayerFormV5 class
    public PlayerFormV5(String title) {
        super(title);
    }

    // Method to add components to the window
    @Override
    public void addComponents() {
        super.addComponents();

        imagePanel = new ReadImage("Image/Football.jpg");
        bottomPanel.add(imagePanel, BorderLayout.CENTER);
    }

    // Method for adding icons to the menu items
    public void addIcon() {
        // Load icons from image files and set them to the menu items
        ImageIcon newImageIcon = new ImageIcon("Image/New-icon.png");
        ImageIcon openImgIcon = new ImageIcon("Image/Open-icon.png");
        ImageIcon saveImgIcon = new ImageIcon("Image/Save-icon.png");

        newMI.setIcon(newImageIcon);
        openMI.setIcon(openImgIcon);
        saveMI.setIcon(saveImgIcon);
    }

    // Method for adding menus
    @Override
    public void addMenus() {
        super.addMenus();
        addIcon();
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
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
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