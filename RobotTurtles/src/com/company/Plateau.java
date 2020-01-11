package com.company;

public class Plateau{
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

    public boolean setWall(int Ligne, int Colonne){
        if( this.isPositionClear(Ligne,Colonne)) {
            plateau[Ligne][Colonne] = "WALL";
            return true;
        }
        else return false;
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
    }

    public void set(Joueur joueur){
        int[] position = joueur.position;
        char direction = joueur.direction;
        if(plateau[position[0]][position[1]].equals(" ")){
            plateau[position[0]][position[1]] = "T"  + joueur.getColor() + direction;
        }

    }


    public void setJoyau(int x, int y){
        plateau[x][y] = "RUBY";
    }

    public void cleanPosition(int[] position){
        plateau[position[0]][position[1]] = " ";
    }

    public boolean isPositionClear(int x, int y){
        if(x >= 0 && x < 8 && y >= 0 && y < 8){
        if(plateau[x][y].equals(" ")){
            return true;
        }
        else return false;

        }
        else {
            return false;
        }
    }
}