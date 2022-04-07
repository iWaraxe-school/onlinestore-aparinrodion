package by.issoft.store.repositories;

import by.issoft.domain.Product;
import by.issoft.store.db.DatabaseConnection;
import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final static String GET_ALL_PRODUCTS_BY_CATEGORY =
            "SELECT * FROM Products WHERE category=?";
    private final static String ADD_PRODUCT =
            "INSERT INTO Products(name, rate, price, category) values (?,?,?,?)";
    private final static String GET_ALL_PRODUCTS = "SELECT * FROM Products";


    @SneakyThrows
    public List<Product> getAllProductsByCategory(String categoryName) {
        PreparedStatement preparedStatement = DatabaseConnection.getConnection()
                .prepareStatement(GET_ALL_PRODUCTS_BY_CATEGORY);
        preparedStatement.setString(1, categoryName);
        ResultSet resultSet = preparedStatement.executeQuery();
        return getListOfProductsFromResultSet(resultSet);
    }

    @SneakyThrows
    public void addProduct(Product product, String category) {
        PreparedStatement preparedStatement = DatabaseConnection.getConnection()
                .prepareStatement(ADD_PRODUCT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getRate());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setString(4, category);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public List<Product> getAllProducts() {
        Statement statement = DatabaseConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ALL_PRODUCTS);
        return getListOfProductsFromResultSet(resultSet);
    }

    @SneakyThrows
    private List<Product> getListOfProductsFromResultSet(ResultSet resultSet) {
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            Double rate = resultSet.getDouble("rate");
            Double price = resultSet.getDouble("price");
            productList.add(new Product(name, rate, price));
        }
        return productList;
    }

}
