package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu { //Dans cette classe, on choisit le nombre de joueur et quand on démarre le jeu


    private int nbJoueurs ;


    public Menu(){
    }

    public int getNbJoueurs(){
        return nbJoueurs;
    }



    public void display(){ //affiche le menu
        JFrame fenetre = new JFrame();
        JPanel pan = new JPanel();

        fenetre.setTitle("Ma première fenêtre Java");
        fenetre.setSize(400, 500);
        fenetre.setLocation(50,200);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.setContentPane(pan);
        fenetre.setVisible(true);

        int choix = - 1;

        switch (choix){
            case 2:
                TwoPlayers twoPlayers = new TwoPlayers();
                twoPlayers.play();
                break;

            case 3:
                ThreePlayers threePlayers = new ThreePlayers();
                threePlayers.play();
                break;

            case 4:
                FourPlayers fourPlayers = new FourPlayers();
                fourPlayers.play();
                break;
        }

    }

}
