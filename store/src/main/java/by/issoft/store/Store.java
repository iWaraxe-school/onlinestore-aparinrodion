package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private final List<Category> categoryList;
    private static Store storeInstance;

    private Store() {
        categoryList = new ArrayList<>();
    }

    public static Store getInstance() {
        if (storeInstance == null) {
            storeInstance = new Store();
        }
        return storeInstance;
    }

    public static void clear() {
        if (storeInstance != null) {
            storeInstance.categoryList.clear();
        }
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    public String getSortedStore(Comparator<Product> comparator) {
        StringBuilder stringBuilder = new StringBuilder("Store:\n");
        categoryList.forEach(category -> stringBuilder.append(category.getSortedProducts(comparator)));
        return stringBuilder.toString();
    }

    public String getTopFiveByPrice() {
        StringBuilder stringBuilder = new StringBuilder("Top five products by price:\n");
        getListOfTopFiveByPrice()
                .forEach(product -> stringBuilder.append(product).append("\n"));
        return stringBuilder.toString();
    }

    public List<Product> getListOfTopFiveByPrice() {
        List<Product> products = new ArrayList<>();
        categoryList.forEach(category -> products.addAll(category.getProductList()));
        return products.stream().sorted(Comparator.comparing(Product::getPrice)
                .reversed()).limit(5).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Store:\n");
        categoryList.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

}
