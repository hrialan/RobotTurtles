package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Obstacle {

    ArrayList<Carte> murs;

    public Obstacle(){
        this.murs = new ArrayList<>();
        create();
    }

    public void create(){
        for(int i=0; i<3;i++){
            Carte carte = new Carte("Mur en pierre");
            this.murs.add(carte);
        }
        for(int i=0; i<2;i++){
            Carte carte = new Carte("Mur en glace");
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
        if(getCardByName("Mur en pierre") == null ){
            return false;
        }
        else {
            return murs.remove(getCardByName("Mur en pierre"));
        }
    }

    public boolean removeGlace(){
        if(getCardByName("Mur en glace") == null ){
            return false;
        }
        else {
            return murs.remove(getCardByName("Mur en glace"));
        }
    }
}
