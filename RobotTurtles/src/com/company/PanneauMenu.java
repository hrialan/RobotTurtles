package com.company;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class PanneauMenu extends JPanel {
    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("images.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
