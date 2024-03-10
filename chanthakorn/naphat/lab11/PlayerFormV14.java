package chanthakorn.naphat.lab11;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class PlayerFormV14 extends PlayerFormV13 {
    protected JMenu fillMenu;
    protected JRadioButtonMenuItem yesItem, noItem;
    protected ButtonGroup fillGroup;
    protected String filename;
    protected Player player, readPlayer;

    public PlayerFormV14(String title) {
        super(title);
    }
    
    // Method to add other components in menu
    @Override
    public void addMenus() {
        super.addMenus();
        fillMenu = new JMenu("Fill");
        yesItem = new JRadioButtonMenuItem("Yes");
        noItem = new JRadioButtonMenuItem("No", true);
        fillGroup = new ButtonGroup();

        fillGroup.add(yesItem);
        fillGroup.add(noItem);
        fillMenu.add(yesItem);
        fillMenu.add(noItem);
        menuBar.add(fillMenu);
    }

    // Method to handle saveing file menu item
    @Override
    public void handleSaveMenu() {
        if (noItem.isSelected()) {
            // Save data without filling form
            super.handleSaveMenu();
        } else {
            fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(this);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileOutputStream fileOut = new FileOutputStream(file);
                        ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    saveFormDataObject(); // Save form data to Player object
                    out.writeObject(player); // Write Player object to file
                    JOptionPane.showMessageDialog(this, "Saving in file " + file.getPath());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error in save file.");
                }
            }
        }
    }

    // Method to handle opening file menu item
    @Override
    public void handleOPenMenu() {
        if (yesItem.isSelected()) {
            fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileInputStream fileIn = new FileInputStream(file);
                        ObjectInputStream in = new ObjectInputStream(fileIn)) {
                    readPlayer = (Player) in.readObject(); // Read the player object from file
                    in.close();
                    JOptionPane.showMessageDialog(this, "Opening file " + file.getPath());

                    // Set form data from the readPlayer object
                    nameTxtField.setText(readPlayer.getName());
                    nationalityTxtField.setText(readPlayer.getNationality());
                    birthTxtField.setText(readPlayer.getDob());
                    yearExpSlider.getValue();
                    if (readPlayer.getGender().equals("Male")) {
                        maleRadioButton.setSelected(true);
                    } else {
                        femaleRadioButton.setSelected(true);
                    }
                    playerTypeBox.setSelectedItem(readPlayer.getPlayerType());
                    yearExpSlider.setValue(readPlayer.getYear());
                    ArrayList<String> hobbies = readPlayer.getHobby();
                    if (hobbies != null) {
                        for (String hobby : hobbies) {
                            switch (hobby) {
                                case "Read":
                                    readBox.setSelected(true);
                                    break;
                                case "Browsing":
                                    browBox.setSelected(true);
                                    break;
                                case "Sleeping":
                                    sleepBox.setSelected(true);
                                    break;
                                case "Traveling":
                                    travelBox.setSelected(true);
                                    break;
                            }
                        }
                    }
                    ArrayList<String> sports = readPlayer.getSport();
                    if (sports != null) {
                        for (String sport : sports) {
                            sportsList.setSelectedValue(sport, true);
                        }
                    }
                    JOptionPane.showMessageDialog(this,
                            "Data read from file " + file.getPath() + " is \n" + getPlayerData());
                } catch (IOException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Error in open file.");
                }
            }
        } else {
            super.handleOPenMenu();
        }
    }

    // Method to save form data into the player object
    protected void saveFormDataObject() {
        String name = nameTxtField.getText();
        String nationality = nationalityTxtField.getText();
        String dob = birthTxtField.getText();
        String gender = maleRadioButton.isSelected() ? "Female" : "male";
        String playerType = playerTypeBox.getSelectedItem().toString();
        int year = yearExpSlider.getValue();
        ArrayList<String> hobby = new ArrayList<>();
        ArrayList<String> sport = new ArrayList<>();
        sport.addAll(sportsList.getSelectedValuesList());

        if (readBox.isSelected()) {
            hobby.add(readBox.getText());
        }
        if (browBox.isSelected()) {
            hobby.add(browBox.getText());
        }
        if (sleepBox.isSelected()) {
            hobby.add(sleepBox.getText());
        }
        if (travelBox.isSelected()) {
            hobby.add(travelBox.getText());
        }

        player = new Player(name, nationality, dob, playerType, gender, hobby, sport, year);
    }

    public static void createAndShowGUI() {
        PlayerFormV14 msw = new PlayerFormV14("Player Form V14");
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