package com.company;

public class Jeu{ // en fonction du nombre de joueur saisi dans la classe Menu, la classe jeu démarre l'algorithme de jeu correcte

    private int nbJoueurs;

    public Jeu(int nbJoueurs){
        this.nbJoueurs = nbJoueurs;
    }

    public void play() { //renvoie à la bonne fonction en prenant en compte le nombre de joueur
        switch (nbJoueurs) {
            case 2:
                twoPlayers();

                break;

            case 3:
                treePlayers();
                break;

            case 4:
                fourPlayers();
                break;
        }
    }


    public void twoPlayers(){ //algorthme principal du jeu pour deux joueurs
        System.out.println(" 2 joueurs");

        Plateau plateau = new Plateau();
        plateau.initialisation2Joueur();
        plateau.display();

        Joueur[] joueurs = new Joueur[nbJoueurs];

        for(int i = 0; i<nbJoueurs; i++){
            Joueur joueur = new Joueur();
            joueurs[i] = joueur;
        }

        }

    public void treePlayers(){ //algorthme principal du jeu pour trois joueurs
        System.out.println(" 3 joueurs");
        Plateau plateau = new Plateau();
        plateau.initialisation3Joueur();
        plateau.display();
        }

    public void fourPlayers(){ //algorthme principal du jeu pour quatre joueurs
        System.out.println(" 4 joueurs");
        Plateau plateau = new Plateau();
        plateau.initialisation4Joueur();
        plateau.display();
        }






}
