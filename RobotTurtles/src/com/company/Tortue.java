package com.company;

public class Tortue extends Joueur{

    private String color;
    private int[] position; //tableau à deux entiers donnant l'abscisse et l'ordonnnée de la tortue sur le plateau
    private char direction; // nord, sud, est, ouest

    public Tortue(){
        this.position = new int[2];
    }

    public String getColor(){return this.color;}
    public void setColor(String color){this.color = color;}

    public void origin(){
        this.position[0] = 0;
        this.position[1] = 1;
    }


}
