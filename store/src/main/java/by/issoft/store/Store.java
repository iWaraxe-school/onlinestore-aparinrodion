package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private final List<Category> categoryList;

    public Store() {
        categoryList = new ArrayList<>();
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Store:\n");
        for (Category category : categoryList
        ) {
            stringBuilder.append(category);
        }
        return stringBuilder.toString();
    }

    public String getSortedStore(Comparator<Product> comparator) {
        StringBuilder stringBuilder = new StringBuilder("Store:\n");
        for (Category category : categoryList
        ) {
            stringBuilder.append(category.getSortedProducts(comparator));
        }
        return stringBuilder.toString();
    }

    public String getTopFiveByPrice() {
        StringBuilder stringBuilder = new StringBuilder("Top five products by price:\n");
        List<Product> products = new ArrayList<>();
        categoryList.forEach(category -> products.addAll(category.getProductList()));
        products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(5)
                .forEach(product -> stringBuilder.append(product).append("\n"));
        return stringBuilder.toString();
    }
}
