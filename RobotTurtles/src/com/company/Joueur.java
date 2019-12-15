package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Joueur extends Tortue{


    private Deck deck;
    private Obstacle obstacle;
    private ArrayDeque<Carte> main;



    public Joueur(){
        this.deck = new Deck();
        this.obstacle = new Obstacle();
        this.main = new ArrayDeque<>();
    }


    public String getLastCard(){
        return deck.getLastCard().getName();
    }

    public ArrayDeque<String> creationFile(ArrayDeque<Carte> main){
        ArrayDeque<String> file = new ArrayDeque<>();
        /*
        Déclarer une nouvelle file ;
— Demander à l’utilisateur de saisir une instruction parmi les trois suivantes :
— “A” pour avancer ;
— “G” pour faire un quart de tour vers la gauche ; — “D” pour faire un quart de tour vers la droite.
— Si la saisie est valide, on l’ajoute en fin de file;
— Répéter cette saisie tant qu’elle est incorrecte ou que la taille de la file est différente
de 5.
— Retourner la file.
         */
        return file;
    }


    public void deplacement(ArrayDeque<String> instructions){
        int x=-1;
        int y=-1;
        char direction=' ';
/*
rendre en paramètre la file d’instructions retournée par la fonction creationFile() ;
— En suivant le principe FIFO d’une file, mettre à jour les variables globales position
et direction.
— Attention, si une instruction fait sortir le pion du plateau, alors celle-ci est retirée de
la file sans être prise en compte.

 */

changePosition(x,y);
changeDirection(direction);
    }



}

