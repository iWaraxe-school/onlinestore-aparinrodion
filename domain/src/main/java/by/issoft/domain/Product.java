package by.issoft.domain;

public class Product {
    private final String name;
    private final Double rate;
    private final Double price;

    public Product(String name, Double rate, Double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Name: '%s', Price: %.2f, Rate: %.1f", name, price, rate);
    }

    public String getName() {
        return name;
    }

    public Double getRate() {
        return rate;
    }

    public Double getPrice() {
        return price;
    }
}
