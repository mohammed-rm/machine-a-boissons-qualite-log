package integration;

import controller.OrderDAO;
import controller.StockDAO;
import launcher.ConnectionDB;
import model.Order;
import model.Stock;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderDAOTest {

    Connection conn;
    Stock stock_backup;
    StockDAO stockDAO;
    OrderDAO orderDAO;

    @BeforeAll
    void init() {
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        conn = dbManager.getConn();
        stockDAO = new StockDAO(conn);
        orderDAO = new OrderDAO(conn, stockDAO);
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
        stockDAO.setStocks(0, 100d, 2, 3, 10);
    }

    @AfterEach
    void rollback() {
        stockDAO.setStocks(stock_backup.getIdStock(), stock_backup.getWater(), stock_backup.getSmallCup(), stock_backup.getLargeCup(), stock_backup.getSugar());
    }

    @Test
    void testPlaceOrder() {
        Order order1 = new Order(1, 75, 5, true, false);
        Assertions.assertTrue(orderDAO.placeOrder(order1).isEmpty());

        Order order2 = new Order(1, 75, 5, true, false);
        Assertions.assertEquals("Eau", orderDAO.placeOrder(order2).get(0));

        Order order3 = new Order(2, 750, 50, true, false);
        Assertions.assertFalse(orderDAO.placeOrder(order3).isEmpty());
    }
}
