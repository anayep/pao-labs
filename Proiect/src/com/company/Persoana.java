package com.company;
import java.util.Scanner;

public class Persoana {

    protected String nume;
    protected String email;
    protected String numarTelefon;

    public Persoana() {

        nume=null;
        email=null;
        numarTelefon=null;
    }

    public Persoana(String nume, String email, String numarTelefon) {
        this.nume = nume;
        this.email = email;
        this.numarTelefon = numarTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }


    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }


}