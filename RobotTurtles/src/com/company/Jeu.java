package com.company;

import netscape.security.UserTarget;
import sun.jvm.hotspot.types.JBooleanField;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Jeu {//classe principale sur fonctionnement du jeu dont le fonctionnement ne dépend pas vraiment du nombre de joueurs

    int nbJoueurs;
    private ArrayDeque<String> classements;
    public Jeu(){
    }

    public Jeu(int nbJoueurs){
        this.classements = new ArrayDeque<>();
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
            joueurs[1].setPosition(0, 5);//0 1 0 5


        }

        else if(nbJoueurs ==3) {
            positionJoyau = new int[3][2];
            positionJoyau[0][0] = 7;//initialisation de la position des trois joyaux
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
        System.out.println();


        int n = (int)(Math.random() * nbJoueurs); //joueur au hasard


        while (nbJoueurs > 1){


            n = (n+1)%nbJoueurs ; //on change le joueur à chaque tour

            System.out.println("Joueur " + (n+1) + " à votre tour, vous avez la tortue " + joueurs[n].getColor());
            System.out.println();
            System.out.println("voici ta main : ");
            joueurs[n].printMain();
            System.out.println();
            System.out.println("Vous avez quatre choix :"+ "\n"
                    + "1 - complèter votre programme" +"\n"
                    + "2 - Construir un mur" + "\n"
                    + "3 - Executer votre programme " + "\n"
                    + "4 - Passer le tour" + "\n\n"
                    + " A vous de choisir : ");

            int choix = scanner.nextInt();

            while (choix != 1 & choix != 2 & choix != 3 & choix != 4){
                System.out.println("\nchoix invalide, recommence :");
                choix = scanner.nextInt();
            }

            switch (choix){
                case 1: //on complète le programme

                    System.out.println("\nCombien de cartes voulez vous ajouter à votre algorithme ? : (Violette = Droite / Jaune = Gauche)");
                    choix = scanner.nextInt();
                    while (choix<1 || choix>5){
                        System.out.println("Non, choisissez un entier entre 1 et 5 : ");
                        choix = scanner.nextInt();
                    }

                    int carte;
                    for (int i = 0; i < choix; i++) {
                        System.out.println();
                        System.out.println();
                        joueurs[n].showWellMain();
                        System.out.println((i + 1) + "\nQuelle carte voulez vous ajouter ? ");
                        carte = scanner.nextInt();
                        while (carte<1 || carte >joueurs[n].sizeMain()){
                            System.out.println("\nChoisissez un entier entre 1 et " + joueurs[n].sizeMain() + " : ");
                            carte = scanner.nextInt();
                        }
                        joueurs[n].addInstructions(joueurs[n].getMain(carte - 1));
                    }
                    defausserMain(n,scanner,joueurs);
                    joueurs[n].remplirMain();
                    break;



                case 2://on construit un mur
                    System.out.println("\nVoici la liste des obstacles que vous possédez : ");
                    System.out.println();
                    joueurs[n].showWellObstacle();
                    System.out.println("Quel obstacle choisissez vous ? ");
                    int indiceObstacle = scanner.nextInt();

                    while (indiceObstacle < 1  || indiceObstacle > joueurs[n].obstacleSize()){
                        System.out.println("Saisie invvalide : ");
                        indiceObstacle = scanner.nextInt();
                    }

                    Carte obstacle = joueurs[n].removeCarteObstacle(indiceObstacle - 1);

                    System.out.println("Saisissez la ligne sur laquelle placer l'obstacle : ");
                    int ligne = scanner.nextInt();
                    System.out.println("Saisissez maintenant la colonne : ");
                    int colonne = scanner.nextInt();

                    while (! plateau.setObstacle(ligne,colonne,obstacle)){
                        System.out.println("Saisie invalide, recommencez !");
                        System.out.println("Saisissez la ligne sur laquelle placer un mur :");
                        ligne = scanner.nextInt();
                        System.out.println("Saisissez maintenant la colonne :");
                        colonne = scanner.nextInt();
                    }

                    break;

                case 3: // on execute le programme
                    ArrayDeque<Character> file = joueurs[n].creationFile(joueurs[n].getInstructions());
                    System.out.println("\ninstructions : " + file);

                    plateau.cleanPosition(joueurs[n].position);
                    joueurs[n].deplacement(file,plateau);
                    plateau.set(joueurs[n]);
                    break;

                case 4:// on passe le tour et on demande si on defausse
                    defausserMain(n,scanner,joueurs);
                    joueurs[n].remplirMain();
                    break;
            }
            plateau.display();
            System.out.println();
            System.out.println();

            if(isFinish(positionJoyau,joueurs[n])){
                classements.add(joueurs[n].color);
                nbJoueurs -= 1;
            }
        }

        System.out.println("\n \nLa partie est terminée ! Bravo \n"+
                "Voici le classement : ");
        int i = 0;
        for (String elt : classements){
            i ++ ;
            System.out.println("N° "+ i + " : " + elt);
        }

    }


    public void defausserMain(int n, Scanner scanner, Joueur[] joueurs){
        System.out.println("\nSouhaitez vous defausser vos cartes ? (oui : 1 - non : 0)");
        int choix = scanner.nextInt();
        while (choix<0 || choix>1){
            System.out.println("\nChoisissez soit 0 (non) soit 1 (oui) :  ");
            choix = scanner.nextInt();
        }

        if(choix == 1){
            System.out.println("\nMain : ");
            joueurs[n].showWellMain();
            System.out.println("\nCombien de cartes souhaitez vous defausser ? ");
            choix = scanner.nextInt();

            while (choix < 1 || choix > joueurs[n].sizeMain()){
                System.out.println("Saisie incorrecte (entier entre 1 et " + joueurs[n].sizeMain() +") : ");
                choix = scanner.nextInt();
            }
            if(choix == joueurs[n].sizeMain()){
                joueurs[n].deleteMain();
            }
            else {
                for (int i = 0; i < choix ; i ++){
                    System.out.println();
                    joueurs[n].showWellMain();
                    System.out.println();
                    System.out.println("Quelle carte voulez vous retirer ? ");
                    int indiceCarte= scanner.nextInt();
                    while (indiceCarte < 1 || indiceCarte > joueurs[n].sizeMain()){
                        System.out.println();
                        System.out.println("Saisie incorrecte (entier entre 1 et " + joueurs[n].sizeMain() +") : ");
                        indiceCarte = scanner.nextInt();
                    }
                    joueurs[n].getMain(indiceCarte - 1);
                }
            }
        }
    }

    public boolean isFinish(int[][] positionJoyau, Joueur joueur){
        for(int[] elt : positionJoyau){

        if(joueur.position[0] == elt[0] && joueur.position[1] == elt[1]){
            return true;
        }

        }

        return false;
    }

}
