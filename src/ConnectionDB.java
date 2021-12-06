import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DB_URL = "jdbc:sqlite:SQLite/";
    private Connection conn;

    public ConnectionDB(String fileName){
        try {
            this.conn = DriverManager.getConnection(DB_URL + "/" + fileName);
            DatabaseMetaData meta = conn.getMetaData();
            // System.out.println("Nom du driver : " + meta.getDriverName());
            System.out.println("Base de données " + fileName + " ouverte.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test the connection of the database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);

            System.out.println("Connecté à SQLite.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void createBoissonsTables(){

    }
}
