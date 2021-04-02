public class Local {

    private String nume;
    private String adresa;
    private String tipLocal; //daca tipul maxim e gold,atunci la sala aia poti sa ai abonament silver platinum sau gold..

    public Local() {

        nume=null;
        adresa=null;
        tipLocal =null;
    }

    public Local(String nume, String adresa, String tipLocal) {
        this.nume = nume;
        this.adresa = adresa;
        this.tipLocal = tipLocal;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTipLocal() {
        return tipLocal;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTipLocal(String tipLocal) {
        this.tipLocal = tipLocal;
    }

    public void afisareLocal()
    {
        System.out.println("Local :"+this.nume);
    }
}