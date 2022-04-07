package by.issoft.store.repositories;

import by.issoft.domain.Category;
import by.issoft.domain.categories.BikeCategory;
import by.issoft.domain.categories.MilkCategory;
import by.issoft.domain.categories.PhoneCategory;
import by.issoft.store.DatabasePopulator;
import by.issoft.store.db.DatabaseConnection;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private final static String GET_ALL_CATEGORIES = "SELECT * FROM Categories";
    private final static String ADD_CATEGORY = "INSERT INTO Categories(name) VALUES(?)";
    private final ProductRepository productRepository;

    public CategoryRepository() {
        this.productRepository = new ProductRepository();
    }

    @SneakyThrows
    public List<String> getAllCategories() {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ALL_CATEGORIES);
        List<String> categoriesList = new ArrayList<>();
        while (resultSet.next()) {
            categoriesList.add(resultSet.getString("name"));
        }
        return categoriesList;
    }

    @SneakyThrows
    public void addCategory(String categoryName) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_CATEGORY);
        preparedStatement.setString(1, categoryName);
        preparedStatement.executeUpdate();
    }

    public List<Category> getCategories() {
        List<Category> categoryList = new ArrayList<>();
        getAllCategories().forEach(categoryName -> {
            Category category = getCategoryInstance(categoryName);
            if (category != null) {
                productRepository.getAllProductsByCategory(categoryName).forEach(category::addProduct);
                categoryList.add(category);
            }
        });
        return categoryList;
    }

    private Category getCategoryInstance(String category) {
        switch (category) {
            case DatabasePopulator.BIKE_CATEGORY:
                return new BikeCategory();
            case DatabasePopulator.MILK_CATEGORY:
                return new MilkCategory();
            case DatabasePopulator.PHONE_CATEGORY:
                return new PhoneCategory();
            default:
                return null;
        }
    }
}
