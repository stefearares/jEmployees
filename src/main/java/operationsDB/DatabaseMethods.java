package operationsDB;

import employeepack.Employee;
import exceptions.MyException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static operationsDB.DBConnection.getConnection;

public class DatabaseMethods {

    /**
     *Metoda introduce in baza de date informatiile legate de un angajat avand ca CNP cheie primara.
     * @param e Obiectul de tip Employee ce urmeaza sa fie adaugat in baza de date.
     */
    public static void AdaugareBD(Employee e){
        try {
            Connection conn= getConnection();
            String query="INSERT INTO people (nume,prenume,cnp,loc_nastere,stare_civila,nationalitate,departament,functie,numar_telefon,adresa,email,marca,salariu) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setString(1,e.getNume());
            pstmt.setString(2,e.getPrenume());
            pstmt.setString(3,e.getCNP());
            pstmt.setString(4,e.getLoc_nastere());
            pstmt.setString(5,e.getStarea_civila());
            pstmt.setString(6,e.getNationalitate());
            pstmt.setString(7,e.getDepartament());
            pstmt.setString(8,e.getFunctie());
            pstmt.setString(9,e.getNumar_telefon());
            pstmt.setString(10,e.getAdresa());
            pstmt.setString(11,e.getEmail());
            pstmt.setString(12,e.getMarca());
            pstmt.setInt(13,e.getSalariu());

            pstmt.execute();

        }
        catch (SQLException x)
        {
            x.printStackTrace();
        }
    }

