package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import com.github.javafaker.Faker;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Set;

public class RandomStorePopulator {
    private final Reflections reflections;
    private final Faker faker;
    private final static int LOWER_BOUND = 3;
    private final static int BOUND = 5;
    private final static String PACKAGE = "by.issoft.domain.categories";
    private final static String BIKE_CATEGORY = "Bike";
    private final static String MILK_CATEGORY = "Milk";
    private final static String PHONE_CATEGORY = "Phone";

    public RandomStorePopulator() {
        faker = new Faker();
        reflections = new Reflections(PACKAGE);
    }

    public void fillStore(Store store) {
        Set<Class<? extends Category>> categories = reflections.getSubTypesOf(Category.class);
        Random random = new Random();
        for (Class<? extends Category> category : categories
        ) {
            try {
                store.addCategory(addProductsToCategory(category.getDeclaredConstructor().newInstance(),
                        random.nextInt(BOUND) + LOWER_BOUND));
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private Category addProductsToCategory(Category category, int num) {
        for (int i = 0; i < num; i++) {
            category.addProduct(new Product(generateProductName(category),
                    faker.number().randomDouble(1, 0, 10),
                    Double.parseDouble(faker.commerce().price())));
        }
        return category;
    }

    private String generateProductName(Category category) {
        switch (category.getName()) {
            case BIKE_CATEGORY:
                return faker.company().name();
            case MILK_CATEGORY:
                return faker.food().ingredient();
            case PHONE_CATEGORY:
                return faker.app().name();
            default:
                return faker.funnyName().name();
        }
    }
}
