package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.domain.categories.BikeCategory;
import by.issoft.domain.categories.MilkCategory;
import by.issoft.domain.categories.PhoneCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreTest {
    @BeforeEach
    void Clear_store() {
        Store.clear();
    }

    @Test
    void Get_instance() {
        Store store1 = Store.getInstance();
        Store store2 = Store.getInstance();
        assertEquals(store1, store2);
    }

    @Test
    void Get_category_list() {
        Store store = Store.getInstance();
        assertEquals(store.getCategoryList(), new ArrayList<Category>());
    }

    @Test
    void Add_category() {
        Store store = Store.getInstance();
        Category category1 = new Category("category 1");
        Category category2 = new Category("category 2");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category1);
        store.addCategory(category1);
        assertEquals(categoryList, store.getCategoryList());
        categoryList.add(category2);
        store.addCategory(category2);

        assertEquals(categoryList, store.getCategoryList());
    }

    @Test
    void Get_top_five_by_price() {
        Store store = Store.getInstance();
        List<Product> productsList = new ArrayList<>();

        Category phoneCategory = new PhoneCategory();
        Product product1 = new Product("a", 20., 302.);
        Product product2 = new Product("b", 20., 33.);
        productsList.add(product1);
        productsList.add(product2);
        phoneCategory.addProduct(product1);
        phoneCategory.addProduct(product2);

        Category milkCategory = new MilkCategory();
        Product product3 = new Product("c", 31., 75.);
        Product product4 = new Product("d", 69., 8.);
        productsList.add(product3);
        productsList.add(product4);
        milkCategory.addProduct(product3);
        milkCategory.addProduct(product4);

        Category bikeCategory = new BikeCategory();
        Product product5 = new Product("e", 87., 70.);
        Product product6 = new Product("f", 64., 14.);
        productsList.add(product5);
        productsList.add(product6);
        bikeCategory.addProduct(product5);
        bikeCategory.addProduct(product6);

        store.addCategory(phoneCategory);
        store.addCategory(bikeCategory);
        store.addCategory(milkCategory);

        assertEquals(productsList.stream()
                        .sorted(Comparator.comparing(Product::getPrice, Comparator.reverseOrder()))
                        .limit(5).collect(Collectors.toList()),
                store.getListOfTopFiveByPrice());
    }
}