package com.company;

public class Meniu {
    private static int id;
    private Mancare[] FeluriMancare;

    public Meniu(Mancare[] feluriMancare) {
        FeluriMancare = feluriMancare;
        id = id + 1;
    }

    public Mancare[] getFeluriMancare() {
        return FeluriMancare;
    }

    public void setFeluriMancare(Mancare[] feluriMancare) {
        FeluriMancare = feluriMancare;
    }

    public int getId(){ return id; }


}
