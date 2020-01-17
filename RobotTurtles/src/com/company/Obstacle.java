package com.company;

import java.util.ArrayList;

public class Obstacle {

    private ArrayList<Carte> murs;

    public Obstacle(){
        this.murs = new ArrayList<>();
        create();
    }

    public void create(){
        for(int i=0; i<3;i++){
            Carte carte = new Carte("WALL");
            this.murs.add(carte);
        }
        for(int i=0; i<2;i++){
            Carte carte = new Carte("ICE");
            this.murs.add(carte);
        }
    }

    public Carte getCardByName(String name){
        for(Carte elt : murs){
            if(name.equals(elt.getName())){
                return elt;
            }
        }
        return null;
    }


    public boolean removePierre(){
        if(getCardByName("WALL") == null ){
            return false;
        }
        else {
            return murs.remove(getCardByName("WALL"));
        }
    }

    public boolean removeGlace(){
        if(getCardByName("ICE") == null ){
            return false;
        }
        else {
            return murs.remove(getCardByName("ICE"));
        }
    }

    public void showWellObstacles(){
        int i = 0;
        for (Carte mur : murs) {
            i++;
            System.out.println(i + " " + mur.getName());
        }
        System.out.println();
    }

    public Carte removeCard(int indice){
        return this.murs.remove(indice);
    }

    public int getSize(){
        return murs.size();
    }

}
