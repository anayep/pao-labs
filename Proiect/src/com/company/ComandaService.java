package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComandaService {

    private ArrayList<Comanda> comenzi = new ArrayList<Comanda>();

    public void addComanda(Comanda other) {
        comenzi.add(other);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        AuditService audit = new AuditService();
        audit.writeCSV("S-a adaugat o comanda noua! ",formatter.format(date));
    }
    public void showComenzi() {
        for(Comanda c : comenzi) {
            System.out.println("Nume client: " + c.getClient().getNume() + "      Restaurant: " + c.getLocal().getNume());
        }
    }
    public void removeComanda(Comanda co) {
        for(Comanda c : comenzi) {
            if(c.getId() == co.getId()) {
                comenzi.remove(c);
                break;
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        AuditService audit = new AuditService();
        audit.writeCSV("S-a sters comanda "+co.getId()+" !",formatter.format(date));
    }


}
