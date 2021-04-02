package com.company;
import java.util.Scanner;

public class Client extends Persoana {

    private String tipClient;

    public Client() {
        tipClient =null;
    }

    public Client(String nume, String email, String nrtel ,String tipMembru) {
        super(nume,email,nrtel);
        this.tipClient = tipMembru;
    }

    public String getTipClient() {
        return tipClient;
    }

    public void setTipClient(String tipClient) {
        this.tipClient = tipClient;
    }

}
