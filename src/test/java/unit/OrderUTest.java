package unit;

import model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class OrderUTest {

    Order order;

    @BeforeEach
    void init(){
        this.order = new Order(1, 35, 5, true, false);
    }

    //Test getter

    @Test
    void getDrinkId(){
        Assertions.assertEquals(1, order.getDrinkId());
    }

    @Test
    void getDrinkQuantity(){
        Assertions.assertEquals(35, order.getDrinkQuantity());
    }

    @Test
    void getSugarQuantity(){
        Assertions.assertEquals(5, order.getSugarQuantity());
    }

    @Test
    void isCup(){
        Assertions.assertTrue(order.isCup());
    }

    @Test
    void isCancel(){
        Assertions.assertFalse(order.isCancel());
    }
}
