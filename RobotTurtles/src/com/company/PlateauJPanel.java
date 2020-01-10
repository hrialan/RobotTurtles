package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlateauJPanel extends JPanel {
    public void paintComponent(Graphics g){
        //x1, y1, x2, y2
        try {
            Image img = ImageIO.read(new File("images/PlateauBackground.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


        for(int i =0; i<8;i++) {
            g.drawLine(i*(dim.width / 16), 0, i*(dim.width / 16), dim.width);
            g.drawLine(0, i* ((dim.width-30)/ 16), dim.width, i*((dim.width-30)/ 16));
        }
    }
}
