package com.company;


import javax.swing.*;
import java.awt.*;

public class TwoPlayers{

    private JFrame fenetrePlateau = new JFrame();

    public TwoPlayers(){
    }

    public void play(){
        int nbJoueurs = 2;

        fenetrePlateau.setTitle("Plateau");
        fenetrePlateau.setSize(400, 500);
        fenetrePlateau.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fenetrePlateau.setSize(dim.width/2, dim.height);
        fenetrePlateau.setLocation(0,0);
        fenetrePlateau.setResizable(false);
        fenetrePlateau.setVisible(true);

        Joueur[] joueurs = new Joueur[nbJoueurs];
        String[] couleursTortues = {"Rouge", "Vert"};

        for (int i = 0; i < nbJoueurs; i++) { //création des joueurs et association avec les couleurs des tortues
            Joueur joueur = new Joueur();
            joueur.setColor(couleursTortues[i]);
            joueur.setDirection('S');

            joueurs[i] = joueur;//on rentre les joueurs dans la liste de joueurs
        }

        joueurs[0].setPosition(0,1);//initialisation des positions en fonction du joueur
        joueurs[1].setPosition(0,5);


        for(Joueur joueur : joueurs){ // on remplit la main
            joueur.remplirMain();
        }


        System.out.println("Voici le plateau : ");
        System.out.println();
        System.out.println();

        Plateau plateau = new Plateau(nbJoueurs);
        plateau.initialisation();
        plateau.set(joueurs[0]);
        plateau.set(joueurs[1]);
        plateau.setJoyau("JV",7,3);
        plateau.display();
        System.out.println();

        Jeu jeu = new Jeu(joueurs,plateau);
        jeu.deroulement();

    }
}
