package by.issoft.store;

import by.issoft.domain.Product;
import by.issoft.store.repositories.CategoryRepository;
import by.issoft.store.repositories.ProductRepository;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Store {
    private final List<Product> purchasedGoods;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private Store() {
        categoryRepository = new CategoryRepository();
        productRepository = new ProductRepository();
        purchasedGoods = new CopyOnWriteArrayList<>();
    }

    private static class StoreHolder {
        private static final Store store = new Store();
    }

    public static Store getInstance() {
        return StoreHolder.store;
    }

    public static void clearPurchasedGoods() {
        StoreHolder.store.purchasedGoods.clear();
    }

    public void addPurchasedItem(Product product) {
        purchasedGoods.add(product);
    }

    public List<Product> getPurchasedGoods() {
        return purchasedGoods;
    }

    public Product getProductByName(String productName) {
        return productRepository.getProductByName(productName);
    }

    public List<Product> getAllProductByCategory(String categoryName) {
        return productRepository.getAllProductsByCategory(categoryName);
    }

    public String getSortedStore(Comparator<Product> comparator) {
        StringBuilder stringBuilder = new StringBuilder("Store:\n");
        categoryRepository.getCategories().forEach(category -> stringBuilder.append(category.getSortedProducts(comparator)));
        return stringBuilder.toString();
    }

    public String getAllCategories() {
        StringBuilder stringBuilder = new StringBuilder("Store categories:\n");
        categoryRepository.getCategories()
                .forEach(category -> stringBuilder.append(category.getName()).append("\n"));
        return stringBuilder.toString();
    }

    public String getTopFiveByPrice() {
        StringBuilder stringBuilder = new StringBuilder("Top five products by price:\n");
        getListOfTopFiveByPrice()
                .forEach(product -> stringBuilder.append(product).append("\n"));
        return stringBuilder.toString();
    }

    public List<Product> getListOfTopFiveByPrice() {
        return productRepository.getAllProducts().stream().sorted(Comparator.comparing(Product::getPrice)
                .reversed()).limit(5).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Store:\n");
        categoryRepository.getCategories().forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

}
