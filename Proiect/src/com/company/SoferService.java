package com.company;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class SoferService {

    public ArrayList<Sofer> readCSV(String path) {
        ArrayList<Sofer> ListaSoferi = new ArrayList<Sofer>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Sofer temp = new Sofer(values[0], values[1], values[2], Integer.parseInt(values[3]));
                ListaSoferi.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ListaSoferi;
    }
}
