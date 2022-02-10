package by.issoft.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product> productList;

    public Category(String name) {
        this.name = name;
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Category: " + name + "\nProducts:\n");
        for (Product product : productList
        ) {
            stringBuilder.append(product).append("\n");
        }
        return stringBuilder.toString();
    }
}
