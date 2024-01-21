package operationsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    /**
     * Metoda incearca sa stabileasca conexiunea cu baza de date "jemployees".
     * @return un obiect de tip connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/jemployees", "root", "");
    }
}
