package by.issoft.domain;

public class Product {
    private final String name;
    private Double rate;
    private Double price;

    public Product(String name, Double rate, Double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + name + ", rate: " + rate + " price: " + price;
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

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
