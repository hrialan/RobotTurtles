package com.company;

public class TwoPlayers {

    int nbJoueurs = 2;

    public TwoPlayers(){
    }

    public void play(){

        System.out.println(" 2 joueurs : ");
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

        Plateau plateau = new Plateau(this.nbJoueurs);
        plateau.initialisation();
        plateau.setPosition(joueurs[0]);
        plateau.setPosition(joueurs[1]);
        plateau.display();
    }
}
