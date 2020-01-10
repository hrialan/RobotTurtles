package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JPanelBackround extends JPanel {
    private String source;

    public JPanelBackround(String source){
        this.source = source;
    }


    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File(this.source));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
