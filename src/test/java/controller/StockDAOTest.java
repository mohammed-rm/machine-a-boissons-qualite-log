package controller;

import launcher.ConnectionDB;
import model.Stock;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.SQLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StockDAOTest {
    @Mock
    StockDAO stockDAO;

    Connection conn;
    Stock stock_backup;


    @BeforeAll
    void init() {
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        conn = dbManager.getConn();
        stockDAO = new StockDAO(conn);
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
        stockDAO.setStocks(0, 1d, 2, 3, 4);
    }
    @AfterEach
    void rollback() {
        stockDAO.setStocks(stock_backup.getIdStock(), stock_backup.getWater(), stock_backup.getSmallCup(), stock_backup.getLargeCup(), stock_backup.getSugar());
    }


    @Test
    @Order(1)
    void testGetStock() {
        Stock result = stockDAO.getStock();

        Assertions.assertEquals(0, result.getIdStock());
        Assertions.assertEquals(1d, result.getWater());
        Assertions.assertEquals(2, result.getSmallCup());
        Assertions.assertEquals(3, result.getLargeCup());
        Assertions.assertEquals(4, result.getSugar());
    }

    @Test
    @Order(2)
    void testReduceSugarStock() {
        int sugar = stockDAO.getStock().getSugar();
        stockDAO.reduceSugarStock(1);

        Assertions.assertEquals(sugar-1, stockDAO.getStock().getSugar());
    }

    @Test
    @Order(3)
    void testDecrementSmallCupStock() {
        int smallCup = stockDAO.getStock().getSmallCup();
        stockDAO.decrementSmallCupStock();

        Assertions.assertEquals(smallCup-1, stockDAO.getStock().getSmallCup());
    }

    @Test
    @Order(4)
    void testDecrementLargeCupStock() {
        int largeCup = stockDAO.getStock().getLargeCup();
        stockDAO.decrementLargeCupStock();

        Assertions.assertEquals(largeCup-1, stockDAO.getStock().getLargeCup());
    }

    @Test
    @Order(5)
    void testReduceWaterStock() {
        Double water = stockDAO.getStock().getWater();
        stockDAO.reduceWaterStock(1d);

        Assertions.assertEquals(water-1d, stockDAO.getStock().getWater());
    }
}