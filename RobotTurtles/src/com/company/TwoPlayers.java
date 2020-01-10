package com.company;

import javax.swing.*;
import java.awt.*;

public class TwoPlayers extends JFrame{

    private PlateauJPanel pan = new PlateauJPanel();

    public TwoPlayers(){
        this.setTitle("Plateau");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pan);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim.width/2, dim.width/2);
        this.setLocation(0,0);
        this.setResizable(false);

        this.setLayout(new GridLayout(8, 8));

        this.setVisible(true);
    }


    public void play(){
        // à mettre algorithme du jeu
    }
}
