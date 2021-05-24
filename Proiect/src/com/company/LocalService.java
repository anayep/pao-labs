package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LocalService {
    protected ArrayList<Local> locals = new ArrayList<Local>();

    public ArrayList<Local> readCSV(String path) {
        ArrayList<Local> ListaLocaluri = new ArrayList<Local>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Local temp = new Local(values[0], values[1], values[2]);
                ListaLocaluri.add(temp);
                locals.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ListaLocaluri;
    }


    public void addLocal (Local l) {
        locals.add(l);
    }

    public int verifMax (String name) {

        String id = getLocalIdByName(name);
        for (Local local : locals) {
            if (local.getId().equals(id)) {
                if (local.getMaxComenzi() == 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public String getLocalIdByName(String name)
    {
        for(Local local: locals){
            if(local.getNume().equals(name)){
                return local.getId();
            }
        }
        return "NU EXISTA";
    }

    public Local getLocalbyId(String id) {
        for(Local l : locals) {
            if(l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    public void scadeCapacitate(Local l1){
    l1.setMaxComenzi();

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    AuditService audit = new AuditService();
    audit.writeCSV("S-a realizat o comanda si a scazut capacitatea cu -1 ! ",formatter.format(date));
    }

    public void afisareLocaluri(){

        for(Local l: locals){

            System.out.println("Nume: "
                    + l.getNume()
                    + "\nNumar de comenzi ramase: "
                    + l.getMaxComenzi()
                    + "\n\n"
            );
        }
    }
}
