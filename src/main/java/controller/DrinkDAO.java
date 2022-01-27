package controller;

import model.Drink;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DrinkDAO {

    private final Connection conn;

    public DrinkDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Drink> getAllDrinks() {
        List<Drink> liste = new ArrayList<>();
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Boisson");
            while (rs.next()) {
                Drink drink = new Drink(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getDouble("prix_u"));
                liste.add(drink);
            }
        } catch (SQLException sqle) {
            System.out.println("Erreur getAllDrink dans DrinkDAO : " + sqle);
        }
        return liste;
    }
}