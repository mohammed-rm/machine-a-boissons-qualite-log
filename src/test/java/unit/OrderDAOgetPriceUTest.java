package unit;

import model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderDAOgetPriceUTest {

    Order order; // Fake order (mock)

    @BeforeEach
    void init() {
        this.order = mock(Order.class);
    }

    @Test
    void testGetPrice_smallNoCup() {
        when(order.getDrinkQuantity()).thenReturn(35d);
        when(order.isCup()).thenReturn(false);
    }
}
