package chanthakorn.naphat.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayerFormV10 extends PlayerFormV9 {
    public PlayerFormV10(String title) {
        super(title);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        newMI.addActionListener(this);
        openMI.addActionListener(this);
        saveMI.addActionListener(this);
        exitMI.addActionListener(this);
        redMI.addActionListener(this);
        greenMI.addActionListener(this);
        blueMI.addActionListener(this);
        size16MI.addActionListener(this);
        size20MI.addActionListener(this);
        size24MI.addActionListener(this);
    }

    private void changeFontColor(Color color) {
        nameTxtField.setForeground(color);
        nationalityTxtField.setForeground(color);
        birthTxtField.setForeground(color);
    }

    private void changeFontSize(int size) {
        Font font = new Font("Serif", Font.BOLD, size);
        noteTxtArea.setFont(font);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JMenuItem source = (JMenuItem) e.getSource();

        if (source == redMI) {
            changeFontColor(Color.RED);
        } else if (source == greenMI) {
            changeFontColor(Color.GREEN);
        } else if (source == blueMI) {
            changeFontColor(Color.BLUE);
        } else if (source == size16MI) {
            changeFontSize(16);
        } else if (source == size20MI) {
            changeFontSize(20);
        } else if (source == size24MI) {
            changeFontSize(24);
        } else if (source == newMI) {
            JOptionPane.showMessageDialog(this, "You click menu New");
        } else if (source == openMI) {
            JOptionPane.showMessageDialog(this, "You click menu Open");
        } else if (source == saveMI) {
            JOptionPane.showMessageDialog(this, "You click menu Save");
        } else if (source == exitMI) {
            System.exit(0);
        }
    }

    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
        msw.addListeners();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}