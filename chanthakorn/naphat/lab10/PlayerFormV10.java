package chanthakorn.naphat.lab10;

import javax.swing.*;

public class PlayerFormV10 extends PlayerFormV9 {
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
