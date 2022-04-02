package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.store.repositories.CategoryRepository;
import by.issoft.store.repositories.ProductRepository;
import com.github.javafaker.Faker;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Set;

public class DatabasePopulator {
    private final Reflections reflections;
    private final Faker faker;
    private final static int LOWER_BOUND = 3;
    private final static int BOUND = 5;
    private final static String PACKAGE = "by.issoft.domain.categories";
    public final static String BIKE_CATEGORY = "Bike";
    public final static String MILK_CATEGORY = "Milk";
    public final static String PHONE_CATEGORY = "Phone";

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DatabasePopulator() {
        faker = new Faker();
        reflections = new Reflections(PACKAGE);
        categoryRepository = new CategoryRepository();
        productRepository = new ProductRepository();
    }

    public void fillDatabase() {
        Set<Class<? extends Category>> categories = reflections.getSubTypesOf(Category.class);
        Random random = new Random();
        for (Class<? extends Category> category : categories
        ) {
            try {
                Category temp = category.getDeclaredConstructor().newInstance();
                categoryRepository.addCategory(temp.getName());
                addProductsByCategory(temp.getName(), random.nextInt(BOUND) + LOWER_BOUND);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    private void addProductsByCategory(String category, int num) {
        for (int i = 0; i < num; i++) {
            productRepository.addProduct(new Product(generateProductName(category),
                    faker.number().randomDouble(1, 0, 10),
                    Double.parseDouble(faker.commerce().price())), category);
        }
    }

    private String generateProductName(String category) {
        switch (category) {
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
