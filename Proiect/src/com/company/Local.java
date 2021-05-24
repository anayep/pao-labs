package com.company;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

public class Local implements Comparable<Local>{
    private String LocalId = UUID.randomUUID().toString();
    private String nume;
    private String adresa;
    private String tipLocal;
    private Meniu meniu;
    private int maxComenzi;

    public Local() {

        nume=null;
        adresa=null;
        tipLocal =null;
        meniu = null;
        maxComenzi = 20;
    }

    public Local(String nume, String adresa, String tipLocal, Meniu meniu) {
        this.nume = nume;
        this.adresa = adresa;
        this.tipLocal = tipLocal;
        this.meniu = meniu;
        this.maxComenzi = 20;
    }

    public Local(String nume, String adresa, String tipLocal) {
        this.nume = nume;
        this.adresa = adresa;
        this.tipLocal = tipLocal;
        this.meniu = null;
        this.maxComenzi = 20;
    }

    public String getId() { return LocalId; }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTipLocal() {
        return tipLocal;
    }

    public Meniu getMeniu() {
        return meniu;
    }

    public int getMaxComenzi() {
        return maxComenzi;
    }

    public void setMeniu(Meniu meniu) {
        this.meniu = meniu;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTipLocal(String tipLocal) {
        this.tipLocal = tipLocal;
    }

    public void setMaxComenzi() {
        this.maxComenzi--;
    }

    @Override
    public int compareTo(Local o) {

        return this.maxComenzi-o.getMaxComenzi();

    }

}