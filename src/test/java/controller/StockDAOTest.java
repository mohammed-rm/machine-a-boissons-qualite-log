package controller;

import launcher.ConnectionDB;
import model.Stock;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.Connection;

import static org.mockito.Mockito.*;

class StockDAOTest {
    @Mock
    Connection conn;
    @InjectMocks
    StockDAO stockDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    @BeforeEach
    void connect() {
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        conn = dbManager.getConn();
        stockDAO = new StockDAO(conn);
    }

    @Test
    void testGetStock() {
        Stock stock_backup = stockDAO.getStock();

        stockDAO.setStocks(0, 1d, 2, 3, 4);
        Stock result = stockDAO.getStock();

        Assertions.assertEquals(0, result.getIdStock());
        Assertions.assertEquals(1d, result.getWater());
        Assertions.assertEquals(2, result.getSmallCup());
        Assertions.assertEquals(3, result.getLargeCup());
        Assertions.assertEquals(4, result.getSugar());

        stockDAO.setStocks(stock_backup.getIdStock(), stock_backup.getWater(), stock_backup.getSmallCup(), stock_backup.getLargeCup(), stock_backup.getSugar());
    }

    @Test
    void testReduceSugarStock() {
        Stock stock_backup = stockDAO.getStock();

        stockDAO.setStocks(0, 1d, 2, 3, 4);
        int sugar = stockDAO.getStock().getSugar();
        stockDAO.reduceSugarStock(1);

        Assertions.assertEquals(sugar-1, stockDAO.getStock().getSugar());
    }

    @Test
    void testDecrementSmallCupStock() {
        Stock stock_backup = stockDAO.getStock();

        stockDAO.setStocks(0, 1d, 2, 3, 4);
        int smallCup = stockDAO.getStock().getSmallCup();
        stockDAO.decrementSmallCupStock();

        Assertions.assertEquals(smallCup-1, stockDAO.getStock().getSmallCup());

    }

    @Test
    void testDecrementLargeCupStock() {
        Stock stock_backup = stockDAO.getStock();

        stockDAO.setStocks(0, 1d, 2, 3, 4);
        int largeCup = stockDAO.getStock().getLargeCup();
        stockDAO.decrementLargeCupStock();

        Assertions.assertEquals(largeCup-1, stockDAO.getStock().getLargeCup());
    }

    @Test
    void testReduceWaterStock() {
        Stock stock_backup = stockDAO.getStock();

        stockDAO.setStocks(0, 1d, 2, 3, 4);
        Double water = stockDAO.getStock().getWater();
        stockDAO.reduceWaterStock(1d);

        Assertions.assertEquals(water-1d, stockDAO.getStock().getWater());
    }
}