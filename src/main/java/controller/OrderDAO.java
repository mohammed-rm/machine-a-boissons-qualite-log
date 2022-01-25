package controller;

import model.Drink;
import model.Order;
import model.Stock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private final Connection conn;
    private final StockDAO stockDAO;

    public OrderDAO(Connection conn, StockDAO stockDAO){
        this.conn = conn;
        this.stockDAO = stockDAO;
    }

    /**
     * Effectue une commande de boisson
     * @param order la commande à effectuer
     * @return la liste des éléments manquant, vide si la commande a été effectué
     */
    public List<String> placeOrder(Order order){
        Stock stock = this.stockDAO.getStock();

        List<String> missingElems = isOrderPossible(order, stock);
        if (missingElems.isEmpty()) return missingElems; // Si le stock est insuffisant, on annule

        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO Commande " +
                    "(Boisson_id, Quantite_boisson, Quantite_sucre, Gobelet, Prix, Annule) VALUES " +
                    "(?, ?, ?, ?, ?, ?);");
            stmt.setInt(1, order.getDrinkId());
            stmt.setInt(2, order.getDrinkQuantity());
            stmt.setInt(3, order.getSugarQuantity());
            stmt.setBoolean(4, order.isCup());
            //stmt.setFloat(5, order.getPrice());
            stmt.setBoolean(6, order.isCancel());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Erreur placeOrder dans OrderDAO : " + sqle);
        }

        this.stockDAO.consumeOrder(order);

        return missingElems;
    }

    /**
     * Vérifie qu'une commande est possible en fonction d'un stock
     * @param order la commande à vérifier
     * @param stock le stock à prendre en compte
     * @return La liste des éléments manquants, vide si possible
     */
    private static List<String> isOrderPossible(Order order, Stock stock){
        List<String> missingElems = new ArrayList<>();
        if (order.getDrinkQuantity() > stock.getWater())
            missingElems.add("Eau");
        if (order.getSugarQuantity() > stock.getSugar())
            missingElems.add("Sucre");
        if (order.isCup() && order.getDrinkQuantity() == 75 && stock.getLargeCup() == 0)
            missingElems.add("Grands gobelets");
        if (order.isCup() && order.getDrinkQuantity() == 35 && stock.getSmallCup() == 0)
            missingElems.add("Petits gobelets");
        return missingElems;
    }

    public List<Order> getAllOrders(){
        List<Order> liste = new ArrayList<>();
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Commande");
            while(rs.next()){
                Order order = new Order(rs.getInt("id"),
                        rs.getInt("Boisson_id"),
                        rs.getInt("Quantite_boisson"),
                        rs.getInt("Quantite_sucre"),
                        rs.getBoolean("Gobelet"),
                        rs.getBoolean("Annule")
                );
                liste.add(order);
            }
        }catch(SQLException sqle) {
            System.out.println("Erreur getAllDrink dans DrinkDAO : " + sqle);
        }
        return liste;
    }
}
