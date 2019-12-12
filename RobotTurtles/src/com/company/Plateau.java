package com.company;

public class Plateau {

    private char [][] plateau;
    private int taillePlateau = 8; //Le plateau est carré


    public Plateau(){
        this.plateau = new char[taillePlateau][taillePlateau];
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


    public void initialisation(){
        for (int L = 0; L < this.taillePlateau; L++) {
            for (int C = 0; C < this.taillePlateau; C++) {
                plateau[L][C] = ' ';
            }
        }
    }




}
