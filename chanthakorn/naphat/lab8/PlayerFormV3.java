package chanthakorn.naphat.lab8;

import javax.swing.*;

import chanthakorn.naphat.lab7.PlayerFormV2;

public class PlayerFormV3 extends PlayerFormV2 {
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu;
    protected JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem, colorMenuItem, sizMenuItem;

    public PlayerFormV3(String title) {
        // Call superclass constructor to set window title
        super(title);
    }

    // Method to add components to the window
    public void addComponents() {
        // Call superclass method to add components
        super.addComponents();
    }

    public void addMenus()  {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");

        newMenuItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");
        colorMenuItem = new JMenuItem("Color");
        sizMenuItem = new JMenuItem("Size");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        configMenu.add(colorMenuItem);
        configMenu.add(sizMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(configMenu);
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
        PlayerFormV2 msw = new PlayerFormV2("Player Form V3");
        // Call the method addComponents to the window
        msw.addComponents();
        // Call the method setFrameFeatures
        msw.setFrameFeatures();
        msw.addMenus();
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