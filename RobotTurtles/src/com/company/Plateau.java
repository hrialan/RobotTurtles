package com.company;

import javax.swing.*;
import java.awt.*;

public class Plateau {

    private String [][] plateau;
    private int taillePlateau = 8; //Le plateau est carré
    private int nbJoueur;



    public Plateau(){
    }


    public Plateau(int nbJoueur){
        this.plateau = new String[taillePlateau][taillePlateau];
        this.nbJoueur = nbJoueur ;
    }

    public int taille(){
        return this.taillePlateau;
    }

    public void display(){
        System.out.println("  0  1  2  3  4  5  6  7");
        System.out.println("  _  _  _  _  _  _  _  _");
        for(int L = 0; L < this.taillePlateau; L++){
            System.out.print(L + "|");
            for(int C = 0; C < this.taillePlateau; C++){
                System.out.print(plateau[L][C] + "  ");
            }
            System.out.println();
        }
    }

    public void initialisation() {
        for (int L = 0; L < this.taillePlateau; L++) {
            for (int C = 0; C < this.taillePlateau; C++) {
                plateau[L][C] = " ";
            }
        }
        if (nbJoueur < 4) { //si nbJoueur < 4 , on réduit le plateau avec des murs en pierre

            for (int L = 0; L < this.taillePlateau; L++) {
                plateau[L][this.taillePlateau - 1] = "WALL";
            }
        }

        if (nbJoueur == 2) {
            plateau[7][3] = "RUBY";
            plateau[0][1] = "TRS";
            plateau[0][5] = "TVS";
        }
        else if(nbJoueur == 3){
            plateau[7][0] = "RUBY";
            plateau[7][3] = "RUBY";
            plateau[7][6] = "RUBY";
            plateau[0][0] = "TRS";
            plateau[0][3] = "TVS";
            plateau[0][6] = "TOS";
        }
        else {

            plateau[7][1] = "RUBY";
            plateau[7][6] = "RUBY";

            plateau[0][0] = "TRS";
            plateau[0][3] = "TVS";
            plateau[0][6] = "TOS";
            plateau[0][6] = "TBS";
        }
    }

    public void set(Joueur joueur){
        int[] position = joueur.position;
        char direction = joueur.direction;
        if(plateau[position[0]][position[1]].equals(" ")){
            plateau[position[0]][position[1]] = "T" + joueur.getColor() + direction;
        }


    }

    public void setJoyau(String name,int x, int y){
        plateau[x][y] = name;
    }

    public void cleanPosition(int[] position){
        plateau[position[0]][position[1]] = " ";
    }

    public boolean isPositionClear(int[] position){
        if(plateau[position[0]][position[1]].equals(" ")){
            return true;
        }
        else {
            return false;
        }
    }

    public String getValue(int i , int j){
        return plateau[i][j];
    }
    public void setValue(int i , int j, String value){
        plateau[i][j] = value;
    }
}