package by.issoft.store;

import by.issoft.domain.Product;
import by.issoft.store.repositories.CategoryRepository;
import by.issoft.store.repositories.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreTest {

    @Test
    void Get_instance() {
        Store store1 = Store.getInstance();
        Store store2 = Store.getInstance();
        assertEquals(store1, store2);
    }

    @Test
    void Get_category_list() {
        Store store = Store.getInstance();
        CategoryRepository categoryRepository = new CategoryRepository();
        assertEquals(store.getCategoryList(), categoryRepository.getCategories());
    }

    @Test
    void Get_top_five_by_price() {
        ProductRepository productRepository = new ProductRepository();
        List<Product> productList = productRepository.getAllProducts();
        assertEquals(productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed())
                        .limit(5).collect(Collectors.toList()),
                Store.getInstance().getListOfTopFiveByPrice()
        );
    }
}