/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 02/02/2024
*/

package chanthakorn.naphat.lab8;

import java.awt.*;
import javax.swing.*;

public class PlayerFormV5 extends PlayerFormV4 {
    protected ReadImage imagePanel;

    public PlayerFormV5(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        addImagePanel();
    }

    private void addImagePanel() {
        imagePanel = new ReadImage("Image/Football.jpg");
        bottomPanel.add(imagePanel, BorderLayout.CENTER);
    }

    public void addIcon() {
        ImageIcon newImageIcon = new ImageIcon("Image/New-icon.png");
        ImageIcon openImgIcon = new ImageIcon("Image/Open-icon.png");
        ImageIcon saveImgIcon = new ImageIcon("Image/Save-icon.png");

        newMI.setIcon(newImageIcon);
        openMI.setIcon(openImgIcon);
        saveMI.setIcon(saveImgIcon);
    }

    @Override
    public void addMenus() {
        super.addMenus();
        addIcon();
    }

    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");
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