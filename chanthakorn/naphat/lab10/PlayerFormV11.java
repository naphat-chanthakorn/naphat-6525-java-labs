package chanthakorn.naphat.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayerFormV11 extends PlayerFormV10 {
    protected JMenuItem customMI;
    protected JColorChooser colorChooser;

    public PlayerFormV11(String title) {
        super(title);
    }

    @Override
    public void addMenus() {
        super.addMenus();
        customMI = new JMenuItem("Custom");
        colorMenu.add(customMI);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        customMI.addActionListener(this);
    }

    public void ColorChooser() {
        colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(this);
        Color newColor = JColorChooser.showDialog(this, "Choose Text Color", Color.BLACK);

        nameTxtField.setForeground(newColor);
        nationalityTxtField.setForeground(newColor);
        birthTxtField.setForeground(newColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JMenuItem source = (JMenuItem) e.getSource();

        if (source == customMI) {
            ColorChooser();
        } else if (source == openMI) {
        } else if (source == saveMI) {
        }
    }

    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11");
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