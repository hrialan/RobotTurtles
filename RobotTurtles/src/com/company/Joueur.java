package com.company;

import java.util.ArrayList;

public class Joueur{

    private String name;

    private Deck deck;
    private Obstacle obstacle;

    private ArrayList<String> main;

    public Joueur(){

    }

    public Joueur(String name){
        this.name = name;
        this.deck = new Deck();
        this.obstacle = new Obstacle();
        this.main = new ArrayList<>();

    }

    public String getName(){
        return this.name;
    }
}
