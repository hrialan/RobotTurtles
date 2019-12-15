package com.company;

public class Plateau{

    private String [][] plateau;
    private int taillePlateau = 8; //Le plateau est carré


    public Plateau(){
        this.plateau = new String[taillePlateau][taillePlateau];
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



    public void initialisation2Joueur(){
        for (int L = 0; L < this.taillePlateau; L++) {
            for (int C = 0; C < this.taillePlateau - 1; C++) {
                plateau[L][C] = " ";
            }
        }
        for (int L = 0; L < this.taillePlateau; L++) {
            plateau[L][this.taillePlateau-1] = "Mur en pierre";
        }

    }

    public void initialisation3Joueur(){
        for (int L = 0; L < this.taillePlateau; L++) {
            for (int C = 0; C < this.taillePlateau - 1; C++) {
                plateau[L][C] = " ";
            }
        }
        for (int L = 0; L < this.taillePlateau; L++) {
            plateau[L][this.taillePlateau-1] = "Mur en pierre";
        }
    }

    public void initialisation4Joueur(){
        for (int L = 0; L < this.taillePlateau; L++) {
            for (int C = 0; C < this.taillePlateau; C++) {
                plateau[L][C] = " ";
            }
        }
    }

    public void refresh(){ //raffraichit le plateau en  fonction de la position des joyaux et tortues

    }
}
