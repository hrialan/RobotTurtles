package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Jeu {//classe principale sur fonctionnement du jeu dont le fonctionnement ne dépend pas vraiment du nombre de joueurs

    Plateau plateau ;
    Joueur[] joueurs;
    int nbJoueurs;

    public Jeu(){
    }

    public Jeu(int nbJoueurs){
        this.nbJoueurs = nbJoueurs;
        this.joueurs = new Joueur[nbJoueurs];
        this.plateau = new Plateau(nbJoueurs);
        this.plateau.initialisation();
        this.deroulement();
    }

    public void deroulement(){

        PlateauAffichage fen = new PlateauAffichage(plateau);

        Scanner scanner = new Scanner(System.in);
        int n = (int)(Math.random() * nbJoueurs);


        String[] couleursTortues = {"Rouge", "Vert"};

        for (int i = 0; i < nbJoueurs; i++) { //création des joueurs et association avec les couleurs des tortues
            Joueur joueur = new Joueur();
            joueur.setColor(couleursTortues[i]);
            joueur.setDirection('S');

            joueurs[i] = joueur;//on rentre les joueurs dans la liste de joueurs
        }

        for(Joueur joueur : joueurs){ // on remplit la main
            joueur.remplirMain();


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
                    while (choix<1 || choix>5){
                        System.out.println("Choisissez un entier entre 1 et 5 : ");
                        choix = scanner.nextInt();
                    }
                    int carte;
                    for (int i = 0; i < choix; i++) {
                        joueurs[n].printMain();
                        System.out.println((i + 1) + "- Quelle carte voulez vous ajouter ?");
                        carte = scanner.nextInt();
                        while (carte<1 || carte >joueurs[n].sizeMain()){
                            System.out.println("Choisissez un entier entre 1 et " + joueurs[n].sizeMain() + " : ");
                            carte = scanner.nextInt();
                        }

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

            n = (n+1)%nbJoueurs ; //on change le joueur à chaque tour
           }
    }}}


