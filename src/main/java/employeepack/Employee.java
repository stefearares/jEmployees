package employeepack;

import exceptions.MyException;

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

    /**
     * Constructor implicit care atribuie valori implicite atributelor.
     */
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

    /**
     * Constructor care primeste atribute, verifica atributele email, numar de telefon si cnp utilizand REGEX si
     * afiseaza erori in cazul in care atributele specificate nu sunt conform conventiilor( email de forma: x@x.x, CNP
     * de lungime 13 caractere si numar de telefon sub forma: 07xxxxxx( lungimea de 10 caractere)).
     * @param prenume conform cartii de identitate/buletinului
     * @param nume conform cartii de identitate/buletinului
     * @param CNP conform cartii de identitate/buletinului
     * @param loc_nastere conform cartii de identitate/buletinului
     * @param starea_civila conform departamentului de resurse umane
     * @param nationalitate conform cartii de identitate/buletinului
     * @param departament conform departamentului de resurse umane
     * @param salariu conform departamentului de contabilitate
     * @param marca conform departamentului de resurse umane
     * @param functie conform departamentului de resurse umane
     * @param numar_telefon conform departamentului de resurse umane
     * @param adresa conform departamentului de resurse umane
     * @param email  conform departamentului de resurse umane
     * @throws MyException
     */
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

    /**
     * Constructor pentru prenume, nume si marca generale.
     * @param prenume angajat
     * @param nume angajat
     * @param marca angajat
     */
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

    /**
     * Getter ce obtine atributul prenume al obiectului employee.
     * @return prenumele angajatului.
     */
    public String getPrenume() {
        return prenume;
    }

    /**
     * Setter ce inlocuieste atributul prenume cu altul, ales de utilizator.
     * @param prenume ce trebuie schimbat.
     */
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    /**
     * Getter pentru numele angajatului.
     * @return numele angajatului.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Setter pentru numele angajatului.
     * @param nume noul nume al angajatului.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Getter pentru marca angajatului.
     * @return marca angajatului.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Setter pentru marca angajatului.
     * @param marca noua marcă a angajatului.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter pentru salariul angajatului.
     * @return salariul angajatului.
     */
    public int getSalariu() {
        return salariu;
    }

    /**
     * Setter pentru salariul angajatului.
     * @param salariu noul salariu al angajatului.
     */
    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    /**
     * Getter pentru adresa angajatului.
     * @return adresa angajatului.
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Setter pentru adresa angajatului.
     * @param adresa noua adresă a angajatului.
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Getter pentru CNP-ul angajatului.
     * @return CNP-ul angajatului.
     */
    public String getCNP() {
        return CNP;
    }

    /**
     * Setter pentru CNP-ul angajatului.
     * @param CNP noul CNP al angajatului.
     */
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    /**
     * Getter pentru departamentul angajatului.
     * @return departamentul angajatului.
     */
    public String getDepartament() {
        return departament;
    }

    /**
     * Setter pentru departamentul angajatului.
     * @param departament noul departament al angajatului.
     */
    public void setDepartament(String departament) {
        this.departament = departament;
    }

    /**
     * Getter pentru adresa de email a angajatului.
     * @return adresa de email a angajatului.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter pentru adresa de email a angajatului.
     * @param email noua adresă de email a angajatului.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter pentru funcția angajatului.
     * @return funcția angajatului.
     */
    public String getFunctie() {
        return functie;
    }

    /**
     * Setter pentru funcția angajatului.
     * @param functie noua funcție a angajatului.
     */
    public void setFunctie(String functie) {
        this.functie = functie;
    }

    /**
     * Getter pentru locul de naștere al angajatului.
     * @return locul de naștere al angajatului.
     */
    public String getLoc_nastere() {
        return loc_nastere;
    }

    /**
     * Setter pentru locul de naștere al angajatului.
     * @param loc_nastere noul loc de naștere al angajatului.
     */
    public void setLoc_nastere(String loc_nastere) {
        this.loc_nastere = loc_nastere;
    }

    /**
     * Getter pentru naționalitatea angajatului.
     * @return naționalitatea angajatului.
     */
    public String getNationalitate() {
        return nationalitate;
    }

    /**
     * Setter pentru naționalitatea angajatului.
     * @param nationalitate noua naționalitate a angajatului.
     */
    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    /**
     * Getter pentru numărul de telefon al angajatului.
     * @return numărul de telefon al angajatului.
     */
    public String getNumar_telefon() {
        return numar_telefon;
    }

    /**
     * Setter pentru numărul de telefon al angajatului.
     * @param numar_telefon noul număr de telefon al angajatului.
     */
    public void setNumar_telefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
    }

    /**
     * Getter pentru starea civilă a angajatului.
     * @return starea civilă a angajatului.
     */
    public String getStarea_civila() {
        return starea_civila;
    }

    /**
     * Setter pentru starea civilă a angajatului.
     * @param starea_civila noua stare civilă a angajatului.
     */
    public void setStarea_civila(String starea_civila) {
        this.starea_civila = starea_civila;
    }

    /**
     * Override pentru System.out, afiseaza obiectul employee intr-un mod specific.
     * @return string-ul formatat.
     */
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
