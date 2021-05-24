package com.company;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class ClientService {
    private ArrayList<Client> clienti = new ArrayList<Client>();

    public ArrayList<Client> readCSV(String path) {
        ArrayList<Client> ListaClienti = new ArrayList<Client>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Client temp = new Client(values[0], values[1], values[2], values[3]);
                ListaClienti.add(temp);
                clienti.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ListaClienti;
    }


    public void writeCSV(String path){
        File file = new File(path);
        boolean header = false;
        boolean result;
        try{
            result = file.createNewFile();
            if(result)      // test if successfully created a new file
            {
                System.out.println("file created "+file.getCanonicalPath()); //returns the path string
                header = true;
            }
            else
            {
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            FileWriter csvWriter = new FileWriter(file,true);
            if(header){
                csvWriter.append("Nume,Email,Telefon,Tip Membru(normal/premium)");
                csvWriter.append("\n");
            }
            for (Client i:
                    clienti) {
                csvWriter.append(i.getNume());
                csvWriter.append(",");
                csvWriter.append(i.getEmail());
                csvWriter.append(",");
                csvWriter.append(i.getNumarTelefon());
                csvWriter.append(",");
                csvWriter.append(i.getTipClient());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adaugaClient(Client c) {
        clienti.add(c);
    }
    public void adaugaClient()
    {
        Client c = new Client();

        Scanner cin = new Scanner(System.in);
        String nume;
        System.out.println("Insereaza nume");
        nume = cin.nextLine();
        c.setNume(nume);
        String em;
        System.out.println("Insereaza email");
        em = cin.nextLine();
        c.setEmail(em);
        String nrtel;
        System.out.println("Insereaza numar de telefon");
        nrtel = cin.nextLine();
        c.setNumarTelefon(nrtel);
        String tip;
        System.out.println("Ce tip de client este? Normal / Premium");
        tip = cin.nextLine();
        c.setTipClient(tip);

        clienti.add(c);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        AuditService audit = new AuditService();
        audit.writeCSV("S-a adaugat un client nou! ",formatter.format(date));
    }

    public void afisareClienti(){

        for(Client c: clienti){

            System.out.println("Nume: "
                    + c.getNume()
                    + "\nNumar de telefon: "
                    + c.getNumarTelefon()
                    + "\nEmail: "
                    + c.getEmail()
                    + "\nTipul clientului (normal / premium): "
                    + c.getTipClient()
                    + "\n\n"
            );
        }
    }

}
