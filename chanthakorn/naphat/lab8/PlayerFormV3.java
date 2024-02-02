/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 02/02/2024
 */

package chanthakorn.naphat.lab8;

import javax.swing.*;
import chanthakorn.naphat.lab7.PlayerFormV2;

public class PlayerFormV3 extends PlayerFormV2 {
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, colorMenu, sizMenu;
    protected JMenuItem newMI, openMI, saveMI, exitMI, redMI, greenMI, blueMI, size16MI, size20MI, size24MI;

    public PlayerFormV3(String title) {
        super(title);
    }

    public void addComponents() {
        super.addComponents();
    }

    public void addMenus() {
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        newMI = new JMenuItem("New");
        openMI = new JMenuItem("Open");
        saveMI = new JMenuItem("Save");
        exitMI = new JMenuItem("Exit");
        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);
        fileMenu.add(exitMI);
        menuBar.add(fileMenu);

        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        redMI = new JMenuItem("Red");
        greenMI = new JMenuItem("Green");
        blueMI = new JMenuItem("Blue");
        sizMenu = new JMenu("Size");
        size16MI = new JMenuItem("16");
        size20MI = new JMenuItem("20");
        size24MI = new JMenuItem("24");
        colorMenu.add(redMI);
        colorMenu.add(greenMI);
        colorMenu.add(blueMI);
        configMenu.add(colorMenu);
        sizMenu.add(size16MI);
        sizMenu.add(size20MI);
        sizMenu.add(size24MI);
        configMenu.add(sizMenu);
        menuBar.add(configMenu);

        setJMenuBar(menuBar);
    }

    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
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