package chanthakorn.naphat.lab8;

import javax.swing.*;

public class PlayerFormV4 extends PlayerFormV3 {
    protected JLabel hobbiesLabel, sportLabel, yearExperLabel;
    protected JCheckBox readBox, browBox, sleepBox, travelBox;
    protected JList sportsList;
    protected String[] sports = {"badmintonList", "boxingList", "footballList", "runningList"};
    protected JPanel 

    public PlayerFormV4(String title) {
        super(title);
    }

    public void addComponents() {
        super.addComponents();
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
