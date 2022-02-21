package by.issoft.store;

import by.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;

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

}
