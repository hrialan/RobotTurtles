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


    public Carte getLastCard(){return deck.getLastCard();}
    public void addInstructions(Carte carte){instructions.addLast(carte);};
    public Carte getMain(int indice){
        return main.remove(indice);
    }
    public void deleteMain(){
        for(int i = sizeMain()-1;i >= 0 ;i--) {
            main.remove(i);
        }
    }

    public ArrayDeque<Carte> getInstructions(){return this.instructions;}

    public void printMain(){//sur une ligne
        for (Carte carte : main){
            System.out.print(carte.getName() + " ");
        }
        System.out.println();
    }
    public void showWellMain(){
        int i = 0;
        for (Carte carte : main) {
            i++;
            System.out.println(i + " " + carte.getName());
        }
        System.out.println();
    }

    public void showWellObstacle(){
        obstacle.showWellObstacles();
    }

    public int obstacleSize(){
        return obstacle.getSize();
    }

    public Carte removeCarteObstacle(int indice){
        return obstacle.removeCard(indice);

    }

    public void remplirMain(){
        while(main.size()<5){
            if(deck.getSize() == 0){
                deck.create();
            }
            main.add(deck.getLastCard());
        }
    }


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

    public void deplacement(ArrayDeque<Character> file,Plateau plateau){ //prend en paramètre la file d’instructions retournée par la fonction creationFile()
        while (file.size() > 0){
            setPositionDirection(file.getFirst(),plateau);
            file.removeFirst();
        }
    }
}

