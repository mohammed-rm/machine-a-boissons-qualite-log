package controller;

import launcher.ConnectionDB;
import model.Drink;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DrinkDAOTest {

    @Mock
    DrinkDAO drinkDAO;

    Connection conn;


    @BeforeAll
    void init() {
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        conn = dbManager.getConn();
        drinkDAO = new DrinkDAO(conn);
    }
    @AfterAll
    void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.getStackTrace();
        }
    }

    @Test
    void testGetAllDrink_DrinkNotInDatabase(){
        List<Drink> list = drinkDAO.getAllDrinks();
        Drink drink_not_in_database = new Drink(-1, "Chocolat Chaud", "Meilleurs boisson", 0d);
        boolean result = list.contains(drink_not_in_database);
        Assertions.assertFalse(result);
    }

    @Test
    void testGetAllDrink_DrinkInDatabase(){
        List<Drink> list = drinkDAO.getAllDrinks();
        Drink drink_in_database = new Drink(1, "Café court", "Un café court.", 0.30);
        boolean result = list.contains(drink_in_database);
        Assertions.assertTrue(result);
    }

    @Test
    void testGetAllDrink_AllDrinkInDatabase(){
        List<Drink> list = drinkDAO.getAllDrinks();
        List<Drink> contenu_theorique = new ArrayList<>();
        contenu_theorique.add(new Drink(1, "Café court", "Un café court.", 0.30d));
        contenu_theorique.add(new Drink(2, "Café long", "Un café long.", 0.40d));
        contenu_theorique.add(new Drink(3, "Café late", "Un café late.", 0.40d));
        contenu_theorique.add(new Drink(4, "Thé noir", "Un thé noir.", 0.30d));
        contenu_theorique.add(new Drink(5, "Thé vert (sencha)", "Un thé vert Sencha de Mai.", 0.50d));
        contenu_theorique.add(new Drink(6, "Soupe de tomate", "La fameuse.", 0.40d));
        boolean result1 = contenu_theorique.containsAll(list);
        boolean result2 = list.containsAll(contenu_theorique);
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    void testGetAllDrink_ThereIsAnImpostorAmongUs(){
        List<Drink> list = drinkDAO.getAllDrinks();
        List<Drink> contenu_theorique = new ArrayList<>();
        contenu_theorique.add(new Drink(1, "Café court", "Un café court.", 0.30));
        contenu_theorique.add(new Drink(2, "Café long", "Un café long.", 0.40));
        contenu_theorique.add(new Drink(3, "Café late", "Un café late.", 0.40));
        contenu_theorique.add(new Drink(4, "Thé noir", "Un thé noir.", 0.30));
        contenu_theorique.add(new Drink(5, "Thé vert (sencha)", "Un thé vert Sencha de Mai.", 0.50));
        contenu_theorique.add(new Drink(6, "Soupe de tomate", "La fameuse.", 0.40));
        contenu_theorique.add(new Drink(-1, "Boisson rouge", "red sus", 0d));
        boolean result1 = contenu_theorique.containsAll(list);
        boolean result2 = list.containsAll(contenu_theorique);
        Assertions.assertTrue(result1);
        Assertions.assertFalse(result2);
    }

    @Test
    void testGetAllDrink_ButThereIsNoSoup(){
        List<Drink> list = drinkDAO.getAllDrinks();
        List<Drink> contenu_theorique = new ArrayList<>();
        contenu_theorique.add(new Drink(1, "Café court", "Un café court.", 0.30));
        contenu_theorique.add(new Drink(2, "Café long", "Un café long.", 0.40));
        contenu_theorique.add(new Drink(3, "Café late", "Un café late.", 0.40));
        contenu_theorique.add(new Drink(4, "Thé noir", "Un thé noir.", 0.30));
        contenu_theorique.add(new Drink(5, "Thé vert (sencha)", "Un thé vert Sencha de Mai.", 0.50));
        boolean result1 = contenu_theorique.containsAll(list);
        boolean result2 = list.containsAll(contenu_theorique);
        Assertions.assertFalse(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    void testGetAllDrink_NothingSimilar(){
        List<Drink> list = drinkDAO.getAllDrinks();
        List<Drink> contenu_theorique = new ArrayList<>();
        contenu_theorique.add(new Drink(1, "Eau","H2O", 0.30));
        contenu_theorique.add(new Drink(2, "Ethanol","C2H6O", 0.40));
        contenu_theorique.add(new Drink(3, "Acide sulfurique","H2SO4", 0.40));
        contenu_theorique.add(new Drink(4, "Mercure", "Hg", 0.30));
        contenu_theorique.add(new Drink(5, "Dibrome","Br2", 0.50));
        contenu_theorique.add(new Drink(6, "Octane","C8H18", 0.40));
        boolean result1 = contenu_theorique.containsAll(list);
        boolean result2 = list.containsAll(contenu_theorique);
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
    }

}
