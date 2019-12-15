package com.company;

import java.util.ArrayList;

public class Joueur extends Tortue{



    private Deck deck;
    private Obstacle obstacle;

    private ArrayList<String> main;

    public Joueur(){
    }

    public Joueur(String name){
        this.deck = new Deck();
        this.obstacle = new Obstacle();
        this.main = new ArrayList<>();
    }


    public String getLastCard(){
        return deck.getLastCard().getName();
    }



}

