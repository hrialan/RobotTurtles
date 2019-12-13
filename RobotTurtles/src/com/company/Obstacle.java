package com.company;

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


}
