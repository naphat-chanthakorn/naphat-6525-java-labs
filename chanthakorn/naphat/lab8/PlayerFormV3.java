package chanthakorn.naphat.lab8;

import javax.swing.*;

import chanthakorn.naphat.lab7.PlayerFormV2;

// Extending PlayerFormV2 to inherit its properties and behaviors
public class PlayerFormV3 extends PlayerFormV2 {
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu;
    protected JMenuItem newMI, openMI, saveMI, exitMI, colorMI, sizMI;

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

        newMI = new JMenuItem("New");
        openMI = new JMenuItem("Open");
        saveMI = new JMenuItem("Save");
        exitMI = new JMenuItem("Exit");
        colorMI = new JMenuItem("Color");
        sizMI = new JMenuItem("Size");

        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);
        fileMenu.add(exitMI);
        configMenu.add(colorMI);
        configMenu.add(sizMI);

        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        // Set the JMenuBar for the JFrame
        setJMenuBar(menuBar);
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
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
        // Call the method addComponents to the window
        msw.addComponents();
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