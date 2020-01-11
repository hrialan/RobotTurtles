package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;


public class MainJeu extends JFrame {

    private Plateau plateau;
    private int nbJoueurs;
    private PlateauJPanel pan = new PlateauJPanel();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


    public MainJeu(int nbJoueur) {
        this.nbJoueurs = nbJoueur;
        this.plateau = new Plateau(nbJoueur);
        this.setTitle("Plateau");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(dim.width / 2 - 20, dim.width / 2 ); // on enlève 20 a width car cela correspond à la taille en pixel du bandeau
        this.setLocation(0, 0);
        this.setResizable(false);
        this.plateau.initialisation();
        this.setContentPane(pan);
        this.setVisible(true);
        go();
    }

    public void go(){
       
    }

    public class PlateauJPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            addImage("images/PlateauBackground.png",0,0,this.getWidth(), this.getHeight(),g);
            for (int i = 0; i < plateau.taille(); i++) {
                for (int j = 0; j < plateau.taille(); j++ ) {
                    String source = "";

                    switch (plateau.getValue(i,j)){
                        case "WALL":
                            source = "images/" + "WALL" + ".png";
                            addImage(source,giveCoord(i, j)[0],giveCoord(i, j)[1],this.getWidth() / 9,this.getHeight() / 9,g);
                            break;

                        case "RUBY" :
                            source = "images/" + "RUBY" + ".png";
                            addImage(source,giveCoord(i, j)[0],giveCoord(i, j)[1],this.getWidth() / 9,this.getHeight() / 9,g);
                            break;

                        case "ICE" :
                            source = "images/" + "ICE" + ".png";
                            addImage(source,giveCoord(i, j)[0],giveCoord(i, j)[1],this.getWidth() / 9,this.getHeight() / 9,g);
                            break;

                        default:
                            if(plateau.getValue(i,j).charAt(0) == 'T'){ //si c'est une tortue
                                source = "images/" + plateau.getValue(i,j) + ".png";
                                addImage(source,giveCoord(i, j)[0],giveCoord(i, j)[1],this.getWidth() / 9,this.getHeight() / 9,g);
                            }
                            break;
                    }
                }
            }
        }
    }

    public void addImage(String source,int pixX,int pixY, int width, int heigth, Graphics g){
        try {
            Image img = ImageIO.read(new File(source));
            g.drawImage(img, pixX, pixY, width, heigth, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] giveCoord(int Ligne, int Colonne) {
        int[] coord = new int[2];
        coord[0] = Colonne * (this.getWidth() / 8) + 5 ;
        coord[1] = Ligne  * (this.getWidth() / 8) + 5;
        return coord;
    }
}
