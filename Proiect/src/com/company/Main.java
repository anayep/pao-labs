package com.company;
import java.util.Collections;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ClientService cs = new ClientService();
        LocalService ls = new LocalService();
        ComandaService cc = new ComandaService();
        System.out.println("--------------Adaugi client-------------");

        Client maria = new Client("Maria","#","#","normal");
        Client andrei = new Client("Andrei","#","#","premium");
        cs.adaugaClient(maria);
        cs.adaugaClient(andrei);
        cs.adaugaClient();
        cs.afisareClienti();

        Mancare pizza = new Mancare("pizza",10, 0 );
        Mancare paste = new Mancare("paste",8,0);
        Mancare prajitura = new Mancare("prajitura",5,0);
        Mancare salata = new Mancare("prajitura",7,1);

        ArrayList<Mancare> meniu1 = new ArrayList<Mancare>();
        meniu1.add(pizza);
        meniu1.add(paste);

        Local mcdonalds = new Local("McDonalds", "strada victoriei", "fastfood",meniu1);
        ls.addLocal(mcdonalds);
        Local mesopotamia = new Local("Mesopotamia", "mall", "fastfood",meniu1);
        ls.addLocal(mesopotamia);
        Local kfc = new Local("KFC", "strada unirii", "fastfood",meniu1);
        ls.addLocal(kfc);
        ls.afisareLocaluri();

        int i = ls.verifMax("KFC");
        if(i==0) {
            System.out.println("RESTAURANTUL NU MAI ACCEPTA COMENZI");
        }
        else {
            System.out.println("Restaurantul nu este full!");
        }

        Comanda c1 = new Comanda (andrei , kfc , meniu1);
        cc.addComanda(c1);
        ls.scadeCapacitate(c1.getLocal());
        int i2 = ls.verifMax("KFC");
        if(i2==0){
            cc.removeComanda(c1);
        }
        System.out.println(kfc.getMaxComenzi());

        cc.showComenzi();

        Collections.sort(ls.locals);

        ls.afisareLocaluri();

        cc.removeComanda(c1);

        cc.showComenzi();
        //Local mcDonalds = new Local("McDonalds", "strada victoriei", "fastfood");

        //s.addComanda(Maria,hanulBerarilor,)

    }
}
