
package controller;

import model.Drink;

import java.sql.*;
import java.util.*;

public class DrinkDAO {

    private Connection conn;

    public DrinkDAO(Connection conn){
        this.conn = conn;
    }

    public List<Drink> getAllDrink(){
        List<Drink> liste = new ArrayList<>();
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Boisson");
            if(rs.next()){
                Drink drink = new Drink(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getDouble("prix_u"));
                liste.add(drink);
            }
        }catch(SQLException sqle) {
            System.out.println("Erreur getAllDrink dans DrinkDAO : " + sqle);
        }
        return liste;
    }

}