package com.company;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Sofer extends Persoana {

    private int salariu;
    private Date dataAngajare;

    public Sofer() {

        salariu=0;
        dataAngajare=null;
    }


    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public Date getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(Date dataAngajare) {
        this.dataAngajare = dataAngajare;
    }


    public  void adaugaSofer()
    {

        Scanner cin = new Scanner(System.in);

        int sal;
        System.out.println("Ce salariu are acest angajat?");
        sal = cin.nextInt();
        this.salariu=sal;


        Date d=null;
        String ss;
        cin.nextLine();
        System.out.println("Care este data de angajare?");
        ss=cin.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        try {
            Date da = sdf.parse(ss);
            this.dataAngajare = da;
        } catch (ParseException e) {
            e.printStackTrace();
            this.dataAngajare = null;
        }


    }
    public void afisareSofer()
    {
        System.out.println("Salariu : " +this.salariu +"lei");
        System.out.println("Data angajare: "+this.dataAngajare);
    }
}