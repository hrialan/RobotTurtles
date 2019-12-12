package com.company;

public class Tortue {

    private String color;
    private int[] position; //tableau à deux entiers donnant l'abscisse et l'ordonnnée de la tortue sur le plateau

    public Tortue(){
        this.position = new int[2];
    }

    public String getColor(){return this.color;}

    public void origin(){
        this.position[0] = 0;
        this.position[1] = 1;
    }


}
