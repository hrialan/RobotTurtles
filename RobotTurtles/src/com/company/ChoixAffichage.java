package com.company;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

public class ChoixAffichage extends JFrame {

    private PlateauJPanel pan = new PlateauJPanel();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Joueur joueur;

    public ChoixAffichage(Joueur joueur) {
        this.joueur = new Joueur();
        this.setTitle("Choix");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(dim.width / 2 - 20, dim.width / 2 ); // on enlève 20 a width car cela correspond à la taille en pixel du bandeau
        this.setLocation(0, 0);
        this.setResizable(false);
        this.setContentPane(pan);
        this.setVisible(true);
    }


    public class PlateauJPanel extends JPanel {

        public void paintComponent(Graphics g) {


        }
    }
}
