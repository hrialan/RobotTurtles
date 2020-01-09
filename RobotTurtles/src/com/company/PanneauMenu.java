package com.company;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauMenu extends JPanel {

    private JButton bouton2Players = new JButton("2 joueurs");
    private JButton bouton3Players = new JButton("3 joueurs");
    private JButton bouton4Players = new JButton("4 joueurs");

    public void paintComponent(Graphics g){
        this.setLayout(null);
        bouton2Players.setBounds(this.getWidth()/2 - bouton2Players.getWidth()/2,this.getHeight()/2 ,200,50);
        bouton3Players.setBounds(this.getWidth()/2 - bouton2Players.getWidth()/2,this.getHeight()/2 + 100 ,200,50);
        bouton4Players.setBounds(this.getWidth()/2 - bouton2Players.getWidth()/2,this.getHeight()/2 + 200 ,200,50);

        this.add(bouton2Players);
        this.add(bouton3Players);
        this.add(bouton4Players);


        try {
            Image img = ImageIO.read(new File("images/Menubackground.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
