package com.company;

import java.util.Scanner;

public class Menu { //Dans cette classe, on choisit le nombre de joueur et quand on démarre le jeu


    private int nbJoueurs ;

    public Menu(){
    }

    public int getNbJoueurs(){
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs){this.nbJoueurs = nbJoueurs;}


    public void display(){ //affiche le menu
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour et bienvenue dans le jeu Robot Turtles ! \n" +
                "\n" +
                "Saississez le nombre de joueur (entre 2 et 4) : ");

        int choix = scanner.nextInt();

        while(choix != 2 & choix != 3 & choix != 4){ //detection des erreurs d'entrées utilisateur
            System.out.println("Saissisez un nombre de joueur valide (entre 2 et 4) : ");
            choix = scanner.nextInt();
        }

        Jeu jeu = new Jeu(choix);
        jeu.play();


    }

}