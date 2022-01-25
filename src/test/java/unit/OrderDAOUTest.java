package unit;

import controller.OrderDAO;
import model.Order;
import model.Stock;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderDAOUTest {

    Order order; // Fake order (mock)
    Stock stock; // Fake stock (mock)

    @BeforeEach
    void init(){
        this.order = mock(Order.class);
        this.stock = mock(Stock.class);

        when(order.getDrinkQuantity()).thenReturn(35);
        when(order.getSugarQuantity()).thenReturn(3);
        when(order.isCup()).thenReturn(true);

        when(stock.getWater()).thenReturn(100.0);
        when(stock.getSugar()).thenReturn(10);
        when(stock.getLargeCup()).thenReturn(2);
        when(stock.getSmallCup()).thenReturn(1);
    }

    @Test
    void testIsOrderPossible_allRight(){
        Assertions.assertTrue(OrderDAO.isOrderPossible(order, stock).isEmpty());
    }

    @Test
    void testIsOrderPossible_water(){
        when(stock.getWater()).thenReturn(12.0);

        Assertions.assertEquals(OrderDAO.isOrderPossible(order, stock).get(0), "Eau");
    }

    @Test
    void testIsOrderPossible_sugar(){
        when(stock.getSugar()).thenReturn(2);

        Assertions.assertEquals(OrderDAO.isOrderPossible(order, stock).get(0), "Sucre");
    }

    @Test
    void testIsOrderPossible_bigGobelets(){
        when(order.getDrinkQuantity()).thenReturn(75);
        when(stock.getLargeCup()).thenReturn(0);

        Assertions.assertEquals(OrderDAO.isOrderPossible(order, stock).get(0), "Grands gobelets");
    }

    @Test
    void testIsOrderPossible_smallGobelets(){
        when(stock.getSmallCup()).thenReturn(0);

        Assertions.assertEquals(OrderDAO.isOrderPossible(order, stock).get(0), "Petits gobelets");
    }

    @Test
    void testIsOrderPossible_everythingExplodes(){
        when(stock.getWater()).thenReturn(0.0);
        when(stock.getSugar()).thenReturn(0);
        when(stock.getSmallCup()).thenReturn(0);

        Assertions.assertTrue(OrderDAO.isOrderPossible(order, stock).contains("Eau"));
        Assertions.assertTrue(OrderDAO.isOrderPossible(order, stock).contains("Sucre"));
        Assertions.assertTrue(OrderDAO.isOrderPossible(order, stock).contains("Petits gobelets"));
    }
}
