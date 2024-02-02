/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 02/02/2024
 */

package chanthakorn.naphat.lab8;

import java.awt.*;
import javax.swing.*;

public class PlayerFormV4 extends PlayerFormV3 {
    protected JLabel hobbiesLabel, sportLabel, yearExpLabel;
    protected JCheckBox readBox, browBox, sleepBox, travelBox;
    protected JList<String> sportsList;
    protected String[] sports = { "Badminton", "Boxing", "Football", "Running" };
    protected JPanel midPanel, hobbiesPanel, sportsPanel, yearExpPanel, boxPanel;
    protected JSlider yearExpSlider;

    public PlayerFormV4(String title) {
        super(title);
    }

    public void addComponents() {
        super.addComponents();

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

        sportsPanel = new JPanel(new GridLayout(1, 1));
        sportLabel = new JLabel("Sports:");
        sportsList = new JList<>(sports);
        sportsList.setSelectedIndex(2);
        sportsPanel.add(sportLabel);
        sportsPanel.add(sportsList);

        yearExpPanel = new JPanel(new BorderLayout());
        yearExpLabel = new JLabel("Year of experience in this sport:");
        yearExpSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
        yearExpSlider.setMajorTickSpacing(5);
        yearExpSlider.setMinorTickSpacing(1);
        yearExpSlider.setPaintTicks(true);
        yearExpSlider.setPaintLabels(true);
        yearExpPanel.add(yearExpLabel, BorderLayout.WEST);
        yearExpPanel.add(yearExpSlider, BorderLayout.SOUTH);

        midPanel = new JPanel(new BorderLayout());
        midPanel.add(hobbiesPanel, BorderLayout.NORTH);
        midPanel.add(sportsPanel, BorderLayout.CENTER);
        midPanel.add(yearExpPanel, BorderLayout.SOUTH);

        mainPanel.add(midPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