    /**
     * Metoda primeste ca parametru cnp-ul sau marca unui angajat care urmeaza sa fie cautat in baza de date
     * @param cnp atribut al anjagatului
     * @param marca atribut al angajatului
     * @return true in cazul in care angajatul a fost gasit si fals in caz contrar.
     */
    public static boolean CautareBD(String cnp,String marca){
        try {
            Connection connection=getConnection();
            String query="SELECT cnp FROM people WHERE cnp=? OR marca=?";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1,cnp);
            pstmt.setString(2,marca);
            ResultSet rs=pstmt.executeQuery();
            if(!rs.isBeforeFirst())
            {
                return false;
            }
            else
                return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metoda care cauta toti angajatii din baza de date si ii retine intr-o lista.
     * @return o lista ce contine obiecte de tip Employee.
     */
    public static List<Employee> ListaBD(){
        List<Employee> lista=new ArrayList<Employee>();

        try {
            Connection connection=getConnection();
            String query="SELECT * FROM people";
            PreparedStatement pstmt=connection.prepareStatement(query);
            ResultSet resultSet=pstmt.executeQuery();

            while (resultSet.next())
            {
                try {
                    Employee temporar = new Employee(resultSet.getString("prenume"),resultSet.getString("nume"), resultSet.getString("cnp"), resultSet.getString("loc_nastere"),
                            resultSet.getString("stare_civila"), resultSet.getString("nationalitate"), resultSet.getString("departament"),resultSet.getInt("salariu") ,resultSet.getString("marca"),resultSet.getString("functie"), resultSet.getString("numar_telefon"),
                            resultSet.getString("adresa"), resultSet.getString("email") );
                            lista.add(temporar);
                }
                catch (MyException z)
                {
                    z.printStackTrace();
                }
                }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Metoda sterge din baza de date inregistrarea aleasa de utilizator
     * @param marca dupa care se face stergerea.
     */
    public static void StergereBD(String marca)
    {
        try {
            Connection connection=getConnection();
            String query="DELETE FROM people WHERE marca=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,marca);
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    /**
     * Metoda ce cauta in baza de date o inregistrare care are aceeasi marca,nume sau prenume cu cel mentionat.
     * @param orice atributul marca al angajatului
     * @return o lista de angajati cautati in baza de date.
     */
    public static List<Employee> CautareBDMarca(String orice)
    {      List<Employee> lista=new ArrayList<Employee>();
        try {
            Connection connection=getConnection();
            String query="SELECT * FROM people WHERE marca LIKE ? OR prenume LIKE ? or nume LIKE ?";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1,orice);
            pstmt.setString(2,orice);
            pstmt.setString(3,orice);
            ResultSet resultSet= pstmt.executeQuery();
            if(resultSet.isBeforeFirst())
            {
                while (resultSet.next()){
                Employee temporar = new Employee(resultSet.getString("prenume"),resultSet.getString("nume"), resultSet.getString("cnp"), resultSet.getString("loc_nastere"),
                        resultSet.getString("stare_civila"), resultSet.getString("nationalitate"), resultSet.getString("departament"),resultSet.getInt("salariu") ,resultSet.getString("marca"),resultSet.getString("functie"), resultSet.getString("numar_telefon"),
                        resultSet.getString("adresa"), resultSet.getString("email") );
                lista.add(temporar);}
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        } catch (MyException x) {
            x.printStackTrace();
        }
        return lista;
    }

    /**
     * Metoda cauta in tabel un angajat in functie de atributul marca.
     * @param marca atributul obiectului angajat
     * @return Returneaza angajatul cu marca corespunzatoare
     */
    public static Employee gasireBazatapeMarca(String marca){
            try {
                Connection connection=getConnection();
                String query="SELECT * FROM people WHERE marca=?";
                PreparedStatement pstmst=connection.prepareStatement(query);
                pstmst.setString(1,marca);
                ResultSet resultSet=pstmst.executeQuery();
                if(resultSet.isBeforeFirst())
                {
                    resultSet.next();
                        Employee temporar = new Employee(resultSet.getString("prenume"),resultSet.getString("nume"), resultSet.getString("cnp"), resultSet.getString("loc_nastere"),
                                resultSet.getString("stare_civila"), resultSet.getString("nationalitate"), resultSet.getString("departament"),resultSet.getInt("salariu") ,resultSet.getString("marca"),resultSet.getString("functie"), resultSet.getString("numar_telefon"),
                                resultSet.getString("adresa"), resultSet.getString("email") );
                       return temporar;
                }

            }catch (SQLException e)
            {
                e.printStackTrace();
            }catch (MyException x)
            {
                x.printStackTrace();
            }

        return null;
    }

    /**
     * Metoda ia atributele(modificate) ale unui obiect de tip employee si modifica in baza de date atributele ce au suferit modificari.
     * @param e obiect de tip employee cu atributele ce vor urma sa fie modificate in baza de date
     */
    public static void ModificareBD(Employee e) {
        try {
            Connection conn = getConnection();
            String query = "UPDATE people SET nume=?, prenume=?, cnp=?, loc_nastere=?, stare_civila=?, nationalitate=?, departament=?, functie=?, numar_telefon=?, adresa=?, email=?, marca=?, salariu=? WHERE cnp=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, e.getNume());
            pstmt.setString(2, e.getPrenume());
            pstmt.setString(3, e.getCNP());
            pstmt.setString(4, e.getLoc_nastere());
            pstmt.setString(5, e.getStarea_civila());
            pstmt.setString(6, e.getNationalitate());
            pstmt.setString(7, e.getDepartament());
            pstmt.setString(8, e.getFunctie());
            pstmt.setString(9, e.getNumar_telefon());
            pstmt.setString(10, e.getAdresa());
            pstmt.setString(11, e.getEmail());
            pstmt.setString(12, e.getMarca());
            pstmt.setInt(13, e.getSalariu());
            pstmt.setString(14, e.getCNP());

            pstmt.execute();
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    /**
     * Metoda care creeaza un tabel(in cazul in care nu exista) care are coloanele egale cu atributele obiectului.
     */
    public static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS " + "people"
                +"  (nume varchar(200) NOT NULL,"
                +"  prenume varchar(200) NOT NULL,"
                +"  cnp varchar(200) NOT NULL PRIMARY KEY,"
                +"  loc_nastere varchar(200) NOT NULL,"
                +"  stare_civila varchar(200) NOT NULL,"
                +"  nationalitate varchar(200) NOT NULL,"
                +"  departament varchar(200) NOT NULL,"
                +"  functie varchar(200) NOT NULL,"
                +"  numar_telefon varchar(200) NOT NULL,"
                +"  adresa varchar(200) NOT NULL,"
                +"  email varchar(200) NOT NULL,"
                +"  marca varchar(255) NOT NULL,"
                +"  salariu int(20) NOT NULL)";
        try{
        Connection conn=getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

     /**
     * Metoda pentru a lista toți angajații din baza de date in ordine crescatoare sau descrescatoare după atributul "marca".
     * @param ascending true pentru sortare crescatoare, false pentru sortare descrescatoare.
     * @return o lista cu angajații sortati după "marca".
     */
    public static List<Employee> ListaBDSortByMarca(boolean ascending) {
        List<Employee> lista = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String orderDirection = ascending ? "ASC" : "DESC";
            String query = "SELECT * FROM people ORDER BY CAST(marca AS UNSIGNED) " + orderDirection;
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                try {
                    Employee temporar = new Employee(resultSet.getString("prenume"), resultSet.getString("nume"), resultSet.getString("cnp"), resultSet.getString("loc_nastere"),
                            resultSet.getString("stare_civila"), resultSet.getString("nationalitate"), resultSet.getString("departament"), resultSet.getInt("salariu"), resultSet.getString("marca"), resultSet.getString("functie"), resultSet.getString("numar_telefon"),
                            resultSet.getString("adresa"), resultSet.getString("email"));
                    lista.add(temporar);
                } catch (MyException z) {
                    z.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
