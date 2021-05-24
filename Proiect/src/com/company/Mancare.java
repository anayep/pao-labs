package com.company;

public class Mancare {

    private String nume;
    private int pret;
    private int picanta;       //0 - daca nu e picanta , 1 - daca e picanta

    public Mancare(String nume, int p, int picanta) {
        this.nume = nume;
        this.pret = p;
        this.picanta = picanta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getPicanta() {
        return picanta;
    }

    public void setPicanta(int picanta) {
        this.picanta = picanta;
    }

    public void afisareMancare()
    {
        System.out.println("Mancare: "+this.nume+"    Pret: "+this.pret +"lei    Picant: "+this.picanta + "\n");
    }


}
