package unit;

import model.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockTest {
    Stock stock = new Stock(0, 1d, 2, 3, 4);

    @Test
    void testToString() {
        String result = stock.toString();
        Assertions.assertEquals("id:0 ; water:1.0 ; SmallCup:2 ; LargeCup:3 ; sugar:4", result);
    }
}