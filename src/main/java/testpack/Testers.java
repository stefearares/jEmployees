package testpack;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import employeepack.Employee;
import exceptions.MyException;
import operationsDB.DBConnection;
import operationsDB.DatabaseMethods;
import org.junit.*;

import static org.junit.Assert.*;

public class Testers {

    @Test
    public void testDBConn()
    {
        try {
            Connection conn = DBConnection.getConnection();
            Assert.assertNotNull(conn);
        } catch (SQLException e) {
            Assert.fail("Connection failed: " + e.getMessage());
        }
    }

    @Test
    public void testDefaultConstructor() {
        Employee employee = new Employee();
        assertEquals("Necunoscut", employee.getPrenume());
        assertEquals("Necunoscut", employee.getNume());
        assertEquals("0000000000000", employee.getCNP());

    }

    @Test
    public void testConstructor() throws MyException {
        Employee employee = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");


        assertEquals("John", employee.getPrenume());
        assertEquals("Doe", employee.getNume());
        assertEquals("1234567890123", employee.getCNP());


        try {
            Employee employee1 = new Employee("Invalid", "User", "123456789012", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "12345", "Address", "invalid-email");

        } catch (MyException e) {
            assertEquals("Nu este dat un mail valid!", e.getMessage());
        }
    }

    @Test
    public void testToString() throws MyException {
        Employee employee = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");
        String expected = "employeeclass.Employee{" +
                "prenume='John', " +
                "nume='Doe', " +
                "CNP='1234567890123', " +
                "loc_nastere='City', " +
                "starea_civila='Married', " +
                "nationalitate='Nationality', " +
                "departament='HR', " +
                "salariu=5000, " +
                "cod_unic=123, " +
                "functie='Manager', " +
                "numar_telefon='0712345678', " +
                "adresa='Address', " +
                "email='john@example.com'}";

        assertEquals(expected, employee.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Employee employee = new Employee();
        employee.setPrenume("John");
        employee.setNume("Doe");
        employee.setCNP("1234567890123");

        assertEquals("John", employee.getPrenume());
        assertEquals("Doe", employee.getNume());
        assertEquals("1234567890123", employee.getCNP());
    }

    @Test
    public void testAdaugareBD() throws MyException {
        Employee employee = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");
        DatabaseMethods.AdaugareBD(employee);

        assertTrue(DatabaseMethods.CautareBD("1234567890123", null));
    }

    @Test
    public void testCautareBD() throws MyException {
        Employee employee = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");
        DatabaseMethods.AdaugareBD(employee);

        assertTrue(DatabaseMethods.CautareBD("1234567890123", null));
        assertFalse(DatabaseMethods.CautareBD("1234567890124", null));
    }

    @Test
    public void testListaBD() throws MyException {
        Employee employee1 = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");
        Employee employee2 = new Employee("Jane", "Smith", "9876543210987", "Town", "Single", "Nationality2", "IT", 6000, "456", "Developer", "0712345679", "Address2", "jane@example.com");

        DatabaseMethods.AdaugareBD(employee1);
        DatabaseMethods.AdaugareBD(employee2);

        List<Employee> lista = DatabaseMethods.ListaBD();
        assertEquals(2, lista.size());
    }

    @Test
    public void testStergereBD() throws MyException {
        Employee employee = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");
        DatabaseMethods.AdaugareBD(employee);

        assertTrue(DatabaseMethods.CautareBD("1234567890123", null));
        DatabaseMethods.StergereBD("1234567890123");
        assertFalse(DatabaseMethods.CautareBD("1234567890123", null));
    }

    @Test
    public void testCautareBDMarca() throws MyException {
        Employee employee1 = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");
        Employee employee2 = new Employee("Jane", "Smith", "9876543210987", "Town", "Single", "Nationality2", "IT", 6000, "456", "Developer", "0712345679", "Address2", "jane@example.com");

        DatabaseMethods.AdaugareBD(employee1);
        DatabaseMethods.AdaugareBD(employee2);

        List<Employee> lista1 = DatabaseMethods.CautareBDMarca("123");
        List<Employee> lista2 = DatabaseMethods.CautareBDMarca("jane");

        assertEquals(1, lista1.size());
        assertEquals(1, lista2.size());
    }

    @Test
    public void testGasireBazatapeMarca() throws MyException {
        Employee employee1 = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");
        DatabaseMethods.AdaugareBD(employee1);

        Employee foundEmployee = DatabaseMethods.gasireBazatapeMarca("123");
        assertNotNull(foundEmployee);
        assertEquals("John", foundEmployee.getPrenume());
        assertEquals("Doe", foundEmployee.getNume());
    }

    @Test
    public void testModificareBD() throws MyException {
        Employee employee1 = new Employee("John", "Doe", "1234567890123", "City", "Married", "Nationality", "HR", 5000, "123", "Manager", "0712345678", "Address", "john@example.com");
        DatabaseMethods.AdaugareBD(employee1);

        Employee modifiedEmployee = new Employee("Modified", "User", "1234567890123", "ModifiedCity", "Single", "ModifiedNationality", "ModifiedHR", 6000, "123", "ModifiedManager", "0712345679", "ModifiedAddress", "modified@example.com");
        DatabaseMethods.ModificareBD(modifiedEmployee);

        Employee foundEmployee = DatabaseMethods.gasireBazatapeMarca("123");
        assertNotNull(foundEmployee);
        assertEquals("Modified", foundEmployee.getPrenume());
        assertEquals("User", foundEmployee.getNume());
    }


}
