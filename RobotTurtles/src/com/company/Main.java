package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Main
{


    public static void main(String[] args) {
        // write your code here

        Menu menu = new Menu();
        menu.display();

        JFrame f = new JFrame("Robot Turtles");
        f.setSize(3000,1000);
        JPanel plateau = new JPanel();
        plateau.setLocation(100, 100);
        plateau.setSize(100,78);
        plateau.setBackground(Color.CYAN);
        f.add(plateau,BorderLayout.CENTER);

        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C://Users//emmab//Downloads//RobotTurtles-master//RobotTurtles-master//images//images//background.jpeg")))));
       } catch (IOException e) {
            e.printStackTrace();
        }
        f.pack();
        f.setVisible(true);
        plateau.setVisible(true);
    }



    }

