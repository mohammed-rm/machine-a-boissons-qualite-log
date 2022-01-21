package controller;

import launcher.ConnectionDB;
import model.Stock;
import model.Order;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.SQLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderDAOTest {
    Connection conn;
    Stock stock_backup;

    @Mock
    StockDAO stockDAO;

    @Mock
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
        Order order1 = new Order(1, 1, 75, 5, true, 75, false, 1.5f);
        Assertions.assertTrue(orderDAO.placeOrder(order1).isEmpty());

        Order order2 = new Order(1, 1, 75, 5, true, 7500, false, 2.5f);
        Assertions.assertEquals("Eau", orderDAO.placeOrder(order2).get(0));

        Order order3 = new Order(1, 2, 750, 50, true, 750, false, 1500.5f);
        Assertions.assertFalse(orderDAO.placeOrder(order3).isEmpty());
    }
}
