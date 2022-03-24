package by.issoft.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    private static final String NAME = "name";
    private static final Double RATE = 8.3;
    private static final Double PRICE = 16.2;
    private static final Product product = new Product(NAME, RATE, PRICE);

    @Test
    void Get_name() {
        assertEquals(product.getName(), NAME);
    }

    @Test
    void Get_rate() {
        assertEquals(product.getRate(), RATE);
    }

    @Test
    void Get_price() {
        assertEquals(product.getPrice(), PRICE);
    }

    @Test
    void To_string() {
        assertEquals(String.format("Name: '%s', Price: %.2f, Rate: %.1f", NAME, PRICE, RATE), product.toString());
    }
}