package chanthakorn.naphat.lab10;

import java.io.File;

import javax.swing.*;
import javax.swing.event.*;

public class PlayerFormV10 extends PlayerFormV9 {
    protected JFileChooser fileChooser;

    public PlayerFormV10(String title) {
        super(title);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        newMI.addItemListener(this); 
        openMI.addItemListener(this); 
        saveMI.addItemListener(this); 
        exitMI.addItemListener(this); 
        redMI.addItemListener(this); 
        greenMI.addItemListener(this); 
        blueMI.addItemListener(this); 
        size16MI.addItemListener(this); 
        size20MI.addItemListener(this); 
        size24MI.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        fileChooser = new JFileChooser();
        if(src == saveMI){
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filename = file.getName();
                JOptionPane.showMessageDialog(this, 
                            "Save : " + filename);
            }
        } else if(src == newMI){
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filename = file.getName();
                JOptionPane.showMessageDialog(this, 
                            "Open : " + filename);
            }
        } else if (src == exitMI){
            System.exit(1);
        } else if (src == blueText){

        } else if (src == customColor){
            Color newColor = JColorChooser.showDialog(this,"Color : ", ta.getForeground()); // Default to current text color
            if (newColor != null) {
                ta.setForeground(newColor);
            }
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
