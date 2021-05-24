package com.company;

import java.util.ArrayList;

public class Meniu {
    private static int id;
    private ArrayList<Mancare> FeluriMancare;

    public Meniu(ArrayList<Mancare> feluriMancare) {
        FeluriMancare = feluriMancare;
        id = id + 1;
    }


    public ArrayList<Mancare> getFeluriMancare() {
        return FeluriMancare;
    }

    public void setFeluriMancare(ArrayList<Mancare> feluriMancare) {
        FeluriMancare = feluriMancare;
    }

    public int getId(){ return id; }


}
