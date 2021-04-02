package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientService {
    private ArrayList<Client> clienti = new ArrayList<Client>();

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
