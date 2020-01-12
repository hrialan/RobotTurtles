package com.company;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    public ArrayList<Carte> deck;

    public Deck(){
        this.deck = new ArrayList<>();
        create();
    }

    public void create(){
        String[] couleurs = {"Bleue", "Jaune", "Violette"}; //différentes cartes de couleurs

        for(String couleur : couleurs) { //on remplie le deck
            for (int i = 0; i < 18; i++) {
                Carte carte = new Carte(couleur);
                this.deck.add(carte);
            }
        }
        for (int i = 0; i < 3; i++) {//ajout des 3 cartes Lasers
            Carte carte = new Carte("Laser");
            this.deck.add(carte);
        }
        Collections.shuffle(this.deck); //on mélange les cartes
    }

    public void getDeck(){
        for(Carte carte : this.deck){
            System.out.print(carte.getName() + " ");
        }
    }

    public Carte getLastCard(){ //renvoie et retire la dernière carte du deck
        return this.deck.remove(0);
    }



}
