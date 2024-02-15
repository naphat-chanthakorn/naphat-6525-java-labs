package chanthakorn.naphat.lab8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ReadImage extends JPanel {
    BufferedImage image;
    String filename = "Image/Football.jpg";

    @Override
    protected void paintComponent(Graphics g) {
        int x = (getWidth() - image.getWidth()) / 2;
        int y = (getHeight() - image.getHeight()) / 2;
        g.drawImage(image, x, y, this);
    }

    public ReadImage(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (image != null) {
            return new Dimension(image.getWidth(), image.getHeight());
        } else {
            return super.getPreferredSize();
        }
    }
}