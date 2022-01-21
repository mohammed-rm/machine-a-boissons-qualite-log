package controller;

import launcher.ConnectionDB;
import model.Drink;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DrinkDAOTest {

    @Mock
    Connection conn;
    @InjectMocks
    DrinkDAO drinkDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    @BeforeEach
    void connect() {
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        conn = dbManager.getConn();
        drinkDAO = new DrinkDAO(conn);
    }

    @Test
    void testGetAllDrink_DrinkNotInDatabase(){
        List<Drink> list = drinkDAO.getAllDrinks();
        Drink drink_not_in_database = new Drink(-1, "Chocolat Chaud", "Meilleurs boisson", 0d);
        boolean result = list.contains(drink_not_in_database);
        Assertions.assertEquals(false, result);
    }

    @Test
    void testGetAllDrink_DrinkInDatabase(){
        List<Drink> list = drinkDAO.getAllDrinks();
        Drink drink_in_database = new Drink(1, "Café court", "Un café court.", 0.30);
        boolean result = list.contains(drink_in_database);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetAllDrink_AllDrinkInDatabase(){
        List<Drink> list = drinkDAO.getAllDrinks();
        List<Drink> contenu_theorique = new ArrayList<>();
        contenu_theorique.add(new Drink(1, "Café court", "Un café court.", 0.30));
        contenu_theorique.add(new Drink(2, "Café long", "Un café long.", 0.40));
        contenu_theorique.add(new Drink(3, "Café late", "Un café late.", 0.40));
        contenu_theorique.add(new Drink(4, "Thé noir", "Un thé noir.", 0.30));
        contenu_theorique.add(new Drink(5, "Thé vert (sencha)", "Un thé vert Sencha de Mai.", 0.50));
        contenu_theorique.add(new Drink(6, "Soupe de tomate", "La fameuse.", 0.40));
        boolean result = list.containsAll(contenu_theorique);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetAllDrink_ThereIsAImpostorAmongUs(){
        List<Drink> list = drinkDAO.getAllDrinks();
        List<Drink> contenu_theorique = new ArrayList<>();
        contenu_theorique.add(new Drink(1, "Café court", "Un café court.", 0.30));
        contenu_theorique.add(new Drink(2, "Café long", "Un café long.", 0.40));
        contenu_theorique.add(new Drink(3, "Café late", "Un café late.", 0.40));
        contenu_theorique.add(new Drink(4, "Thé noir", "Un thé noir.", 0.30));
        contenu_theorique.add(new Drink(5, "Thé vert (sencha)", "Un thé vert Sencha de Mai.", 0.50));
        contenu_theorique.add(new Drink(6, "Soupe de tomate", "La fameuse.", 0.40));
        contenu_theorique.add(new Drink(-1, "Chocolat Chaud", "Meilleurs boisson", 0d));
        boolean result = list.containsAll(contenu_theorique);
        Assertions.assertEquals(false, result);
    }

}
