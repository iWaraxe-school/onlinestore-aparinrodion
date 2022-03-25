package by.issoft.domain;

import by.issoft.domain.categories.BikeCategory;
import by.issoft.domain.categories.MilkCategory;
import by.issoft.domain.categories.PhoneCategory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    @Test
    void getName() {
        Category category = new Category("name");
        assertEquals("name", category.getName());

        category = new BikeCategory();
        assertEquals("Bike", category.getName());

        category = new MilkCategory();
        assertEquals("Milk", category.getName());

        category = new PhoneCategory();
        assertEquals("Phone", category.getName());
    }

    @Test
    void addProduct() {
        Category category = new Category("name");
        Product product1 = new Product("product name", 10., 20.);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        category.addProduct(product1);
        assertEquals(productList, category.getProductList());

        Product product2 = new Product("product name", 20., 30.);
        productList.add(product2);
        category.addProduct(product2);
        assertEquals(productList, category.getProductList());
    }

    @Test
    void getSortedProducts() {
        Category category = new Category("category");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("a", 5.6, 50.));
        productList.add(new Product("a1", 5.6, 51.));
        productList.add(new Product("b", 5.4, 51.));
        productList.add(new Product("b1", 5.2, 53.));
        productList.add(new Product("c", 5.2, 52.));
        productList.add(new Product("c1", 5.1, 55.));
        productList.forEach(category::addProduct);

        Comparator<Product> comparator = Comparator
                .comparing(Product::getName, Comparator.reverseOrder())
                .thenComparing(Product::getPrice)
                .thenComparing(Product::getPrice, Comparator.reverseOrder());
        assertEquals(productList.stream().sorted(comparator).collect(Collectors.toList()),
                category.getSortedProductsList(comparator));
    }

    @Test
    void getProductList() {
        Category category = new Category("name");
        assertEquals(category.getProductList(), new ArrayList<>());
    }
}