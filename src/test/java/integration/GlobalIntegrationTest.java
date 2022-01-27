package integration;

import controller.DrinkDAO;
import controller.OrderDAO;
import controller.StockDAO;
import launcher.ConnectionDB;
import model.Order;
import model.Stock;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GlobalIntegrationTest {
    StockDAO stockDAO;
    OrderDAO orderDAO;
    DrinkDAO drinkDAO;

    Connection conn;
    Stock stock_backup;


    @BeforeAll
    void init() {
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        conn = dbManager.getConn();
        stockDAO = new StockDAO(conn);
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

    @BeforeEach
    void connect() {
        stock_backup = stockDAO.getStock();
        orderDAO = new OrderDAO(conn, stockDAO);
        stockDAO.setStocks(0, 100d, 2, 3, 4);
    }

    @AfterEach
    void rollback() {
        stockDAO.setStocks(stock_backup.getIdStock(), stock_backup.getWater(), stock_backup.getSmallCup(), stock_backup.getLargeCup(), stock_backup.getSugar());
    }


    @Test
    void testOrderConsumeDrink() {
        double d = stockDAO.getStock().getWater();

        Order o = new Order(1, 75d, 1, false, false);
        Assertions.assertTrue(orderDAO.placeOrder(o).isEmpty());

        Order o2 = new Order(2, 110d, 1, false, false);
        Assertions.assertFalse(orderDAO.placeOrder(o2).isEmpty());

        Assertions.assertEquals(d - o.getDrinkQuantity(), stockDAO.getStock().getWater());
    }

}