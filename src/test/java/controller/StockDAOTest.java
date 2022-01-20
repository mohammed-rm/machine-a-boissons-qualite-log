package controller;

import launcher.ConnectionDB;
import model.Stock;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
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

    private void connect() {
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        conn = dbManager.getConn();
        stockDAO = new StockDAO(conn);
    }

    @Test
    void testGetStock() {
        connect();
        Stock result = stockDAO.getStock();

        for (int i=0; i<100; i++)
            stockDAO.reduceSugarStock(1);

        Assertions.assertEquals(new Stock(0, 0d, 0, 0, 0), result);
    }

    @Test
    void testReduceSugarStock() {
        connect();
        stockDAO.reduceSugarStock(0);
    }

    @Test
    void testDecrementSmallCupStock() {
        connect();
        stockDAO.decrementSmallCupStock();
    }

    @Test
    void testDecrementLargeCupStock() {
        connect();
        stockDAO.decrementLargeCupStock();
    }

    @Test
    void testReduceWaterStock() {
        connect();
        stockDAO.reduceWaterStock(0d);
    }
}