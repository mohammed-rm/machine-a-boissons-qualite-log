import java.sql.*;

public class ConnectionDB {
    private static final String DB_URL = "jdbc:sqlite:SQLite/";
    private Connection conn;

    public ConnectionDB(String fileName){
        try {
            this.conn = DriverManager.getConnection(DB_URL + "/" + fileName);
            DatabaseMetaData meta = conn.getMetaData();
            // System.out.println("Nom du driver : " + meta.getDriverName());
            System.out.println("Base de données " + fileName + " ouverte.");
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : " + ex.getMessage());
        }
    }

    public void createBoissonsTables(){
        try {
            Statement stmt = this.conn.createStatement();
            // Table stock
            String query =  "CREATE TABLE IF NOT EXISTS Stock(" +
                            "Eau FLOAT," +
                            "Petits_gobelets INTEGER," +
                            "Grands_gobelets INTEGER," +
                            "Sucre INTEGER);";
            stmt.executeUpdate(query);

            // Boisson
            query = "CREATE TABLE IF NOT EXISTS Boisson(" +
                    "Id INTEGER," +
                    "Nom VARCHAR(32)," +
                    "Description VARCHAR(256)," +
                    "Prix_u FLOAT," +
                    "PRIMARY KEY (Id));";
            stmt.executeUpdate(query);

            // Commande
            query = "CREATE TABLE IF NOT EXISTS Commande(" +
                    "Id INTEGER," +
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
        }
        catch(SQLException ex){
            System.out.println("Erreur SQL : " + ex.getMessage());
        }
    }
}
