package controller;

import model.Order;
import model.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private final Connection conn;
    private final StockDAO stockDAO;

    public OrderDAO(Connection conn, StockDAO stockDAO) {
        this.conn = conn;
        this.stockDAO = stockDAO;
    }

    /**
     * Effectue une commande de boisson
     *
     * @param order la commande à effectuer
     * @return la liste des éléments manquant, vide si la commande a été effectué
     */
    public List<String> placeOrder(Order order) {
        Stock stock = this.stockDAO.getStock();

        List<String> missingElems = isOrderPossible(order, stock);
        if (!missingElems.isEmpty()) return missingElems; // Si le stock est insuffisant, on annule

        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO Commande " +
                    "(Boisson_id, Quantite_boisson, Quantite_sucre, Gobelet, Prix, Annule) VALUES " +
                    "(?, ?, ?, ?, ?, ?);");
            stmt.setInt(1, order.getDrinkId());
            stmt.setDouble(2, order.getDrinkQuantity());
            stmt.setInt(3, order.getSugarQuantity());
            stmt.setBoolean(4, order.isCup());
            //stmt.setFloat(5, order.getPrice());
            stmt.setBoolean(6, order.isCancel());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Erreur placeOrder dans OrderDAO : " + sqle);
        }

        if (!order.isCancel())
            this.stockDAO.consumeOrder(order);

        return missingElems;
    }

    /**
     * Vérifie qu'une commande est possible en fonction d'un stock
     *
     * @param order la commande à vérifier
     * @param stock le stock à prendre en compte
     * @return La liste des éléments manquants, vide si possible
     */
    public static List<String> isOrderPossible(Order order, Stock stock) {
        List<String> missingElems = new ArrayList<>();
        if (order.getDrinkQuantity() > stock.getWater())
            missingElems.add("Water");
        if (order.getSugarQuantity() > stock.getSugar())
            missingElems.add("Sugar");
        if (order.isCup() && order.getDrinkQuantity() == 75 && stock.getLargeCup() == 0)
            missingElems.add("Large Cups");
        if (order.isCup() && order.getDrinkQuantity() == 35 && stock.getSmallCup() == 0)
            missingElems.add("Small Cups");
        System.out.println("Éléments manquants de la commande : " + missingElems);
        return missingElems;
    }

    /**
     * Calcule et retourne le prix d'un ordre donne
     *
     * @param order L'ordre pour lequel on veut avoir son prix
     * @return Le prix de l'ordre
     */
    public double getPrice(Order order) {
        double price = 0d;
        // Recuperation prix boisson
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM Boisson WHERE Id=?;");
            stmt.setInt(1, order.getDrinkId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                price += rs.getDouble("Prix_u");
            }
        } catch (SQLException sqle) {
            System.out.println("Erreur getPrice dans OrderDAO : " + sqle);
            return price;
        }
        // Augmentation si 75cl
        if (order.getDrinkQuantity() == 75) {
            price *= 1.5d;
        }
        // Reduction si pas de gobelet
        if (!order.isCup()) {
            price -= 0.1d;
            if (order.getDrinkQuantity() == 75) {
                price -= 0.05d;
            }
        }
        return price;
    }
}
