package controller;

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
                return new Stock(rs.getInt("id"), rs.getDouble("Eau"), rs.getInt("Petits_gobelets"), rs.getInt("Grands_gobelets"), rs.getInt("Sucre"));
            }
            return null;
        }catch(SQLException sqle){
            System.out.println("Erreur getStock dans StockDAO : "+sqle);
        }
        return null;
    }

    /**
     * Méthode pour enlever du sucre du stock actuel
     * @param sugar Quantité de sucre qu'on enlève
     * note : sugar peut être négatif, ce qui ajoute du sucre
     */
    public void reduceSugarStock(int sugar){
        try{
            Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM Stock");
            if(rs.next()){
                rs.updateInt("Sucre", rs.getInt("Sucre")-sugar);
            }
        }catch(SQLException sqle){
            System.out.println("Erreur reduceSugarStock dans StockDAO : "+sqle);
        }
    }

    /**
     * Méthode pour enlever un seul petit gobelet du stock
     */
    public void decrementSmallCupStock(){
        try{
            Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM Stock");
            if(rs.next()){
                rs.updateInt("Petits_gobelets", rs.getInt("Petits_gobelets")-1);
            }
        }catch(SQLException sqle){
            System.out.println("Erreur decrementSmallCupStock dans StockDAO : "+sqle);
        }
    }

    /**
     * Méthode pour enlever un seul grand gobelet du stock
     */
    public void decrementLargeCupStock(){
        try{
            Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM Stock");
            if(rs.next()){
                rs.updateInt("Grands_gobelets", rs.getInt("Grands_gobelets")-1);
            }
        }catch(SQLException sqle){
            System.out.println("Erreur decrementLargeCupStock dans StockDAO : "+sqle);
        }
    }

    /**
     * Méthode pour réduire le stock d'eau
     * @param water Quantité d'eau à enlever du stock
     * note : water peut être négatif
     */
    public void reduceWaterStock(double water){
        try{
            Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM Stock");
            if(rs.next()){
                rs.updateDouble("Eau", rs.getDouble("Eau")-water);
            }
        }catch(SQLException sqle){
            System.out.println("Erreur reduceWaterStock dans StockDAO : "+sqle);
        }
    }
}
