package com.company;

import java.util.ArrayList;

public class LocalService {
    protected ArrayList<Local> locals = new ArrayList<Local>();

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
