package launcher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private static final String DB_URL = "jdbc:sqlite:SQLite/";
    private Connection conn;

    public ConnectionDB(String fileName) {
        try {
            this.conn = DriverManager.getConnection(DB_URL + "/" + fileName);
            // System.out.println("Nom du driver : " + meta.getDriverName());
            System.out.println("Base de données " + fileName + " ouverte.");
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : " + ex.getMessage());
        }
    }

    /**
     * Create the Boissons tables
     * /!\ Drop the tables if they already exists
     */
    public void createBoissonsTables() {
        try {
            Statement stmt = this.conn.createStatement();
            // Drop all the tables
            stmt.executeUpdate("DROP TABLE IF EXISTS Commande");
            stmt.executeUpdate("DROP TABLE IF EXISTS Boisson");
            stmt.executeUpdate("DROP TABLE IF EXISTS Stock");

            // Table Stock
            String query = "CREATE TABLE IF NOT EXISTS Stock(" +
                    "Id INTEGER," +
                    "Eau FLOAT," +
                    "Petits_gobelets INTEGER," +
                    "Grands_gobelets INTEGER," +
                    "Sucre INTEGER," +
                    "PRIMARY KEY (Id));";
            stmt.executeUpdate(query);

            // Table Boisson
            query = "CREATE TABLE IF NOT EXISTS Boisson(" +
                    "Id INTEGER," +
                    "Nom VARCHAR(32)," +
                    "Description VARCHAR(256)," +
                    "Prix_u FLOAT," +
                    "PRIMARY KEY (Id));";
            stmt.executeUpdate(query);

            // Table Commande
            query = "CREATE TABLE IF NOT EXISTS Commande(" +
                    "Id INTEGER AUTO_INCREMENT," +
                    "Boisson_id INTEGER," +
                    "Quantite_boisson INTEGER," +
                    "Quantite_sucre INTEGER," +
                    "Gobelet BOOLEAN," +
                    "Prix FLOAT," +
                    "Annule BOOLEAN," +
                    "PRIMARY KEY (Id)," +
                    "FOREIGN KEY (Boisson_id) REFERENCES Boisson);";
            stmt.executeUpdate(query);

            System.out.println("Tables de la base Boissons créées.");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : " + ex.getMessage());
        }
    }

    /**
     * Fill the database Boissons with test values
     */
    public void fillBoissonsTables() {
        try {
            Statement stmt = this.conn.createStatement();

            // Stock
            String query = "INSERT INTO Stock VALUES(" +
                    "0," +      // id to always use
                    "250.0," +  // cl of water
                    "10," +     // little cups
                    "5," +      // big cups
                    "20);";     // g of sugar
            stmt.executeUpdate(query);

            // Boisson
            query = "INSERT INTO Boisson VALUES(" +
                    "1," +
                    "'Café court'," +
                    "'Un café court.'," +
                    "0.30);";
            stmt.executeUpdate(query);
            query = "INSERT INTO Boisson VALUES(" +
                    "2," +
                    "'Café long'," +
                    "'Un café long.'," +
                    "0.40);";
            stmt.executeUpdate(query);
            query = "INSERT INTO Boisson VALUES(" +
                    "3," +
                    "'Café late'," +
                    "'Un café late.'," +
                    "0.40);";
            stmt.executeUpdate(query);
            query = "INSERT INTO Boisson VALUES(" +
                    "4," +
                    "'Thé noir'," +
                    "'Un thé noir.'," +
                    "0.30);";
            stmt.executeUpdate(query);
            query = "INSERT INTO Boisson VALUES(" +
                    "5," +
                    "'Thé vert (sencha)'," +
                    "'Un thé vert Sencha de Mai.'," +
                    "0.50);";
            stmt.executeUpdate(query);
            query = "INSERT INTO Boisson VALUES(" +
                    "6," +
                    "'Soupe de tomate'," +
                    "'La fameuse.'," +
                    "0.40);";
            stmt.executeUpdate(query);

            System.out.println("Tables de la base Boissons remplies.");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : " + ex.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }
}
