package com.company;

import java.util.Scanner;

public class ThreePlayers {

    int nbJoueurs = 3;

    public ThreePlayers() {
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" 3 joueurs : ");
        System.out.println();

        Joueur[] joueurs = new Joueur[nbJoueurs]; //création des joueurs

        String[] couleursTortues = {"R", "V","O"};

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

        Plateau plateau = new Plateau(this.nbJoueurs);
        plateau.initialisation();
        plateau.set(joueurs[0]);
        plateau.set(joueurs[1]);

        plateau.display();
        System.out.println();

        Jeu jeu = new Jeu(joueurs,plateau);
        jeu.deroulement();

    }
}
