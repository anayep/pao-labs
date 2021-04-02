package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ComandaService {

    private ArrayList<Comanda> comenzi = new ArrayList<Comanda>();

    public void addComanda(Comanda other) {
        comenzi.add(other);
    }
    public void showComenzi() {
        for(Comanda c : comenzi) {
            System.out.println(c.getClient().getNume() + " " + c.getLocal().getNume());
        }
    }
    public void removeComanda(Comanda co) {
        for(Comanda c : comenzi) {
            if(c.getId() == co.getId()) {
                comenzi.remove(c);
                break;
            }
        }
    }


}
