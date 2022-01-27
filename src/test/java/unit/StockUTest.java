package unit;

import model.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockUTest {
    Stock stock;

    @BeforeEach
    void init() {
        this.stock = new Stock(0, 1d, 2, 3, 4);
    }

    @Test
    void testGetIdStock() {
        int id = stock.getIdStock();
        Assertions.assertEquals(0, id);
    }

    @Test
    void testGetWater() {
        double water = stock.getWater();
        Assertions.assertEquals(1d, water);
    }

    @Test
    void testGetSmallCup() {
        int smallCup = stock.getSmallCup();
        Assertions.assertEquals(2, smallCup);
    }

    @Test
    void testGetLargeCup() {
        int largeCup = stock.getLargeCup();
        Assertions.assertEquals(3, largeCup);
    }

    @Test
    void testSetSugar() {
        stock.setSugar(99);
        Assertions.assertEquals(99, stock.getSugar());
    }


    @Test
    void testGetSugar() {
        int id = stock.getIdStock();
        Assertions.assertEquals(0, id);
    }

    @Test
    void testToString() {
        String result = stock.toString();
        Assertions.assertEquals("id:0 ; water:1.0 ; SmallCup:2 ; LargeCup:3 ; sugar:4", result);
    }
}