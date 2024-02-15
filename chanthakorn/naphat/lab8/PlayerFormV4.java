/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 15/02/2024
*/

package chanthakorn.naphat.lab8;

import java.awt.*;
import javax.swing.*;

// Extending PlayerFormV3 to inherit its properties and behaviors
public class PlayerFormV4 extends PlayerFormV3 {
    protected JLabel hobbiesLabel, sportLabel, yearExpLabel;
    protected JCheckBox readBox, browBox, sleepBox, travelBox;
    protected JList<String> sportsList;
    protected String[] sports = { "Badminton", "Boxing", "Football", "Running" };
    protected JPanel midPanel, hobbiesPanel, sportsPanel, yearExpPanel, boxPanel;
    protected JSlider yearExpSlider;

    // Constructor of the PlayerFormV4 class
    public PlayerFormV4(String title) {
        // Call superclass constructor to set window title
        super(title);
    }

    // Method to add components to the window
    @Override
    public void addComponents() {
        super.addComponents();

        // Add hobbies label and check box
        hobbiesPanel = new JPanel(new BorderLayout());
        hobbiesLabel = new JLabel("Hobbies:");
        boxPanel = new JPanel();
        readBox = new JCheckBox("Reading");
        browBox = new JCheckBox("Browsing");
        sleepBox = new JCheckBox("Sleeping", true);
        travelBox = new JCheckBox("Traveling");
        boxPanel.add(readBox);
        boxPanel.add(browBox);
        boxPanel.add(sleepBox);
        boxPanel.add(travelBox);
        hobbiesPanel.add(hobbiesLabel, BorderLayout.WEST);
        hobbiesPanel.add(boxPanel, BorderLayout.SOUTH);

        // Add sports label and list
        sportsPanel = new JPanel(new GridLayout(1, 1));
        sportLabel = new JLabel("Sports:");
        sportsList = new JList<>(sports);
        sportsList.setSelectedIndex(2);
        sportsPanel.add(sportLabel);
        sportsPanel.add(sportsList);

        // Add years of experience label and slider
        yearExpPanel = new JPanel(new BorderLayout());
        yearExpLabel = new JLabel("Year of experience in this sport:");
        yearExpSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
        yearExpSlider.setMajorTickSpacing(5);
        yearExpSlider.setMinorTickSpacing(1);
        yearExpSlider.setPaintTicks(true);
        yearExpSlider.setPaintLabels(true);
        yearExpPanel.add(yearExpLabel, BorderLayout.WEST);
        yearExpPanel.add(yearExpSlider, BorderLayout.SOUTH);

        // Add hobbies panel, sports panel and years of experience panel in the midPanel
        midPanel = new JPanel(new BorderLayout());
        midPanel.add(hobbiesPanel, BorderLayout.NORTH);
        midPanel.add(sportsPanel, BorderLayout.CENTER);
        midPanel.add(yearExpPanel, BorderLayout.SOUTH);

        // Add midPanel to the mainPanel
        mainPanel.add(midPanel, BorderLayout.CENTER);
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
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
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