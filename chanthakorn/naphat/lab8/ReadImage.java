/*
 * The Author: Naphat Chanthakorn
 * Student ID: 663040652-5
 * Sec: 2
 * Date: 15/02/2024
*/

package chanthakorn.naphat.lab8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

// ReadImage class extends JPanel and is used to display an image
public class ReadImage extends JPanel {
    BufferedImage image;
    String filename = "Image/Football.jpg";

    // Override the paintComponent method to paint the image on the panel
    @Override
    protected void paintComponent(Graphics g) {
        // Calculate the position to center the image on the panel
        int x = (getWidth() - image.getWidth()) / 2;
        int y = (getHeight() - image.getHeight()) / 2;
        // Draw the image on the panel
        g.drawImage(image, x, y, this);
    }

    // Constructor to initialize the ReadImage object with the image file
    public ReadImage(String filename) {
        try {
            // Read the image from the file
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            // Print stack trace if there's an error reading the image
            e.printStackTrace(System.err);
        }
    }

    // Override the getPreferredSize method to return the preferred size of the
    // panel
    @Override
    public Dimension getPreferredSize() {
        if (image != null) {
            // If the image is not null, return its dimensions as the preferred size
            return new Dimension(image.getWidth(), image.getHeight());
        } else {
            // Else the image is null, return the default preferred size of the panel
            return super.getPreferredSize();
        }
    }
}