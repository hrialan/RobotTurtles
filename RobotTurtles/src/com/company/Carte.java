package com.company;

public class Carte {

    private String name;

    public Carte(String name){
        this.name = name;
    }  //constructeur

    public void setName(String name){
        this.name = name;
    } //setter

    public String getName(){
        return this.name;
    } //getter
}
