package com.company;

import java.util.ArrayDeque;

public class Tortue{

    protected String color;
    protected int[] position; //tableau à deux entiers donnant l'abscisse et l'ordonnnée de la tortue sur le plateau
    protected char direction; // nord, sud, est, ouest

    public Tortue(){
        this.position = new int[2];
    }


    public String getColor(){return this.color;}

    public void setColor(String color){this.color = color;}

    public void origin(){
        this.position[0] = 0;
        this.position[1] = 0;
        this.direction = 'N';
    }

    public boolean setPosition(int x, int y){
        if(x >= 0 & x < 8 & y >= 0 & y < 8) { // on vérifie que l'on ne sort  pas du tableau
            this.position[0] = x;
            this.position[1] = y;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean setDirection(char direction){

        if(direction != 'N' & direction != 'S' & direction != 'E' & direction != 'O') {
            return false;
        }
        else {
            this.direction = direction;
            return true;
        }
    }

}
