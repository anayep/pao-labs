package com.company;

import java.util.ArrayList;

public class Comanda {

    private static int id;
    private Local local;
    private Sofer sofer;
    private Client client;
    private ArrayList<Mancare> FeluriMancare;
    private int stareComanda; // 0 - anulata , 1 - in curs de preparare , 1 - livrata

    public Comanda(Client client, Local local, ArrayList<Mancare> feluriMancare) {

        id = id + 1;
        this.local = local;
        this.client = client;
        this.FeluriMancare = feluriMancare;
        this.stareComanda = 1;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getId() { return id; }

    public Sofer getSofer() {
        return sofer;
    }

    public void setSofer(Sofer sofer) {
        this.sofer = sofer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Mancare> getFeluriMancare() {
        return FeluriMancare;
    }

    public void setFeluriMancare(ArrayList<Mancare> feluriMancare) {
        FeluriMancare = feluriMancare;
    }

    public int getStareComanda() {
        return stareComanda;
    }

    public void setStareComanda(int stareComanda) {
        this.stareComanda = stareComanda;
    }
}
