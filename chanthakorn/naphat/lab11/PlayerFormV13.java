package chanthakorn.naphat.lab11;

import java.io.*;
import javax.swing.*;

public class PlayerFormV13 extends PlayerFormV12 {

    public PlayerFormV13(String title) {
        super(title);
    }

    public String getPlayerData() {
        StringBuilder data = new StringBuilder();
        data.append(nameTxtField.getText()).append(" has nationality as ")
                .append(nationalityTxtField.getText()).append(" and was born on ")
                .append(birthTxtField.getText()).append(", has gender as ")
                .append(maleRadioButton.isSelected() ? "Male" : "Female").append(", is a ")
                .append((String) playerTypeBox.getSelectedItem()).append(" player, has hobbies as ")
                .append(hobbies).append(" and plays [").append(sports)
                .append("]");
        return data.toString();
    }

    @Override
    public void handleSaveMenu() {
        fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                String data = getPlayerData();
                writer.write(data);
                JOptionPane.showMessageDialog(this, "Saving in file " + file.getPath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error in save file.");
            }
        }
    }

    @Override
    public void handleOPenMenu() {
        fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder fileData = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    fileData.append(line).append("\n");
                }
                JOptionPane.showMessageDialog(this, "Opening file " + file.getPath());
                JOptionPane.showMessageDialog(this, "Data read from file " + file.getPath() + " is \n" + fileData);
            } catch (IOException e) {
                System.err.println("Error in open file");
            }
        }
    }
    
    // Method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV13 msw = new PlayerFormV13("Player Form V13");
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