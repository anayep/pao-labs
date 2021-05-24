package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MancareService {

    public ArrayList<Mancare> readCSV(String path) {
        ArrayList<Mancare> ListaMancare = new ArrayList<Mancare>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Mancare temp = new Mancare(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                ListaMancare.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ListaMancare;
    }

}
