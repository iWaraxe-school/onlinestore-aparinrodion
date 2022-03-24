package by.issoft.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    private static final String NAME = "name";
    private static final Double RATE = 8.3;
    private static final Double PRICE = 16.2;
    private static final Product product = new Product(NAME, RATE, PRICE);

    @Test
    void getName() {
        assertEquals(product.getName(), NAME);
    }

    @Test
    void getRate() {
        assertEquals(product.getRate(), RATE);
    }

    @Test
    void getPrice() {
        assertEquals(product.getPrice(), PRICE);
    }

    @Test
    void toStringTest() {
        assertEquals(String.format("Name: '%s', Price: %.2f, Rate: %.1f", NAME, PRICE, RATE), product.toString());
    }
}