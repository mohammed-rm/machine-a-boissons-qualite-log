package controller;

import model.Order;
import model.Stock;

import java.sql.*;

public class StockDAO {

    private final Connection conn;

    public StockDAO(Connection conn){
        this.conn = conn;
    }

    public Stock getStock(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Stock");
            if(rs.next()){
                return new Stock(rs.getInt("Id"), rs.getDouble("Eau"), rs.getInt("Petits_gobelets"), rs.getInt("Grands_gobelets"), rs.getInt("Sucre"));
            }
            return null;
        }catch(SQLException sqle){
            System.out.println("Erreur getStock dans StockDAO : "+sqle);
        }
        return null;
    }

    /**
     * Méthode pour enlever du sucre du stock actuel
     * @param amount Quantité de sucre qu'on enlève
     * note : sugar peut être négatif, ce qui ajoute du sucre
     */
    public void reduceSugarStock(int amount){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT Sucre FROM Stock WHERE Id = 0");
            rs1.next();
            int preSugar = rs1.getInt(1);

            String sql = "UPDATE Stock SET Sucre = ? WHERE Id = 0";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, preSugar-amount);
            pstmt.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erreur reduceSugarStock dans StockDAO : "+sqle);
        }
    }

    /**
     * Méthode pour enlever un seul petit gobelet du stock
     */
    public void decrementSmallCupStock(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Petits_gobelets FROM Stock WHERE Id = 0");
            rs.next();
            int preSmallCups = rs.getInt(1);

            String sql = "UPDATE Stock SET Petits_gobelets = ? WHERE Id = 0";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, preSmallCups-1);

            pstmt.executeUpdate();
        }catch(SQLException sqle){
            System.out.println("Erreur decrementSmallCupStock dans StockDAO : "+sqle);
        }
    }

    /**
     * Méthode pour enlever un seul grand gobelet du stock
     */
    public void decrementLargeCupStock(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Grands_gobelets FROM Stock WHERE Id = 0");
            rs.next();
            int preLargeCups = rs.getInt(1);

            String sql = "UPDATE Stock SET Grands_gobelets = ? WHERE Id = 0";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, preLargeCups-1);

            pstmt.executeUpdate();
        }catch(SQLException sqle){
            System.out.println("Erreur decrementLargeCupStock dans StockDAO : "+sqle);
        }
    }

    /**
     * Méthode pour réduire le stock d'eau
     * @param water Quantité d'eau à enlever du stock
     * note : water peut être négatif
     */
    public void reduceWaterStock(double amount){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Eau FROM Stock WHERE Id = 0");
            rs.next();
            Double preEau = rs.getDouble(1);

            String sql = "UPDATE Stock SET Eau = ? WHERE Id = 0";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, preEau-amount);

            pstmt.executeUpdate();
        }catch(SQLException sqle) {
            System.out.println("Erreur reduceWaterStock dans StockDAO : " + sqle);
        }
    }

    public void setStocks(int idStock, double water, int smallCup, int largeCup, int sugar) {
        try {
            String str = "UPDATE Stock " +
                    "SET Eau = ?, " +
                    "Petits_gobelets = ?, " +
                    "Grands_gobelets = ?, " +
                    "Sucre = ? " +
                    "WHERE Id = ?";
            PreparedStatement stmt = conn.prepareStatement(str);
            stmt.setDouble(1, water);
            stmt.setInt(2, smallCup);
            stmt.setInt(3, largeCup);
            stmt.setInt(4, sugar);
            stmt.setInt(5, idStock);

            stmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erreur setStocks dans StockDAO : " + sqle);
        }
    }

    /**
     * Méthode appelé par OrderDAO si une commande est effectuée
     * Consomme les éléments commandés dans le stock
     * @param order la commande à prendre en compte
     */
    public void consumeOrder(Order order) {
        try {
            Statement stmt = conn.createStatement();
            String gobeletSize;
            if (order.getDrinkQuantity() == 75)
                gobeletSize = "Grands_gobelets";
            else
                gobeletSize = "Petits_gobelets";

            stmt.executeUpdate("UPDATE Stock SET " +
                    "Eau = Eau - " + order.getWater() + ", " +
                    gobeletSize + " = " + gobeletSize + " - " + 1 + ", " +
                    "Sucre = Sucre - " + order.getSugarQuantity() + ";");
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Erreur consumeOrder dans StockDAO : " + sqle);
        }
    }
}
