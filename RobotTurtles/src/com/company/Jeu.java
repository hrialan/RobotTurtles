package com.company;

import sun.jvm.hotspot.types.JBooleanField;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Jeu {//classe principale sur fonctionnement du jeu dont le fonctionnement ne dépend pas vraiment du nombre de joueurs

    Plateau plateau;
    Joueur[] joueurs;
    int nbJoueurs;

    public Jeu(){
    }

    public Jeu(int nbJoueurs){
        this.nbJoueurs = nbJoueurs;
    }

    public void deroulement(){

        Scanner scanner = new Scanner(System.in);


        Plateau plateau = new Plateau(this.nbJoueurs);
        plateau.initialisation();

        System.out.println( nbJoueurs +" joueurs : ");
        System.out.println();

        Joueur[] joueurs = new Joueur[nbJoueurs]; //création des joueurs

        String[] couleursTortues = {"R", "V","O","B"};

        for (int i = 0; i < nbJoueurs; i++) { //création des joueurs et association avec les couleurs des tortues
            Joueur joueur = new Joueur();
            joueur.setColor(couleursTortues[i]);
            joueur.setDirection('S');
            joueurs[i] = joueur;//on rentre les joueurs dans la liste de joueurs
        }

        int[][] positionJoyau;

        if(nbJoueurs ==2) {
            positionJoyau = new int[1][2];
            positionJoyau[0][0] = 7;
            positionJoyau[0][1] = 3;
            plateau.setJoyau(positionJoyau);

            joueurs[0].setPosition(0, 1);//initialisation des positions en fonction du joueur
            joueurs[1].setPosition(0, 5);

        }

        else if(nbJoueurs ==3) {
            positionJoyau = new int[3][2];
            positionJoyau[0][0] = 7;
            positionJoyau[0][1] = 0;
            positionJoyau[1][0] = 7;
            positionJoyau[1][1] = 3;
            positionJoyau[2][0] = 7;
            positionJoyau[2][1] = 6;
            plateau.setJoyau(positionJoyau);

            joueurs[0].setPosition(0, 0);
            joueurs[1].setPosition(0, 3);
            joueurs[2].setPosition(0, 6);
        }

        else {
            positionJoyau = new int[2][2];
            positionJoyau[0][0] = 7;
            positionJoyau[0][1] = 1;
            positionJoyau[1][0] = 7;
            positionJoyau[1][1] = 6;
            plateau.setJoyau(positionJoyau);

            joueurs[0].setPosition(0, 0);
            joueurs[1].setPosition(0, 2);
            joueurs[2].setPosition(0, 5);
            joueurs[3].setPosition(0, 7);
        }


        for(Joueur joueur : joueurs){ // on remplit la main
            joueur.remplirMain();
            plateau.set(joueur);
        }


        System.out.println("Voici le plateau : ");
        System.out.println();
        System.out.println();

        plateau.display();
        System.out.println();


        int n = (int)(Math.random() * nbJoueurs); //joueur au hasard


        while (isFinish(positionJoyau,joueurs[n])) { //is finish


            System.out.println("Joueur " + (n+1) + " à ton tour, tu as la tortue " + joueurs[n].getColor());
            System.out.println();
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
                        System.out.println((i + 1) + "- Quelle carte voulez vous ajouter ? (Violette = Droite / Jaune = Gauche");
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
                    System.out.println("Saisissez la ligne sur laquelle placer un mur :");
                    int ligne = scanner.nextInt();
                    System.out.println("Saisissez maintenant la colonne :");
                    int colonne = scanner.nextInt();

                    while (! plateau.setWall(ligne,colonne)){
                        System.out.println("Saisie invalide, recommencez !");
                        System.out.println("Saisissez la ligne sur laquelle placer un mur :");
                        ligne = scanner.nextInt();
                        System.out.println("Saisissez maintenant la colonne :");
                        colonne = scanner.nextInt();
                    }

                    break;

                case 3: // on execute le programme
                    ArrayDeque<Character> file = joueurs[n].creationFile(joueurs[n].getInstructions());
                    System.out.println(file);

                    plateau.cleanPosition(joueurs[n].position);
                    joueurs[n].deplacement(file,plateau);
                    plateau.set(joueurs[n]);
                    break;

            }

            plateau.display();
            n = (n+1)%nbJoueurs ; //on change le joueur à chaque tour
        }
    }



    public boolean isFinish(int[][] positionJoyau, Joueur joueur){
        for(int[] elt : positionJoyau){
        if(joueur.position == elt){
            System.out.println("Joueur " + joueur.getColor() + " vous avez gagné, BRAVO !!");
            return false;
        }
        }

        return true;
    }

}
