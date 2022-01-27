package unit;

import model.Drink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DrinkUTest {
    Drink drink;

    @BeforeEach
    void init() {
        this.drink = new Drink(1, "Breuvage intriguant", "Une boisson bizarre", 50.00d);
    }

    @Test
    void testGetName() {
        Assertions.assertEquals("Breuvage intriguant", drink.getName());
    }

    @Test
    void testGetDescription() {
        Assertions.assertEquals("Une boisson bizarre", drink.getDescription());
    }

    @Test
    void testGetPrice() {
        Assertions.assertEquals(50.00d, drink.getPrice());
    }

    @Test
    void setName() {
        drink.setName("Boisson perturbante");
        Assertions.assertEquals("Boisson perturbante", drink.getName());
    }
}
