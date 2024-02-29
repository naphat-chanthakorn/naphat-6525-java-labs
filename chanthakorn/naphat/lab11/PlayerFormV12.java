/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 22/02/2024
*/

package chanthakorn.naphat.lab11;

import javax.swing.*;
import java.awt.*;
import chanthakorn.naphat.lab10.PlayerFormV11;

public class PlayerFormV12 extends PlayerFormV11 {
    public PlayerFormV12(String title) {
        super(title);
    }

    public void handlerNameTxtField(ActionEvent e) {
        String newName = nameTxtField.getText().trim(); // Get the text from the Name field and trim leading/trailing whitespace
        if (newName.isEmpty()) {
            // Show dialog if the name is empty
            JOptionPane.showMessageDialog(this, "Please enter some data in Name");
            nameTxtField.requestFocusInWindow(); // Set focus on the text field Name
            nextComponent.setEnabled(false); // Disable the next component
        } else {
            // Show dialog if the name is not empty
            keyPressed(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        handlerNameTxtField(e);
    }

    public void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        PlayerFormV12 msw = new PlayerFormV12("Player Form V12");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
        msw.addListeners();
        msw.enableKeyboard();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}