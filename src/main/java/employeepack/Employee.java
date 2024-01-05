package employeepack;

public class Employee {
    private String prenume;
    private String nume;
    private String CNP;
    private String loc_nastere;
    private String starea_civila;
    private String nationalitate;
    private String departament;
    private int salariu;
    private String marca;
    private String functie;
    private String numar_telefon;
    private String adresa;
    private String email;

    public Employee()
    {
        this.prenume="Necunoscut";
        this.nume="Necunoscut";
        this.CNP="0000000000000";
        this.loc_nastere="Necunoscut";
        this.starea_civila="Singur";
        this.nationalitate="Necunoscut";
        this.departament="Necunoscut";
        this.salariu=0;
        this.marca="Nu exista";
        this.functie="Necunoscut";
        this.numar_telefon="0700000000";
        this.adresa="Necunoscut";
        this.email="necunoscut@necunoscut.necunoscut";
    }


    public Employee(String prenume,String nume, String CNP,String loc_nastere,String starea_civila, String nationalitate,String departament,int salariu,String marca, String functie,String numar_telefon, String adresa,String email) throws MyException {
        super();
        if (!email.matches(".+@.+\\..+"))
        {
            throw new MyException("Nu este dat un mail valid!");
        }

        if (CNP.length()!=13)
        {
            throw new MyException("CNP-ul nu este valid!");
        }
        if (!numar_telefon.matches("07[0-9]{8}"))
        {
            throw new MyException("Nu este un numar valid de telefon!");
        }

        this.prenume=prenume;
        this.nume=nume;
        this.CNP=CNP;
        this.loc_nastere=loc_nastere;
        this.starea_civila=starea_civila;
        this.nationalitate=nationalitate;
        this.departament=departament;
        this.salariu=salariu;
        this.marca=marca;
        this.functie=functie;
        this.numar_telefon=numar_telefon;
        this.adresa=adresa;
        this.email=email;
    }
    public Employee(String prenume,String nume,String marca)
    {
        this.prenume=prenume;
        this.nume=nume;
        this.marca=marca;
        this.CNP="0000000000000";
        this.loc_nastere="Necunoscut";
        this.starea_civila="Singur";
        this.nationalitate="Necunoscut";
        this.departament="Necunoscut";
        this.salariu=0;
        this.functie="Necunoscut";
        this.numar_telefon="0700000000";
        this.adresa="Necunoscut";
        this.email="necunoscut@necunoscut.necunoscut";
    }
    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getLoc_nastere() {
        return loc_nastere;
    }

    public void setLoc_nastere(String loc_nastere) {
        this.loc_nastere = loc_nastere;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public String getNumar_telefon() {
        return numar_telefon;
    }

    public void setNumar_telefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
    }

    public String getStarea_civila() {
        return starea_civila;
    }

    public void setStarea_civila(String starea_civila) {
        this.starea_civila = starea_civila;
    }

    @Override
    public String toString() {
        return "employeeclass.Employee{" +
                "prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", loc_nastere='" + loc_nastere + '\'' +
                ", starea_civila='" + starea_civila + '\'' +
                ", nationalitate='" + nationalitate + '\'' +
                ", departament='" + departament + '\'' +
                ", salariu=" + salariu +
                ", cod_unic=" + marca +
                ", functie='" + functie + '\'' +
                ", numar_telefon='" + numar_telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
