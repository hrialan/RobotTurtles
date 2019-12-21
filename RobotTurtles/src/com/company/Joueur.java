package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Joueur extends Tortue{


    private Deck deck;
    private Obstacle obstacle;
    private ArrayList<Carte> main;
    private ArrayDeque<Carte> instructions;


    public Joueur(){
        super();
        this.deck = new Deck();
        this.obstacle = new Obstacle();
        this.main = new ArrayList<>();
        this.instructions = new ArrayDeque<>();
    }


    public int sizeMain(){
        return main.size();
    }

    public void addMain(Carte carte){
        main.add(carte);
    }

    public Carte getLastCard(){return deck.getLastCard();}


    public ArrayDeque<Character> creationFile(ArrayDeque<Carte> instructions){ //simplification de la pile instruction avec des caractères
        ArrayDeque<Character> file = new ArrayDeque<>();
        Carte carte;
        while (instructions.size() > 0){
            carte = instructions.getLast();

            switch (carte.getName()){
                case "Bleue" :
                    file.addFirst('A');//avancer
                    break;
                case "Jaune" :
                    file.addFirst('G');//tourner à gauche
                    break;
                case "Violette" :
                    file.addFirst('D');//tourner à droite
                    break;
                case "Laser" :
                    file.addFirst('L');//laser
                    break;
            }
            instructions.remove(carte);
        }
        return file;
    }


    public void deplacement(ArrayDeque<Character> file){ //prend en paramètre la file d’instructions retournée par la fonction creationFile()
        while (file.size() > 0){
            setPositionDirection(file.getLast());
            file.removeLast();
        }
    }
}

