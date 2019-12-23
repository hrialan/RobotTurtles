package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class TwoPlayers {

    int nbJoueurs = 2;

    public TwoPlayers(){
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" 2 joueurs : ");
        System.out.println();
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

        int n = (int)(Math.random() * nbJoueurs);
        System.out.println("Joueur " + (n+1) + " commence ! ");
        System.out.println("Voici le plateau : ");
        System.out.println();
        System.out.println();

        Plateau plateau = new Plateau(this.nbJoueurs);
        plateau.initialisation();
        plateau.set(joueurs[0]);
        plateau.set(joueurs[1]);
        plateau.setJoyau("JV",7,3);
        plateau.display();
        System.out.println();

        while (true) { // il faudra trouver une condition d'arrêt du jeu (arrivé d'un joueur sur le joyau)
            System.out.println("Joueur " + (n+1) + " à ton tour");
            System.out.println("voici ta main : ");
            joueurs[n].printMain();
            System.out.println();
            System.out.println("Tu as trois choix :"+ "\n"
                    + "1 - complète ton programme" +"\n"
            + "2 - Construit un mur" + "\n"
            + "3 - Execute ton programme " + "\n"
            + " A toi de choisir : ");

            int choix = scanner.nextInt();
            while (choix != 1 & choix != 2 & choix != 3){
                System.out.println("choix invalide, recommence :");
                choix = scanner.nextInt();
            }

            switch (choix){
                case 1: //on complète le programme

                    System.out.println("Combien de cartes voulez vous ajouter à votre algorithme ? : ");
                    choix = scanner.nextInt();
                    int carte;
                        for (int i = 0; i < choix; i++) {
                            joueurs[n].printMain();
                            System.out.println((i + 1) + "- Quelle carte voulez vous ajouter ?");
                            carte = scanner.nextInt();

                            joueurs[n].addInstructions(joueurs[n].getMain(carte - 1));
                        }
                    joueurs[n].remplirMain();
                    break;

                case 2://on construit un mur

                    break;

                case 3: // on execute le programme
                    ArrayDeque<Character> file = joueurs[n].creationFile(joueurs[n].getInstructions());
                    plateau.cleanPosition(joueurs[n].position);
                    joueurs[n].deplacement(file);
                    plateau.set(joueurs[n]);
                    break;
            }
            plateau.display();
            n = (n+1)%nbJoueurs ; //on change le joueur à chaque tour
        }

    }
}
