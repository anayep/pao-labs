package com.company;
import repository.*;
import java.util.Collections;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ClientService cs = new ClientService();
        LocalService ls = new LocalService();
        ComandaService cc = new ComandaService();
        MancareService ms = new MancareService();
        SoferService ss = new SoferService();
        ArrayList<Client> ListaClienti = new ArrayList<Client>();
        ArrayList<Mancare> ListaMancare = new ArrayList<Mancare>();
        ArrayList<Sofer> ListaSoferi = new ArrayList<Sofer>();
        ArrayList<Mancare> ListaMancare2 = new ArrayList<Mancare>();
        ArrayList<Local> ListaLocaluri = new ArrayList<Local>();

        System.out.println("--------------Adaugi client-------------");

        // adaugam datele clientului prin parametrii
        Client maria = new Client("Maria","maria@gmail.com","076#######","normal");
        Client andrei = new Client("Andrei","#","076#######","premium");
        cs.adaugaClient(maria);
        cs.adaugaClient(andrei);

        // introducem datele clientului de la tastatura
        //cs.adaugaClient();

        // adauga clientii creati anterior intr-un fisier CSV
        //cs.writeCSV("D:\\facultateee\\pao\\github\\pao-labs\\csvs\\users.csv");

        // citeste din fisierul CSV si adauga clienti de acolo
        //cs.readCSV("D:\\facultateee\\pao\\github\\pao-labs\\csvs\\users.csv");

        // afisam clientii
        cs.afisareClienti();


        Mancare pizza = new Mancare("pizza",10, 0 );
        Mancare paste = new Mancare("paste",8,0);
        Mancare limonada = new Mancare("limonada",3,0);
        Mancare cheesecake = new Mancare("cheesecake",13,0);

        //System.out.println("--------------Afisam Mancare-------------");


        // CSV pt Mancare
        ListaMancare = ms.readCSV("D:\\facultateee\\pao\\github\\pao-labs\\csvs\\mancare.csv");
        //for (Mancare i:
        //        ListaMancare) {
        //    i.afisareMancare();
        //}

        // adaugam mancare in meniu
        Meniu meniu = new Meniu(ListaMancare);

        // CSV pt Soferi
        ListaSoferi = ss.readCSV("D:\\facultateee\\pao\\github\\pao-labs\\csvs\\sofer.csv");

        //System.out.println("--------------Afisam Soferi-------------");
        //for (Sofer i:
        //        ListaSoferi) {
        //  i.afisareSofer();
        //}

        //adaugam restaurante pt delivery
        Local mcdonalds = new Local("McDonalds", "strada victoriei", "fastfood",meniu);
        ls.addLocal(mcdonalds);
        Local mesopotamia = new Local("Mesopotamia", "mall", "fastfood",meniu);
        ls.addLocal(mesopotamia);
        Local kfc = new Local("KFC", "strada unirii", "fastfood",meniu);
        ls.addLocal(kfc);

        // citim restaurantele din fisierul CSV
        ListaLocaluri = ls.readCSV("D:\\facultateee\\pao\\github\\pao-labs\\csvs\\local.csv");

        System.out.println("--------------Afisam restaurante -------------");
        ls.afisareLocaluri();


        // pt fiecare comanda plasata verificam daca s a atins nr maxim de comenzi
        System.out.println("Numarul maxim de comenzi pt KFC este : " + kfc.getMaxComenzi());
        int i = ls.verifMax("KFC");
        if(i==0) {
            System.out.println("RESTAURANTUL KFC NU MAI ACCEPTA COMENZI");
        }
        else {
            System.out.println("Restaurantul KFC nu este full!");
        }

        ListaMancare2.add(cheesecake);
        ListaMancare2.add(limonada);

        // facem o comanda
        Comanda c1 = new Comanda (andrei , kfc , ListaMancare2);
        cc.addComanda(c1);
        ls.scadeCapacitate(c1.getLocal()); // la fiecare comanda, scadem cu 1 din capacitatea maxima a restaurantului
        int i2 = ls.verifMax("KFC");
        if(i2==0){
            cc.removeComanda(c1);           //daca ajungem la 0, atunci nu mai putem plasa comenzi deci o stergem
        }
        System.out.println("Mai avem un numar de " + kfc.getMaxComenzi()+" comenzi valabile!");

        System.out.println("--------------Afisam comenzile -------------");
        cc.showComenzi();

        //sortam restaurantele dupa nr de comenzi valabile
        Collections.sort(ls.locals);

        //System.out.println("--------------Afisam restaurantele dupa sortare -------------");
        //ls.afisareLocaluri();

        //stergem comanda
        //cc.removeComanda(c1);
        //Comanda c2 = new Comanda(maria,mcdonalds,ListaMancare2);
        //cc.addComanda(c2);

        //System.out.println("--------------Afisam comenzile dupa stergere -------------");
        //cc.showComenzi();

        ClientUS clientUS = new ClientUS();
//        clientUS.createTable();
//        clientUS.updateTable();
//        clientUS.addClient();
//        clientUS.displayClient();
//        clientUS.deleteTable();

        SoferUS soferUs = new SoferUS();
        //soferUS.createTable();
//        soferUS.addSofer();
//        soferUS.displaySofer();
//        soferUS.deleteTable();

        MancareUS mancareUS = new MancareUS();
        mancareUS.createTable();
        mancareUS.addMancare();
        mancareUS.displayMancare();
        //mancareUS.deleteTable();

    }
}
